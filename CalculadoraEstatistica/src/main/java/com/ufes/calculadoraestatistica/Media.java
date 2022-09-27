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
public class Media implements MetodoEstatistico{
    
    @Override
    public Resultado calcular(List<Double> numeros) {
        Resultado r = new Somatorio().calcular(numeros);
        return new Resultado("Media", r.getValor() / numeros.size());
    }
    
}
