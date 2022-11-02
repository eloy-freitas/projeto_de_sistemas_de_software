
package com.ufes.exerciciotransicaoestados.state;

import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;
import java.io.IOException;
import java.time.LocalDate;


public class FechadaState extends PortaState{

    public FechadaState(Porta porta) throws IOException {
        super(porta);
        this.porta.setFechado(true);
        this.porta.setAberto(false);
        
        try{
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Porta fechada", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
        
    }
    
    
    @Override
    public void trancar() throws IOException{
        try{
            porta.setEstado(new TrancadaState(porta));
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Trancando porta...", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }
    
    
    @Override
    public void abrir() throws IOException{
        try{
            porta.setEstado(new AbertaState(porta));
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Abrindo porta...", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
