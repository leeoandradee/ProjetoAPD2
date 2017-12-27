/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleClientes;
import control.ControlePedidos;
import java.util.Scanner;
import model.ClientesCadastrados;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class InterfaceSistemaDeCobranca {

    Scanner entrada = new Scanner(System.in);
    ControlePedidos cp = new ControlePedidos();
    ClientesCadastrados cc = new ClientesCadastrados();
    ControleClientes controleClientes = new ControleClientes();

    public InterfaceSistemaDeCobranca() {
        int escolha;
        do {
            try {
                escolha = menuSistemaCobranca();
                switch (escolha) {
                    case 1:
                        alteraStatusPagamento();
                        break;
                    case 2:
                        alteraStatusCliente();
                        break;
                    case 3:
                        exibePedidosCadastrados();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }

            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                System.out.println("");
                escolha = 0;
            }
        } while (escolha != 4);
    }

    public int menuSistemaCobranca() {
        int escolha = 0;
        System.out.println("----- MENU DEPOSITO ----"
                + "\n1 - Mudar status do pagamento"
                + "\n2 - Mudar status do Cliente(Bom/Mal Pagador)"
                + "\n3 - Exibe Pedidos Cadastrados"
                + "\n4 - Sair");
        System.out.print("Opção Escolhida: ");
        escolha = Integer.parseInt(entrada.nextLine());
        return escolha;
    }

    public void alteraStatusPagamento() {
        System.out.println(" ----- ALTERAR PAGAMENTO ----- ");
        System.out.println("Digite o id do pedido referente ao pagamento: ");
        String idPedido = entrada.nextLine();
        boolean resposta = cp.alteraStatusPagamento(idPedido);
        if (resposta == true) {
            System.out.println("Status do Pagamento alterado com sucesso");
        } else {
            System.out.println("Pedido não encontrado");
        }
    }

    public void alteraStatusCliente() {
        System.out.println("------- ALTERAR STATUS CLIENTE ------");
        System.out.print("Digite o cpf do cliente que deseja alterar: ");
        String cpf = entrada.nextLine();
        int status = 0;
        do {
            System.out.println("Digite 1 - Bom Pagador 2 - Mal Pagador");
            status = Integer.parseInt(entrada.nextLine());
        } while (status != 1 && status != 2);
        boolean resultado = controleClientes.alteraStatusCliente(cpf, status);
        if (resultado = true) {
            System.out.println("Status do Cliente alterado com sucesso");
        } else {
            System.out.println("Cliente Não Existe");
        }
    }

    public void exibePedidosCadastrados() {
        System.out.println("\n ------- PEDIDOS CADASTRADOS -------- \n");
        cp.exibePedidosCadastrados();
    }
}
