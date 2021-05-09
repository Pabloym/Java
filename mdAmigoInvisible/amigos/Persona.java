package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Collection;
import java.util.Iterator;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private String amigo = null;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void setAmigo(String amigo) {
        this.amigo = amigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean mismoTipo = obj instanceof Persona;
        if (mismoTipo) {
            mismoTipo = this.getNombre().equalsIgnoreCase(((Persona) obj).getNombre());
        }
        return mismoTipo;
    }

    @Override
    public int hashCode() {
        return this.nombre.toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        String salida = this.getNombre() + " --> ";
        if (this.getAmigo() == null) {
            salida += "sin amigo";
        } else {
            salida += this.getAmigo();
        }
        return salida;
    }

    @Override
    public int compareTo(Persona p) {
        String p1 = this.getNombre();
        String p2 = p.getNombre();
        return p1.compareTo(p2);
    }
}/*
        int resultado = 0;
        int pos = 0;
        int longt = Math.min(p1.length(), p2.length());
        boolean listo = pos < longt;
        while (listo) {
            if (p1.substring(pos, pos + 1).hashCode() == p2.substring(pos, pos + 1).hashCode()) {
                if (pos < longt) {
                    pos += 1;
                } else {
                    listo = false;
                }
            } else {
                listo = false;
            }
        }
        if (p1.substring(pos, pos + 1).hashCode() < p2.substring(pos, pos + 1).hashCode()) {
            resultado = 1;
        } else if (p1.substring(pos, pos + 1).hashCode() > p2.substring(pos, pos + 1).hashCode()) {
            resultado = -1;
        }
        return resultado;
    }
    */

