package com.ufes.atividadememento;

import com.ufes.atividadememento.business.Produto;

public class AtividadeMemento {

    public static void main(String[] args) {
        Zelador z = Zelador.getInstace();
        Produto p = new Produto("mouse", 10);
        System.out.println(p.toString());
        z.adicionarMemento(p.makeSnapshot());
        p.setValor(1);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.setValor(2);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.setValor(3);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.setValor(4);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.setValor(5);
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.setValor(6);
        System.out.println(p.toString());
        z.adicionarMemento(p.makeSnapshot());
        System.out.println(p.toString());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.restore(z.undo());
        System.out.println(p.toString());
        p.restore(z.redo());
        System.out.println(p.toString());
        
        
    }
}
