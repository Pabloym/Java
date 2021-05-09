package org.uma.mbd.mdMastermindL.mdMastermind;

public class MasterMindException extends RuntimeException {
    //Escribir un error que sea que el tamaño de la cifra obtenida sea menor que 0 o mayor que 10
    public MasterMindException(){
        super();
    }
    public MasterMindException(String mensaje){
        super(mensaje);
    }
}
