package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.DAOFactory;

/**
 *
 * @author gustavo
 */
public abstract class ControlePadrao{
    
    private final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    
    protected DAOFactory getDAOFactory() {
        return daoFactory;
    }
}
