package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.tipoteste.TipoTesteDAO;
import com.gdcontrol.desktop.visao.VisaoManutencaoTipoTeste;
import com.gdcontrol.entidade.TipoTeste;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoTipoTeste extends ControleManutencaoPadrao<TipoTeste>{
    
    private TipoTesteDAO tipoTesteDao = getDAOFactory().getTipoTesteDAO();
    private VisaoManutencaoTipoTeste tela;

    @Override
    public void salvar() {
        boolean salvou;
        TipoTeste tipo = (TipoTeste) this.getModelo();
        tipo.setDescricao(this.tela.getEdDescricao().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = tipoTesteDao.alterar(tipo);
        }else{
            salvou = tipoTesteDao.inserir(tipo);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public TipoTeste getModelo() {
        if(this.modelo == null){
            return new TipoTeste();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(TipoTeste modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoTipoTeste getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoTipoTeste tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getId() + "");
        this.tela.getEdDescricao().setText(this.modelo.getDescricao());
    }
}
