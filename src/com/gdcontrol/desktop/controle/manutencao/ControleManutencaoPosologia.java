package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.posologia.PosologiaDAO;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoPosologia;
import com.gdcontrol.entidade.Posologia;
import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.util.DateUtil;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoPosologia extends ControleManutencaoPadrao<Posologia>{
    
    private PosologiaDAO posologiaDao = getDAOFactory().getPosologiaDAO();
    private VisaoManutencaoPosologia tela;

    @Override
    public void salvar() {
        DateUtil format = new DateUtil();
        boolean salvou;
        Posologia tipo = (Posologia) this.getModelo();
        tipo.setDosagem(this.tela.getEdDosagem().getText());
        tipo.setHora(format.validaHora(this.tela.getEdHora().getText()));
        tipo.setPrescricaoId(Integer.parseInt(this.tela.getEdIdPrescricao().getText()));
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = posologiaDao.alterar(tipo);
        }else{
            salvou = posologiaDao.inserir(tipo);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public Posologia getModelo() {
        if(this.modelo == null){
            return new Posologia();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Posologia modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoPosologia getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoPosologia tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        DateUtil format = new DateUtil();
        
        this.tela.getEdId().setText(this.modelo.getPosologiaId() + "");
        this.tela.getEdDosagem().setText(this.modelo.getDosagem());
        this.tela.getEdHora().setText(format.formataHora(this.modelo.getHora()));
        this.tela.getEdIdPrescricao().setText(this.modelo.getPrescricaoId() + "");
        this.tela.getEdHoraInicioPrescricao().setText(format.formataData(this.modelo.getPrescricao().getDataInicio()));
    }
    
    public Prescricao buscaPrescricao(int id){
        return getDAOFactory().getPrescricaoDAO().filtraId(id);
    }
}
