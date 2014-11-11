package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.entidade.Teste;
import com.gdcontrol.util.DateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
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
public class ControleRelatorioMensal extends ControleRelatorioPadrao{
    
    private int mes;
    private int ano;

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
        DateUtil format = new DateUtil();
        for(Teste t : testes){
            if(format.getAno(t.getDataHora()) == getAno() && format.getMes(t.getDataHora()) == getMes()){
                filtrados.add(t);
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
}