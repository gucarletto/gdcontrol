package com.gdcontrol.dao;

import com.gdcontrol.dao.core.GrupoAlimentoDAO;
import com.gdcontrol.dao.xml.XMLGrupoAlimentoDAO;

/**
 * 
 * @author gustavo
 */
public class XMLDAOFactory extends DAOFactory {
    
    public GrupoAlimentoDAO getGrupoAlimentoDAO(){
        return new XMLGrupoAlimentoDAO();
    }
    
}