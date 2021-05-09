package org.uma.mbd.mdTestL.Test;

import java.util.StringJoiner;

public class Test {
    protected int aciertos, errores;
    protected String alumno;

    public Test(String nombre, int bien, int mal){
        aciertos=bien;
        errores=mal;
        alumno=nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getErrores() {
        return errores;
    }

    public String getAlumno() {
        return alumno;
    }

    @Override
    public boolean equals(Object obj){
        boolean res = false;
        if (obj instanceof Test){
            Test t = (Test)obj;
            res= t.getAlumno().equalsIgnoreCase(this.getAlumno());
        }
        return res;
    }

    @Override
    public int hashCode(){
        return this.alumno.toLowerCase().hashCode();
    }

    @Override
    public String toString(){
        return alumno.toUpperCase()+" ["+aciertos+","+errores+"]";
    }

    public double calificacion(double valAci,double valErr){
        if (valAci<=0){
            throw new RuntimeException("El valor de los aciertos es negativo o 0: "+valAci);
        }
        if (valErr>0){
            throw new RuntimeException("El valor de los errores es positivo: "+valErr);
        }
        // O hacer un solo if con el ||
        return valAci*aciertos+valErr*errores;
    }


}
