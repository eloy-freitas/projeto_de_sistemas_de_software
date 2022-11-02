
package com.ufes.exerciciotransicaoestados.factory;

import com.ufes.exerciciotransicaoestados.adaptador.ILogAdapter;
import com.ufes.exerciciotransicaoestados.adaptador.LogJSONAdapter;


public class LogJSONAdapterFactory implements ILogAdapaterFactory{
    
    private String nomeArquivo;

    public LogJSONAdapterFactory() {
        this.nomeArquivo = "logPortaJSON.json";
    }

    @Override
    public ILogAdapter getLogAdapter() {
        return new LogJSONAdapter(this.nomeArquivo);
    }
    
    
   
}
