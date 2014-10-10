package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.teste.TesteDAO;
import com.gdcontrol.entidade.Teste;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaTeste extends ControleConsultaPadrao<Teste>{

    private TesteDAO testeDao = getDAOFactory().getTesteDAO();

    @Override
    public List<Teste> listar() {
        return testeDao.listar();
    }

    @Override
    public void excluir(Teste t) {
        if(testeDao.excluir(t)){
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(null, "Erro na exclusão");
       }
    }
    
    public Teste filtraId(int id){
        return testeDao.filtraId(id);
    }
    
    public ArrayList<Teste> filtraData(String data){
        return testeDao.filtraData(data);
    }
    
    public ArrayList<Teste> filtraHora(String hora){
        return testeDao.filtraHora(hora);
    }
    
    public ArrayList<Teste> filtraValor(int valor){
        return testeDao.filtraValor(valor);
    }
    
    public ArrayList<Teste> filtraDescricaoTipo(String descricao){
        return testeDao.filtraDescricaoTipoTeste(descricao);
    }
}
