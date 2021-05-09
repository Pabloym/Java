package org.uma.mbd.mdLibreria.libreria;

import java.util.Arrays;
import java.util.ListResourceBundle;

public class Libreria {
    private Libro[] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria() {
        this(TAM_DEFECTO);
        /*
        libros=new Libro[TAM_DEFECTO];
        numLibros=0;
        Estas cosas hacen lo mismo y no serviria para ahorra codigo.
         */
    }

    public Libreria(int tam) {
        libros = new Libro[tam];
        numLibros = 0;
    }

    private void aseguraQueCabe() {
        if (numLibros == libros.length) {
            libros = Arrays.copyOf(libros, numLibros * 2);
        }
    }

    public int posicionLibro(String aut, String tit) {
        int pos = 0;
        while (!(libros[pos].getAutor().equals(aut) && libros[pos].getTitulo().equals(tit)) && pos < numLibros) {
            pos += 1;
        }
        return (pos < numLibros) ? pos : -1;
    }

    public void addLibro(String aut, String tit, double prec) {
        Libro libro = new Libro(aut, tit, prec);
        addLibro(libro);
    }

    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro.getAutor(), libro.getTitulo());
        if (pos >= 0) {
            // el libro esta en la posicion pos
            libros[pos] = libro;
        } else {
            aseguraQueCabe();
            libros[numLibros] = libro;
            numLibros += 1;
        }
    }

    public void remLibro(String aut, String tit) {
        int pos = posicionLibro(aut, tit);
        if (pos >= 0) {
            for (int i = pos; i < numLibros - 1; i++) {
                libros[i] = libros[i + 1];
            }
            libros[numLibros - 1] = null; //para quitar el ultimo libro del array, que ya lo hemos copiado en una posicion anterior
            numLibros -= 1;
        }
    }

    public double getPrecioBase(String aut, String tit) {
        int pos = posicionLibro(aut, tit);
        return (pos >= 0) ? libros[pos].getPrecioBase() : 0;
    }
    public double getPrecioFinal(String aut, String tit){
        int pos = posicionLibro(aut, tit);
        return (pos>=0)?libros[pos].getPrecioFinal():0;
    }
    @Override
    public String toString(){
        String salida ="[";
        for (int i =0; i<=numLibros;i++){
            salida+= libros[i];
            if (i<numLibros-1){
                salida+=",";
            }
        }
        salida+="]";
        return salida;
    }
}