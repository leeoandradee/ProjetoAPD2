/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.ArrayList;
import model.Atendente;
import model.CatalagoProdutos;
import model.CentralDePedidos;
import model.Cliente;
import model.ClientesCadastrados;
import model.Distribuidora;
import model.Endereco;
import model.Entrega;
import model.Estoque;
import model.Geografico;
import model.ItemPedido;
import model.Organizacao;
import model.Pagamento;
import model.Party;
import model.Pedido;
import model.Pedidos;
import model.Pessoa;
import model.Produto;
import model.Telefonico;
import model.Virtual;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Inicializador {

    ArrayList<Produto> produtosCadastrados = new ArrayList<>();
    Distribuidora distribuidora;
    ArrayList<Pedido>pedidos = new ArrayList<>();
    ArrayList<Cliente>clientes = new ArrayList<>();
    
    File catalagoProdutos = new File("catalagoProdutos.txt");
    File pedidosfeitos = new File("pedidos.txt");
    File clintesCadastrados = new File("clientesCadastrados.txt");
    File distrib = new File("distribuidora.txt");
    CatalagoProdutos catalago;
    ClientesCadastrados cc;
    Pedidos p;

    public Inicializador() {

        produtosCadastrados = new ArrayList<>();
        

        catalago = CatalagoProdutos.getInstance();
        catalago.setProdutos(IOUtil.carregaCatalagoProdutos(catalagoProdutos));
        
        cc = ClientesCadastrados.getInstance();
        cc.setClientes(IOUtil.carregaCliente(clintesCadastrados));
        
        p = Pedidos.getInstance();
        p.setPedidos(IOUtil.carregaPedidos(pedidosfeitos));
        
        distribuidora = Distribuidora.getInstance(IOUtil.carregaDistribuidora(distrib));
        
    }

    public ArrayList<Produto> getProdutosCadastrados() {
        return produtosCadastrados;
    }

    
    public void criaObjetos(){
        Produto p1 = new Produto("01", "Colheitadeira", 18000);
        Produto p2 = new Produto("02", "Secadora de Grãos", 15000);
        Produto p3 = new Produto("03", "Semeadora", 10000);
        Produto p4 = new Produto("04", "Trator", 9000);
        Produto p5 = new Produto("05", "Roçadeira", 7000);
        Produto p6 = new Produto("06", "Pulverizador", 12000);
        produtosCadastrados.add(p1);
        produtosCadastrados.add(p2);
        produtosCadastrados.add(p3);
        produtosCadastrados.add(p4);
        produtosCadastrados.add(p5);
        produtosCadastrados.add(p6);
        
        IOUtil.salvaCatalagoProdutos(catalagoProdutos, produtosCadastrados);
        
        //INSTANCIA DISTRIBUIDORAS
        //DISTRIBUIDORA 1
        Geografico geo = new Geografico("Rua Maria Antonia, 56", "03145030", "Sao Paulo", "Sao Paulo", "Brasil");
        Virtual virtual = new Virtual("distribuidora1@gmail.com", "");
        Telefonico tel = new Telefonico("011", "2145-1253");
        Endereco ender1 = new Endereco(geo, virtual, tel);
        Organizacao org1 = new Organizacao("Distribuidora", "125851103-0001", ender1, "Distribuidora SP");

        Estoque e1 = new Estoque();
        ItemPedido ep1 = new ItemPedido(10, p1);
        ItemPedido ep2 = new ItemPedido(8, p3);
        ItemPedido ep3 = new ItemPedido(3, p5);
        e1.addItemPedido(ep1);
        e1.addItemPedido(ep2);
        e1.addItemPedido(ep3);

        Distribuidora d1 = new Distribuidora(e1, org1);
        

//        //DISTRIBUIDORA 2
//        Geografico geo2 = new Geografico("Rua das Laranjeiras, 106", "08146020", "Salvador", "Bahia", "Brasil");
//        Virtual virtual2 = new Virtual("distribuidora2@gmail.com", "");
//        Telefonico tel2 = new Telefonico("071", "5874-1483");
//        Endereco ender2 = new Endereco(geo2, virtual2, tel2);
//        Organizacao org2 = new Organizacao("Distribuidora", "141511103-0001", ender2, "Distribuidora BA");
//
//        Estoque e2 = new Estoque();
//        ItemPedido ep4 = new ItemPedido(7, p2);
//        ItemPedido ep5 = new ItemPedido(12, p4);
//        ItemPedido ep6 = new ItemPedido(2, p6);
//        e1.addItemPedido(ep4);
//        e1.addItemPedido(ep5);
//        e1.addItemPedido(ep6);
//
//        Distribuidora d2 = new Distribuidora(e2, org2);
//
        //CENTRAL DE PEDIDOS
        Geografico geo3 = new Geografico("Avenida Paulista, 1014", "00242030", "Sao Paulo", "Sao Paulo", "Brasil");
        Virtual virtual3 = new Virtual("centralpedidos@gmail.com", "");
        Telefonico tel3 = new Telefonico("011", "0274-1283");
        Endereco ender3 = new Endereco(geo3, virtual3, tel3);
//        Organizacao org3 = new Organizacao("Central de Pedidos", "321528203-0001", ender3, "Central de Pedidos SP");
        Pessoa pessoa2 = new Pessoa("Masculino","12548","45",ender3,"Jose Paulo");
//        CentralDePedidos cp = new CentralDePedidos(org3);

        //ATENDENTE
        Geografico geo4 = new Geografico("Rua Campos Eliseos, 116", "08286020", "Sao Paulo", "Sao Paulo", "Brasil");
        Virtual virtual4 = new Virtual("paulaSilva@gmail.com", "");
        Telefonico tel4 = new Telefonico("011", "9174-1283");
        Endereco ender4 = new Endereco(geo4, virtual4, tel4);
        Pessoa pessoa1 = new Pessoa("Feminino", "1234", "25", ender4, "Paula Da Silva");
        Atendente a1 = new Atendente(pessoa1);
        
        //CLIENTE
        Cliente cli1 = new Cliente(pessoa1);
        Cliente cli2 = new Cliente(pessoa2);
        cli1.setBomPagador(false);
        clientes.add(cli1);
        clientes.add(cli2);
        IOUtil.salvaClientes(clintesCadastrados, clientes);
        
        
        //PEDIDO
        Pedido pedido1 = new Pedido(cli1);
        pedido1.addItemPedido(1, p6);
        pedido1.addItemPedido(2, p1);
        pedido1.setIDCompra("10");
        Pagamento pag1 = new Pagamento();
        pag1.calculaTotal(pedido1.getProdutos());
        pag1.setTipo("a vista");
        pag1.setStatusPagamento(true);
        pag1.setDataPagamento();
        Entrega entrega1 = new Entrega();
        entrega1.setPagamento(pag1);
        pedido1.setEntrega(entrega1);
        d1.addPedido(pedido1);//Distribuidora recebe pedido
        cli1.addPedido(pedido1);
        
        Pedido pedido2 = new Pedido(cli1);
        pedido2.addItemPedido(1, p3);
        pedido2.addItemPedido(1, p2);
        pedido2.setIDCompra("05");
        Pagamento pag2 = new Pagamento();
        pag1.calculaTotal(pedido2.getProdutos());
        pag1.setTipo("a vista");
        pag1.setStatusPagamento(false);
        pag1.setDataPagamento();
        Entrega entrega2 = new Entrega();
        entrega2.setPagamento(pag2);
        pedido2.setEntrega(entrega2);
        d1.addPedido(pedido2);//Distribuidora recebe pedido
        cli1.addPedido(pedido2);
        
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        IOUtil.salvaPedidos(pedidosfeitos, pedidos);
        IOUtil.salvaDistribuidora(distrib, d1);
        
        
                
                
    }
    
    

}
