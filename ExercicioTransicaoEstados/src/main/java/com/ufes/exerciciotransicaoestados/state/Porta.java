/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.exerciciotransicaoestados.state;

import com.ufes.exerciciotransicaoestados.factory.ILogAdapaterFactory;
import java.io.IOException;

/**
 *
 * @author eloy
 */
public class Porta {
    private boolean aberto;
    private boolean fechado;
    private PortaState estado;

    public Porta() throws IOException, Exception {
        this.aberto = false;
        this.fechado = true;
        this.estado = new TrancadaState(this);
    }
    
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
    
    public boolean isAberto() {
        return aberto;
    }

    public boolean isFechado() {
        return fechado;
    }

    public void setEstado(PortaState estado) {
        this.estado = estado;
    }
    
    public void destrancar() throws Exception, IOException{
        this.estado.destrancar();
    }
    
    public void trancar() throws Exception, IOException{
        this.estado.trancar();
    }
    
    public void fechar() throws Exception, IOException{
        this.estado.fechar();
    }
    
    public void abrir() throws Exception, IOException{
        this.estado.abrir();
    }
    
    
}
