/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class Entrega implements Serializable{
    
    private Date dataEntrega;
    private String IDentrega;
    private String entregaTipo;
    private Pagamento pagamento;

    public Entrega() {
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setDataEntrega() {
        this.dataEntrega = new Date();
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
     
    
 
    public void criaEntrega(Pagamento pag){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o id da entrega: ");
        this.IDentrega = entrada.nextLine();
        
        System.out.println("Digite o tipo da entrega(Rápida ou Economica): ");
        this.entregaTipo = entrada.nextLine();
        
        this.pagamento = pag;
    }
}


