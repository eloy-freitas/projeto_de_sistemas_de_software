package com.ufes.teste;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eloy
 */
public class SeletorArquivo {
    private JFileChooser fileChooser;
    private File arquivo;
    private JFrame frame;
    
    public SeletorArquivo(JFrame frame){
        this.frame = frame;
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
    }
    
    public void abrirSeletor(){
        this.fileChooser.showOpenDialog(this.frame);
        Path path = this.fileChooser.getSelectedFile().toPath();
        if (Files.exists(path) && path != null){
            setArquivo(path.toFile());
        }
        System.out.println(path.getFileName());
    }
    
    public void setArquivo(File file){
        this.arquivo = file;
    }
    
    public File getArquivo(){
        return this.arquivo;
    }
}
