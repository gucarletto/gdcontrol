package java.br.udesc.gdc.model;

/**
 *
 * @author gustavo
 */
public class Medico extends Pessoa{
    
    private String crm;
    private String telefone;
    private String especializacao;

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

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
