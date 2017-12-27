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
public abstract class Party implements Serializable{
    
    protected String nome;
    protected Endereco endereco;

    public abstract void mostrarInfo();
    public abstract void atualizarInfo(String nome, String sexo, String spf, String idade, Endereco e);
    public abstract String getInfo();

    public Party(String nome) {
        this.nome = nome;
        this.endereco = new Endereco();
    }

    public Party() {
        this.nome = "";
        this.endereco = new Endereco();
    }

    public String getNome() {
        return nome;
    }

    
    
    
    
    
    
    
}
