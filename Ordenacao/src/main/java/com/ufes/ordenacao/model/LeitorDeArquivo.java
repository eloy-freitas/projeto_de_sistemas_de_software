/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eloy
 */
public class LeitorDeArquivo {
    private File arquivo;
    private List<Integer> numerosDesordenados;
    
    public LeitorDeArquivo(String path) {
        this.arquivo = new File(path);
        this.numerosDesordenados = new ArrayList<>();
    }
    
    public List<Integer> getNumerosDesordenados() throws FileNotFoundException{
        Scanner scanner = new Scanner(this.arquivo);
        while(scanner.hasNextInt()){
            this.numerosDesordenados.add(scanner.nextInt());
        }
        return this.numerosDesordenados;
    }
    
}
