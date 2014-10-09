package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.TipoTeste;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class TipoTesteTableModel extends AbstractTableModel{
    
    private ArrayList<TipoTeste> tipos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return tipos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoTeste tip = tipos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return tip.getTipoTesteId();
            }
            default:{
                return tip.getDescricao();
            }
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:{
                return "ID";
            }
            default:{
                return "Descrição";
            }
        }
    }
    
    public void addTipoTeste(TipoTeste tipo){
        tipos.add(tipo);
        fireTableRowsInserted(tipos.size()-1, tipos.size()-1);
    }
    
    public TipoTeste getTipoTeste(int indice){
        return tipos.get(indice);
    }

    public void limpar(){
        tipos.clear();
    }
    
}
