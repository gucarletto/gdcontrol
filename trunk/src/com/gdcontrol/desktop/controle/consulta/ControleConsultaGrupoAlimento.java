package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.entidade.GrupoAlimento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaGrupoAlimento extends ControleConsultaPadrao<GrupoAlimento>{
    
    private GrupoAlimentoDAO grupoAlimentoDao = getDAOFactory().getGrupoAlimentoDAO();
    
    @Override
    public List<GrupoAlimento> listar() {
        return grupoAlimentoDao.listar();
    }
    
    @Override
    public void excluir(GrupoAlimento t) {
       if(grupoAlimentoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public GrupoAlimento filtraId(int id){
        return grupoAlimentoDao.filtraId(id);
    }
    
    public ArrayList<GrupoAlimento> filtraDescricao(String descricao){
        return grupoAlimentoDao.filtraDescricao(descricao);
    }
}
