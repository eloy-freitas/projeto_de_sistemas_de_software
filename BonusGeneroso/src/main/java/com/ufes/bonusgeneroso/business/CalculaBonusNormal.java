/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.bonusgeneroso.business;

import com.ufes.bonusgeneroso.model.Bonus;
import com.ufes.bonusgeneroso.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author eloy
 */
public class CalculaBonusNormal implements CalculaBonus{
    
    private double valor;
    private String nome;
    
    public CalculaBonusNormal(double valor) {
        this.valor = valor;
        this.nome = "Bonus Normal";
    }
    
    @Override
    public void calcular(Funcionario funcionario) {
        if(!validarFuncionario(funcionario)){
            double bonus = funcionario.getSalarioBase()*this.valor;
            funcionario.addBonus(new Bonus(
            this.nome, 
            bonus, 
            LocalDate.now()
            ));
        }else{
            throw new RuntimeException(
         "Esse tipo de bonus já foi aplicado neste funcionário."
            );
        }    
    }

    @Override
    public boolean validarFuncionario(Funcionario funcionario) {
        boolean bonusExiste = false;
        for(Bonus b : funcionario.getBonus()){
            if(b.getTipo().equals(this.nome))
                bonusExiste = true;
        }
        return bonusExiste;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }
    
}
