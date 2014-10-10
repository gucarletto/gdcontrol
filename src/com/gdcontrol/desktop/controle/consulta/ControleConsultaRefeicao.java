package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.refeicao.RefeicaoDAO;
import com.gdcontrol.entidade.Refeicao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaRefeicao extends ControleConsultaPadrao<Refeicao>{
    
    private RefeicaoDAO refeicaoDao = getDAOFactory().getRefeicaoDAO();

    @Override
    public List<Refeicao> listar() {
        return refeicaoDao.listar();
    }

    @Override
    public void excluir(Refeicao t) {
        if(refeicaoDao.excluir(t)){
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public Refeicao filtraId(int id){
        return refeicaoDao.filtraId(id);
    }
    
    public ArrayList<Refeicao> filtraData(String data){
        return refeicaoDao.filtraData(data);
    }
    
    public ArrayList<Refeicao> filtraHora(String hora){
        return refeicaoDao.filtraHora(hora);
    }
    
    public ArrayList<Refeicao> filtraTipo(String tipo){
        return refeicaoDao.filtraTipo(tipo);
    }
}
