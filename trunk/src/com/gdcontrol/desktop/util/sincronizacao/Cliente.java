package com.gdcontrol.desktop.util.sincronizacao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class Cliente {

    public void iniciarCliente() {
        Socket socket;
        try {
            socket = new Socket("localhost", 4444);//endereco e porta			
            System.out.println("Inicio cliente");
            String opcao = "";
            while (!opcao.equals("9")) {
                opcao = JOptionPane.showInputDialog("1 - Leitura\n 9 - Sair");
                if (opcao.equals("1")) {
                    enviandoArquivo(socket);
                }
            }
            System.out.println("fim cliente");
        } catch (EOFException eof) {//fim conexao cliente
        } catch (IOException io) {//problema de io
        }
    }

    public void enviandoArquivo(Socket socket) {
        try {
            OutputStream saida = socket.getOutputStream();//obtem o fluxo de saida		
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File fonte = fileChooser.getSelectedFile();
            FileInputStream entrada = new FileInputStream(fonte);
            byte[] buffer = new byte[8192];
            int length = 0;
            while ((length = entrada.read(buffer)) != -1) { //-1 indica final de arquivo
                saida.write(buffer, 0, length); //grava apenas bytes lidos
                saida.flush();
            }
            entrada.close();
        } catch (IOException io) {//problema de io
        }
    }
}
