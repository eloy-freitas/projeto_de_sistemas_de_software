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
public class SomaAoQuadrado implements MetodoEstatistico{

    @Override
    public Resultado calcular(List<Double> numeros) {
        double somaAoQuadrado = 0;
        
        for(int i = 0; i< numeros.size(); i++){
            somaAoQuadrado += Math.pow(numeros.get(i), 2);
        }
        
        return new Resultado("Soma ao Quadrado", somaAoQuadrado);
    }
    
}
