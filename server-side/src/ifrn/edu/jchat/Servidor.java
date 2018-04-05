/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrn.edu.jchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 20171148060019
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        Distribuidor distribuidor = new Distribuidor();
        final int PORTA = 5000;
        // Abrindo a porta do servidor!
        ServerSocket servidor = new ServerSocket(PORTA);
        System.out.println("Porta: " + PORTA + " Aberta!");
        
        
        
        
        
        
        

        /*
        while(true){
            //Aceitando o cliente
            Socket cliente = servidor.accept();
            System.out.println("Conexão estabelecida com : " + cliente.getInetAddress().getHostAddress());
            ObjectInputStream entradaDeDados = new ObjectInputStream(cliente.getInputStream());
            Usuario novoUsuario = (Usuario) entradaDeDados.readObject();
            System.out.println(novoUsuario);
            cliente.close();
            entradaDeDados.close();
            servidor.close();
        }
         */
    }
}
