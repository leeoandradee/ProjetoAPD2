/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class CatalagoProdutos implements Serializable{
    
    private static CatalagoProdutos instance;
    private ArrayList<Produto>produtos;

    public CatalagoProdutos() {
        this.produtos = new ArrayList<>();
//        Produto p = new Produto("01","Colheitadeira",18000);
//        Produto p2 = new Produto("01","Secadora de Grãos",15000);
//        Produto p3 = new Produto("01","Semeadora",10000);
//        Produto p4 = new Produto("01","Trator",9000);
//        Produto p5 = new Produto("01","Roçadeira",7000);
//        Produto p6 = new Produto("01","Pulverizador",12000);
    }
    
    public static CatalagoProdutos getInstance() {
        if (instance == null) {
            instance = new CatalagoProdutos();
        }
        return instance;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
    public void addProduto(Produto p){
        produtos.add(p);
    }
    
    public Produto buscaProduto(String id){
        for (Produto p : produtos) {
            if(p.getIDProduto().equalsIgnoreCase(id)){
                return p;
            }
        }
        return null;
    }
    
   
    
}
