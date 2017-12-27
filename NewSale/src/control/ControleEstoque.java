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
import model.Distribuidora;
import model.Estoque;
import model.Organizacao;
import model.Party;
import model.Pedido;
import model.Pessoa;
import util.IOUtil;
import util.Inicializador;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class ControleEstoque {
    
    Scanner entrada = new Scanner(System.in);
    CatalagoProdutos cp;
    Distribuidora distribuidora;
    File distrib = new File("distribuidora.txt");

    public ControleEstoque() {
        this.distribuidora = Distribuidora.getInstance(IOUtil.carregaDistribuidora(distrib));
        this.cp = CatalagoProdutos.getInstance();
    }

    public Distribuidora getDistribuidora() {
        return distribuidora;
    }
 
    
    public void atualiza(Distribuidora distribuidora){
        distribuidora.getEstoque().atualiza();
        IOUtil.salvaDistribuidora(distrib, distribuidora);
    }
    
    public void registra(Distribuidora distribuidora){
        distribuidora.getEstoque().registra(cp.getProdutos());
        IOUtil.salvaDistribuidora(distrib, distribuidora);
    }
    
    public Pedido autorizaDespacho(String compraID){
        Pedido p = this.distribuidora.autorizaDespacho(compraID);
        IOUtil.salvaDistribuidora(distrib, distribuidora);
        return p;
    }
    
    public void mostraPedidos(){
        distribuidora.mostraPedidos();
    }
    
    public void mostraEstoque(){
        distribuidora.getEstoque().mostraEstoque();
    }
    
}
