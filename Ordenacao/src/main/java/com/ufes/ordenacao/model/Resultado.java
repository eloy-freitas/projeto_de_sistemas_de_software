/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.util.List;
import java.time.Duration;
/**
 *
 * @author eloy
 */
public class Resultado {
    
    public List<Integer> numeros;
    public Duration tempo;

    public Resultado(List<Integer> numeros, Duration tempo) {
        this.numeros = numeros;
        this.tempo = tempo;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public String getTempo() {
        
        return this.tempo.toString().replace("PT", "");
    }
    
    
    
}
