package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.entidade.Posologia;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class PosologiaTableModel extends AbstractTableModel{

    private ArrayList<Posologia> posologias = new ArrayList<>();

    @Override
    public int getRowCount() {
        return posologias.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DateUtil format = new DateUtil();
        Posologia pos = posologias.get(rowIndex);
        switch(columnIndex){
            case 0:{
                return pos.getPosologiaId();
            }
            case 1:{
                return pos.getDosagem();
            }
            case 2:{
                return format.formataHora(pos.getHora());
            }
            case 3:{
                return format.formataData(pos.getPrescricao().getDataInicio());
            }
            case 4:{
                return format.formataData(pos.getPrescricao().getDataFim());
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
                return "Dosagem";
            }
            case 2:{
                return "Hora";
            }
            case 3:{
                return "Início Prescrição";
            }
            case 4:{
                return "Final Prescrição";
            }
        }
        return null;
    }
    
    public void addPosologia(Posologia posologia){
        posologias.add(posologia);
        fireTableRowsInserted(posologias.size()-1, posologias.size()-1);
    }
    
    public Posologia getPosologia(int indice){
        return posologias.get(indice);
    }

    public void limpar(){
        posologias.clear();
    }
}