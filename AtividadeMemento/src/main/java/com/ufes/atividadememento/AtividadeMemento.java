package com.ufes.atividadememento;

import com.ufes.atividadememento.business.Produto;

public class AtividadeMemento {

    public static void main(String[] args) {
        Zelador z = new Zelador();
        Produto p = new Produto("mouse", 10);
        System.out.println(p.toString());
        z.adicionarMemento(p.makeSnapshot());
        p.setNome("teclado");
        p.setValor(200);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.setNome("headset");
        p.setValor(300);
        z.adicionarMemento(p.makeSnapshot());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.restore(z.redo());
        System.out.println(p.toString());
        
    }
}
