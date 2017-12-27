/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Cliente;
import model.Distribuidora;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class IOUtil {

    public static ArrayList<Cliente> carregaCliente(File file) {
        ArrayList<Cliente> p = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            p = (ArrayList<Cliente>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }

        return p;
    }

    public static void salvaClientes(File file, ArrayList<Cliente> clientes) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída!");
        }
    }

    //--------------------- PEDIDOS ---------------------------
    public static ArrayList<Pedido> carregaPedidos(File file) {
        ArrayList<Pedido> p = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            p = (ArrayList<Pedido>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }

        return p;
    }

    public static void salvaPedidos(File file, ArrayList<Pedido> pedidos) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pedidos);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída!");
        }
    }

    // ------------------- CATALAGO DE PRODUTOS ------------------------------
    public static ArrayList<Produto> carregaCatalagoProdutos(File file) {
        ArrayList<Produto> p = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            p = (ArrayList<Produto>) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }

        return p;
    }

    public static void salvaCatalagoProdutos(File file, ArrayList<Produto> catalago) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catalago);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída!");
        }
    }

    // ------------------- DISTRIBUIDORA ------------------------------
    public static Distribuidora carregaDistribuidora(File file) {
        Distribuidora d = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            d = (Distribuidora) ois.readObject();

            ois.close();
            fis.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de entrada!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problema ao criar o objeto pessoa!");
        }

        return d;
    }

    public static void salvaDistribuidora(File file, Distribuidora d) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Problema no fluxo de saída!");
        }
    }

}
