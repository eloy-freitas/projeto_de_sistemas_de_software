package com.ufes.ordenacao.presenter;

import com.ufes.ordenacao.view.OrdenacaoView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eloy
 */
public class PrincipalPresenter {
    private OrdenacaoView ordenacaoView;
    
    public PrincipalPresenter(){
        this.ordenacaoView = new OrdenacaoView();
        
        iniciarView();
        setCbmMetodo();
        this.ordenacaoView.setVisible(true);
        
    }
    
    private void setCbmMetodo(){
        //pegar o nome de cada objeto da MetodosOrdenacaoCollection 
        List<String> metodosOrdencao = new ArrayList<>();
        metodosOrdencao.add("BubbleSort");
        metodosOrdencao.add("SellectionSort");
        
        for(String m : metodosOrdencao){
            this.ordenacaoView.getCmbMetodo().addItem(m);//adicionar metodo com m.getNome()
        }
        
    } 
    
    private void iniciarView(){
        this.ordenacaoView.getLblSemOrdem().removeAll();
        this.ordenacaoView.getCmbMetodo().removeAllItems();
        this.ordenacaoView.getLstOrdenados().removeAll();
        this.ordenacaoView.getRbtnCrescente().setSelected(true);
    }
    
    private void setMetodoOrdenacao(){
        //definir a variável método com o que foi selecionado no cmbMetodo
    }
    
    private void setTipoOrdenacao(){
        //definir se a ordenação vai ser crescene ou decresente 
        //a partir do radioButton
        //deixar crescente por padrão
    }
}
