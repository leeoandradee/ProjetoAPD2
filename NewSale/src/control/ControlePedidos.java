/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import model.CatalagoProdutos;
import model.Cliente;
import model.Distribuidora;
import model.Entrega;
import model.Pagamento;
import model.Pedido;
import model.Pedidos;
import util.IOUtil;
import util.Inicializador;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class ControlePedidos {
    
    Scanner entrada = new Scanner(System.in);
    CatalagoProdutos cp;
    Distribuidora distribuidora;
    Pedidos pedidos;
    Inicializador ini;
    File pedidosfeitos = new File("pedidos.txt");
    File distrib = new File("distribuidora.txt");
    
    public ControlePedidos() {
        ini = new Inicializador();
        pedidos = Pedidos.getInstance();
        cp = CatalagoProdutos.getInstance();
        distribuidora = Distribuidora.getInstance(IOUtil.carregaDistribuidora(distrib));
    }
    
    public Cliente novoPedido(Cliente c, String IDCompra){
        Pedido p = new Pedido(c);
        p.novoPedido(cp, IDCompra);
        
        Pagamento pag = new Pagamento();
        pag.calculaTotal(p.getProdutos());
        pag.criaPagamento();
        
        Entrega e = new Entrega();
        e.criaEntrega(pag);
        
        p.setEntrega(e);
        
        c.addPedido(p);
        
        distribuidora.addPedido(p);
        
        pedidos.addPedido(p);
        IOUtil.salvaPedidos(pedidosfeitos, pedidos.getPedidos());
        IOUtil.salvaDistribuidora(distrib, distribuidora);
        
        return c;
    }
    
    public boolean verificaIDPedido(String id){
        Pedido p = pedidos.buscaPedido(id);
        if(p == null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean alteraStatusPagamento(String idPedido){
        Pedido p = pedidos.buscaPedido(idPedido);
        if(p != null){
            p.getEntrega().getPagamento().setStatusPagamento(true);
            p.setEstadoDePagamento(true);
            distribuidora.atualizaPedido(p);
            p.getEntrega().getPagamento().setDataPagamento();
            atualizaPedido(p);
            IOUtil.salvaPedidos(pedidosfeitos, pedidos.getPedidos());
            return true;
        }
        return false;
    }
    
    public void atualizaPedido(Pedido p){
        pedidos.atualizaPedido(p);
    }
    
    public void exibePedidosCadastrados(){
        pedidos.exibePedidosCadastrados();
    }
}
