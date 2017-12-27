/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ControleEstoque;
import control.ControlePedidos;
import java.io.File;
import java.util.Scanner;
import model.Distribuidora;
import model.Pedido;
import util.IOUtil;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class InterfaceDeposito {

    Scanner entrada = new Scanner(System.in);
    ControleEstoque ce = new ControleEstoque();
    ControlePedidos cp = new ControlePedidos();
    Distribuidora distribuidora;
    File distrib = new File("distribuidora.txt");
    
    public InterfaceDeposito() {
        int escolha;
        do {
            try {
                this.distribuidora = Distribuidora.getInstance(IOUtil.carregaDistribuidora(distrib));
                escolha = menuDeposito();
                switch (escolha) {
                    case 1:
                        ce.atualiza(distribuidora);
                        break;
                    case 2:
                        ce.registra(distribuidora);
                        break;
                    case 3:
                        autorizaDespacho();
                        break;
                    case 4:
                        mostraPedidos();
                        break;
                    case 5:
                        mostraEstoque();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }

            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                System.out.println("Digite um número válido!");
                System.out.println("");
                escolha = 0;
            }
        } while (escolha != 6);
    }
    
    public int menuDeposito() {
        int escolha = 0;
        System.out.println("----- MENU DEPOSITO ----"
                + "\n1 - Atualiza Quantidade de Produtos no Estoque"
                + "\n2 - Registra um novo Produto"
                + "\n3 - Verificar se o pedido foi pago para autorizar o envio"
                + "\n4 - Exibe todos os pedidos recebidos"
                + "\n5 - Exibe produtos no estoque"
                + "\n6 - Sair");
        System.out.print("Opção Escolhida: ");
        escolha = Integer.parseInt(entrada.nextLine());
        return escolha;
    }
    
    
    
    public void autorizaDespacho(){
        System.out.println(" ------ DESPACHO ------ ");
        System.out.print("Digite o id do Pedido para verificar o pagamento: ");
        String idCompra = entrada.nextLine();
        Pedido p = ce.autorizaDespacho(idCompra);
        if(p != null){
            System.out.println("Pedido despachado");
            cp.atualizaPedido(p);
        }else{
            System.out.println("Pedido não encontrado");
        }
    }
    
    public void mostraPedidos(){
        System.out.println("\n ------ PEDIDOS RECEBIDOS ------ \n");
        ce.mostraPedidos();
    }
    
    public void mostraEstoque(){
        System.out.println("-------- ESTOQUE --------- \n");
        ce.mostraEstoque();
    }
}
