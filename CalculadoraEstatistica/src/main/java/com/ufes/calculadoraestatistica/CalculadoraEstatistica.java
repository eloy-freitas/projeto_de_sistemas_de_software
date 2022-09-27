/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ufes.calculadoraestatistica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloy
 */
public class CalculadoraEstatistica {
    
    public double calcular(List<Double> numeros, Operacao operacao){
        return operacao.calcula(numeros);
    }
    
}
