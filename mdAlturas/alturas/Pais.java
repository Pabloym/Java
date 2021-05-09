package org.uma.mbd.mdAlturas.alturas;

public class Pais implements Comparable<Pais>{
    private String nombre, continente;
    private double altMedia;

    public Pais(String pais, String cont, double alturas){
        nombre=pais;
        continente=cont;
        altMedia=alturas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public double getAlturaMedia() {
        return altMedia;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = obj instanceof Pais;
        if (res){
            res = this.nombre.equalsIgnoreCase(((Pais) obj).nombre);
        }
        return res;
    }

    @Override
    public int hashCode(){
        return this.nombre.hashCode();
    }

    @Override
    public String toString(){
        return "Pais("+nombre+","+continente+","+altMedia+")";
    }

    @Override
    public int compareTo(Pais p) {
        int resultado = Double.compare(this.altMedia,p.altMedia);
        if (resultado==0){
            resultado = this.nombre.compareTo(p.nombre);
        }
        return resultado;
    }
}
