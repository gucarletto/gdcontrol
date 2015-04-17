package com.gdcontrol.desktop.util.relatorio;

import com.gdcontrol.entidade.Aplicacao;
import com.gdcontrol.entidade.Prescricao;
import com.gdcontrol.entidade.Teste;
import com.gdcontrol.entidade.Usuario;

/**
 *
 * @author gustavo
 */
public class RelatorioMensalUtil {

    private Aplicacao aplicacao;
    private Teste teste;
    private Prescricao prescricao;
    private Usuario usuario;
    private int diaDoMes;
    private String dataHoraFormatada;

    public Aplicacao getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getDiaDoMes() {
        return diaDoMes;
    }

    public void setDiaDoMes(int diaDoMes) {
        this.diaDoMes = diaDoMes;
    }

    public String getDataHoraFormatada() {
        return dataHoraFormatada;
    }

    public void setDataHoraFormatada(String dataHoraFormatada) {
        this.dataHoraFormatada = dataHoraFormatada;
    }
}