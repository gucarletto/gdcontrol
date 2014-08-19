package java.br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class Ingrediente {
    
    private int id;
    private int quantidade;
    
    private Alimento alimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
}
