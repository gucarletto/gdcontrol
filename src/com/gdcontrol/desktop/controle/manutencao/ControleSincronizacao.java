package com.gdcontrol.desktop.controle.manutencao;

import com.gdcontrol.desktop.controle.ControlePadrao;
import com.gdcontrol.util.sincronizacao.Cliente;
import com.gdcontrol.util.sincronizacao.Servidor;
import com.gdcontrol.util.sincronizacao.SincronizaDadosXML;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class ControleSincronizacao extends ControlePadrao{
 
    public boolean enviaArquivos(String ip, String caminhos){
        Cliente cliente = new Cliente();
        cliente.setIp(ip);
        ArrayList<File> arquivos = new ArrayList<>();
        for(String caminho : caminhos.split(";")){
            File atual = new File(caminho);
            arquivos.add(atual);
        }
        cliente.setArquivos(arquivos);
        cliente.iniciarCliente();
        return false;
    }
    
    public void iniciaServidor(){
        Servidor serv = new Servidor();
        serv.iniciarServidor();
        if(serv.getArquivos().size() > 0){
            SincronizaDadosXML sincronizador = new SincronizaDadosXML();
            sincronizador.iniciarSincronizacao();
        }
    }
    
}
