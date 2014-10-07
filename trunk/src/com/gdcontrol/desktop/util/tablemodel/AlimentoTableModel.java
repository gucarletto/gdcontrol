package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.dao.DAOFactory;
import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.entidade.Alimento;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class AlimentoTableModel extends AbstractTableModel{
    
    private ArrayList<Alimento> alimentos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return alimentos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupoAlimentoDAO grupoAlimentoDao = DAOFactory.getDAOFactory().getGrupoAlimentoDAO();
        Alimento ali = alimentos.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return ali.getId();
            }
            default:{
                return ali.getNome();
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
    
    public void addAlimento(Alimento grupo){
        alimentos.add(grupo);
        fireTableRowsInserted(alimentos.size()-1, alimentos.size()-1);
    }
    
    public Alimento getAlimento(int indice){
        return alimentos.get(indice);
    }

    public void limpar(){
        alimentos.clear();
    }
}