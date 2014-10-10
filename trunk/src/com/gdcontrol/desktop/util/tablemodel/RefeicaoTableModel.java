package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Refeicao;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class RefeicaoTableModel extends AbstractTableModel{
    
    private ArrayList<Refeicao> refeicoes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return refeicoes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Refeicao refeicao = refeicoes.get(rowIndex);
        DateUtil format = new DateUtil();
        
        switch(columnIndex){
            case 0:{
                return refeicao.getRefeicaoId();
            }
            case 1:{
                return format.formataData(refeicao.getData());
            }
            case 2:{
                return format.formataHora(refeicao.getHora());
            }
            case 3:{
                switch(refeicao.getTipoRefeicao()){
                    case Refeicao.TIPO_CAFE:
                        return "Café";
                    case Refeicao.TIPO_ALMOCO:
                        return "Almoço";
                    case Refeicao.TIPO_JANTA:
                        return "Janta";
                    case Refeicao.TIPO_OUTROS:
                        return "Outros";
                }
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
                return "Data";
            }
            case 2:{
                return "Hora";
            }
            case 3:{
                return "Tipo";
            }
        }
        return null;
    }
    
    public void addRefeicao(Refeicao refeicao){
        refeicoes.add(refeicao);
        fireTableRowsInserted(refeicoes.size()-1, refeicoes.size()-1);
    }
    
    public Refeicao getRefeicao(int indice){
        return refeicoes.get(indice);
    }

    public void limpar(){
        refeicoes.clear();
    }    
}
