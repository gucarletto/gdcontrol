package com.gdcontrol.desktop.controle;

import com.gdcontrol.entidade.TipoTeste;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ControleTipoTeste extends ControlePadrao<TipoTeste>{

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(TipoTeste t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoTeste> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoTeste getModelo() {
        return this.modelo;
    }

    @Override
    public void setModelo(TipoTeste modelo) {
        this.modelo = modelo;
    }
}
