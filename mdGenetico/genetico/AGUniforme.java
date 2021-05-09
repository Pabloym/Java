package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUniforme extends AlgoritmoGenetico {

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va a utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AGUniforme(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		boolean k;
		Cromosoma newCromosoma = new Cromosoma(cromosoma1.longitud(),Cromosoma.gna.nextBoolean());
		for (int i =0;i<cromosoma1.longitud();i++) {
			k= Cromosoma.gna.nextBoolean();
			if (k) {
				newCromosoma.gen(i, cromosoma1.gen(i));
			} else {
				newCromosoma.gen(i, cromosoma2.gen(i));
			}
		}
		return newCromosoma;
	}

}
