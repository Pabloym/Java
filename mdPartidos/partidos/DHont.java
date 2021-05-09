package org.uma.mbd.mdPartidos.partidos;

import java.util.*;
import java.util.stream.Collectors;

public class DHont implements CriterioSeleccion{
    private double minPor;

    public DHont(double mp) {
        minPor=mp/100;
    }
    public DHont(){
        minPor=0.15;
    }

    private List<Token> filtra(List<Token> tks){
        return tks.stream().filter(tk -> tk.getRatio()>=minPor).collect(Collectors.toList());
    }

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
        List<Token> lista = new ArrayList<Token>();
        for (int i = 0; i<numEsc;i++){
            lista.add(tkns.get(i));
        }
        lista = filtra(lista);

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