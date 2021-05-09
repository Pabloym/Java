package org.uma.mbd.mdPuntos.puntos;
import org.uma.mbd.mdPuntos.puntos.Punto;

public class Segmentos {
    private Punto origen, extremo;
    public Segmentos(Punto or,Punto ext){
        origen=or;
        extremo=ext;
    }
    public void trasladar(double a, double b){
        origen.trasladar(a,b);
        extremo.trasladar(a,b);
    }
    public double longitud(){
        return origen.distancia(extremo);
    }
    public String toString(){
        return "S("+origen+","+extremo+")";
    }
}
