package com.gdcontrol.modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Aplicacao {

    private int id;
    private Time hora;
    private Date data;
    private double dosagemAplicada;
    private double dosagemSugerida;
    private String observacao;
 
    private Medicacao medicacao;
    private LocalAplicacao local;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getDosagemAplicada() {
        return dosagemAplicada;
    }

    public void setDosagemAplicada(double dosagemAplicada) {
        this.dosagemAplicada = dosagemAplicada;
    }

    public double getDosagemSugerida() {
        return dosagemSugerida;
    }

    public void setDosagemSugerida(double dosagemSugerida) {
        this.dosagemSugerida = dosagemSugerida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Medicacao getMedicacao() {
        return medicacao;
    }

    public void setMedicacao(Medicacao medicacao) {
        this.medicacao = medicacao;
    }

    public LocalAplicacao getLocal() {
        return local;
    }

    public void setLocal(LocalAplicacao local) {
        this.local = local;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
}