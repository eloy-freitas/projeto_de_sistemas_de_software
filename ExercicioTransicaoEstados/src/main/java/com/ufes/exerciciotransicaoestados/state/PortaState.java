
package com.ufes.exerciciotransicaoestados.state;

import java.io.IOException;
import com.ufes.exerciciotransicaoestados.factory.ILogAdapaterFactory;
import com.ufes.exerciciotransicaoestados.factory.LogCSVAdapterFactory;
import com.ufes.exerciciotransicaoestados.factory.LogJSONAdapterFactory;
import com.ufes.exerciciotransicaoestados.adaptador.ILogAdapter;


public abstract class PortaState {
    protected Porta porta;
    private ILogAdapaterFactory logAdapterFactory;
    protected ILogAdapter arquivoAdapter;

    public PortaState(Porta porta) {
        this.porta = porta;
        this.logAdapterFactory = new LogCSVAdapterFactory();
        this.arquivoAdapter = this.logAdapterFactory.getLogAdapter();
    }
    
    void destrancar() throws Exception, IOException{
        throw new Exception("Estado inválido");
    }
    
    public void trancar() throws Exception, IOException{
        throw new Exception("Estado inválido");
    }
    
    public void fechar() throws Exception, IOException{
        throw new Exception("Estado inválido");
    }
    
    public void abrir() throws Exception, IOException{
        throw new Exception("Estado inválido");
    }
}
