/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.bonusgeneroso.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloy
 */
public class Funcionario {
    private String nome;
    private double salarioBase;
    private double salario;
    private String cargo;
    private double distanciaTrabalho;
    private List<Bonus> bonus;
    private List<Falta> faltas;
    
    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.faltas = new ArrayList<>();
        this.bonus = new ArrayList<>();
    }
    
    public void addBonus(Bonus bonus){
        if(!this.bonus.contains(bonus))
            this.bonus.add(bonus);
        else
           throw new RuntimeException("Erro: bonus duplicado!");
    }
    
    public void acrescentarFalta(LocalDate mes){
        try {
           for(Falta f : this.faltas)
               if(f.getData().equals(mes))
                   f.addFalta();
        } catch (Exception e) {
            throw new RuntimeException("Erro: mês inválido!");
        }
    }
    
    public void addFalta(LocalDate mes){
        try {
            this.faltas.add(new Falta(mes));
        } catch (Exception e) {
            throw new RuntimeException("Erro: mês duplicado!");
        }
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setDistanciaTrabalho(double distanciaTrabalho) {
        this.distanciaTrabalho = distanciaTrabalho;
    }
    
    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getDistanciaTrabalho() {
        return distanciaTrabalho;
    }

    public List<Bonus> getBonus() {
        return bonus;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }
    
    
}
