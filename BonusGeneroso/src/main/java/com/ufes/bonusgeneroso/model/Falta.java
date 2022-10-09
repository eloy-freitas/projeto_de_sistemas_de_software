/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.bonusgeneroso.model;

import java.time.LocalDate;

/**
 *
 * @author eloy
 */
public class Falta {
    private int quantidade;
    private LocalDate mes;

    public Falta(LocalDate mes) {
        this.quantidade = 0;
        this.mes = mes;
    }
    
    
    public void addFalta(){
        this.quantidade++;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getMes() {
        return mes;
    }
    
    
}
