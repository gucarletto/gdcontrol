package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.prescricao.PrescricaoDAO;
import com.gdcontrol.entidade.Prescricao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaPrescricao extends ControleConsultaPadrao<Prescricao>{
    
    private PrescricaoDAO prescricaoDao = getDAOFactory().getPrescricaoDAO();
    
    @Override
    public void excluir(Prescricao t) {
        if(prescricaoDao.excluir(t)){
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
            JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }

    @Override
    public List<Prescricao> listar() {
        return prescricaoDao.listar();
    }
    
    public Prescricao filtraId(int id){
        return prescricaoDao.filtraId(id);
    }
    
    public ArrayList<Prescricao> filtraDataInicio(String data){
        return prescricaoDao.filtraDataInicio(data);
    }
    
    public ArrayList<Prescricao> filtraDataFim(String data){
        return prescricaoDao.filtraDataFim(data);
    }
    
    public ArrayList<Prescricao> filtraNomeMedico(String nome){
        return prescricaoDao.filtraNomeMedico(nome);
    }
    
    public ArrayList<Prescricao> filtraNomeComercialMedicacao(String nome){
        return prescricaoDao.filtraNomeComercialMedicacao(nome);
    }
}
