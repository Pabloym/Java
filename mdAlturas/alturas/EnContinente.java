package org.uma.mbd.mdAlturas.alturas;

public class EnContinente implements Seleccion{
    private String texto;
    public EnContinente(String txt){
        texto=txt;
    }

    @Override
    public boolean test(Pais pais){
        boolean resultado = pais.getContinente().contains(texto);
        return resultado;
    }
}
