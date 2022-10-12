/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.business.leitor_arquivo;

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
    private List<Double> numerosSemOrdem;
    
    public LeitorDeArquivo(String path) {
        this.arquivo = new File(path);
        this.numerosSemOrdem = new ArrayList<>();
    }
    
    public List<Double> getNumerosSemOrdem() throws FileNotFoundException{
        Scanner scanner = new Scanner(this.arquivo);
        while(scanner.hasNextInt()){
            this.numerosSemOrdem.add(scanner.nextDouble());
        }
        return this.numerosSemOrdem;
    }
    
}
