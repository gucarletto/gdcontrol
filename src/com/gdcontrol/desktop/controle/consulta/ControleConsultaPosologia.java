package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.posologia.PosologiaDAO;
import com.gdcontrol.entidade.Posologia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaPosologia extends ControleConsultaPadrao<Posologia>{
    
    private PosologiaDAO posologiaDao = getDAOFactory().getPosologiaDAO();
    
    @Override
    public void excluir(Posologia t) {
        if(posologiaDao.excluir(t)){
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
            JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }

    @Override
    public List<Posologia> listar() {
        return posologiaDao.listar();
    }
    
    public Posologia filtraId(int id){
        return posologiaDao.filtraId(id);
    }
    
    public ArrayList<Posologia> filtraDosagem(String dosagem){
        return posologiaDao.filtraDosagem(dosagem);
    }
    
    public ArrayList<Posologia> filtraHora(String hora){
        return posologiaDao.filtraHora(hora);
    }
    
    public ArrayList<Posologia> filtraInicioPrescricao(String data){
        return posologiaDao.filtraInicioPrescricao(data);
    }
    
    public ArrayList<Posologia> filtraFinalPrescricao(String data){
        return posologiaDao.filtraFinalPrescricao(data);
    }
}
