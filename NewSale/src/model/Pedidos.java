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
public class Pedidos implements Serializable {

    private static Pedidos instance;
    private ArrayList<Pedido> pedidos;

    public Pedidos() {
        this.pedidos = new ArrayList<>();
    }

    public static Pedidos getInstance() {
        if (instance == null) {
            instance = new Pedidos();
        }
        return instance;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void addPedido(Pedido p) {
        pedidos.add(p);
    }

    public Pedido buscaPedido(String idPedido) {
        for (Pedido p : pedidos) {
            if (p.getIDCompra().equalsIgnoreCase(idPedido)) {
                return p;
            }
        }
        return null;
    }

    public void atualizaPedido(Pedido p) {
        for (Pedido pedido : pedidos) {
            if (pedido.equals(p)) {
                pedidos.remove(pedido);
            }
        }
        pedidos.add(p);
    }

    public void exibePedidosCadastrados() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
        System.out.println("");
    }

}
