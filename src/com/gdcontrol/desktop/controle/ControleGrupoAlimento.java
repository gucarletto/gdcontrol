package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.desktop.visao.VisaoManutencaoGrupoAlimento;
import com.gdcontrol.entidade.GrupoAlimento;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleGrupoAlimento extends ControlePadrao<GrupoAlimento>{
    
    private GrupoAlimentoDAO grupoAlimentoDao = getDAOFactory().getGrupoAlimentoDAO();
    private VisaoManutencaoGrupoAlimento tela;

    @Override
    public void salvar() {
        boolean salvou;
        GrupoAlimento grupo = (GrupoAlimento) this.getModelo();
        grupo.setDescricao(this.tela.getEdDescricao().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            grupo.setId(Integer.parseInt(this.tela.getEdId().getText()));
            salvou = grupoAlimentoDao.alterar(grupo);
        }else{
            salvou = grupoAlimentoDao.inserir(grupo);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public void excluir(GrupoAlimento t) {
       if(grupoAlimentoDao.excluir(t)){
           JOptionPane.showMessageDialog(this.tela, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(this.tela, "Erro na exclusão");
       }
    }

    @Override
    public List<GrupoAlimento> listar() {
        return grupoAlimentoDao.listar();
    }

    @Override
    public GrupoAlimento getModelo() {
        if(this.modelo == null){
            return new GrupoAlimento();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(GrupoAlimento modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoGrupoAlimento getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoGrupoAlimento tela) {
        this.tela = tela;
    }
}
