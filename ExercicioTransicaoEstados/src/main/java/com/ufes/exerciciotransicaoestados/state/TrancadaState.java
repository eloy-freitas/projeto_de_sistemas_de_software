
package com.ufes.exerciciotransicaoestados.state;

import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;
import java.io.IOException;
import java.time.LocalDate;


public class TrancadaState extends PortaState{
    
    public TrancadaState(Porta porta) throws IOException {
        super(porta);
        this.porta.setFechado(true);
        this.porta.setAberto(false);
        
        try{
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Porta trancada", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
        
    }
    
    @Override
    public void destrancar() throws IOException{
        try{
            porta.setEstado(new FechadaState(porta));
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Destrancando porta...", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
