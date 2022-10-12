package com.ufes.ordenacao.presenter;

import com.ufes.ordenacao.business.leitor_arquivo.LeitorArquivoService;
import com.ufes.ordenacao.business.metodos_ordenacao.BubbleSortStrategy;
import com.ufes.ordenacao.business.leitor_arquivo.LeitorDeArquivo;
import com.ufes.ordenacao.business.metodos_ordenacao.MetodoOrdenacaoStrategy;
import com.ufes.ordenacao.service.MetodosOrdenacaoService;
import com.ufes.ordenacao.model.Resultado;
import com.ufes.ordenacao.view.OrdenacaoView;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private LeitorArquivoService leitorArquivoService;
    private List<Double> numerosSemOrdem;
    private List<Double> numerosOrdenados;
    private DefaultListModel listModelSemOrdem;
    private DefaultListModel listModelOrdenados;
    private MetodosOrdenacaoService metodosOrdenacao;
    private MetodoOrdenacaoStrategy metodo;
    private Resultado resultado;
    
    public PrincipalPresenter(){
        iniciarView();      
        setCbmMetodo();
        setBtnCarregarArquivo();
        setBtnOrdenar();
         this.leitorArquivoService = new LeitorArquivoService();
        this.ordenacaoView.setVisible(true);
    }
    
    private void setCbmMetodo(){
        for(MetodoOrdenacaoStrategy m : this.metodosOrdenacao.getMetodos()){
            this.ordenacaoView.getCmbMetodo().addItem(m.getNome());
        } 
    } 
    
    private String getMetodoOrdenacao(){
        return this.ordenacaoView.getCmbMetodo().getSelectedItem().toString();
    }
    
    private void setBtnCarregarArquivo(){
        this.ordenacaoView.getBtnCarregarArquivo().addActionListener(e -> {
            selecionarArquivo();
            if (this.path != null){
                try {
                    this.numerosSemOrdem = new ArrayList<>();
                    
                    removeElementsList(
                        this.ordenacaoView.getLstSemOrdem()
                    );
                    
                    this.numerosSemOrdem = this.leitorArquivoService.processarArquivo(this.path);
                    
                    setListModel(
                        this.numerosSemOrdem, 
                        this.ordenacaoView.getLstSemOrdem()
                    );
                    
                    this.ordenacaoView.getBtnOrdenar().setEnabled(true);
                    
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(
                            "Erro: arquivo com formato inválido"
                    );
                } catch (Exception ex) {
                    Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
    }
    
    private void setBtnOrdenar(){
        this.ordenacaoView.getBtnOrdenar().addActionListener(e -> {
            System.out.println(getMetodoOrdenacao());
            
            this.numerosOrdenados = new ArrayList<>();
            
            removeElementsList(
                this.ordenacaoView.getLstOrdenados()
            );
            
            this.ordenacaoView.getLblTempo().setText("0");
            
            this.resultado = ordenar();
            
            this.numerosOrdenados = this.resultado.getNumeros();
            
            this.ordenacaoView.
                getLblTempo().
                    setText(this.resultado.getTempo());
            
            
            setListModel(
                this.numerosOrdenados, 
                this.ordenacaoView.getLstOrdenados()
            );
            
        });
    }
    
    private void iniciarView(){
        this.numerosSemOrdem = new ArrayList<>();
        this.numerosOrdenados = new ArrayList<>();
        this.ordenacaoView = new OrdenacaoView();
        this.path = null;
        this.listModelSemOrdem = new DefaultListModel();
        this.listModelOrdenados = new DefaultListModel();
        this.metodosOrdenacao = new MetodosOrdenacaoService();
        this.metodo = new BubbleSortStrategy();
        removeElementsList(this.ordenacaoView.getLstSemOrdem());
        //removeElementsList(this.ordenacaoView.getLstOrdenados());
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
    
    private void setListModel(List<Double> numeros, java.awt.List list){
        for(double i : numeros){
            list.add(String.valueOf(i));
        }
    }
    
    private void removeElementsList(java.awt.List list){
        list.removeAll();
    }
    
    private Resultado ordenar(){
        String metodo = getMetodoOrdenacao();
        Boolean ordem = true;
        if (this.ordenacaoView.getRbtnCrescente().isSelected())
            ordem = true;
        else
            ordem = false;
        
        return metodosOrdenacao.ordenar(
            metodo, 
            this.numerosSemOrdem, 
            ordem
        );
  
    }
    
}
