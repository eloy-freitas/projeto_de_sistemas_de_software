
package com.ufes.ordenacao;

import com.ufes.ordenacao.business.leitor_arquivo.LeitorArquivoCsvHandler;
import com.ufes.ordenacao.business.leitor_arquivo.LeitorArquivoProcessor;
import com.ufes.ordenacao.business.leitor_arquivo.LeitorArquivoTxtHandler;
import com.ufes.ordenacao.business.metodos_ordenacao.BubbleSortStrategy;
import com.ufes.ordenacao.business.metodos_ordenacao.MetodoOrdenacaoStrategy;
import com.ufes.ordenacao.model.Resultado;
import com.ufes.ordenacao.business.metodos_ordenacao.SelectionSortStrategy;
import com.ufes.ordenacao.presenter.PrincipalPresenter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eloy
 */
public class Ordenacao {

    public static void main(String[] args) {
        new PrincipalPresenter();
        
        /*LeitorArquivoProcessor arquivoProcessor = new LeitorArquivoProcessor();
        arquivoProcessor.addLeitorArquivoHandler(new LeitorArquivoCsvHandler());
        arquivoProcessor.addLeitorArquivoHandler(new LeitorArquivoTxtHandler());
        String nome = "/home/eloy/salarios.csv";
        List<Double> numeros;
        Resultado result;
            MetodoOrdenacaoStrategy b = new SelectionSortStrategy();
        try {
            
            numeros = arquivoProcessor.handleRequest(nome);
            /*for (double i : numeros){
                System.out.println(i);
            }
            result = b.ordenarCrescente(numeros);
            for (double i : result.getNumeros()){
                System.out.println(i);
            }
            System.out.println(result.getTempo());
        } catch (Exception e) {
            throw new RuntimeException("arquivo inválido");
        }
        
        
        ArrayList<Double> numeros= new ArrayList<>(Arrays.asList(
                   4.0
                    ,73.0
                    ,87.0
                    ,7.0
                    ,37.0
                    ,1.0
                    ,98.0
                    ,10.0
                    ,13.0
                    ,14.0
                    ,78.0

             ));
        
        MetodoOrdenacao b = new SelectionSort();
        Resultado result = b.ordenarDecrescente(numeros);
        for (double i : result.getNumeros()){
            System.out.println(i);
        }
        */
    }
}
