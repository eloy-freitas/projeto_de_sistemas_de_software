
package com.ufes.exerciciotransicaoestados.state;

import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;
import java.io.IOException;
import java.time.LocalDate;


public class AbertaState extends PortaState{

    public AbertaState(Porta porta) throws IOException{
        super(porta);
        
        this.porta.setFechado(false);
        this.porta.setAberto(false);
        
        try{
            this.arquivoAdapter.gravar(
                    new RegistroLog(
                            "info", 
                            "Porta aberta", 
                            "system",
                            LocalDate.now().toString())
            );
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
        
    }
    
    
    @Override
    public void fechar() throws IOException, Exception{
        try{
            porta.setEstado(new FechadaState(porta));
            this.arquivoAdapter.gravar(new RegistroLog(
                            "info", 
                            "Fechando porta...", 
                            "system",
                            LocalDate.now().toString()));
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
