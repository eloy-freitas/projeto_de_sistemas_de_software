/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.bonusgeneroso.service;

import com.ufes.bonusgeneroso.business.CalculaBonus;
import com.ufes.bonusgeneroso.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloy
 */
public class CalculadoraBonus {
    private List<CalculaBonus> calculosBonus;
    private Funcionario funcionario;

    public CalculadoraBonus() {
        this.calculosBonus = new ArrayList<>();
    }
    
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public void resetCalculosBonus(){
         this.calculosBonus = new ArrayList<>();
    }
    
    public void addCalculoBonus(CalculaBonus calculosBonus){
        if (!this.calculosBonus.contains(calculosBonus))
            this.calculosBonus.add(calculosBonus);
        else 
            throw new RuntimeException("Erro: Calculo de bonus já existe");
    }
    
    public void calcular(){
        if(this.funcionario == null)
            throw new RuntimeException(
            "Erro: Nenhum funcionario foi selecionado para efetuar o calculo de bonus"
            );
        if(!this.calculosBonus.isEmpty())
            for(CalculaBonus cb : this.calculosBonus){
                cb.calcular(this.funcionario);
            }
    }
    
}
