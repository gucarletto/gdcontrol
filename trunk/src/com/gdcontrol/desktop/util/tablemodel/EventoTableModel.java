package com.gdcontrol.desktop.util.tablemodel;

import com.gdcontrol.dao.DAOFactory;
import com.gdcontrol.dao.tipoevento.TipoEventoDAO;
import com.gdcontrol.entidade.Evento;
import com.gdcontrol.entidade.TipoEvento;
import com.gdcontrol.util.DateUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author gustavo
 */
public class EventoTableModel extends AbstractTableModel{
    
    private ArrayList<Evento> eventos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return eventos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TipoEventoDAO tipoEventoDao = DAOFactory.getDAOFactory().getTipoEventoDAO();
        Evento evento = eventos.get(rowIndex);
        TipoEvento tipo = tipoEventoDao.filtraId(evento.getTipoEventoId());
        
        DateUtil format = new DateUtil();
        
        switch(columnIndex){
            case 0:{
                return evento.getEventoId();
            }
            case 1:{
                return format.formataData(evento.getDataInicio());
            }
            case 2:{
                return format.formataData(evento.getDataFim());
            }
            case 3:{
                return format.formataHora(evento.getHora());
            }
            case 4:{
                return evento.getValor();
            }
            case 5:{
                return tipo.getNome();
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
                return "Data Início";
            }
            case 2:{
                return "Data Fim";
            }
            case 3:{
                return "Hora";
            }
            case 4:{
                return "Valor";
            }
            case 5:{
                return "Tipo Evento";
            }
        }
        return null;
    }
    
    public void addEvento(Evento evento){
        eventos.add(evento);
        fireTableRowsInserted(eventos.size()-1, eventos.size()-1);
    }
    
    public Evento getEvento(int indice){
        return eventos.get(indice);
    }

    public void limpar(){
        eventos.clear();
    }
}