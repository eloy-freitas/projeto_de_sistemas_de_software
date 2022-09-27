/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.calculadoraestatistica;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author eloy
 */
public class Menor implements MetodoEstatistico{

    @Override
    public Resultado calcular(List<Double> numeros) {
        return new Resultado("Menor", Collections.min(numeros));
    }
    
}
