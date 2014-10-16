package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class PrescricaoTableModel extends AbstractTableModel{
    
    private ArrayList<Prescricao> prescricoes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return prescricoes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prescricao prescricao = prescricoes.get(rowIndex);
        DateUtil format = new DateUtil();
        switch(columnIndex){
            case 0:{
                return prescricao.getPrescricaoId();
            }
            case 1:{
                return prescricao.getFatorCarboidrato();
            }
            case 2:{
                return prescricao.getFatorCorrecao();
            }
            case 3:{
                return format.formataData(prescricao.getDataInicio());
            }
            case 4:{
                return format.formataData(prescricao.getDataFim());
            }
            case 5:{
                return prescricao.getMedico().getNome();
            }
            case 6:{
                return prescricao.getMedicacao().getNomeComercial();
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:{
                return "ID";
            }
            case 1:{
                return "Fator Carboidrato";
            }
            case 2:{
                return "Fator Correção";
            }
            case 3:{
                return "Data Início";
            }
            case 4:{
                return "Data Final";
            }
            case 5:{
                return "Médico";
            }
            case 6:{
                return "Medicação";
            }
        }
        return null;
    }
    
    public void addPrescricao(Prescricao prescricao){
        prescricoes.add(prescricao);
        fireTableRowsInserted(prescricoes.size()-1, prescricoes.size()-1);
    }
    
    public Prescricao getPrescricao(int indice){
        return prescricoes.get(indice);
    }

    public void limpar(){
        prescricoes.clear();
    }   
}