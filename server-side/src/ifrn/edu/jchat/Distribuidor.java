/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifrn.edu.jchat;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author 20171148060019
 */
class Distribuidor {

    private Collection<Emissor> emissores = new ArrayList<Emissor>();

    public void addEmisor(Emissor emissor) {
        this.emissores.add(emissor);
    }

    public void DistribuirMsg(String msg) {
        for (Emissor emissor : this.emissores) {
            emissor.enviarMsg(msg);
        }
    }
}
