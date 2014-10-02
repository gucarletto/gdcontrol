package com.gdcontrol.desktop.visao;

import java.awt.Frame;

/**
 *
 * @author gustavo
 */
public abstract class VisaoConsultaPadrao extends VisaoPadrao{

    public VisaoConsultaPadrao(Frame owner, boolean modal) {
        super(owner, modal);
    }
    
    public abstract void getOpcoesPesquisa();
    
}
