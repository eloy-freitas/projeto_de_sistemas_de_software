package com.ufes.ordenacao.presenter;

import com.ufes.ordenacao.model.BubbleSort;
import com.ufes.ordenacao.model.LeitorDeArquivo;
import com.ufes.ordenacao.model.MetodoOrdenacao;
import com.ufes.ordenacao.model.MetodosOrdenacaoCollection;
import com.ufes.ordenacao.model.Resultado;
import com.ufes.ordenacao.view.OrdenacaoView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;

/**
 *
 * @author eloy
 */
public class PrincipalPresenter {
    private OrdenacaoView ordenacaoView;
    private String path;
    private LeitorDeArquivo leitorDeArquivo;
    private List<Integer> numerosSemOrdem;
    private List<Integer> numerosOrdenados;
    private DefaultListModel listModelSemOrdem;
    private DefaultListModel listModelOrdenados;
    private MetodosOrdenacaoCollection metodosOrdenacao;
    private MetodoOrdenacao metodo;
    private Resultado resultado;
    
    public PrincipalPresenter(){
        iniciarView();
        setCbmMetodo();
        setBtnCarregarArquivo();
        setBtnOrdenar();
        this.ordenacaoView.setVisible(true);
        
    }
    
    private void setCbmMetodo(){
        for(MetodoOrdenacao m : this.metodosOrdenacao.getMetodos()){
            this.ordenacaoView.getCmbMetodo().addItem(m.getNome());
        } 
    } 
    
    private void setBtnCarregarArquivo(){
        this.ordenacaoView.getBtnCarregarArquivo().addActionListener(e -> {
            selecionarArquivo();
            if (this.path != null){
                try {
                    this.numerosSemOrdem = new ArrayList<>();
                    
                    removeElementsJlist(
                        this.ordenacaoView.getLstSemOrdem()
                    );
                    
                    this.leitorDeArquivo = new LeitorDeArquivo(this.path);
                    
                    this.numerosSemOrdem = this.leitorDeArquivo.getNumerosSemOrdem();
                    
                    setListModel(
                        this.numerosSemOrdem, 
                        this.listModelSemOrdem
                    );
                    
                    this.ordenacaoView.
                        getLstSemOrdem().
                        setModel(this.listModelSemOrdem);
                    
                    this.ordenacaoView.getBtnOrdenar().setEnabled(true);
                    
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(
                            "Erro: arquivo com formato inválido"
                    );
                }
            } 
        });
    }
    
    private void setBtnOrdenar(){
        this.ordenacaoView.getBtnOrdenar().addActionListener(e -> {
            this.numerosOrdenados = new ArrayList<>();
            
            removeElementsJlist(
                this.ordenacaoView.getLstOrdenados()
            );
            
            this.ordenacaoView.getLblTempo().setText("0");
            
            this.resultado = ordenar(
                this.numerosSemOrdem,
                this.metodo
            );
            
            this.numerosOrdenados = this.resultado.getNumeros();
            
            this.ordenacaoView.
                    getLblTempo().
                    setText(this.resultado.getTempo());
            
            
            setListModel(
                this.numerosOrdenados, 
                this.listModelOrdenados
            );
            
            this.ordenacaoView.
                getLstOrdenados().
                setModel(this.listModelOrdenados);
        });
    }
    
    private void iniciarView(){
        this.numerosSemOrdem = new ArrayList<>();
        this.numerosOrdenados = new ArrayList<>();
        this.ordenacaoView = new OrdenacaoView();
        this.path = null;
        this.listModelSemOrdem = new DefaultListModel();
        this.listModelOrdenados = new DefaultListModel();
        this.metodosOrdenacao = new MetodosOrdenacaoCollection();
        this.metodo = new BubbleSort();
        removeElementsJlist(this.ordenacaoView.getLstSemOrdem());
        removeElementsJlist(this.ordenacaoView.getLstOrdenados());
        this.ordenacaoView.getCmbMetodo().removeAllItems();
        this.ordenacaoView.getLstOrdenados().removeAll();
        this.ordenacaoView.getRbtnCrescente().setSelected(true);
        this.ordenacaoView.getBtnOrdenar().setEnabled(false);
    }
    
    private void selecionarArquivo(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = chooser.showOpenDialog(this.ordenacaoView);
        if (result == JFileChooser.APPROVE_OPTION)
            this.path = chooser.getSelectedFile().getAbsolutePath();
    }
    
    private void setListModel(List<Integer> numeros, DefaultListModel listModel){
        int size = listModel.getSize();
        if(size > 0){
            listModel.removeAllElements();
        }
        for(int i : numeros){
            listModel.addElement(i);
        }
    }
    
    private void removeElementsJlist(JList jlist){
        jlist.removeAll();
    }
    
    private Resultado ordenar(List<Integer> numerosSemOrdem, MetodoOrdenacao metodo){
        if (this.ordenacaoView.getRbtnCrescente().isSelected())
            return metodo.ordenarCrescente(numerosSemOrdem);
        else
            return metodo.ordenarDecrescente(numerosSemOrdem);
    }
}
