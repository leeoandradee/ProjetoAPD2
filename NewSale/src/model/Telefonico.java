/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Telefonico extends Endereco implements Serializable{
    public static Scanner sc;
    private String DDD;
    private String numero;

    public Telefonico() {   
    }

    public Telefonico(String DDD, String numero) {
        this.DDD = DDD;
        this.numero = numero;
    }
    
    

    public void atualizarInfo(String ddd, String numero) {
        this.DDD = ddd;
        this.numero = numero;
    }


    @Override
    public String toString() {
        
        return "\t------Telefonico------\n" +
                "\tDDD: " + DDD + "\n" +
                "\tNúmero: " + numero + "\n";
                
    }

    
    
    
}
