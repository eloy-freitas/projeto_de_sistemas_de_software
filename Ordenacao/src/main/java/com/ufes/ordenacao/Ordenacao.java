
package com.ufes.ordenacao;

import com.ufes.ordenacao.business.BubbleSortStrategy;
import com.ufes.ordenacao.business.MetodoOrdenacaoStrategy;
import com.ufes.ordenacao.model.Resultado;
import com.ufes.ordenacao.business.SelectionSortStrategy;
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
        /*
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
