package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.alimento.AlimentoDAO;
import com.gdcontrol.dao.grupoalimento.GrupoAlimentoDAO;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoAlimento;
import com.gdcontrol.entidade.Alimento;
import com.gdcontrol.entidade.GrupoAlimento;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoAlimento extends ControleManutencaoPadrao<Alimento>{

    private AlimentoDAO alimentoDao = getDAOFactory().getAlimentoDAO();
    private GrupoAlimentoDAO grupoAlimentoDao = getDAOFactory().getGrupoAlimentoDAO();
    private VisaoManutencaoAlimento tela;

    @Override
    public void salvar() {
        boolean salvou;
        Alimento alimento = (Alimento) this.getModelo();
        alimento.setNome(this.tela.getEdNome().getText());
        alimento.setCarboidrato(Integer.parseInt(this.tela.getEdCarboidrato().getText()));
        alimento.setCaloria(Integer.parseInt(this.tela.getEdCaloria().getText()));
        alimento.setProteina(Integer.parseInt(this.tela.getEdProteina().getText()));
        alimento.setGordura(Integer.parseInt(this.tela.getEdGordura().getText()));
        alimento.setMedidaExata(this.tela.getEdMedidaExata().getText());
        alimento.setMedidaUsual(this.tela.getEdMedidaUsual().getText());
        alimento.setUnidadeMedida(this.tela.getEdUnidadeMedida().getText());
        alimento.setGrupoAlimentoID(Integer.parseInt(this.tela.getEdIdGrupo().getText()));
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = alimentoDao.alterar(alimento);
        }else{
            salvou = alimentoDao.inserir(alimento);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public Alimento getModelo() {
        if(this.modelo == null){
            return new Alimento();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Alimento modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoAlimento getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoAlimento tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getAlimentoId() + "");
        this.tela.getEdNome().setText(this.modelo.getNome());
        this.tela.getEdCarboidrato().setText(this.modelo.getCarboidrato()+"");
        this.tela.getEdCaloria().setText(this.modelo.getCaloria()+"");
        this.tela.getEdProteina().setText(this.modelo.getProteina()+"");
        this.tela.getEdGordura().setText(this.modelo.getGordura()+"");
        this.tela.getEdMedidaExata().setText(this.modelo.getMedidaExata());
        this.tela.getEdMedidaUsual().setText(this.modelo.getMedidaUsual());
        this.tela.getEdUnidadeMedida().setText(this.modelo.getUnidadeMedida());
        
        GrupoAlimento grupo = this.buscaGrupo(this.modelo.getGrupoAlimentoID());
        if(grupo != null){
            this.tela.getEdIdGrupo().setText(grupo.getGrupoAlimentoId()+"");
            this.tela.getEdDescricaoGrupo().setText(grupo.getDescricao());
        }
    }
    
    public GrupoAlimento buscaGrupo(int id){
        return grupoAlimentoDao.filtraId(id);
    }
}
