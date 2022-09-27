package com.ufes.calculadoraestatistica;

public class Resultado {
	private String nome;
	private double valor;
	
	public Resultado(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
}
