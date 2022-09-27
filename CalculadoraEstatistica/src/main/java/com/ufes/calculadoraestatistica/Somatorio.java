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
public class Somatorio implements MetodoEstatistico {
    @Override
    public final Resultado calcular(List<Double> numeros){
        double total = 0;
        for(int i=0; i < numeros.size(); i++){
            total += numeros.get(i);
        }
        return new Resultado("Somatorio", total);
    }
    
}
