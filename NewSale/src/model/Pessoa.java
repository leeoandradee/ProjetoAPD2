/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;
import static control.ControleClientes.sc;
import exceptions.CPFSizeException;
import exceptions.CPFNumberFormatException;
import exceptions.CPFInvalid;
import java.io.Serializable;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Pessoa extends Party implements Serializable{
    public static Scanner sc;
    private String sexo;
    private String cpf;
    private String idade;
    private Endereco endereco;

    public Pessoa(String sexo, String cpf, String idade, Endereco endereco, String nome) {
        super(nome);
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Pessoa(String sexo, String cpf, String idade, String nome) {
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "------Pessoal------" + "\nNome:"+nome+ "\nSexo: " + sexo + "\nCPF: " + cpf + "\nIdade:" + idade +"\n------Pessoal------";
    }

    @Override
    public void mostrarInfo() {
        System.out.println("\tPessoa criada:\n"
                        + "\tNome: "+this.nome+"\n"
                        + "\tSexo: "+this.sexo+"\n"
                        + "\tCPF: "+this.cpf+"\n"
                        + "\tIdade: "+this.idade+"\n"
                        + "\tEndereco:\n");
        this.endereco.mostraEndereco();
                        
    }

    @Override
    public void atualizarInfo(String nome, String sexo, String cpf, String idade, Endereco e) {
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = e;
 
        
    }
    
    @Override
    public String getInfo() {
        return this.cpf;
    }

    
    
    
    
    
    
    
}
