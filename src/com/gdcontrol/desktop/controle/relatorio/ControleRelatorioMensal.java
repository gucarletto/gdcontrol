package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.desktop.util.mail.Email;
import com.gdcontrol.desktop.util.mail.EnviarEmail;
import com.gdcontrol.desktop.util.relatorio.RelatorioMensalUtil;
import com.gdcontrol.entidade.Aplicacao;
import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.entidade.Teste;
import com.gdcontrol.entidade.Usuario;
import com.gdcontrol.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gustavo
 */
public class ControleRelatorioMensal extends ControleRelatorioPadrao {

    private int mes;
    private int ano;
    private String destinatario;
    private String tipoImpressao;

    public static final String TIPO_IMPRESSAO_GERAL = "Geral";
    public static final String TIPO_IMPRESSAO_CAFE = "Café da Manhã";
    public static final String TIPO_IMPRESSAO_ALMOCO = "Almoço";
    public static final String TIPO_IMPRESSAO_JANTA = "Janta";

    @Override
    public String getNomeArquivoRelatorio() {
        return "RelatorioMensal";
    }

    @Override
    public void chamaRelatorio() {
        JasperPrint printer = this.getPrinter();
        JasperViewer.viewReport(printer, false);
    }

    private JasperPrint getPrinter() {
        File relatorio = new File(getCaminhoRelatorios() + getNomeArquivoRelatorio() + ".jasper");
        try {
            InputStream fis = new FileInputStream(relatorio);
            JasperReport report = (JasperReport) JRLoader.loadObject(fis);
            List<RelatorioMensalUtil> testes = filtraTestes();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(testes);

            HashMap parametro = new HashMap();
            parametro.put("ano", getAno());
            parametro.put("mes", getMes());

            JasperPrint printer = JasperFillManager.fillReport(report, parametro, dataSource);
            return printer;
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void enviaEmail() {
        Email email = new Email();

        email.setDe("no.reply.gdcontrol@gmail.com", "gdsis321654");
        email.getPara().addAll(Arrays.asList(new String[]{this.getDestinatario()}));

        Usuario u = getDAOFactory().getUsuarioDAO().carregaUnicoUsuario();

        String mensagem = "<b>Em anexo</b>";

        email.setMensagem(mensagem);
        email.setAssunto("Relatório de Acompanhamento Mensal do Paciente " + u.getNome());

        JasperPrint printer = this.getPrinter();
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, printer);
        try {
            File temp = new File(this.getCaminhoTemp() + getNomeArquivoRelatorio() + ".pdf");
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(temp));
            exporter.exportReport();
            email.addAnexo(temp);
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(ControleRelatorioMensal.class.getName()).log(Level.SEVERE, null, ex);
        }

        EnviarEmail enviar = new EnviarEmail(email);
        if (!email.getPara().isEmpty()) {
            enviar.start();
        }
    }

    private List<RelatorioMensalUtil> filtraTestes() {
        List<Teste> testes = getDAOFactory().getTesteDAO().listar();
        List<RelatorioMensalUtil> filtrados = new ArrayList<>();
        Usuario usu = getDAOFactory().getUsuarioDAO().carregaUnicoUsuario();
        DateUtil format = new DateUtil();
        for (Teste t : testes) {
            if (format.getAno(t.getDataHora()) == getAno() && format.getMes(t.getDataHora()) == getMes()) {
                RelatorioMensalUtil util = new RelatorioMensalUtil();
                Aplicacao a = getDAOFactory().getAplicacaoDAO().carregaAplicacoesPorDataHora(t.getDataHora());
                Prescricao p = getDAOFactory().getPrescricaoDAO().filtraData(format.formataData(t.getDataHora()));

                Calendar cal = Calendar.getInstance();
                cal.setTime(t.getDataHora());

                if (this.filtraPeriodo(cal)) {

                    util.setTeste(t);
                    util.setAplicacao(a);
                    util.setUsuario(usu);
                    util.setPrescricao(p);
                    util.setDiaDoMes(cal.get(Calendar.DAY_OF_MONTH));
                    util.setDataHoraFormatada(format.formataDataCompleta(t.getDataHora()));
                    filtrados.add(util);
                }
            }
        }
        return filtrados;
    }

    private boolean filtraPeriodo(Calendar cal) {
        long hora = cal.get(Calendar.HOUR_OF_DAY);
        switch (this.getTipoImpressao()) {
            case ControleRelatorioMensal.TIPO_IMPRESSAO_CAFE:
                if(hora >= 6 && hora <= 10){
                    return true;
                }
                return false;
            case ControleRelatorioMensal.TIPO_IMPRESSAO_ALMOCO:
                if(hora >= 11 && hora <= 14){
                    return true;
                }
                return false;
            case ControleRelatorioMensal.TIPO_IMPRESSAO_JANTA:
                if(hora >= 17 && hora <= 23){
                    return true;
                }
                return false;
        }
        return true;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTipoImpressao() {
        return tipoImpressao;
    }

    public void setTipoImpressao(String tipoImpressao) {
        this.tipoImpressao = tipoImpressao;
    }
}
