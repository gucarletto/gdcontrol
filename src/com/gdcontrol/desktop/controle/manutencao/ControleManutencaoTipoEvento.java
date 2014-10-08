package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoTipoEvento;
import com.gdcontrol.dao.tipoevento.TipoEventoDAO;
import com.gdcontrol.entidade.TipoEvento;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoTipoEvento extends ControleManutencaoPadrao<TipoEvento>{
    
    private TipoEventoDAO tipoEventoDao = getDAOFactory().getTipoEventoDAO();
    private VisaoManutencaoTipoEvento tela;

    @Override
    public void salvar() {
        boolean salvou;
        TipoEvento tipo = (TipoEvento) this.getModelo();
        tipo.setNome(this.tela.getEdNome().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = tipoEventoDao.alterar(tipo);
        }else{
            salvou = tipoEventoDao.inserir(tipo);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public TipoEvento getModelo() {
        if(this.modelo == null){
            return new TipoEvento();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(TipoEvento modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoTipoEvento getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoTipoEvento tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getId() + "");
        this.tela.getEdNome().setText(this.modelo.getNome());
    }
}
