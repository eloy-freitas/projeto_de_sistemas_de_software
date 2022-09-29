package com.ufes.ordenacao.presenter;

import com.ufes.ordenacao.model.LeitorDeArquivo;
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
    private DefaultListModel listModelDesordenados;
    
    public PrincipalPresenter(){
        this.ordenacaoView = new OrdenacaoView();
        this.path = null;
        this.listModelDesordenados = new DefaultListModel();
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
        this.ordenacaoView.getBtnOrdenar().setEnabled(false);
        this.ordenacaoView.getBtnCarregarArquivo().addActionListener(e -> {
            selecionarArquivo();
            if (this.path != null){
                try {
                    this.leitorDeArquivo = new LeitorDeArquivo(this.path);
                    this.numerosDesordenados = this.leitorDeArquivo.getNumerosDesordenados();
                    setListModel(this.numerosDesordenados);
                    this.ordenacaoView.getLstSemOrdem().setModel(this.listModelDesordenados);
                    this.ordenacaoView.getBtnOrdenar().setEnabled(true);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException("Erro: arquivo com formato inválido");
                }
            } 
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
    
    private void setListModel(List<Integer> numerosDesordenados){
        for(int n: numerosDesordenados){
            this.listModelDesordenados.addElement(n);
        }
    }
}
