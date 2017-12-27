/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Pedido implements Serializable{

    private Date data;
    private boolean estadoDePagamento;
    private boolean estadaDaEntrega;
    private String IDCompra;
    private ArrayList<ItemPedido> produtos;
    private Entrega entrega;
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.data = new Date();
        this.estadoDePagamento = false;
        this.estadaDaEntrega = false;
        this.IDCompra = "";
        this.produtos = new ArrayList<>();
        this.cliente = cliente;
        this.entrega = null;
    }

    public ArrayList<ItemPedido> getProdutos() {
        return produtos;
    }

    public String getIDCompra() {
        return IDCompra;
    }

    public void setEstadaDaEntrega(boolean estadaDaEntrega) {
        this.estadaDaEntrega = estadaDaEntrega;
    }

    public void setIDCompra(String IDCompra) {
        this.IDCompra = IDCompra;
    }
    
    
    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEstadoDePagamento(boolean estadoDePagamento) {
        this.estadoDePagamento = estadoDePagamento;
    }
    
    
    

    public void addItemPedido(int quantidade, Produto p) {
        ItemPedido i = new ItemPedido(quantidade, p);
        produtos.add(i);
    }

    public void novoPedido(CatalagoProdutos cp, String IDCcompra) {
        Scanner entrada = new Scanner(System.in);
        Produto p = null;
        System.out.println("");
        this.IDCompra = IDCcompra;
        String escolha = "sair";
        for (Produto produto : cp.getProdutos()) {
            System.out.println(produto);
        }
        do {
            System.out.println("");
            System.out.println("Digite o id de cada produto que deseja adicionar ao pedido ou Digite 'SAIR'");
            System.out.print("Sua Escolha: ");
            escolha = entrada.nextLine();
            p = cp.buscaProduto(escolha);
            if(p != null){
                System.out.println("Digite a quantidade desejada do produto: ");
                int quantidade = Integer.parseInt(entrada.nextLine());
                ItemPedido ip = new ItemPedido(quantidade, p);
                produtos.add(ip);
            }else{
                System.out.println("Produto não encontrado");
            }
        }while(!escolha.equalsIgnoreCase("sair"));
        System.out.println("");
        
    
    }

    @Override
    public String toString() {
        return "Pedido{" + "data=" + data + ", estadoDePagamento=" + estadoDePagamento + ", estadaDaEntrega=" + estadaDaEntrega + ", IDCompra=" + IDCompra + ", produtos=" + produtos + ", cliente=" + cliente.getNome();
    }
    
    

}
