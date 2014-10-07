package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.medico.MedicoDAO;
import com.gdcontrol.entidade.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaMedico extends ControleConsultaPadrao<Medico>{
    
    private MedicoDAO medicoDao = getDAOFactory().getMedicoDAO();
    
    @Override
    public void excluir(Medico t) {
        if(medicoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }

    @Override
    public List<Medico> listar() {
        return medicoDao.listar();
    }
    
    public Medico filtraId(int id){
        return medicoDao.filtraId(id);
    }
    
    public ArrayList<Medico> filtraNome(String nome){
        return medicoDao.filtraNome(nome);
    }
    
    public ArrayList<Medico> filtraTelefone(String tel){
        return medicoDao.filtraTelefone(tel);
    }
    
    public ArrayList<Medico> filtraCrm(String crm){
        return medicoDao.filtraCrm(crm);
    }
    
    public ArrayList<Medico> filtraEspecializacao(String espec){
        return medicoDao.filtraEspecializacao(espec);
    }    
}
