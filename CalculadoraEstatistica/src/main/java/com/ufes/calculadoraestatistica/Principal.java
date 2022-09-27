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
        
        
        double resultado = new CalculadoraEstatistica().calcular(numeros, new DesvioPadrao());
        System.out.println("Desvio padrão: " + resultado);
        resultado = new CalculadoraEstatistica().calcular(numeros, new Variancia());
        System.out.println("Variância: " + resultado);
        resultado = new CalculadoraEstatistica().calcular(numeros, new Menor());
        System.out.println("Menor: " + resultado);
        resultado = new CalculadoraEstatistica().calcular(numeros, new Maior());
        System.out.println("Maior: " + resultado);
        resultado = new CalculadoraEstatistica().calcular(numeros, new Somatorio());
        System.out.println("Somatório: " + resultado);
        resultado = new CalculadoraEstatistica().calcular(numeros, new SomaAoQuadrado());
        System.out.println("Soma ao Quadrado: " + resultado);

    }
}
