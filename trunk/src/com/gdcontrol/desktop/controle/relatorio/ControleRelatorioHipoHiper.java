package com.gdcontrol.desktop.controle.relatorio;

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
    
    private double valorHipo;
    private double valorHiper;
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
            
            JasperPrint printer = JasperFillManager.fillReport(report, parametro, dataSource);
            
            JasperViewer.viewReport(printer, false);
        } catch (FileNotFoundException | JRException ex) {
            ex.printStackTrace();
        }
    }
    
    private List<Teste> filtraTestes(){
        List<Teste> testes = getDAOFactory().getTesteDAO().listar();
        List<Teste> filtrados = new ArrayList<>();
        int qtdeHipo = 0;
        int qtdeHiper = 0;
        for(Teste t : testes){
            if(validaPeriodoTeste(t)){
                if(t.getValor() < getValorHipo()){
                    t.setHipoHiper("Hipo");
                    filtrados.add(t);
                    t.setQtde(++qtdeHipo);
                }else if(t.getValor() > getValorHiper()){
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

    public double getValorHipo() {
        return valorHipo;
    }

    public void setValorHipo(double valorHipo) {
        this.valorHipo = valorHipo;
    }

    public double getValorHiper() {
        return valorHiper;
    }

    public void setValorHiper(double valorHiper) {
        this.valorHiper = valorHiper;
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