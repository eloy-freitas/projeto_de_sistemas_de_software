/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.util.List;

/**
 *
 * @author eloy
 */
public abstract class MetodoOrdenacao {
    private String nome;
    
    public MetodoOrdenacao(String nome){
        this.nome = nome;
    }
    
    public abstract Resultado ordenarCrescente(List<Integer> valores);
    
   public abstract Resultado ordenarDecrescente(List<Integer> valores);

    public String getNome() {
        return nome;
    }
        
}
