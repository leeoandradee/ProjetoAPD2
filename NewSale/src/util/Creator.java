/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Cliente;
import model.Endereco;
import model.Geografico;
import model.Organizacao;
import model.Party;
import model.Pessoa;
import model.Telefonico;
import model.Virtual;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Creator {
    
    public static Pessoa criarPessoa(){
        Pessoa p = new Pessoa();
        return p;
    }
    
    public static Organizacao criarOrganizacao(){
        Organizacao o = new Organizacao();
        return o;
    }
    
    public static Endereco criaEndereco(){
        Endereco e = new Endereco();
        return e;
    }
    
    public static Geografico criaGeografico(){
        Geografico g = new Geografico();
        return g;
    }
    public static Telefonico criaTelefonico(){
        Telefonico t = new Telefonico();
        return t;
    }
    
    public static Virtual criaVirtual(){
        Virtual v = new Virtual();
        return v;
    }
    
    public static Cliente criaCliente(Party p){
        Cliente c = new Cliente(p);
        return c;
    }
}
