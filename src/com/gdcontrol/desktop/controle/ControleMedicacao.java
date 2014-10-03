package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.medicacao.MedicacaoDAO;
import com.gdcontrol.desktop.visao.VisaoManutencaoMedicacao;
import com.gdcontrol.entidade.Medicacao;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleMedicacao extends ControlePadrao<Medicacao>{
    
    private MedicacaoDAO medicacaoDao = getDAOFactory().getMedicacaoDAO();
    private VisaoManutencaoMedicacao tela;

    @Override
    public void salvar() {
        boolean salvou;
        Medicacao medicacao = (Medicacao) this.getModelo();
        medicacao.setNomeComercial(this.tela.getEdNomeComercial().getText());
        medicacao.setNomeQuimico(this.tela.getEdNomeQuimico().getText());
        medicacao.setMarca(this.tela.getEdMarca().getText());
        medicacao.setUnidade(this.tela.getEdUnidade().getText());
        medicacao.setFormaUso(this.tela.getEdFormaUso().getText());
        medicacao.setObservacao(this.tela.getEdObservacao().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = medicacaoDao.alterar(medicacao);
        }else{
            salvou = medicacaoDao.inserir(medicacao);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public void excluir(Medicacao t) {
       if(medicacaoDao.excluir(t)){
           JOptionPane.showMessageDialog(this.tela, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(this.tela, "Erro na exclusão");
       }
    }

    @Override
    public List<Medicacao> listar() {
        return medicacaoDao.listar();
    }

    @Override
    public Medicacao getModelo() {
        if(this.modelo == null){
            return new Medicacao();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Medicacao modelo) {
        this.modelo = modelo;
    }

    public VisaoManutencaoMedicacao getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoMedicacao tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getId() + "");
        this.tela.getEdNomeComercial().setText(this.modelo.getNomeComercial());
        this.tela.getEdNomeQuimico().setText(this.modelo.getNomeQuimico());
        this.tela.getEdMarca().setText(this.modelo.getMarca());
        this.tela.getEdUnidade().setText(this.modelo.getUnidade());
        this.tela.getEdFormaUso().setText(this.modelo.getFormaUso());
        this.tela.getEdObservacao().setText(this.modelo.getObservacao());
    }   
}