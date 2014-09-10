package com.gdcontrol.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Refeicao {
    
    private int id;
    private Date data;
    
    private ArrayList<ItemRefeicao> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<ItemRefeicao> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemRefeicao> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemRefeicao item){
        this.itens.add(item);
    }
}
