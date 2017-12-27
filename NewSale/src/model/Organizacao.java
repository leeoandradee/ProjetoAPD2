/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import static control.ControleClientes.sc;
import java.io.Serializable;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Organizacao extends Party implements Serializable{
    public static Scanner sc;
    private String tipo;
    private String CNPJ;
    private String inscricao;
    private Endereco endereco;

    public Organizacao(String tipo, String CNPJ, Endereco endereoco, String nome) {
        super(nome);
        this.tipo = tipo;
        this.CNPJ = CNPJ;
        this.endereco = endereco;
    }

    public Organizacao() {
    }

    @Override
    public String toString() {
        return "------Organização------" + "\nNome:"+nome+"\nTipo: " + tipo + "\nCNPJ: " + CNPJ + "\n------Organização------";
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\tPessoa criada:\n"
                        + "\tNome: "+this.nome+"\n"
                        + "\tTipo: "+this.tipo+"\n"
                        + "\tCNPJ: "+this.CNPJ+"\n"
                        + "\tInscricao: "+this.inscricao+"\n"
                        + "\tEndereco:\n");
        this.endereco.mostraEndereco();
    }

    @Override
    public void atualizarInfo(String nome, String tipo, String cnpj, String inscricao, Endereco e) {
        this.nome = nome;
        this.tipo = tipo;
        this.CNPJ = cnpj; 
        this.inscricao = inscricao;
        this.endereco = e;

        

    }

    @Override
    public String getInfo() {
        return this.CNPJ;
    }

    public String getNome() {
        return nome;
    }
    
    
    
    
}
