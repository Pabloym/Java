package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Proporcional implements CriterioSeleccion{

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc){
        Map<Partido, Integer> map = new TreeMap<>(Comparator.comparing(Partido::getVotos).reversed());
        List<Token> tkns = new LinkedList<Token>();

        int nTotalVotos = partidos.stream().map(Partido::getVotos).reduce(Integer::sum).get();
        double vpe = nTotalVotos/numEsc;

        for (Partido p : partidos){
            for (int k = 0; k<numEsc; k++){
                Token tk = new Token(p,p.getVotos()-k*vpe);
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
            int Esc = map.getOrDefault(tk.getPartido(),0);
            map.put(tk.getPartido(), Esc+1);
        }
        return map;
    }
}
