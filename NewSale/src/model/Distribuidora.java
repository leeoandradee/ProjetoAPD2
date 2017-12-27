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
public class Distribuidora extends Role implements Serializable{
    
    private static Distribuidora instance;
    Estoque estoque;
    ArrayList<Pedido>pedidosRecebidos;
    
    public Distribuidora(Party party) {
        super(party);
        this.pedidosRecebidos = new ArrayList<>();
    }
    
    public static Distribuidora getInstance(Distribuidora d) {
        if (instance == null) {
            instance = d;
        }
        return instance;
    }

    public Distribuidora(Estoque estoque, Party party) {
        super(party);
        this.estoque = estoque;
        this.pedidosRecebidos = new ArrayList<>();
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public ArrayList<Pedido> getPedidosRecebidos() {
        return pedidosRecebidos;
    }
    
    public void addPedido(Pedido p){
        pedidosRecebidos.add(p);
    }
    
    public void mostraPedidos(){
        for (Pedido p : pedidosRecebidos) {
            System.out.println(p);
        }
        System.out.println("");
    }
    
    public void atualizaPedido(Pedido p){
        for (Pedido pedidosRecebido : pedidosRecebidos) {
            if(pedidosRecebido.getIDCompra().equals(p.getIDCompra())){
                pedidosRecebidos.remove(pedidosRecebido);
            }
        }
        pedidosRecebidos.add(p);
    }
    
    public Pedido autorizaDespacho(String compraID){
        for (Pedido p : pedidosRecebidos) {
            if(p.getIDCompra().equalsIgnoreCase(compraID)){
                if(p.getEntrega().getPagamento().getStatusPagamento() == true){
                    p.setEstadaDaEntrega(true);
                    p.getEntrega().setDataEntrega();
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.getNome();
    }
    
    
    
    
    
    
    
}
