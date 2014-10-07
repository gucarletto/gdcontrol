package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.dao.tipoteste.TipoTesteDAO;
import com.gdcontrol.entidade.TipoTeste;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleConsultaTipoTeste extends ControleConsultaPadrao<TipoTeste> {
    
    private TipoTesteDAO tipoTesteDao = getDAOFactory().getTipoTesteDAO();

    @Override
    public void excluir(TipoTeste t) {
        if (tipoTesteDao.excluir(t)) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na exclusão");
        }
    }

    @Override
    public List<TipoTeste> listar() {
        return tipoTesteDao.listar();
    }
    
    public TipoTeste filtraId(int id){
        return tipoTesteDao.filtraId(id);
    }
    
    public ArrayList<TipoTeste> filtraDescricao(String descricao){
        return tipoTesteDao.filtraDescricao(descricao);
    }
}
