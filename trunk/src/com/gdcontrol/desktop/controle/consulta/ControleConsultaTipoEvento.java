package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.tipoevento.TipoEventoDAO;
import com.gdcontrol.entidade.TipoEvento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaTipoEvento extends ControleConsultaPadrao<TipoEvento>{
    
    private TipoEventoDAO tipoEventoDao = getDAOFactory().getTipoEventoDAO();
    
    @Override
    public void excluir(TipoEvento t) {
        if(tipoEventoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }

    @Override
    public List<TipoEvento> listar() {
        return tipoEventoDao.listar();
    }
    
    public TipoEvento filtraId(int id){
        return tipoEventoDao.filtraId(id);
    }
    
    public ArrayList<TipoEvento> filtraNome(String nome){
        return tipoEventoDao.filtraNome(nome);
    }
}
