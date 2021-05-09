package org.uma.mbd.mdUrna;
import org.uma.mbd.mdUrna.urna.Urna;

public class Main {
    public static void main(String[] args) {
        int nBB=Integer.parseInt(args[0]);
        int nBN = Integer.parseInt(args[1]);
        Urna u = new Urna(nBB,nBN);
        while(u.totalBolas()>1){
            Urna.ColorBola a = u.extraerBola();
            Urna.ColorBola b = u.extraerBola();
            if (a==b){
                u.ponerBlanca();
            }
            else{
                u.ponerNegras();
            }
        }
        Urna.ColorBola ult = u.extraerBola();
        System.out.println("La ultima bola era de color "+ult);
    }
}
