package com.ufes.atividadememento;

import com.ufes.atividadememento.business.IProdutoMemento;
import java.util.LinkedList;
import java.util.List;


public class Zelador {
    
    private LinkedList<IProdutoMemento> historico;
    private int index;

    public Zelador() {
        this.historico = new LinkedList<>();
        this.index = this.historico.size();
    }
    
    public void adicionarMemento(IProdutoMemento produtoMemento){
        int size = this.historico.size() - 1;
        while(index < this.historico.size() - 1){
            this.historico.pollLast();
        }
        this.historico.add(produtoMemento);
        this.index = this.historico.size() - 1;
    }
    
    public IProdutoMemento undo(){
        if(this.historico.size() <= 0)
            throw new RuntimeException("Sem histórico de mementos");
        if(this.index > 0)
            this.index -= 1;
        IProdutoMemento memento = this.historico.get(this.index);
        
        
        return memento; 
    }
    
    public IProdutoMemento redo(){
        if(this.historico.size() <= 0)
            throw new RuntimeException("Sem histórico de mementos");
        if(this.index < this.historico.size() - 1)
            this.index += 1;
        IProdutoMemento memento = this.historico.get(this.index);
        
        return memento;
    }
    
}
