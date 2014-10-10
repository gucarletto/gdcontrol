package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.dao.DAOFactory;
import com.gdcontrol.dao.tipoteste.TipoTesteDAO;
import com.gdcontrol.entidade.Teste;
import com.gdcontrol.entidade.TipoTeste;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class TesteTableModel extends AbstractTableModel{

    private ArrayList<Teste> testes = new ArrayList<>();

    @Override
    public int getRowCount() {
        return testes.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoTesteDAO tipoTesteDao = DAOFactory.getDAOFactory().getTipoTesteDAO();
        Teste teste = testes.get(rowIndex);
        TipoTeste tipo = tipoTesteDao.filtraId(teste.getTipoTesteId());
        
        DateUtil format = new DateUtil();
        
        switch(columnIndex){
            case 0:{
                return teste.getTesteId();
            }
            case 1:{
                return format.formataData(teste.getDataHora());
            }
            case 2:{
                return format.formataHora(teste.getDataHora());
            }
            case 3:{
                return teste.getValor();
            }
            case 4:{
                return tipo.getDescricao();
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
                return "Valor";
            }
            case 4:{
                return "Tipo Teste";
            }
        }
        return null;
    }
    
    public void addTeste(Teste teste){
        testes.add(teste);
        fireTableRowsInserted(testes.size()-1, testes.size()-1);
    }
    
    public Teste getTeste(int indice){
        return testes.get(indice);
    }

    public void limpar(){
        testes.clear();
    }
}
