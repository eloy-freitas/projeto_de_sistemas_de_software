
package com.ufes.exerciciotransicaoestados.factory;

import com.ufes.exerciciotransicaoestados.adaptador.ILogAdapter;
import com.ufes.exerciciotransicaoestados.adaptador.LogCSVAdapter;


public class LogCSVAdapterFactory implements ILogAdapaterFactory{
    
    private String nomeArquivo;

    public LogCSVAdapterFactory() {
        this.nomeArquivo = "logPortaCSV.csv";
    }
    
    @Override
    public ILogAdapter getLogAdapter() {
        return new LogCSVAdapter(nomeArquivo);
    }
    
}
