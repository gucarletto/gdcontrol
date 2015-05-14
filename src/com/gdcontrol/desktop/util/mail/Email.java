package com.gdcontrol.desktop.util.mail;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Email implements Serializable {

    private String de[];
    private List<String> para;
    private String assunto;
    private String mensagem;
    private List<File> anexos;

    public Email() {
        this.para = new ArrayList<String>();
        this.de = new String[2];
        this.assunto = "";
        this.mensagem = "";
        this.anexos = new ArrayList<File>();
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String[] getDe() {
        return de;
    }

    public void setDe(String email, String senha) {
		if (de == null) 
			de = new String[2];
        this.de[0] = email;
		this.de[1] = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getPara() {
        return para;
    }

    public void setPara(List<String> para) {
        this.para = para;
    }

    public List<File> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<File> anexos) {
        this.anexos = anexos;
    }
    
    public void addAnexo(File anexo){
        this.anexos.add(anexo);
    }
}

