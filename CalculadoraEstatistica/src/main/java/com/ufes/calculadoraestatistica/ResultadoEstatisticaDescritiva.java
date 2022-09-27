package com.ufes.calculadoraestatistica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class ResultadoEstatisticaDescritiva {
	private LocalDateTime data;
	private List<Double> numeros;
	private List<Resultado> resultados;
	
	public ResultadoEstatisticaDescritiva(List<Double> numeros) {
		this.data = LocalDateTime.now();
		this.numeros = numeros;
		this.resultados = new ArrayList<>();
	}
	
	public void addResultado(Resultado resultado) throws RuntimeException{
		if(resultado == null) {
			throw new RuntimeErrorException(null, "ERR > O resultado não pode ser nulo");
		}
		resultados.add(resultado);
	}

	public LocalDateTime getData() {
		return data;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public List<Double> getNumeros() {
		return numeros;
	}	
}