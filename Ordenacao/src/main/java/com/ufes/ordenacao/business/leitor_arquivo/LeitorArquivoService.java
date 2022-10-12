/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.ordenacao.business.leitor_arquivo;

import java.util.List;

/**
 *
 * @author eloy
 */
public class LeitorArquivoService {
    private LeitorArquivoProcessor arquivoProcessor ;
    
    public LeitorArquivoService() {
        this.arquivoProcessor = new LeitorArquivoProcessor();
        this.arquivoProcessor.addLeitorArquivoHandler(new LeitorArquivoCsvHandler());
        this.arquivoProcessor.addLeitorArquivoHandler(new LeitorArquivoTxtHandler());
    }
    
    public List<Double> processarArquivo(String path) throws Exception{
        return  arquivoProcessor.handleRequest(path);
    }
    
}
