
package com.ufes.exerciciotransicaoestados.adaptador;

import java.io.IOException;
import com.ufes.exerciciotransicaoestados.adaptado.RegistroLog;

public interface ILogAdapter {
    void gravar(RegistroLog log) throws IOException;
}
