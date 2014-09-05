package br.udesc.gdc.view;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JDialog;

/**
 *
 * @author gustavo
 */
public abstract class ViewPadrao extends JDialog{
    
    private ArrayList<JComponent> componentes;

    public ViewPadrao(Frame owner, boolean modal) {
        super(owner, modal);
    }

    public ArrayList<JComponent> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<JComponent> componentes) {
        this.componentes = componentes;
    }
    
    public void addComponente(JComponent componente) {
        this.componentes.add(componente);
    }
    
    protected void limpar(){
        for(JComponent componente : this.getComponentes()){
            //switch(componente.clas)
        }
    }
}
