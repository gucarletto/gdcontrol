package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.GrupoAlimento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class GrupoAlimentoTableModel extends AbstractTableModel{
    
    private ArrayList<GrupoAlimento> grupos = new ArrayList<GrupoAlimento>();

    @Override
    public int getRowCount() {
        return grupos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupoAlimento grp = grupos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return grp.getId();
            }
            default:{
                return grp.getDescricao();
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
    
    public void addGrupoAlimento(GrupoAlimento grupo){
        grupos.add(grupo);
        fireTableRowsInserted(grupos.size()-1, grupos.size()-1);
    }
    
    public GrupoAlimento getGrupoAlimento(int indice){
        return grupos.get(indice);
    }

    public void limpar(){
        grupos.clear();
    }
}