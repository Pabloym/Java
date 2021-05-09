package org.uma.mbd.mdPartidos.partidos;
import java.util.Map;
import java.util.List;

public interface CriterioSeleccion {
    Map<Partido,Integer> ejecuta(List<Partido> partidos, int numEsc);
}
