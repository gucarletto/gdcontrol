package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.TipoEvento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class TipoEventoTableModel extends AbstractTableModel{
    
    private ArrayList<TipoEvento> tipos = new ArrayList<>();

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
        TipoEvento tip = tipos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return tip.getId();
            }
            default:{
                return tip.getNome();
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
                return "Nome";
            }
        }
    }
    
    public void addTipoEvento(TipoEvento tipo){
        tipos.add(tipo);
        fireTableRowsInserted(tipos.size()-1, tipos.size()-1);
    }
    
    public TipoEvento getTipoEvento(int indice){
        return tipos.get(indice);
    }

    public void limpar(){
        tipos.clear();
    }
    
}
