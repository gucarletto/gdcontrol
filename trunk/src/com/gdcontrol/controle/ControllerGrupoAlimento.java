package com.gdcontrol.controle;

import br.udesc.gdc.dao.core.GrupoAlimentoDAO;
import br.udesc.gdc.model.GrupoAlimento;

/**
 *
 * @author gustavo
 */
public class ControllerGrupoAlimento extends ControllerPadrao<GrupoAlimento>{
    
    private GrupoAlimentoDAO grupoAlimentoDao = getDAOFactory().getGrupoAlimentoDAO();

    @Override
    public boolean salvar(GrupoAlimento t) {
        if(t.getId() != 0){
            grupoAlimentoDao.inserir(t);
        }else{
            grupoAlimentoDao.
        }
    }

    @Override
    public boolean excluir(GrupoAlimento t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
