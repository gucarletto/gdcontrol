package br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class Alimento {
    
    private int id;
    private int caloria;
    private int carboidrato;
    private int gordura;
    private int proteina;
    private String nome;
    private String medidaExata;
    private String medidaUsual;
    private String unidadeMedida;
    
    private GrupoAlimento grupoAlimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCaloria() {
        return caloria;
    }

    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public int getGordura() {
        return gordura;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMedidaExata() {
        return medidaExata;
    }

    public void setMedidaExata(String medidaExata) {
        this.medidaExata = medidaExata;
    }

    public String getMedidaUsual() {
        return medidaUsual;
    }

    public void setMedidaUsual(String medidaUsual) {
        this.medidaUsual = medidaUsual;
    }

    public int getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    public GrupoAlimento getGrupoAlimento() {
        return grupoAlimento;
    }

    public void setGrupoAlimento(GrupoAlimento grupoAlimento) {
        this.grupoAlimento = grupoAlimento;
    }
}
