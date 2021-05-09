package org.uma.mbd.mdTren.tren;

public class Vagon {
    public int capacidad;
    private int carga;

    public Vagon(){
        this(0);
    }

    public Vagon(int capacidad){
        this.capacidad=capacidad;
        carga=0;
    }

    public int carga(int ton){
        int capActual = capacidad-carga;
        if (capActual<ton){
            carga=capacidad;
        }
        else{
            carga+=ton;
        }
        int carbon =ton-capActual;
        return (capActual<ton)?carbon:0;
    }

    public int descarga(int ton){
        int carbon = ton-carga;
        if (carbon>0){
            carga=0;
        }
        else{
            carga-=ton;
        }
        return (carbon>0)?carbon:0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getCarga() {
        return carga;
    }
    @Override
    public String toString(){
        return "V("+carga+"/"+capacidad+")";
    }

}
