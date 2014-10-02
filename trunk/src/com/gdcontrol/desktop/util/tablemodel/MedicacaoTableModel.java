package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Medicacao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class MedicacaoTableModel extends AbstractTableModel{
    
    private ArrayList<Medicacao> medicacoes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return medicacoes.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicacao med = medicacoes.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return med.getId();
            }
            case 1:{
                return med.getNomeComercial();
            }
            case 2:{
                return med.getNomeQuimico();
            }
            case 3:{
                return med.getMarca();
            }
            case 4:{
                return med.getUnidade();
            }
            case 5:{
                return med.getFormaUso();
            }
            default:{
                return med.getNomeComercial();
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
                return "Nome Comercial";
            }
            case 2:{
                return "Nome Químico";
            }
            case 3:{
                return "Marca";
            }
            case 4:{
                return "Unidade";
            }
            case 5:{
                return "Forma de Uso";
            }
            default:{
                return "Nome Comercial";
            }
        }
    }
    
    public void addMedicacao(Medicacao medicacao){
        medicacoes.add(medicacao);
        fireTableRowsInserted(medicacoes.size()-1, medicacoes.size()-1);
    }
    
    public Medicacao getMedicacao(int indice){
        return medicacoes.get(indice);
    }

    public void limpar(){
        medicacoes.clear();
    }
}