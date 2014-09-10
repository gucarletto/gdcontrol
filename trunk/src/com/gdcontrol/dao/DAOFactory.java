package br.udesc.gdc.dao;

import br.udesc.gdc.dao.core.GrupoAlimentoDAO;

/**
 * 
 * @author gustavo
 */
public abstract class DAOFactory {

    public static final int XML = 1;
    
    public abstract GrupoAlimentoDAO getGrupoAlimentoDAO();

    public static DAOFactory getDAOFactory(int fabrica) {

        switch (fabrica) {
            case XML:
                return new XMLDAOFactory();
            default:
                return null;
        }
    }
}
