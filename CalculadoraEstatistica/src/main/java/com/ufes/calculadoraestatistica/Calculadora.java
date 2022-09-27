package com.ufes.calculadoraestatistica;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Calculadora {
	
	private List<MetodoEstatistico> metodosEstatisticos;
	
	public Calculadora() {
		this.metodosEstatisticos = new ArrayList<>();
		addMetodoEstatistico(new Media());
		addMetodoEstatistico(new Maior());
		addMetodoEstatistico(new Menor());
		addMetodoEstatistico(new DesvioPadrao());
		addMetodoEstatistico(new SomaAoQuadrado());
		addMetodoEstatistico(new Somatorio());
		addMetodoEstatistico(new Variancia());
	}

	public void calcular(ResultadoEstatisticaDescritiva resultado) {
		for(int i=0; i < metodosEstatisticos.size(); i++) {
			resultado.addResultado(metodosEstatisticos.get(i).calcular(resultado.getNumeros()));
		}
	}
	
	public void addMetodoEstatistico(MetodoEstatistico metodo) throws RuntimeException{
		// add metodos pela main ou através do construtor?
		if(metodo == null)
			throw new RuntimeErrorException(null, "ERR > O método informado não pode ser nulo.");
		metodosEstatisticos.add(metodo);
	}
		
}