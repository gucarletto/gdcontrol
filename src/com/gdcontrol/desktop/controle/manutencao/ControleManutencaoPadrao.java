package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.desktop.controle.ControlePadrao;

/**
 *
 * @author gustavo
 */
public abstract class ControleManutencaoPadrao<T> extends ControlePadrao{
    
    protected T modelo;
    
    public abstract void salvar();
    
    public abstract T getModelo();
    public abstract void setModelo(T modelo);
}
