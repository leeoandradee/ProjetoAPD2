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
public class Role implements Serializable{
    
    protected Party party;

    public Role(Party party) {
        this.party = party;
    }

    public Party getParty() {
        return party;
    }
    
    public String getNome(){
        return party.getNome();
    }        
    
    
    
    
    
 
}
