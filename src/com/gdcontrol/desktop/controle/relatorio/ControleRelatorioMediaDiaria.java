package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.desktop.util.relatorio.RelatorioMediaDiariaUtil;
import com.gdcontrol.entidade.Teste;
import com.gdcontrol.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        HashMap<String, ArrayList<Double>> dias = new HashMap<>();
                
        for(Teste t : testes){
            if(validaPeriodoTeste(t)){
                ArrayList<Double> valores = dias.get(format.formataData(t.getDataHora()));
                if(!(valores instanceof ArrayList)){
                    valores = new ArrayList<>();
                } 
                valores.add(t.getValor());
                dias.put(format.formataData(t.getDataHora()), valores);
            }
        }
        for (Map.Entry<String, ArrayList<Double>> entry : dias.entrySet()) {
            ArrayList<Double> valores = entry.getValue();
            double total = 0.0;
            for(Double valor : valores){
                total += valor;
            }
            RelatorioMediaDiariaUtil util = new RelatorioMediaDiariaUtil();
            util.setData(entry.getKey());
            util.setValor(total/valores.size());
            filtrados.add(util);
        }
        return filtrados;
    }
    
    private boolean validaPeriodoTeste(Teste t){
        DateUtil format = new DateUtil();
        if(!getDataInicio().isEmpty() && !getDataFim().isEmpty()){
            Calendar cal = Calendar.getInstance();
            Date dataInicio = format.validaData(getDataInicio());
            cal.setTime(dataInicio);
            cal.add(Calendar.DATE, -1);
            dataInicio = cal.getTime();
            Date dataFim = format.validaData(getDataFim());
            cal.setTime(dataFim);
            cal.add(Calendar.DATE, 1);
            dataFim = cal.getTime();
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