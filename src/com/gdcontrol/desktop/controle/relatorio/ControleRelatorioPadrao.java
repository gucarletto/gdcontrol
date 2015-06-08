package com.gdcontrol.desktop.controle.relatorio;

import com.gdcontrol.desktop.controle.ControlePadrao;
import java.io.File;

/**
 *
 * @author gustavo
 */
public abstract class ControleRelatorioPadrao extends ControlePadrao{
    
    public abstract String getNomeArquivoRelatorio();
    
    public String getCaminhoRelatorios(){
        File arquivo = new File("");
        return arquivo.getAbsolutePath() + "//src//com//gdcontrol//desktop//relatorio//";
    }
    
    public String getCaminhoTempRelatorios(){
        File arquivo = new File("");
        return arquivo.getAbsolutePath();
    }
    
    public String getCaminhoTemp(){
        File arquivo = new File("");
        return arquivo.getAbsolutePath()+"//temp//";
    }
    
    public abstract void chamaRelatorio();
    
    public abstract void enviaEmail();
}