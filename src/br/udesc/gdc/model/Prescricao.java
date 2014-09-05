package java.br.udesc.gdc.model;

import java.util.Date;

/**
 *
 * @author gustavo
 */
public class Prescricao {
 
    private int id;
    private double fatorReducao;
    private double fatorCarboidrato;
    private Date dataInicio;
    private Date dataFim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFatorReducao() {
        return fatorReducao;
    }

    public void setFatorReducao(double fatorReducao) {
        this.fatorReducao = fatorReducao;
    }

    public double getFatorCarboidrato() {
        return fatorCarboidrato;
    }

    public void setFatorCarboidrato(double fatorCarboidrato) {
        this.fatorCarboidrato = fatorCarboidrato;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }   
}