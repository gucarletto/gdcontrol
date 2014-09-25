package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.DAOFactory;
import java.util.List;
import javax.swing.JDialog;

/**
 *
 * @author gustavo
 * @param <T>
 */
public abstract class ControlePadrao<T>{
    
    private final DAOFactory daoFactory = DAOFactory.getDAOFactory();
    
    protected T modelo;
    
    protected DAOFactory getDAOFactory() {
        return daoFactory;
    }
    
    public abstract void salvar();
    public abstract void excluir(T t);
    public abstract List<T> listar();
    public abstract T getModelo();
    public abstract void setModelo(T modelo);
}
