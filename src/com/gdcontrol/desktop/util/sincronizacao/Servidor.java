package com.gdcontrol.desktop.util.sincronizacao;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gustavo
 */
public class Servidor {

    public void iniciarServidor() {
        ServerSocket servidor; //socket servidor			
        try {
            servidor = new ServerSocket(4444, 100); //conexao(porta,maximo clientes)
            System.out.println("Servidor iniciado");
            while (true) {
                Socket socketCliente = servidor.accept(); // espera da conexao
                System.out.println("Chegou cliente");
                recebendoArquivo(socketCliente);
                System.out.println("fim servidor");
                socketCliente.close();
            }
        } catch (EOFException e) {//fim conexao cliente
            System.out.println(" Erro " + e);
        } catch (IOException e) {//problema de io
            System.out.println(" Erro " + e);
        }
    }

    public void recebendoArquivo(Socket cliente) {
        try {
            InputStream entrada = cliente.getInputStream(); //obtem o fluxo de entrada				
            try {
                File destino = new File("c:/arquivo.xml");
                FileOutputStream saida = new FileOutputStream(destino, false); //False apaga o arquivo
                byte[] buffer = new byte[8192];
                int length = 0;
                while ((length = entrada.read(buffer)) != -1) { //-1 indica final de arquivo
                    saida.write(buffer, 0, length); //grava apenas bytes lidos
                    saida.flush();
                }
                saida.close();
                entrada.close();
            } catch (IOException e) {
                System.out.println(" Erro " + e);
            }
            System.out.println("fim servidor");
        } catch (IOException e) {//problema de io
            System.out.println(" Erro " + e);
        }
    }
}
