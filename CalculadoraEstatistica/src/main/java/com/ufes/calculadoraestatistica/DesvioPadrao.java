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
public class DesvioPadrao implements Operacao {

    @Override
    public double calcula(List<Double> numeros) {
        double size = numeros.size();
        double p1 = 1 / (size - 1);
        double somaAoQuadrado = new SomaAoQuadrado().calcula(numeros);
        double somatorio = new Somatorio().calcula(numeros);
        double p2 = somaAoQuadrado - Math.pow(somatorio, 2) / size;
        
        return Math.sqrt(p1*p2);
    }
    
}
