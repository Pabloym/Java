package org.uma.mbd.mdPartidos.partidos;
import java.util.*;
import java.io.*;

public class Elecciones {
    private List<Partido> partidos = new LinkedList<>();

    static private Partido stringToPartido(String dato){
        Partido partido = null;
        try(Scanner part = new Scanner(dato)){
            part.useDelimiter("[,]+");
            String nomb = part.next();
            int n = part.nextInt();
            partido = new Partido(nomb,n);
        }
        catch (EleccionesException e){
            System.err.println(dato+" Error en los tipos de los datos.");
        }
        return partido;
    }
    public void leeDatos(String [] datos){
        for (String st : datos){
            Partido partido = stringToPartido(st);
            if (partido!=null) {
                partidos.add(partido);
            }
        }
    }
    public void leeDatos(String nombreFichero) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(nombreFichero))){
            while(sc.hasNextLine()){
                partidos.add(stringToPartido(sc.nextLine()));
            }
        }
    }

    public Map<Partido,Integer> generaResultados(CriterioSeleccion cs, int numEsc){
        Map<Partido,Integer> map = cs.ejecuta(partidos,numEsc);
        return map;
    }



    public void presentaResultados(String nombreFichero, Map<Partido,Integer> map) throws FileNotFoundException{
        try(PrintWriter pw = new PrintWriter(nombreFichero)){
            for (Map.Entry<Partido,Integer> par : map.entrySet()){
                int esc = par.getValue();
                String salida = "";
                if (esc==0){
                    salida="sin representación";
                    pw.println(par.getKey()+", "+salida);
                }
                else {
                    pw.println(par.getKey() + ", " + esc);
                }
            }
        }
    }
}
