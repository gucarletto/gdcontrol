package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.evento.EventoDAO;
import com.gdcontrol.entidade.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaEvento extends ControleConsultaPadrao<Evento>{
    
    private EventoDAO eventoDao = getDAOFactory().getEventoDAO();

    @Override
    public List<Evento> listar() {
        return eventoDao.listar();
    }

    @Override
    public void excluir(Evento t) {
        if(eventoDao.excluir(t)){
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public Evento filtraId(int id){
        return eventoDao.filtraId(id);
    }
    
    public ArrayList<Evento> filtraDataInicio(String data){
        return eventoDao.filtraDataInicio(data);
    }
    
    public ArrayList<Evento> filtraDataFim(String data){
        return eventoDao.filtraDataFim(data);
    }
    
    public ArrayList<Evento> filtraHora(String hora){
        return eventoDao.filtraHora(hora);
    }
    
    public ArrayList<Evento> filtraValor(int valor){
        return eventoDao.filtraValor(valor);
    }
    
    public ArrayList<Evento> filtraNomeTipo(String nome){
        return eventoDao.filtraNomeTipo(nome);
    }    
}
