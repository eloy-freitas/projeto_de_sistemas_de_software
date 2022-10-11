/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ufes.bonusgeneroso;

import com.ufes.bonusgeneroso.model.Bonus;
import com.ufes.bonusgeneroso.business.CalculaBonus;
import com.ufes.bonusgeneroso.business.CalculaBonusGeneroso;
import com.ufes.bonusgeneroso.business.CalculaBonusNormal;
import com.ufes.bonusgeneroso.service.CalculadoraBonus;
import com.ufes.bonusgeneroso.model.Falta;
import com.ufes.bonusgeneroso.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author eloy
 */
public class BonusGeneroso {

    public static void main(String[] args) {
        Funcionario f = new Funcionario("juraci", 1000);
        CalculaBonus cbn = new CalculaBonusNormal(0.3);
        CalculaBonus cbg = new CalculaBonusGeneroso(0.5);
       
        CalculadoraBonus cb = new CalculadoraBonus();
        cb.setFuncionario(f);
        cb.addCalculoBonus(cbn);
        cb.addCalculoBonus(cbg);
        cb.calcular();
        
        for (Bonus b : f.getBonus()) {
            System.out.println("tipo: "+b.getTipo()+" valor: "+b.getValor());
        }
    }
    
    
}
