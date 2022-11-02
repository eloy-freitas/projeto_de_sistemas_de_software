
package com.ufes.exerciciotransicaoestados.adaptador;

import com.ufes.exerciciotransicaoestados.adaptado.ObjectWriter;
import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;
import java.io.IOException;


public class LogJSONAdapter implements ILogAdapter{
    private ObjectWriter objectWriter;

    public LogJSONAdapter(String nomeArquivo) {
        if (!nomeArquivo.toLowerCase().endsWith("json")) {
            throw new RuntimeException("Informe um arquivo JSON válido");
        }
        this.objectWriter = new ObjectWriter(nomeArquivo);
    }
    
    @Override
    public void gravar(RegistroLog log) throws IOException {
        this.objectWriter.escrever(log);
    }

    
    
    
    
}
