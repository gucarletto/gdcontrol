package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.desktop.util.mail.Email;
import com.gdcontrol.desktop.util.mail.EnviarEmail;
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
public class ControleRelatorioHipoHiper extends ControleRelatorioPadrao{
    
    private String dataInicio;
    private String dataFim;
    private String destinatario;

    @Override
    public String getNomeArquivoRelatorio() {
        return "RelatorioHipoHiper";
    }

    @Override
    public void chamaRelatorio() {
        JasperPrint printer = this.getPrinter();
        JasperViewer.viewReport(printer, false);
    }
    
    private List<Teste> filtraTestes(){
        List<Teste> testes = getDAOFactory().getTesteDAO().listar();
        List<Teste> filtrados = new ArrayList<>();
        DateUtil format = new DateUtil();
                
        int qtdeHipo = 0;
        int qtdeHiper = 0;
        for(Teste t : testes){
            Prescricao presc = getDAOFactory().getPrescricaoDAO().filtraData(format.formataData(t.getDataHora()));
            if(validaPeriodoTeste(t)){
                if(t.getValor() < presc.getMinimoGlicemia()){
                    t.setHipoHiper("Hipo");
                    filtrados.add(t);
                    t.setQtde(++qtdeHipo);
                }else if(t.getValor() > presc.getMaximoGlicemia()){
                    t.setHipoHiper("Hiper");
                    filtrados.add(t);
                    t.setQtde(++qtdeHiper);
                }
            }
        }
        return filtrados;
    }
    
    private boolean validaPeriodoTeste(Teste t){
        DateUtil format = new DateUtil();
        if(!getDataInicio().isEmpty() && !getDataFim().isEmpty()){
            Date dataInicio = format.validaData(getDataInicio());
            Date dataFim = format.validaData(getDataFim());
            return (t.getDataHora().after(dataInicio) && t.getDataHora().before(dataFim));
        }
        return true;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    private JasperPrint getPrinter() {
        File relatorio = new File(getCaminhoRelatorios() + getNomeArquivoRelatorio() + ".jasper");
        try {
            InputStream fis = new FileInputStream(relatorio);
            JasperReport report = (JasperReport) JRLoader.loadObject(fis);
            List<Teste> testes = filtraTestes();
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(testes);
            
            HashMap parametro = new HashMap();
            
            parametro.put("dataInicio", getDataInicio());
            parametro.put("dataFinal", getDataFim());
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
        email.setAssunto("Relatório de Quantidade de Hipo/Hiper Mensal do paciente: " + u.getNome());
        
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
}