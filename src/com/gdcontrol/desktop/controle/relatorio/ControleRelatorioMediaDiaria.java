package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.desktop.util.relatorio.RelatorioMediaDiariaUtil;
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
 * @author gucarletto
 */
public class ControleRelatorioMediaDiaria extends ControleRelatorioPadrao{
    
    private String dataInicio;
    private String dataFim;

    @Override
    public String getNomeArquivoRelatorio() {
        return "RelatorioMediaDiaria";
    }

    @Override
    public void chamaRelatorio() {
        File relatorio = new File(getCaminhoRelatorios() + getNomeArquivoRelatorio() + ".jasper");
        try {
            InputStream fis = new FileInputStream(relatorio);
            JasperReport report = (JasperReport) JRLoader.loadObject(fis);
            List<RelatorioMediaDiariaUtil> medias = filtraTestes();
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(medias);
            
            HashMap parametro = new HashMap();
            
            parametro.put("dataInicio", getDataInicio());
            parametro.put("dataFinal", getDataFim());
            JasperPrint printer = JasperFillManager.fillReport(report, parametro, dataSource);
            
            JasperViewer.viewReport(printer, false);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
    }
    
    private List<RelatorioMediaDiariaUtil> filtraTestes(){
        List<Teste> testes = getDAOFactory().getTesteDAO().listar();
        List<RelatorioMediaDiariaUtil> filtrados = new ArrayList<>();
        DateUtil format = new DateUtil();
                
        for(Teste t : testes){
            if(validaPeriodoTeste(t)){
                
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
}