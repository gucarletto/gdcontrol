package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.LocalAplicacao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class LocalAplicacaoTableModel extends AbstractTableModel{
    
    private ArrayList<LocalAplicacao> locais = new ArrayList<>();

    @Override
    public int getRowCount() {
        return locais.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LocalAplicacao local = locais.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return local.getLocalAplicacaoId();
            }
            default:{
                return local.getDescricao();
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
    
    public void addLocalAplicacao(LocalAplicacao grupo){
        locais.add(grupo);
        fireTableRowsInserted(locais.size()-1, locais.size()-1);
    }
    
    public LocalAplicacao getLocalAplicacao(int indice){
        return locais.get(indice);
    }

    public void limpar(){
        locais.clear();
    }
    
}
