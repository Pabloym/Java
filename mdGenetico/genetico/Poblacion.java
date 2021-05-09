package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if (tamaño<0 || longitud<0){
			throw new RuntimeException("El tamaño de la población o la longitud de los cromosomas no es un valor válido.");
		}
		else{
			individuos = new Individuo[tamaño];
			for (int k=0;k<tamaño;k++){
				individuos[k]= new Individuo(longitud,problema);
			}
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int numIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		Individuo persona = individuos[0];
		double fit = persona.fitness();
		double newFit =0;
		for (int i=1; i<numIndividuos();i++){
			newFit =individuos[i].fitness();
			if (newFit>fit){
				fit = newFit;
				persona=individuos[i];
			}
		}
		return persona;
	}

	// Devuelve la posicion del peor individuo
	public int peorIndividuo() {
		Individuo persona = individuos[0];
		double fit = persona.fitness();
		double newFit =0;
		int pos=0;
		for (int i=1; i<this.individuos.length;i++){
			newFit =individuos[i].fitness();
			if (newFit<fit){
				fit = newFit;
				pos=i;
			}
		}
		return pos;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo individuo(int i) {
		if (i<0 || i>=individuos.length){
			throw new RuntimeException("El indice i esta fuera del rango de valores");
		}
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		int pos =peorIndividuo();
		if (ind.fitness()>individuo(pos).fitness()){
			individuos[pos]=ind;
		}
	}

}
