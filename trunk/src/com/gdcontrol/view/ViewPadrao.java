package br.udesc.gdc.view;

import com.gdcontrol.controle.ControllerPadrao;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.text.JTextComponent;

/**
 *
 * @author gustavo
 */
public abstract class ViewPadrao extends JDialog{
    
    private ArrayList<JTextComponent> componentesTexto = new ArrayList<JTextComponent>();

    public ViewPadrao(Frame owner, boolean modal) {
        super(owner, modal);
    }
    
    public abstract ControllerPadrao getController();

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
