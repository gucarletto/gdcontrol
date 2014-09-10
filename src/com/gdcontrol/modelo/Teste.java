package com.gdcontrol.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Teste {

    private int id;
    private Date data;
    private Time hora;
    private String observacao;
    private float valor;
    
    private TipoTeste tipoTeste;

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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public TipoTeste getTipoTeste() {
        return tipoTeste;
    }

    public void setTipoTeste(TipoTeste tipoTeste) {
        this.tipoTeste = tipoTeste;
    }
}