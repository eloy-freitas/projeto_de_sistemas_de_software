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
public class Maior implements Operacao{

    @Override
    public double calcula(List<Double> numeros) {
        return Collections.max(numeros);
    }
    
}
