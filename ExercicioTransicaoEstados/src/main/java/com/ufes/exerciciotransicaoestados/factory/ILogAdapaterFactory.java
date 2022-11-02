/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ufes.exerciciotransicaoestados.factory;

import com.ufes.exerciciotransicaoestados.adaptador.ILogAdapter;

/**
 *
 * @author eloy
 */
public interface ILogAdapaterFactory {
    ILogAdapter getLogAdapter();
}
