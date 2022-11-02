

package com.ufes.exerciciotransicaoestados;


import com.ufes.exerciciotransicaoestados.factory.LogJSONAdapterFactory;
import com.ufes.exerciciotransicaoestados.state.Porta;
import com.ufes.exerciciotransicaoestados.state.PortaState;
import com.ufes.exerciciotransicaoestados.state.TrancadaState;
import java.io.IOException;


public class ExercicioTransicaoEstados {

    public static void main(String[] args) throws IOException, Exception {
        try{
           
           Porta p = new Porta();
           p.destrancar();
           p.abrir();
           p.fechar();
           p.abrir();
           p.fechar();
           p.trancar();
       
        }catch(IOException e){
            throw new IOException(e.getMessage());
        }
        
    }
}
