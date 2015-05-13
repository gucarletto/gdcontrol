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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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

            JasperViewer.viewReport(printer, false);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
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

    @Override
    public void enviaEmail() {
        Email email = new Email();

        email.setDe("no.reply.gdcontrol@gmail.com", "gdsis321654");
        email.getPara().addAll(Arrays.asList(new String[]{this.getDestinatario()}));

        String mensagem = "<b>Segue em anexo</b>";
        DateUtil du = new DateUtil();
        
        email.setMensagem(mensagem);
        email.setAssunto("Relatório de Acompanhamento Mensal");

        EnviarEmail enviar = new EnviarEmail(email);
        if (!email.getPara().isEmpty()) {
            enviar.start();
        }
    }
    
}
