/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrn.edu.jchat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 20171148060019
 */
public class Registrador implements Runnable {

    private Distribuidor distribuidor;
    private ServerSocket servidor;

    public Registrador(Distribuidor distribuidor, ServerSocket servidor) {
        this.distribuidor = distribuidor;
        this.servidor = servidor;

    }

    public void aguardaUsuario() {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket cliente = this.servidor.accept();
                Scanner entradaDeDados = new Scanner(cliente.getInputStream());
                PrintStream saidaDeDados = new PrintStream(cliente.getOutputStream());
                //
                Receptor receptor = new Receptor(entradaDeDados, this.distribuidor);
                Thread pilha = new Thread(receptor);
                pilha.start();
                //
                Emissor emissor = new Emissor(saidaDeDados);

                this.distribuidor.addEmisor(emissor);

            } catch (IOException e) {
                System.out.println("Erro!");
            }
        }

    }
}
