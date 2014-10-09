package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.dao.DAOFactory;
import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.entidade.Alimento;
import com.gdcontrol.entidade.GrupoAlimento;
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
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupoAlimentoDAO grupoAlimentoDao = DAOFactory.getDAOFactory().getGrupoAlimentoDAO();
        Alimento ali = alimentos.get(rowIndex);
        GrupoAlimento grupo = grupoAlimentoDao.filtraId(ali.getGrupoAlimentoID());
        switch(columnIndex){
            case 0:{
                return ali.getAlimentoId();
            }
            case 1:{
                return ali.getNome();
            }
            case 2:{
                return ali.getCarboidrato();
            }
            case 3:{
                return ali.getCaloria();
            }
            case 4:{
                return ali.getGordura();
            }
            case 5:{
                return ali.getProteina();
            }
            case 6:{
                return grupo.getGrupoAlimentoId();
            }
            case 7:{
                return grupo.getDescricao();
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
                return "Nome";
            }
            case 2:{
                return "Carboidratos";
            }
            case 3:{
                return "Calorias";
            }
            case 4:{
                return "Gordura";
            }
            case 5:{
                return "Proteína";
            }
            case 6:{
                return "ID Grupo";
            }
            case 7:{
                return "Grupo";
            }
        }
        return null;
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