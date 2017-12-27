/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.util.Scanner;
import model.Cliente;
import model.ClientesCadastrados;
import model.Endereco;
import model.Geografico;
import model.Organizacao;
import model.Pessoa;
import model.Telefonico;
import model.Virtual;
import util.Creator;
import util.IOUtil;
import util.Inicializador;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class ControleClientes {

    public static Scanner sc = new Scanner(System.in);
    private ClientesCadastrados cc;
    Inicializador ini;
    File f = new File("clientesCadastrados.txt");

    public ControleClientes() {
        cc = ClientesCadastrados.getInstance();
        ini = new Inicializador();
    }

    public boolean cadastrarPessoa(String nome, String sexo, String cpf, String idade, String rua, String CEP, String cidade, String estado, String pais, String email, String site, String ddd, String numero) {
        Pessoa p1 = Creator.criarPessoa();
        Geografico g1 = Creator.criaGeografico();
        g1.atualizarInfo(rua, CEP, cidade, estado, pais);
        Virtual v1 = Creator.criaVirtual();
        v1.atualizarInfo(email, site);
        Telefonico t1 = Creator.criaTelefonico();
        t1.atualizarInfo(ddd, numero);
        Endereco e1 = Creator.criaEndereco();
        
        e1.atualizarInfo(g1, v1, t1);
        p1.atualizarInfo(nome, sexo, cpf, idade,e1);
        p1.mostrarInfo();
        Cliente c = Creator.criaCliente(p1);
        cc.addCliente(c);
        IOUtil.salvaClientes(f, cc.getClientes());
        return false;
    }
    
    public boolean cadastrarOrganizacao(String nome, String tipo, String cnpj, String inscricao, String rua, String CEP, String cidade, String estado, String pais, String email, String site, String ddd, String numero) {
        Organizacao o1 = Creator.criarOrganizacao();
        Geografico g1 = Creator.criaGeografico();
        g1.atualizarInfo(rua, CEP, cidade, estado, pais);
        Virtual v1 = Creator.criaVirtual();
        v1.atualizarInfo(email, site);
        Telefonico t1 = Creator.criaTelefonico();
        t1.atualizarInfo(ddd, numero);
        Endereco e1 = Creator.criaEndereco();
        
        e1.atualizarInfo(g1, v1, t1);
        o1.atualizarInfo(nome, tipo, cnpj, inscricao, e1);
        o1.mostrarInfo();
        Cliente c = Creator.criaCliente(o1);
        cc.addCliente(c);
        IOUtil.salvaClientes(f, cc.getClientes());
        return false;
    }
    
    public void addCliente(Cliente c){
        cc.addCliente(c);
        IOUtil.salvaClientes(f, cc.getClientes());
    }
    
    public void exibeClientesCadastrados(){
        cc.exibeClientesCadastrados();
    }

    public Cliente buscaCPF(String cpf) {
        Cliente c = cc.busca(cpf);
        if (c != null) {
            return c;
        }
        return c;
    }

    public boolean alteraStatusCliente(String cpf, int status) {
        boolean resp = false;
        if (status == 1) {
            resp = true;
        }
        boolean resposta = cc.alteraStatusCliente(cpf, resp);
        IOUtil.salvaClientes(f, cc.getClientes());
        return resposta;
    }

}
