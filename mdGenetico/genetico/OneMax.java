package org.uma.mbd.mdGenetico.genetico;

public class OneMax implements Problema {

	/**
	 * El fitness de un individuo es el número de unos que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */
	public double evalua(Cromosoma cromosoma) {
		double contador1 =0;
		for (int j=0;j<cromosoma.longitud();j++){
			if (cromosoma.gen(j)==1){
				contador1+=1;
			}
		}
		return contador1;
	}
}
