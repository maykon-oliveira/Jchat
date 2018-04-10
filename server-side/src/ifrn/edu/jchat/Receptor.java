/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrn.edu.jchat;

import java.util.Scanner;

/**
 *
 * @author 20171148060019
 */
public class Receptor implements Runnable {
    
    private Scanner entrada;
    private Distribuidor distribuidor;
    
    public Receptor(Scanner entrada, Distribuidor distribuidor) {
        entrada = this.entrada;
        distribuidor = this.distribuidor;
        
    }
    //public void aguardaMsgs(){}

    @Override
    public void run() {
        while (this.entrada.hasNextLine()) {
            String msg = this.entrada.nextLine();
            this.distribuidor.DistribuirMsg(msg);
        }
    }
}
