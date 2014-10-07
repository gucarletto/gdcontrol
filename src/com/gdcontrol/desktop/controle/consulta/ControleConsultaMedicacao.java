package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.medicacao.MedicacaoDAO;
import com.gdcontrol.entidade.Medicacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaMedicacao extends ControleConsultaPadrao<Medicacao>{
    
    private MedicacaoDAO medicacaoDao = getDAOFactory().getMedicacaoDAO();
    
    @Override
    public void excluir(Medicacao t) {
       if(medicacaoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }

    @Override
    public List<Medicacao> listar() {
        return medicacaoDao.listar();
    }
    
    public Medicacao filtraId(int id){
        return medicacaoDao.filtraId(id);
    }
    
    public ArrayList<Medicacao> filtraMarca(String marca){
        return medicacaoDao.filtraMarca(marca);
    }
    
    public ArrayList<Medicacao> filtraNomeComercial(String nome){
        return medicacaoDao.filtraNomeComercial(nome);
    }
    
    public ArrayList<Medicacao> filtraNomeQuimico(String nome){
        return medicacaoDao.filtraNomeQuimico(nome);
    }
    
    public ArrayList<Medicacao> filtraUnidade(String und){
        return medicacaoDao.filtraUnidade(und);
    }    
}
