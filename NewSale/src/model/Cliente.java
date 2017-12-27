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
public class Cliente extends Role implements Serializable{
    private boolean bomPagador;
    private ArrayList<Pedido> historicoDeCompras;

    public Cliente(Party party) {
        super(party);
        this.bomPagador = true;
        this.historicoDeCompras = new ArrayList<>();
    }
    
    public String getCPF(){
        return super.party.getInfo();
    }

    public boolean isBomPagador() {
        return bomPagador;
    }
    
    public void setBomPagador(boolean status) {
        this.bomPagador = status;
    }
    
    public void addPedido(Pedido p){
        historicoDeCompras.add(p);
    }
            

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + ", cpf: " + getCPF() + ", historicoCompras=" + historicoDeCompras + ", bomPagador=" + bomPagador;
    }

    
    
}
