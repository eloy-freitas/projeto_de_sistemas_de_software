/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica;

import java.util.List;

/**
 *
 * @author eloy
 */
public class Variancia implements MetodoEstatistico{

    @Override
    public Resultado calcular(List<Double> numeros) {
        Resultado somatorio = new Somatorio().calcular(numeros);
        Resultado somaAoQuadrado = new SomaAoQuadrado().calcular(numeros);
        int size = numeros.size();
        double p1 = 1 / (size - 1);
        
        double p2 = somaAoQuadrado.getValor() - Math.pow(somatorio.getValor(), 2) / size;
        
        return new Resultado("Variancia", p1 * p2);
    }
    
    
    
}
