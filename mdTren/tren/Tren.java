package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.Arrays;

public class Tren {
    private int numVagones;
    private ArrayList<Vagon> vagones;
    private final int capacidadComun;

    public Tren(int n, int cap){
        numVagones=n;
        capacidadComun=cap;
        vagones=new ArrayList<Vagon>();
        for(int i =0;i<numVagones;i++){
            vagones.add(new Vagon(capacidadComun));
        }
    }
    public void optimiza(){
        ArrayList cargas = new ArrayList();
        for (int i=0;i<numVagones;i++){
            int cargai=vagones.get(i).getCarga(); // Carga del vagon i-esimo
            if (cargai!=0){
                cargas.add(cargai);
            }
        }
        numVagones=cargas.size(); // Actualizo el numVagones con el contador de vagones con carga>0
        Tren newTren = new Tren(numVagones,capacidadComun);
        for (int j=0;j<numVagones;j++){
            int c = (int) cargas.get(j);
            newTren.vagones.get(j).carga(c);
        }
        vagones = newTren.vagones;
    }

    public void carga(int ton){
        int j =0;
        while(ton>0){
            if (j==numVagones){
                numVagones+=1;
                vagones.add(new Vagon(capacidadComun));
            }
            ton = vagones.get(j).carga(ton);
            j+=1;
        }
    }

    public void gasta(int ton){
        int j =0;
        while(ton>0){
            if (j==numVagones){
                throw new IllegalArgumentException("El tren se ha quedado sin combustible");
            }
            ton = vagones.get(j).descarga(ton);
            j+=1;
        }
    }

    @Override
    public String toString(){
        String salida = "Tren[";
        for (int i=0;i<numVagones;i++){
            salida+=vagones.get(i);
            if (i<numVagones-1) {
                salida += ", ";
            }
        }
        salida+="]";
        return salida;
    }



}
