package com.ufes.atividadememento.business;


public class ProdutoMemento implements IProdutoMemento{

    private String nome;
    private double valor;

    public ProdutoMemento(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public double getValor() {
        return this.valor;
    }
    
}
