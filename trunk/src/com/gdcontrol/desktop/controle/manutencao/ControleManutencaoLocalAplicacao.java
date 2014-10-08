package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.localaplicacao.LocalAplicacaoDAO;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoLocalAplicacao;
import com.gdcontrol.entidade.LocalAplicacao;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoLocalAplicacao extends ControleManutencaoPadrao<LocalAplicacao>{
    
    private LocalAplicacaoDAO localAplicacaoDao = getDAOFactory().getLocalAplicacaoDAO();
    private VisaoManutencaoLocalAplicacao tela;

    @Override
    public void salvar() {
        boolean salvou;
        LocalAplicacao grupo = (LocalAplicacao) this.getModelo();
        grupo.setDescricao(this.tela.getEdDescricao().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = localAplicacaoDao.alterar(grupo);
        }else{
            salvou = localAplicacaoDao.inserir(grupo);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public LocalAplicacao getModelo() {
        if(this.modelo == null){
            return new LocalAplicacao();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(LocalAplicacao modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoLocalAplicacao getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoLocalAplicacao tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getId() + "");
        this.tela.getEdDescricao().setText(this.modelo.getDescricao());
    }
    
}
