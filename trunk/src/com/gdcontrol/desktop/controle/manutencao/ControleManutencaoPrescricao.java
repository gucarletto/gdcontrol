package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.prescricao.PrescricaoDAO;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoPrescricao;
import com.gdcontrol.entidade.Medicacao;
import com.gdcontrol.entidade.Medico;
import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.util.DateUtil;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoPrescricao extends ControleManutencaoPadrao<Prescricao>{
    
    private PrescricaoDAO prescricaoDao = getDAOFactory().getPrescricaoDAO();
    private VisaoManutencaoPrescricao tela;

    @Override
    public void salvar() {
        DateUtil format = new DateUtil();
        boolean salvou;
        
        Prescricao prescricao = (Prescricao) this.getModelo();
        prescricao.setFatorCarboidrato(Double.parseDouble(this.tela.getEdFatorCarboidrato().getText()));
        prescricao.setFatorCorrecao(Double.parseDouble(this.tela.getEdFatorCorrecao().getText()));
        prescricao.setFatorSensibilidade(Double.parseDouble(this.tela.getEdFatorSensibilidade().getText()));
        prescricao.setMinimoGlicemia(Double.parseDouble(this.tela.getEdMinimoGlicemia().getText()));
        prescricao.setMaximoGlicemia(Double.parseDouble(this.tela.getEdMaximoGlicemia().getText()));
        prescricao.setDataInicio(format.validaData(this.tela.getEdDataInicio().getText()));
        prescricao.setDataFim(format.validaData(this.tela.getEdDataFim().getText()));
        prescricao.setMedicacaoId(Integer.parseInt(this.tela.getEdIdMedicacao().getText()));
        prescricao.setMedicoId(Integer.parseInt(this.tela.getEdIdMedico().getText()));
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = prescricaoDao.alterar(prescricao);
        }else{
            salvou = prescricaoDao.inserir(prescricao);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public Prescricao getModelo() {
        if(this.modelo == null){
            return new Prescricao();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Prescricao modelo) {
        this.modelo = modelo;
    }    
    
    public VisaoManutencaoPrescricao getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoPrescricao tela) {
        this.tela = tela;
    }
    
    public void carregaTela(){
        DateUtil format = new DateUtil();
        this.tela.getEdId().setText(this.modelo.getPrescricaoId()+ "");
        this.tela.getEdFatorCarboidrato().setText(this.modelo.getFatorCarboidrato()+ "");
        this.tela.getEdFatorCorrecao().setText(this.modelo.getFatorCorrecao()+ "");
        this.tela.getEdFatorSensibilidade().setText(this.modelo.getFatorSensibilidade()+ "");
        this.tela.getEdMinimoGlicemia().setText(this.modelo.getMinimoGlicemia()+ "");
        this.tela.getEdMaximoGlicemia().setText(this.modelo.getMaximoGlicemia()+ "");
        this.tela.getEdDataInicio().setText(format.formataData(this.modelo.getDataInicio()));
        this.tela.getEdDataFim().setText(format.formataData(this.modelo.getDataFim()));
        this.tela.getEdIdMedico().setText(this.modelo.getMedicoId() + "");
        this.tela.getEdNomeMedico().setText(this.modelo.getMedico().getNome());
        this.tela.getEdIdMedicacao().setText(this.modelo.getMedicacaoId() + "");
        this.tela.getEdNomeMedicacao().setText(this.modelo.getMedicacao().getNomeComercial());
    }
    
    public Medico buscaMedico(int id){
        return getDAOFactory().getMedicoDAO().filtraId(id);
    }
    
    public Medicacao buscaMedicacao(int id){
        return getDAOFactory().getMedicacaoDAO().filtraId(id);
    }
}
