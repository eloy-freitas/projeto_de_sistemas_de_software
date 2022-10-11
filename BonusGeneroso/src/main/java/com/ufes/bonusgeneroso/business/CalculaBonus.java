/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.bonusgeneroso.business;

import com.ufes.bonusgeneroso.model.Funcionario;

/**
 *
 * @author eloy
 */
public interface CalculaBonus {
    void calcular(Funcionario funcionario);
    boolean validarFuncionario(Funcionario funcionario);
    String getNome();
}
