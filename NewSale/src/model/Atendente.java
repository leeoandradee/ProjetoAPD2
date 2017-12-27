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
public class Atendente implements Serializable{
    
    private Party party;
    private int cargaHoraria;
    private double salario;

    public Atendente(Party party) {
        this.party = party;
    }
    
    
}

