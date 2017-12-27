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
public class Geografico extends Endereco implements Serializable{
    public static Scanner sc;
    private String rua;
    private String CEP;
    private String cidade;
    private String estado;
    private String pais;

    public Geografico(String rua, String CEP, String cidade, String estado, String pais) {
        this.rua = rua;
        this.CEP = CEP;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    
    

    public Geografico() {
    }
    


    public void atualizarInfo(String rua, String CEP, String cidade, String estado, String pais) {
        this.rua = rua;
        this.CEP =  CEP;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        
    }

    @Override
    public String toString() {
        return "\t------Geografico------\n"+
                "\tRua: " + rua + "\n" +
                "\tCEP: " + CEP + "\n" +
                "\tCidade: " + cidade + "\n" +
                "\tEstado: " + estado + "\n" +
                "\tPaís: " + pais + "\n";
                
    }
    
    
    
    

    
    
    
    
    
}
