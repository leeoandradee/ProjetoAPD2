/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Estoque implements Serializable{
    
    private ArrayList<ItemPedido>estoque;

    public Estoque() {
        this.estoque = new ArrayList<>();
    }
    
    public void addItemPedido(ItemPedido ip){
        estoque.add(ip);
    }
    
    public void atualiza(){
        Scanner entrada = new Scanner(System.in);
        System.out.println(" ----- ATUALIZAR ----- ");
        System.out.print("Digite o id do produto que deseja atualizar: ");
        String id = entrada.nextLine();
        for (ItemPedido ip : estoque) {
            if(ip.getProduto().getIDProduto().equalsIgnoreCase(id)){
                System.out.println("Digite a nova quantidade do produto: ");
                int quantidade = Integer.parseInt(entrada.nextLine());
                ip.setQuantidade(quantidade);
            }
        }
    }
    
    public void registra(ArrayList<Produto>produtos){
        Scanner entrada = new Scanner(System.in);
        System.out.println(" ----- REGISTRA ------ ");
        System.out.println("Digite o id do produto que deseja registrar: ");
        String id  = entrada.nextLine();
        for (Produto p : produtos) {
            if(p.getIDProduto().equalsIgnoreCase(id)){
                System.out.println("Digite a quantidade do Produto: ");
                int quantidade = Integer.parseInt(entrada.nextLine());
                ItemPedido ip = new ItemPedido(quantidade, p);
                estoque.add(ip);
            }
        }
    }
    
    public void mostraEstoque(){
        for (ItemPedido itemPedido : estoque) {
            System.out.println(itemPedido);
        }
        System.out.println("");
    }
    
    
}
