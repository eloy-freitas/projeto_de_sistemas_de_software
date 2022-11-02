
package com.ufes.exerciciotransicaoestados.adaptado;


public class RegistroLog {
    private String tipo;
    private String informacao;
    private String usuario;
    private String dataHora;

    public RegistroLog(String tipo, String informacao, String usuario, String dataHora) {
        this.tipo = tipo;
        this.informacao = informacao;
        this.usuario = usuario;
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getInformacao() {
        return informacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDataHora() {
        return dataHora;
    }
    
    
}
