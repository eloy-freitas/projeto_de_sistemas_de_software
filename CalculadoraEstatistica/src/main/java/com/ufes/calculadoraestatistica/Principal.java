/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author eloy
 */
public class Principal {
    public static void main(String[] args) {
        List<Double> numeros
                = new ArrayList<>(Arrays.asList(
                        10.0, 5.0, 6.0, 7.0, 8.0, 2.0
                ));
        
        Calculadora calculadora = new Calculadora();
        
        ResultadoEstatisticaDescritiva resultados = new ResultadoEstatisticaDescritiva(numeros);
        
        calculadora.calcular(resultados);
        
        System.out.println("Data -> " + resultados.getData());
        System.out.println("Resultados: ");
        
        for(int i=0; i < resultados.getResultados().size(); i++) {
        	System.out.print("Nome -> " + resultados.getResultados().get(i).getNome() + 
        			" Resultado -> " + resultados.getResultados().get(i).getValor() + "\n");
        }
    }
}
