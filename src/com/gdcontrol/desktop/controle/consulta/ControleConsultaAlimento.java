package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.alimento.AlimentoDAO;
import com.gdcontrol.entidade.Alimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaAlimento extends ControleConsultaPadrao<Alimento>{
    
    private AlimentoDAO alimentoDao = getDAOFactory().getAlimentoDAO();

    @Override
    public List<Alimento> listar() {
        return alimentoDao.listar();
    }

    @Override
    public void excluir(Alimento t) {
        if(alimentoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public Alimento filtraId(int id){
        return alimentoDao.filtraId(id);
    }
    public ArrayList<Alimento> filtraNome(String nome){
        return alimentoDao.filtraNome(nome);
    }
    public ArrayList<Alimento> filtraIdGrupo(int id){
        return alimentoDao.filtraIdGrupo(id);
    }
    public ArrayList<Alimento> filtraDescricaoGrupo(String descricao){
        return alimentoDao.filtraDescricaoGrupo(descricao);
    }
}
