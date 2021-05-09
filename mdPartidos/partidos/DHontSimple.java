package org.uma.mbd.mdPartidos.partidos;
import java.util.*;


public class DHontSimple implements CriterioSeleccion {

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc){
        Map<Partido, Integer> map = new TreeMap<>(Comparator.comparing(Partido::getVotos).reversed());
        List<Token> tkns = new LinkedList<Token>();
        for (Partido p : partidos){
            for (int k = 1; k<=numEsc; k++){
                Token tk = new Token(p,p.getVotos()/k);
                tkns.add(tk);
            }
        }
        tkns.sort(Comparator.naturalOrder());
        ArrayList<Token> lista = new ArrayList<Token>();
        for (int i = 0; i<numEsc;i++){
            lista.add(tkns.get(i));
        }
        for (Partido p : partidos){
            map.put(p,0);
        }
        for (Token tk : lista){
            int votos = map.getOrDefault(tk.getPartido(),0);
            map.put(tk.getPartido(), votos+1);
        }
        return map;
    }
}

