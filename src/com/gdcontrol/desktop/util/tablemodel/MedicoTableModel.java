package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Medico;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class MedicoTableModel extends AbstractTableModel{
    
    private ArrayList<Medico> medicos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return medicos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medico med = medicos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return med.getId();
            }
            case 1:{
                return med.getNome();
            }
            case 2:{
                return med.getTelefone();
            }
            case 3:{
                return med.getCrm();
            }
            case 4:{
                return med.getEspecializacao();
            }
            default:{
                return med.getNome();
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:{
                return "ID";
            }
            case 1:{
                return "Nome";
            }
            case 2:{
                return "Telefone";
            }
            case 3:{
                return "CRM";
            }
            case 4:{
                return "Especialização";
            }
            default:{
                return "Nome";
            }
        }
    }
    
    public void addMedico(Medico medico){
        medicos.add(medico);
        fireTableRowsInserted(medicos.size()-1, medicos.size()-1);
    }
    
    public Medico getMedico(int indice){
        return medicos.get(indice);
    }

    public void limpar(){
        medicos.clear();
    }
}