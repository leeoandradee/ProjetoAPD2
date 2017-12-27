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
public class ClientesCadastrados implements Serializable{
    
    private static ClientesCadastrados instance;
    private ArrayList<Cliente>clientes;

    public ClientesCadastrados() {
        this.clientes = new ArrayList<>();
    }

    public static ClientesCadastrados getInstance() {
        if (instance == null) {
            instance = new ClientesCadastrados();
        }
        return instance;
    }
    
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void addCliente(Cliente c){
        clientes.add(c);
    }
    
    public Cliente busca(String cpf){
        Cliente clienteEncontrado;
        for (Cliente c : clientes) {
            if(c.getCPF().equalsIgnoreCase(cpf)){
                clienteEncontrado = c;
                clientes.remove(c);
                return clienteEncontrado;
            }
        }
        return null;
    }
    
    public void exibeClientesCadastrados(){
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        System.out.println("");
    }
    
    public boolean alteraStatusCliente(String cpf, boolean status){
        for (Cliente c : clientes) {
            if(c.getCPF().equalsIgnoreCase(cpf)){
                c.setBomPagador(status);
                return true;
            }
        }
        return false;
    }
    
}
