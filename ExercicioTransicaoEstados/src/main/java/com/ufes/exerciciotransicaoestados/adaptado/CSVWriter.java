
package com.ufes.exerciciotransicaoestados.adaptado;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CSVWriter {

    File file;

    public CSVWriter(String fileName) {
        file = new File(fileName);
    }

    public void escrever(RegistroLog log) throws IOException {
        FileWriter outputFile = new FileWriter(file, true);
        com.opencsv.CSVWriter csvWriter = new com.opencsv.CSVWriter(outputFile);

        String[] logData = {
                log.getTipo(),
                log.getInformacao(),
                log.getUsuario(),
                log.getDataHora()
        };

        csvWriter.writeNext(logData);
        csvWriter.close();

    }

}