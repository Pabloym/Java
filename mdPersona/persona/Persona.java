package org.uma.mbd.mdPersona.persona;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String name, int año){
        nombre=name;
        edad=año;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = false;
        if ((obj instanceof Persona)){
            Persona p = (Persona)obj;
            res=edad==p.edad && nombre.equalsIgnoreCase(p.nombre);
        }
        return res;
    }

    public int hashCode() {
        return Integer.hashCode(edad)+nombre.toUpperCase().hashCode();
    }

    @Override
    public String toString(){
        return "Persona("+nombre+", "+edad+")";
    }

    @Override
    public int compareTo(Persona p){
        int res = Integer.compare(edad,p.edad);
        if (res==0){
            res = nombre.compareTo(p.nombre);
        }
        return res;
    }
}
