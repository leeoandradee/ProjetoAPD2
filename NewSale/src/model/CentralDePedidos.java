/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class CentralDePedidos extends Role implements Serializable{
    
    public CentralDePedidos(Party party) {
        super(party);
    }
    
    public void SelecionaDeposito(Pedido p, Distribuidora d){
        d.addPedido(p);
    }
}
