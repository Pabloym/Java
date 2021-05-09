package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    static public enum ColorBola {Blanca, Negra};
    private int bBlancas, bNegras;
    private static Random alea = new Random();

    public Urna(int b, int n){
        bBlancas=b;
        bNegras=n;
        if (bBlancas<0 || bNegras<0){
           throw new IllegalArgumentException("Numero de bolas negativo");
        }
    }
    public int totalBolas(){
        return bNegras+bBlancas;
    }
    public void ponerBlanca(){
        bBlancas+=1;
    }
    public void ponerNegras(){
        bNegras+=1;
    }
    public ColorBola extraerBola(){
        int n = this.totalBolas();
        if (n==0){
            throw new NoSuchElementException("No hay mas bolas");
        }
        else {
            ColorBola bolaSacada = null;
            int j = alea.nextInt(8)+1;
            if (j<=this.bBlancas){
                this.bBlancas-=1;
                bolaSacada = ColorBola.Blanca;
            }
            else{
                this.bNegras-=1;
                bolaSacada= ColorBola.Negra;
            }
            return bolaSacada;
        }


    }
    public String toString(){
        return "Urna(B:"+bBlancas+",N:"+bNegras+")";
    }
}
