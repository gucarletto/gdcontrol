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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(getCaminhoTempRelatorios() + getNomeArquivoRelatorio() + ".pdf"));
            exporter.exportReport();
            File arquivo = this.getRelatorioTemp();
            email.addAnexo(arquivo);
        } catch (FileNotFoundException | JRException ex) {
            Logger.getLogger(ControleRelatorioMensal.class.getName()).log(Level.SEVERE, null, ex);
        }

        EnviarEmail enviar = new EnviarEmail(email);
        if (!email.getPara().isEmpty()) {
            enviar.start();
            File arquivoTemp = this.getRelatorioTemp();
            arquivoTemp.delete();
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

                util.setTeste(t);
                util.setAplicacao(a);
                util.setUsuario(usu);
                util.setPrescricao(p);
                util.setDiaDoMes(cal.get(Calendar.DAY_OF_MONTH));
                util.setDataHoraFormatada(format.formataDataCompleta(t.getDataHora()));
                filtrados.add(util);
            }
        }
        return filtrados;
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
    
}