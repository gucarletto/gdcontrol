package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Aplicacao;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class AplicacaoTableModel extends AbstractTableModel{
    
    private ArrayList<Aplicacao> aplicacoes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return aplicacoes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aplicacao aplicacao = aplicacoes.get(rowIndex);
        
        DateUtil format = new DateUtil();
        
        switch(columnIndex){
            case 0:{
                return aplicacao.getAplicacaoId();
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
        }
        return null;
    }
    
    public void addAplicacao(Aplicacao aplicacao){
        aplicacoes.add(aplicacao);
        fireTableRowsInserted(aplicacoes.size()-1, aplicacoes.size()-1);
    }
    
    public Aplicacao getAplicacao(int indice){
        return aplicacoes.get(indice);
    }

    public void limpar(){
        aplicacoes.clear();
    }   
}