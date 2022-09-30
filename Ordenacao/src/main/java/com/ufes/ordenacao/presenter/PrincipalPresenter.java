package com.ufes.ordenacao.presenter;

import com.ufes.ordenacao.model.BubbleSort;
import com.ufes.ordenacao.model.LeitorDeArquivo;
import com.ufes.ordenacao.model.MetodoOrdenacao;
import com.ufes.ordenacao.model.MetodosOrdenacaoCollection;
import com.ufes.ordenacao.view.OrdenacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author eloy
 */
public class PrincipalPresenter {
    private OrdenacaoView ordenacaoView;
    private String path;
    private LeitorDeArquivo leitorDeArquivo;
    private List<Integer> numerosDesordenados;
    private List<Integer> numerosOrdenados;
    private DefaultListModel listModelDesordenados;
    private DefaultListModel listModelOrdenados;
    private MetodosOrdenacaoCollection metodosOrdenacao;
    private MetodoOrdenacao metodo;
    
    public PrincipalPresenter(){
        this.numerosDesordenados = new ArrayList<>();
        this.numerosOrdenados = new ArrayList<>();
        this.ordenacaoView = new OrdenacaoView();
        this.path = null;
        this.listModelDesordenados = new DefaultListModel();
        this.listModelOrdenados = new DefaultListModel();
        this.metodosOrdenacao = new MetodosOrdenacaoCollection();
        this.metodo = new BubbleSort();
        iniciarView();
        setCbmMetodo();
        this.ordenacaoView.setVisible(true);
        
    }
    
    private void setCbmMetodo(){
        
        for(MetodoOrdenacao m : this.metodosOrdenacao.getMetodos()){
            this.ordenacaoView.getCmbMetodo().addItem(m.getNome());//adicionar metodo com m.getNome()
        }
        
    } 
    
    private void iniciarView(){
        removeElementsJlist(this.listModelDesordenados, this.ordenacaoView.getLstSemOrdem());
        removeElementsJlist(this.listModelOrdenados, this.ordenacaoView.getLstOrdenados());
        this.ordenacaoView.getCmbMetodo().removeAllItems();
        this.ordenacaoView.getLstOrdenados().removeAll();
        this.ordenacaoView.getRbtnCrescente().setSelected(true);
        this.ordenacaoView.getBtnOrdenar().setEnabled(false);
        this.ordenacaoView.getBtnCarregarArquivo().addActionListener(e -> {
            selecionarArquivo();
            if (this.path != null){
                try {
                    this.numerosDesordenados = new ArrayList<>();
                    removeElementsJlist(this.listModelDesordenados, this.ordenacaoView.getLstSemOrdem());
                    this.leitorDeArquivo = new LeitorDeArquivo(this.path);
                    this.numerosDesordenados = this.leitorDeArquivo.getNumerosDesordenados();
                    setListModel(this.numerosDesordenados, this.listModelDesordenados);
                    this.ordenacaoView.getLstSemOrdem().setModel(this.listModelDesordenados);
                    this.ordenacaoView.getBtnOrdenar().setEnabled(true);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException("Erro: arquivo com formato inválido");
                }
            } 
        });
        
        this.ordenacaoView.getBtnOrdenar().addActionListener(e -> {
            this.numerosOrdenados = new ArrayList<>();
            removeElementsJlist(this.listModelOrdenados, this.ordenacaoView.getLstOrdenados());
            this.numerosOrdenados = ordenar(this.numerosDesordenados, this.metodo);
            setListModel(numerosOrdenados, this.listModelOrdenados);
            this.ordenacaoView.getLstOrdenados().setModel(this.listModelOrdenados);
            
        });
    }
    
    private void setMetodoOrdenacao(){
        //definir a variável método com o que foi selecionado no cmbMetodo
    }
    
    private void setTipoOrdenacao(){
        //definir se a ordenação vai ser crescene ou decresente 
        //a partir do radioButton
        //deixar crescente por padrão
    }
    
    private void selecionarArquivo(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showOpenDialog(this.ordenacaoView);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.path = chooser.getSelectedFile().getAbsolutePath();
         
        } else {
            // user changed their mind
        }

    }
    
    private void setListModel(List<Integer> numeros, DefaultListModel listModel){
        for(int i : numeros){
            listModel.addElement(i);
        }
    }
    
    private void removeElementsJlist(DefaultListModel listModel, JList jlist){
        int tamanho = listModel.getSize();
        if (tamanho > 0)
            for(int i = 0; i < tamanho; i++){
                System.out.println("index: " + i);
                jlist.remove(i);
            }
    }
    
    private List<Integer> ordenar(List<Integer> numerosDesordenados, MetodoOrdenacao metodo){
        return metodo.ordenarCrescente(numerosDesordenados);
    }
}
