package org.uma.mbd.mdPartidos.partidos;

public class Partido {
    private String nombre;
    private int numVotos;

    public Partido(String part,int n){
        nombre=part;
        numVotos=n;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return numVotos;
    }

    @Override
    public String toString(){
        return nombre+" : "+numVotos;
    }

    @Override
    public boolean equals(Object obj){
        boolean resultado = obj instanceof Partido;
        if (resultado){
            resultado = this.getNombre().equalsIgnoreCase(((Partido) obj).getNombre());
        }
        return resultado;
    }

    @Override
    public int hashCode(){
        return this.getNombre().toUpperCase().hashCode();
    }
}
