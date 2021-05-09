package org.uma.mbd.mdLibreria.libreria;

public class Libro {
    private String autor, titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String au, String titulo, double precioBase){
        autor=au;
        this.titulo=titulo;
        this.precioBase=precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }
    public double getPrecioFinal(){
        return precioBase*(1+IVA/100);
    }

    @Override
    public String toString() {
        return "(" + autor + ";" + titulo + ";" +precioBase +";"+IVA+"%;"+getPrecioFinal()+")";
    }
}
