package com.gdcontrol.desktop.controle.consulta;

import com.gdcontrol.desktop.controle.ControlePadrao;
import java.util.List;

/**
 *
 * @author gustavo
 */
public abstract class ControleConsultaPadrao<T> extends ControlePadrao{
    
    public abstract List<T> listar();
    public abstract void excluir(T t);
}
