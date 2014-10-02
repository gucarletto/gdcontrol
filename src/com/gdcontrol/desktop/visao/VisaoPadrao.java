package com.gdcontrol.desktop.visao;

import com.gdcontrol.desktop.controle.ControlePadrao;
import java.awt.Frame;
import javax.swing.JDialog;

/**
 *
 * @author gustavo
 */
public abstract class VisaoPadrao extends JDialog{
    
    public VisaoPadrao(Frame owner, boolean modal) {
        super(owner, modal);
    }
    
    public abstract ControlePadrao getControle();
}
