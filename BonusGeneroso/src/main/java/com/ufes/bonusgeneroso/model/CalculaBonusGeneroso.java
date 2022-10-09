/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.bonusgeneroso.model;

/**
 *
 * @author eloy
 */
public class CalculaBonusGeneroso implements CalculaBonus{
    private double valor;

    public CalculaBonusGeneroso(double valor) {
        this.valor = valor;
    }

    @Override
    public void calcular(Funcionario funcionario) {
        Bonus bonus = new Bonus("Generoso", this.valor);
        boolean bonusExiste = false;
        for(Bonus b : funcionario.getBonus()){
            if(b.getTipo().equals(bonus.getTipo()))
                bonusExiste = true;
        }
        if(!bonusExiste){
           funcionario.addBonus(bonus);
        }else{
            throw new RuntimeException(
                    "Esse tipo de bonus já foi aplicado neste funcionário."
            );
        }    
    }
    
    
}
