package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio){
        this.partido=partido;
        this.ratio=ratio;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public int compareTo(Token tok){
        int resultado = Double.compare(tok.ratio,this.ratio);
        if(resultado==0) {
            resultado = this.partido.getNombre().compareTo(tok.partido.getNombre());
        }
        return resultado;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc){
        Set<Token> resultado = new TreeSet<>();
        Iterator<Token> it = tks.iterator();
        int cont = numEsc;
        while(it.hasNext() && cont>0){
            Token tk = it.next();
            resultado.add(tk);
            cont-=1;
        }
        return resultado;
    }


    public static Map<Partido,Integer> generaResultados(Set<Token> tks){
        Map<Partido,Integer> map = new TreeMap<>();
        Iterator<Token> it = tks.iterator();
        while (it.hasNext()){
            Token tk = it.next();
            int votos = map.getOrDefault(tk.getPartido(), 0);
            map.put(tk.getPartido(),votos+1);
        }
        return map;
    }
}
