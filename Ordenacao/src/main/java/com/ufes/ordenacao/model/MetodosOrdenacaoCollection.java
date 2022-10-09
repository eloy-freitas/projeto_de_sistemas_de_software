/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloy
 */
public class MetodosOrdenacaoCollection {
    private List<MetodoOrdenacao> metodos;

    public MetodosOrdenacaoCollection() {
        this.metodos = new ArrayList<>();
        this.metodos.add(new BubbleSort());
        this.metodos.add(new SelectionSort());
    }

    public List<MetodoOrdenacao> getMetodos() {
        return this.metodos;
    }
    
    
    
}
