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
public class Pagamento implements Serializable{
    
    private double valor;
    private String tipo;
    private Date dataPagamento;
    private boolean statusPagamento;

    public Pagamento() {
        this.statusPagamento = false;
    }

    public boolean getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(boolean statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataPagamento() {
        this.dataPagamento = new Date();
    }
    
    
    public void criaPagamento(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Valor total do pedido: R$ " + this.valor);
        System.out.print("\nDigite o tipo de Pagamento: ");
        this.tipo = entrada.nextLine();
    }
    
    public void calculaTotal(ArrayList<ItemPedido>produtos){
        double total = 0;
        double valorItemPedido = 0;
        for (ItemPedido ip : produtos) {
            total += (ip.getQuantidade()) * (ip.getProduto().getPreco());
        }
        this.valor = total;
    }
    
}
