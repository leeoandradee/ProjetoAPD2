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
public class Produto implements Serializable{
    
    private String IDProduto;
    private String nome;
    private double preco;

    public Produto(String IDProduto, String nome, double preco) {
        this.IDProduto = IDProduto;
        this.nome = nome;
        this.preco = preco;
    }

    public String getIDProduto() {
        return IDProduto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Product{" + "IDProduto=" + IDProduto + ", nome=" + nome + ", preco=" + preco + '}';
    }

    
    
    
}
