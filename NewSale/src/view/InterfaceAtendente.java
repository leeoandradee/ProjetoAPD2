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
public class InterfaceAtendente {

    Scanner entrada = new Scanner(System.in);
    ControleClientes cc = new ControleClientes();
    ControlePedidos cp = new ControlePedidos();

    public InterfaceAtendente() {
        int escolha;
        do {
            try {
                escolha = menuAtendente();
                switch (escolha) {
                    case 1:
                        buscaCPF();
                        break;
                    case 2:
                        interfaceCadastro();
                        break;
                    case 3:
                        novoPedido();
                        break;
                    case 4:
                        exibeClientesCadastrados();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                System.out.println("");
                escolha = 0;
            }
        } while (escolha != 5);
    }

    public int menuAtendente() {
        System.out.println("\n----- MENU ATENDENTE ----"
                + "\n1 - Busca CPF"
                + "\n2 - Cadastrar Cliente"
                + "\n3 - Novo Pedido"
                + "\n4 - Exibe Clientes Cadastrados"
                + "\n5 - Sair"
                + "\n");
        System.out.print("Opção Escolhida: ");
        int escolha = Integer.parseInt(entrada.nextLine());
        return escolha;
    }

    public void buscaCPF() {
        System.out.print("Digite o CPF/CNPJ que deseja busca: ");
        String cpf = entrada.nextLine();
        Cliente c = cc.buscaCPF(cpf);
        if (c != null) {
            System.out.println(c);
            cc.addCliente(c);
        } else {
            System.out.println("CPF/CNPJ Não Encontrado");
        }
    }

    public void novoPedido() {
        System.out.println("\n------ Novo Pedido ------");
        System.out.println("Somente Clientes cadastrados poderào fazer um novo Pedido");
        System.out.print("Digite o CPF do Cliente: ");
        String cpf = entrada.nextLine();
        Cliente c = cc.buscaCPF(cpf);
        if (c == null) {
            System.out.println("Cliente não cadastrado\n Cadastro Necessario");
        }else if(c.isBomPagador() == false){
            System.out.println("Cliente tem pedidos não pagos. Novo Pedido Negado");
            cc.addCliente(c);
        } else {
            System.out.println("Cliente encontrado");
            System.out.println(c);
            System.out.println("Digite o id da compra: ");
            String id = entrada.nextLine();
            boolean verifica = cp.verificaIDPedido(id);
            if(verifica == true){
                c = cp.novoPedido(c,id);
                cc.addCliente(c);
            }else{
                System.out.println("ID da compra ja cadastrado");
            }
        }
    }

    public void interfaceCadastro() {
        int escolha;
        do {
            try {
                escolha = menuCadastro();
                switch (escolha) {
                    case 1:
                        cadastroPessoa();
                        break;
                    case 2:
                        cadastroOrganizacao();
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Digite um número válido!");
                System.out.println("");
                escolha = 0;
            }
        } while (escolha != 3);

    }

    public int menuCadastro() {
        System.out.println("-----MENU CADASTRO----"
                + "\n1 - Pessoa Fisica"
                + "\n2 - Pessoa Juridica"
                + "\n3 - Voltar");
        System.out.print("Opção Escolhida: ");
        int op = Integer.parseInt(entrada.nextLine());
        return op;
    }
    
    public void exibeClientesCadastrados(){
        cc.exibeClientesCadastrados();
    }

    public void cadastroPessoa() {
        System.out.println("Digite o nome do cliente: ");
        String nome = entrada.nextLine();

        System.out.println("Sexo: ");
        String sexo = entrada.nextLine();

        System.out.println("CPF: ");
        String cpf = entrada.nextLine();
        Cliente c = cc.buscaCPF(cpf);
        if (c == null) {
            System.out.println("Idade: ");
            String idade = entrada.nextLine();

            System.out.println("Vamos cadastrar o endereço...");

            System.out.println("Rua: ");
            String rua = entrada.nextLine();

            System.out.println("CEP: ");
            String CEP = entrada.nextLine();

            System.out.println("Cidade: ");
            String cidade = entrada.nextLine();

            System.out.println("Estado: ");
            String estado = entrada.nextLine();

            System.out.println("País: ");
            String pais = entrada.nextLine();

            System.out.println("\n");
            System.out.println("Email: ");
            String email = entrada.nextLine();

            System.out.println("Site(Se não possui deixar em branco): ");
            String site = entrada.nextLine();

            System.out.println("\nEndereço telefônico...");
            System.out.println("DDD: ");
            String DDD = entrada.nextLine();

            System.out.println("Número: ");
            String numero = entrada.nextLine();

            cc.cadastrarPessoa(nome, sexo, cpf, idade, rua, CEP, cidade, estado, pais, email, site, DDD, numero);

            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("CPF já cadastrado");
        }
    }

    public void cadastroOrganizacao() {
        System.out.println("Digite o nome da Organizacao: ");
        String nome = entrada.nextLine();

        System.out.println("Tipo: ");
        String tipo = entrada.nextLine();

        System.out.println("CNPJ: ");
        String cnpj = entrada.nextLine();
        Cliente c = cc.buscaCPF(cnpj);
        if (c == null) {

            System.out.println("Inscricao Estadual: ");
            String inscricao = entrada.nextLine();

            System.out.println("Vamos cadastrar o endereço...");

            System.out.println("Rua: ");
            String rua = entrada.nextLine();

            System.out.println("CEP: ");
            String CEP = entrada.nextLine();

            System.out.println("Cidade: ");
            String cidade = entrada.nextLine();

            System.out.println("Estado: ");
            String estado = entrada.nextLine();

            System.out.println("País: ");
            String pais = entrada.nextLine();

            System.out.println("\n");
            System.out.println("Email: ");
            String email = entrada.nextLine();

            System.out.println("Site(Se não possui deixar em branco): ");
            String site = entrada.nextLine();

            System.out.println("\nEndereço telefônico...");
            System.out.println("DDD: ");
            String DDD = entrada.nextLine();

            System.out.println("Número: ");
            String numero = entrada.nextLine();

            cc.cadastrarPessoa(nome, tipo, cnpj, inscricao, rua, CEP, cidade, estado, pais, email, site, DDD, numero);

            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("CPNJ Já cadastrado");
        }
    }

}
