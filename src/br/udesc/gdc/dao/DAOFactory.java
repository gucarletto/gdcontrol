package br.udesc.gdc.dao;

/**
 * 
 * @author gustavo
 */
public abstract class DAOFactory {

    public static final int XML = 1;

    public static DAOFactory getDAOFactory(int fabrica) {

        switch (fabrica) {
            case XML:
                return new XMLDAOFactory();
            default:
                return null;
        }
    }
}