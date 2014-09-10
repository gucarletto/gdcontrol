package com.gdcontrol.modelo;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Cardapio {
    
    private int id;
    private String nome;
    
    private ArrayList<Ingrediente> ingredientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void addIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }
}