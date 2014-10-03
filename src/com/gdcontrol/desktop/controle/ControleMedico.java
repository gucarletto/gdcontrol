package com.gdcontrol.desktop.controle;

import com.gdcontrol.dao.medico.MedicoDAO;
import com.gdcontrol.desktop.visao.VisaoManutencaoMedico;
import com.gdcontrol.entidade.Medico;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleMedico extends ControlePadrao<Medico>{
    
    private MedicoDAO medicoDao = getDAOFactory().getMedicoDAO();
    private VisaoManutencaoMedico tela;

    @Override
    public void salvar() {
        boolean salvou;
        Medico medico = (Medico) this.getModelo();
        medico.setNome(this.tela.getEdNome().getText());
        medico.setTelefone(this.tela.getEdTelefone().getText());
        medico.setCrm(this.tela.getEdCrm().getText());
        medico.setEspecializacao(this.tela.getEdEspecializacao().getText());
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = medicoDao.alterar(medico);
        }else{
            salvou = medicoDao.inserir(medico);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public void excluir(Medico t) {
        if(medicoDao.excluir(t)){
           JOptionPane.showMessageDialog(this.tela, "Excluído com sucesso");
       }else{
           JOptionPane.showMessageDialog(this.tela, "Erro na exclusão");
       }
    }

    @Override
    public List<Medico> listar() {
        return medicoDao.listar();
    }

    @Override
    public Medico getModelo() {
        if(this.modelo == null){
            return new Medico();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Medico modelo) {
        this.modelo = modelo;
    }    
    
    public VisaoManutencaoMedico getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoMedico tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getId() + "");
        this.tela.getEdNome().setText(this.modelo.getNome());
        this.tela.getEdTelefone().setText(this.modelo.getTelefone());
        this.tela.getEdCrm().setText(this.modelo.getCrm());
        this.tela.getEdEspecializacao().setText(this.modelo.getEspecializacao());
    }
}