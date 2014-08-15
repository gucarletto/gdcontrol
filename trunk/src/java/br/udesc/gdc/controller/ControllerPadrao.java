package java.br.udesc.gdc.controller;

import java.br.udesc.gdc.dao.DAOFactory;

/**
 *
 * @author gustavo
 */
public class ControllerPadrao {
    
    private final DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
    
    protected DAOFactory getDAOFactory() {
        return daoFactory;
    }
    
}
