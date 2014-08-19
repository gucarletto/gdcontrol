package java.br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class Alimento {
    
    private int id;
    private int caloria;
    private int carboidrato;
    private int gordura;
    private String nome;
    private int proteina;
    
    private GrupoAlimento grupoAlimento;
    private MedidaExata medidaExata;
    private MedidaUsual medidaUsual;

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

    public int getProteina() {
        return proteina;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }
    
    public GrupoAlimento getGrupoAlimento() {
        return grupoAlimento;
    }

    public void setGrupoAlimento(GrupoAlimento grupoAlimento) {
        this.grupoAlimento = grupoAlimento;
    }

    public MedidaExata getMedidaExata() {
        return medidaExata;
    }

    public void setMedidaExata(MedidaExata medidaExata) {
        this.medidaExata = medidaExata;
    }

    public MedidaUsual getMedidaUsual() {
        return medidaUsual;
    }

    public void setMedidaUsual(MedidaUsual medidaUsual) {
        this.medidaUsual = medidaUsual;
    }
}
