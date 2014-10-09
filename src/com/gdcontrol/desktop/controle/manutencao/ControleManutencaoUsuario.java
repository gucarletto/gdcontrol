package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.dao.usuario.UsuarioDAO;
import com.gdcontrol.desktop.visao.manutencao.VisaoManutencaoUsuario;
import com.gdcontrol.entidade.Usuario;
import com.gdcontrol.util.DateUtil;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ControleManutencaoUsuario extends ControleManutencaoPadrao<Usuario>{
    
    UsuarioDAO usuarioDao = getDAOFactory().getUsuarioDAO();
    private VisaoManutencaoUsuario tela;

    @Override
    public void salvar() {
        boolean salvou;
        Usuario usuario = (Usuario) this.getModelo();
        usuario.setNome(this.tela.getEdNome().getText());
        usuario.setTelefone(this.tela.getEdTelefone().getText());
        usuario.setPeso(Double.parseDouble(this.tela.getEdPeso().getText()));
        usuario.setAltura(Double.parseDouble(this.tela.getEdAltura().getText()));
        
        DateUtil format = new DateUtil();
        usuario.setDataNascimento(format.validaData(this.tela.getEdDataNascimento().getText()));
        
        if(this.tela.getRbMasculino().isSelected()){
            usuario.setSexo(Usuario.SEXO_MASCULINO);
        }else{
            usuario.setSexo(Usuario.SEXO_FEMININO);
        }
        
        if(this.tela.getRbTipo1().isSelected()){
            usuario.setTipoDiabete(Usuario.TIPO_1);
        }else{
            usuario.setTipoDiabete(Usuario.TIPO_2);
        }
            
        if(!this.tela.getEdId().getText().isEmpty()){
            salvou = usuarioDao.alterar(usuario);
        }else{
            salvou = usuarioDao.inserir(usuario);
        }
        if(salvou){
            JOptionPane.showMessageDialog(this.tela, "Gravado com sucesso");
        }else{
            JOptionPane.showMessageDialog(this.tela, "Erro na gravação");
        }
    }

    @Override
    public Usuario getModelo() {
        if(this.modelo == null){
            this.modelo = new Usuario();
        }
        return this.modelo;
    }

    @Override
    public void setModelo(Usuario modelo) {
        this.modelo = modelo;
    }
    
    public VisaoManutencaoUsuario getTela() {
        return tela;
    }

    public void setTela(VisaoManutencaoUsuario tela) {
        this.tela = tela;
    }
    
    public void verificaUsuarioExistente(){
        Usuario usu = usuarioDao.buscaPorId(1);
        if(usu != null){
            this.setModelo(usu);
            this.carregaTela();
        }
    }
    
    public void carregaTela(){
        this.tela.getEdId().setText(this.modelo.getPessoaId() + "");
        this.tela.getEdNome().setText(this.modelo.getNome());
        this.tela.getEdAltura().setText(this.modelo.getAltura() + "");
        this.tela.getEdPeso().setText(this.modelo.getPeso()+ "");
        this.tela.getEdTelefone().setText(this.modelo.getTelefone()+ "");

        DateUtil format = new DateUtil();
        this.tela.getEdDataNascimento().setText(format.formataData(this.modelo.getDataNascimento()));
        
        this.tela.getRbMasculino().setSelected(this.modelo.getSexo() == Usuario.SEXO_MASCULINO);
        this.tela.getRbFeminino().setSelected(this.modelo.getSexo() == Usuario.SEXO_FEMININO);
        this.tela.getRbTipo1().setSelected(this.modelo.getTipoDiabete() == Usuario.TIPO_1);
        this.tela.getRbTipo2().setSelected(this.modelo.getTipoDiabete() == Usuario.TIPO_2);
    }   
}
