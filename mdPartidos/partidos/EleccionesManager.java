package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;

public class EleccionesManager {
    private String [] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones){
        this.elecciones=elecciones;
    }

    public EleccionesManager setDatos(String[] datos) {
        this.datos = datos;
        return this;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
    }

    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }

    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }

    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    private void verify(){
        boolean v1 = (this.fEntrada!=null) || (this.datos!=null);
        boolean v2 = cs!=null;
        boolean v3 = numEsc>0;
        boolean v4 = (this.fSalida!=null) || (this.consola);
        if (!(v1 && v2 && v3 && v4)){
            throw new EleccionesException("Alguna de las condiciones fallan en verify");
        }
    }

    public void build() throws IOException {
        verify();
        if (datos==null) {
            elecciones.leeDatos(fEntrada);
        }
        else{
            elecciones.leeDatos(datos);
        }
        Map<Partido,Integer> map = elecciones.generaResultados(cs,numEsc);
        if (fSalida!=null) {
            elecciones.presentaResultados(fSalida, map);
        }
        if(consola){
            for (Map.Entry<Partido,Integer> par : map.entrySet()){
                int esc = par.getValue();
                String salida = "";
                if (esc==0){
                    salida="sin representación";
                    System.out.println(par.getKey()+", "+salida);
                }
                else {
                    System.out.println(par.getKey() + ", " + esc);
                }
            }
        }
    }
}
