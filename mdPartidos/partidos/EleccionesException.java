package org.uma.mbd.mdPartidos.partidos;

public class EleccionesException extends RuntimeException{
    public EleccionesException(){
        super();
    }
    public EleccionesException(String mensaje){
        super(mensaje);
    }
}
