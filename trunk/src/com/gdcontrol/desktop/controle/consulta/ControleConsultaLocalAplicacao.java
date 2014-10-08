package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.localaplicacao.LocalAplicacaoDAO;
import com.gdcontrol.entidade.LocalAplicacao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaLocalAplicacao extends ControleConsultaPadrao<LocalAplicacao>{
    
    private LocalAplicacaoDAO localAplicacaoDao = getDAOFactory().getLocalAplicacaoDAO();

    @Override
    public List<LocalAplicacao> listar() {
        return localAplicacaoDao.listar();
    }

    @Override
    public void excluir(LocalAplicacao t) {
        if(localAplicacaoDao.excluir(t)){
           JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public LocalAplicacao filtraId(int id){
        return localAplicacaoDao.filtraId(id);
    }
    
    public ArrayList<LocalAplicacao> filtraDescricao(String descricao){
        return localAplicacaoDao.filtraDescricao(descricao);
    }
}
