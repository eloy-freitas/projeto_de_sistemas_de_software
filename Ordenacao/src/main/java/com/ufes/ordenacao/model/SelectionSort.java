/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author eloy
 */
public class SelectionSort extends MetodoOrdenacao{

    public SelectionSort() {
        super("SelectionSort");
    }

    @Override
    public Resultado ordenarCrescente(List<Integer> valores) {
        Instant start = Instant.now();
        int tamanho = valores.size();
        int menorValor = 0;
        int index = 0;
        for (int i = 0; i < tamanho - 1; i++)  {  
            index = i;  
            for (int j = i + 1; j < tamanho; j++){  
                if (valores.get(j) < valores.get(index)){  
                    index = j;
                }  
            }  
            menorValor = valores.get(index);   
            valores.set(index, valores.get(i));  
            valores.set(i, menorValor);  
        }    
        Instant end = Instant.now();
        Duration tempoExecuacao = Duration.between(
             start,
             end
        );
       return new Resultado(valores, tempoExecuacao);
    }

    @Override
    public Resultado ordenarDecrescente(List<Integer> valores) {
        Instant start = Instant.now();
        int tamanho = valores.size();
        int menorValor = 0;
        int index = 0;
        for (int i = tamanho; i > 0; i--)  {  
            index = i;  
            for (int j = i - 1; j > 0; j--){  
                if (valores.get(j) < valores.get(index)){  
                    index = j;
                }  
            }  
            menorValor = valores.get(index);   
            valores.set(index, valores.get(i));  
            valores.set(i, menorValor);  
        }    
        Instant end = Instant.now();
        Duration tempoExecuacao = Duration.between(
             start,
             end
        );
        return new Resultado(valores, tempoExecuacao);
    }
    
}
