package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.entidade.GrupoAlimento;

/**
 *
 * @author gustavo
 */
public class ControleGrupoAlimento extends ControlePadrao<GrupoAlimento>{
    
    private GrupoAlimentoDAO grupoAlimentoDao = getDAOFactory().getGrupoAlimentoDAO();

    @Override
    public boolean salvar(GrupoAlimento t) {
        boolean salvou;
        if(t.getId() != 0){
            salvou = grupoAlimentoDao.alterar(t);
        }else{
            t.setId(grupoAlimentoDao.getNextId());
            salvou = grupoAlimentoDao.inserir(t);
        }
        return salvou;
    }

    @Override
    public boolean excluir(GrupoAlimento t) {
       return grupoAlimentoDao.excluir(t);
    }

    @Override
    public boolean persistir(GrupoAlimento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean listar(GrupoAlimento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
