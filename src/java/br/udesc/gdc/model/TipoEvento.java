package java.br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class TipoEvento {
    
    private String id;
    private String nome;
    private String unidade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}