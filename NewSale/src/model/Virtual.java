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
public class Virtual extends Endereco implements Serializable{
    public static Scanner sc;
    private String email;
    private String site;

    public Virtual() {
        
    }

    public Virtual(String email, String site) {
        this.email = email;
        this.site = site;
    }
    

    public void atualizarInfo(String email, String site) {
        this.email = email;
        this.site = site;

    }

    @Override
    public String toString() {
        return "\t------Virtual------"+ "\n" +
                "\tEmail: " + email + "\n" +
                "\tSite: " + site + "\n";

    }
    
    

   
    
}
