
package com.ufes.exerciciotransicaoestados.adaptador;

import com.ufes.exerciciotransicaoestados.adaptado.CSVWriter;
import com.ufes.exerciciotransicaoestados.adaptado.ObjectWriter;
import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;
import java.io.IOException;


public class LogCSVAdapter implements ILogAdapter{
    
    private CSVWriter csvWriter;
    
    public LogCSVAdapter(String nomeArquivo) {
        if (!nomeArquivo.toLowerCase().endsWith("csv")) {
            throw new RuntimeException("Informe um arquivo CSV válido");
        }
        this.csvWriter = new CSVWriter(nomeArquivo);
    }

    
    @Override
    public void gravar(RegistroLog log) throws IOException {
        this.csvWriter.escrever(log);
    }
    
}
