package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.aplicacao.AplicacaoDAO;
import com.gdcontrol.entidade.Aplicacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ControleConsultaAplicacao extends ControleConsultaPadrao<Aplicacao>{

    private AplicacaoDAO aplicacaoDao = getDAOFactory().getAplicacaoDAO();
    
    @Override
    public List<Aplicacao> listar() {
        return this.aplicacaoDao.listar();
    }

    @Override
    public void excluir(Aplicacao t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Aplicacao filtraId(int id){
        return aplicacaoDao.filtraId(id);
    }
    
    public ArrayList<Aplicacao> filtraDosagemAplicada(double dose){
        return aplicacaoDao.filtraDosagemAplicada(dose);
    }
    
    public ArrayList<Aplicacao> filtraData(String data){
        return aplicacaoDao.filtraData(data);
    }
    
    public ArrayList<Aplicacao> filtraNomeComercialMedicacao(String nome){
        return aplicacaoDao.filtraNomeComercialMedicacao(nome);
    }
    
    public ArrayList<Aplicacao> filtraDescricaoLocalAplicacao(String nome){
        return aplicacaoDao.filtraDescricaoLocalAplicacao(nome);
    }
}
