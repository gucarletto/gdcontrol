package com.gdcontrol.controle;

import br.udesc.gdc.dao.DAOFactory;

/**
 *
 * @author gustavo
 * @param <T>
 */
public abstract class ControllerPadrao<T extends Object>{
    
    private final DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    
    protected DAOFactory getDAOFactory() {
        return daoFactory;
    }
    
    public abstract boolean salvar(T t);
    public abstract boolean excluir(T t);
    public abstract boolean persistir(T t);
    public abstract boolean listar(T t);
}
