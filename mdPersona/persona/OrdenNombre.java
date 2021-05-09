package org.uma.mbd.mdPersona.persona;

import java.util.Comparator;

public class OrdenNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona p1,Persona p2){
        return p1.getNombre().compareToIgnoreCase(p2.getNombre());
    }
}
