package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema {

    /**
     * El fitness de un individuo es el número de unos que tiene el cromosoma.
     * @see Problema#evalua(Cromosoma)
     */
    public double evalua(Cromosoma cromosoma) {
        double contador0 =0;
        for (int j=0;j<cromosoma.longitud();j++){
            if (cromosoma.gen(j)==0){
                contador0+=1;
            }
        }
        return contador0;
    }
}
