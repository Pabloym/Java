package org.uma.mbd.mdJarras.jarra;

public class Jarra {
    public int capacidad, contenido;

    public Jarra(int cap) {
        capacidad = cap;
        contenido=0;
    }
    public void llena() {
        contenido = capacidad;
    }

    public void vacia() {
        contenido = 0;
    }

    public void llenarDesde(Jarra jar) {
        if (jar.contenido+contenido<=capacidad){
            contenido+=jar.contenido;
            jar.contenido=0;
        }
        else{
            jar.contenido-= (capacidad-contenido);
            contenido=capacidad;
        }
    }

    public String toString() {
        return "Jarra(" + capacidad + "," + contenido + ")";
    }
}
