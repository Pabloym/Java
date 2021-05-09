package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.Objects;

public class Movimiento {
    protected String cifras;
    protected int colocadas;
    protected int descolocadas;

    public Movimiento(String intento, int bienColocadas,int descolocadas){
        cifras = intento;
        colocadas=bienColocadas;
        this.descolocadas=descolocadas;
    }

    public int getColocadas(){
        return colocadas;
    }

    protected int getDescolocadas(){
        return descolocadas;
    }

    protected String getCifras(){
        return cifras;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        int num1= Integer.parseInt(cifras);
        int num2=Integer.parseInt(that.cifras);
        return num1==num2;
    }

    @Override
    public int hashCode() {
        return cifras.hashCode();
    }

    @Override
    public String toString() {
        return "["+cifras+", "+colocadas+", "+descolocadas+"]";
    }

}
