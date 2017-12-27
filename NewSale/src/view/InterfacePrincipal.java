/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleClientes;
import control.ControlePedidos;
import java.util.Scanner;
import model.Cliente;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class InterfacePrincipal {

    Scanner entrada = new Scanner(System.in);
    ControleClientes cc = new ControleClientes();
    ControlePedidos cp = new ControlePedidos();
    InterfaceAtendente ia;
    InterfaceDeposito id;
    InterfaceSistemaDeCobranca isc;
            

    public InterfacePrincipal() {
        int escolha;
        do {
            try {
                escolha = menuPrincipal();
                switch (escolha) {
                    case 1:
                        ia = new InterfaceAtendente();
                        break;
                    case 2:
                        id = new InterfaceDeposito();
                        break;
                    case 3:
                        isc = new InterfaceSistemaDeCobranca();
                        break;
                   
                }

            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                System.out.println("");
                escolha = 0;
            }
        } while (escolha != 4);
    }

    public int menuPrincipal() {
        int escolha = 0;
        System.out.println("----- NEW SALE ----"
                + "\n1 - Menu Atendente"
                + "\n2 - Menu Deposito"
                + "\n3 - Menu Sistema de Cobrança"
                + "\n4 - Sair");
        System.out.print("Opção Escolhida: ");
        escolha = Integer.parseInt(entrada.nextLine());
        return escolha;
    }

  

}
