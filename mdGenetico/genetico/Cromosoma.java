package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {

	protected int[] datos;
	protected static Random gna = new Random();
	protected static int GEN_POR_DEFECTO = 0;


	public Cromosoma(int longitud, boolean aleatorio) {
		if (longitud<0){
			throw new RuntimeException("Longitud negativa");
		}
		else {
			datos = new int[longitud];
			if (aleatorio) {
				double alt = 0;
				for (int i = 0; i < longitud; i++) {
					alt=gna.nextDouble();
					if (alt<=0.5) {
						datos[i] = 0;
					}
					else{
						datos[i]=1;
					}
				}
			}
			else{
				for (int i=0;i<longitud;i++){
					datos[i]=GEN_POR_DEFECTO;
				}
			}
		}
	}


	public int gen(int i) {
		int g =0;
		if (i<0 || i>=this.longitud()){
			throw new RuntimeException("El indice esta fuera del rango de valores validos");
		}
		else{
			g = this.datos[i];
		}
		return g;
	}

	public void gen(int i, int val) {
		if (i<0 || i>=this.longitud()){
			throw new RuntimeException("El indice esta fuera del rango de valores validos");
		}
		else{
			this.datos[i]=val;
		}
	}

	public void mutar(double probMutacion) {
		if (probMutacion<0 || probMutacion>1){
			throw new RuntimeException("La probabilidad de mutación no es un valor valido");
		}
		else{
			double alt = 0;
			for (int j=0; j<longitud();j++){
				alt = gna.nextDouble();
				if (alt<=probMutacion){
					if (gen(j)==0){
						this.gen(j,1);
					}
					else{
						this.gen(j,0);
					}
					//(gen(j)==0)?this.gen(j,1):this.gen(j,0);
				}
			}
		}
	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int longitud() {
		return datos.length;
	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia() {
		boolean alt = gna.nextBoolean();
		Cromosoma newCromosoma = new Cromosoma(this.longitud(),alt);
		newCromosoma.datos = Arrays.copyOf(this.datos,this.longitud());
		return newCromosoma;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < datos.length - 1; i++) {
			s.append(datos[i]).append(", ");
		}
		return "Cromosoma(" + s + datos[datos.length - 1] + ")";
	}
}
