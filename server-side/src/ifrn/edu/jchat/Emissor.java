/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrn.edu.jchat;

import java.io.PrintStream;

/**
 *
 * @author 20171148060019
 */
public class Emissor {
    private PrintStream saidaDeDados;

    public Emissor(PrintStream saidaDeDados) {
        saidaDeDados = this.saidaDeDados;
    }

    public void enviarMsg(String msg) {
        this.saidaDeDados.println(msg);
    }
}
