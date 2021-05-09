package org.uma.mbd.mdAlturas;

import org.uma.mbd.mdAlturas.alturas.EnContinente;
import org.uma.mbd.mdAlturas.alturas.MenoresQue;
import org.uma.mbd.mdAlturas.alturas.Pais;
import org.uma.mbd.mdAlturas.alturas.Mundo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.FileNotFoundException;

public class MainMundo {
    public static void main(String args[]) throws FileNotFoundException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        /*for (Pais pais : paises.selecciona(new MenoresQue(1.70))) {
            System.out.println(pais);
        }
        System.out.println();
        for (Pais pais : paises.selecciona(new EnContinente("Europe"))) {
            System.out.println(pais);
        }
        paises.asociaPaisesAContinentes("recursos/mdAlturas/alturas.txt");

         */
        /*
        for (String cont : paises.getContinentes()){
            System.out.println(cont);
        }
        boolean res = paises.todosMayores(1.5);
        System.out.println(res);

        Pais pBajo = paises.masBajoDelContinente("Europe");
        System.out.println(pBajo);

        Pais pAlto =  paises.paisDeMayorAltura();
        System.out.println(pAlto);

        Set<Pais> set = paises.conjOrdPaisesDelContinente("Europe");
        System.out.println(set);

        for (Map.Entry<String, List<Pais>> par : paises.paisesPorContinente().entrySet()){
            System.out.println(par.getKey());
            for (Pais p : par.getValue()){
                System.out.println("\t"+p);
            }
        }

         */
        Map<String,Set<Double>> map =paises.alturasPorContinente();
        for (String cont : map.keySet()){
            System.out.println(cont+" "+map.get(cont));
        }
    }
}
