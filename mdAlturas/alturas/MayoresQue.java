package org.uma.mbd.mdAlturas.alturas;

public class MayoresQue implements Seleccion{
    private double altMin;
    public MayoresQue(double altura){
        altMin=altura;
    }

    @Override
    public boolean test(Pais pais){
        boolean resultado = pais.getAlturaMedia()>altMin;
        return resultado;
    }
}
