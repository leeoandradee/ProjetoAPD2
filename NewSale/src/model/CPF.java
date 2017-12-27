/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.CPFSizeException;
import exceptions.CPFNumberFormatException;
import exceptions.CPFInvalid;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Kenji
 * @author Leonardo Andrade
 * @author Matheus Fontanetti
 */
public class CPF {
    private ArrayList<Integer> numbers;

    public CPF() {
    }

    public CPF(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }
    
    public void parse(String str){
        this.numbers = new ArrayList<>();
        String[] nums = str.split("");
        //TODO: tratamento se tem caracteres
        //TODO: tratamento se tem mais ou menos de 11 dígitos
        if(nums.length != 11){
            throw new CPFSizeException();
        }else{
            for (int i = 0; i < nums.length; i++) {
                try{
                int temp = Integer.parseInt(nums[i]);
                numbers.add(temp);
                }catch(NumberFormatException ex){
                    throw new CPFNumberFormatException();
                }
            }
            boolean verify = validaCPF();
            if(verify==false){
                throw new CPFInvalid();
        }
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        String str = "";
        int cont = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            str+=this.numbers.get(i);
            cont++;
            if(cont%3==0 && cont<7) str+=".";
            else if(cont%3==0) str+="-";
        }
        
        return str;
    }
    
    public boolean validaCPF(){
        //valida primeiro número
        boolean verify = false;
        int cont1 = 10;
        int soma = 0;
        int controler = 1;
        for(int n: this.numbers){
            if(controler<=9){
                soma+=n*cont1;
                cont1--;    
            }
            controler++;
        }
        int divisao = (int)soma/11;
        int resto = soma%11;
        int firstDigit = 0;
        
        if (resto>2){
            firstDigit = 11-resto;
        }
        //valida segundo número
        int cont2 = 11;
        int soma2 = 0;
        int controler2 = 1;
        for(int n: this.numbers){
            if(controler2<=9){
                soma2+=n*cont2;
                cont2--;    
            }
            if(controler2==9){
                soma2+=firstDigit*cont2;
            }
            controler2++;
        }
        
        int divisao2 = (int)soma2/11;
        int resto2 = soma2%11;
        int secondDigit = 0;
        
        if (resto2>2){
            secondDigit = 11-resto2;
        }
        
        if(this.numbers.get(9)==firstDigit && this.numbers.get(10)==secondDigit){
            verify = true;
        }
        
        return verify;
    }
    
}
