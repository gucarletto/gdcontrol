package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.entidade.Teste;
import com.gdcontrol.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
public class ControleRelatorioHipoHiper extends ControleRelatorioPadrao{
    
    private String dataInicio;
    private String dataFim;

    @Override
    public String getNomeArquivoRelatorio() {
        return "RelatorioHipoHiper";
    }

    @Override
    public void chamaRelatorio() {
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
            
            JasperViewer.viewReport(printer, false);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
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

    @Override
    public void enviaEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}