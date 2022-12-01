package com.ufes.atividadememento.business;


public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    public void restore(IProdutoMemento estado){
        this.nome = estado.getNome();
        this.valor = estado.getValor();
    }
    
    public IProdutoMemento makeSnapshot(){
        IProdutoMemento estado = new ProdutoMemento(this.nome, this.valor);
        return estado;
    } 
    
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", valor=" + valor + '}';
    }
    
    
    
}
