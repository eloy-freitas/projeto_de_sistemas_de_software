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
public class DesvioPadrao implements MetodoEstatistico {

    @Override
    public Resultado calcular(List<Double> numeros) {
        double size = numeros.size();
        double p1 = 1 / (size - 1);
        Resultado somaAoQuadrado = new SomaAoQuadrado().calcular(numeros);
        Resultado somatorio = new Somatorio().calcular(numeros);
        double p2 = somaAoQuadrado.getValor() - Math.pow(somatorio.getValor(), 2) / size;
        
        return new Resultado("Desvio Padrão", Math.sqrt(p1*p2));
    }
    
}
