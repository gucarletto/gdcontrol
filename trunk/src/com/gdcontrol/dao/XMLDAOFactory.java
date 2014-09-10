package br.udesc.gdc.dao;

import br.udesc.gdc.dao.core.GrupoAlimentoDAO;
import br.udesc.gdc.dao.xml.XMLGrupoAlimentoDAO;

/**
 * 
 * @author gustavo
 */
public class XMLDAOFactory extends DAOFactory {
    
    public GrupoAlimentoDAO getGrupoAlimentoDAO(){
        return new XMLGrupoAlimentoDAO();
    }
    
}