package br.udesc.gdc.model;

import java.sql.Time;

/**
 *
 * @author gustavo
 */
public class Posologia {

    private int id;
    private String dosagem;
    private Time hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}