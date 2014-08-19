package java.br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class Medico extends Pessoa{
    
    private String crm;
    private String telefone;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
