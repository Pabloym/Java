package org.uma.mbd.mdAlturas.alturas;

public class MenoresQue implements Seleccion {
    private double altMax;
    public MenoresQue(double altura){
        altMax=altura;
    }

    @Override
    public boolean test(Pais pais){
        boolean resultado = pais.getAlturaMedia()<altMax;
        return resultado;
    }
}
