/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.util.List;

/**
 *
 * @author eloy
 */
public class BubbleSort extends MetodoOrdenacao{

    public BubbleSort() {
        super("BubbleSort");
        
    }

    
    @Override
    public List<Integer> ordenarCrescente(List<Integer> valores) {
       int tamanho = valores.size();
       int aux = 0;
       for (int i = 0; i < tamanho; i++){
           for (int j = 0; j < tamanho - 1; j++){
               if (valores.get(j).compareTo(valores.get(j+1)) > 0)
                {
                    aux = valores.get(j);
                    valores.set(j,valores.get(j+1) );
                    valores.set(j+1, aux);
                }
           }
       }
       return valores;
    }

  
    
}
