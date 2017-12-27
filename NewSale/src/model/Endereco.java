/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;


/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Endereco implements Serializable{
    private Geografico g;
    private Virtual v;
    private Telefonico t;

    public Endereco() {
    }

    public Endereco(Geografico g, Virtual v, Telefonico t) {
        this.g = g;
        this.v = v;
        this.t = t;
    }
    
    

    public void atualizarInfo(Geografico g, Virtual v, Telefonico t){
        this.g = g;
        this.v = v;
        this.t = t;
   
    }

   
   public void mostraEndereco(){
       System.out.println(this.g);
       System.out.println(this.v);
       System.out.println(this.t);
   }
   
   
}

