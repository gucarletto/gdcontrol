package com.gdcontrol.desktop.visao.manutencao;

import com.gdcontrol.desktop.visao.VisaoPadrao;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.text.JTextComponent;

/**
 *
 * @author gustavo
 */
public abstract class VisaoManutencaoPadrao extends VisaoPadrao{
    
    private ArrayList<JTextComponent> componentesTexto = new ArrayList<JTextComponent>();

    public VisaoManutencaoPadrao(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public ArrayList<JTextComponent> getComponentesTexto() {
        return componentesTexto;
    }

    public void setComponentesTexto(ArrayList<JTextComponent> componentesTexto) {
        this.componentesTexto = componentesTexto;
    }
    
    public void addComponenteTexto(JTextComponent componenteTexto) {
        this.componentesTexto.add(componenteTexto);
    }
    
    protected void limpar(){
        for(JTextComponent componenteTexto : this.getComponentesTexto()){
             componenteTexto.setText("");
        }
    }
}
