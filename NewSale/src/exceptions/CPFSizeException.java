/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class CPFSizeException extends RuntimeException{

    public CPFSizeException() {
        super("CPF com número de dígitos errado. Esperado 11!");
    }
    
}
