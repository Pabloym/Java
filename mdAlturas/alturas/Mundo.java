package org.uma.mbd.mdAlturas.alturas;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Mundo {
    private List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<Pais>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner paises = new Scanner(new File(file))) {
            leePaises(paises);
        }
    }

    private void leePaises(Scanner sc){
        while (sc.hasNextLine()){
            String linea = sc.nextLine();
            try(Scanner linPais = new Scanner(linea)){
                linPais.useDelimiter("[,]");
                String nombre = linPais.next();
                String cont = linPais.next();
                String alt = linPais.next();
                double altura = Double.parseDouble(alt);
                Pais p = new Pais(nombre,cont,altura);
                paises.add(p);
            }
            catch (InputMismatchException e){
                System.err.println(linea+" Error: Dato no numerico.");
            }
            catch (NoSuchElementException e){
                System.err.println(linea+" Error: Faltan datos.");
            }
        }
    }
    public List<Pais> selecciona(Seleccion sel){
        LinkedList<Pais> lista = new LinkedList<>();
        for (Pais p : paises){
            if (sel.test(p)){
                lista.add(p);
            }
        }
        return lista;
    }

    public void asociaPaisesAContinentes(String file) throws FileNotFoundException{
        Mundo paises = new Mundo();
        paises.leePaises(file);
        Map<String, List<String>> map = new TreeMap<>();
        List<Pais> lPaises = paises.getPaises();
        for (int i = 0; i < lPaises.size(); i++) {
            Pais pais =  lPaises.get(i);
            List<String> paisesPorContinente=map.computeIfAbsent(pais.getContinente(), key -> new ArrayList<>());
            paisesPorContinente.add(pais.getNombre());
        }
        for (Map.Entry<String,List<String>> entrada : map.entrySet()) {
            String clave= entrada.getKey();
            List<String> paisesPorContiente = entrada.getValue();
            System.out.println(clave + ":\t" + paisesPorContiente);
        }
    }

    public Set<String> getContinentes(){
        Set<String> set = new HashSet<>();
        for (Pais p : paises){
            set.add(p.getContinente());
        }
        return set;
    }

    public boolean todosMayores(double minAltura){
        boolean test = true;
        /*int i = 0;
        while(test && i< paises.size()){
            if (paises.get(i).getAlturaMedia()<minAltura){
                test=false;
            }
        }
        */
        Iterator<Pais> it = paises.iterator();
        while(test && it.hasNext()){
        test=it.next().getAlturaMedia()>minAltura;
        }

        return test;
    }

    public Pais masBajoDelContinente(String continente) {
        double altura = 1000;
        Pais pBajito = null;
        for (Pais p : paises) {
            if (p.getContinente().equalsIgnoreCase(continente)) {
                if (p.getAlturaMedia() < altura) {
                    altura = p.getAlturaMedia();
                    pBajito = p;
                }
            }
        }
        return pBajito;
    }


    public Pais paisDeMayorAltura(){
        /*double altura = 0;
        Pais pAlto = paises.get(0);
        for (Pais p : paises) {
            if (p.getAlturaMedia() > altura) {
                    altura = p.getAlturaMedia();
                    pAlto = p;
            }
        }
         */
        List<Pais> paisOrd = new ArrayList<>(paises);
        paisOrd.sort(Comparator.comparing(Pais::getAlturaMedia));
        return paisOrd.get(0);
    }

    public Map<String,List<Pais>> paisesPorContinente(){
        Map<String,List<Pais>> map = new HashMap<>();
        for (Pais p : paises){
            String cont = p.getContinente();
            List<Pais> lPais = new LinkedList<>();
            List<Pais> lPaises =map.computeIfAbsent(cont, key -> lPais);
            map.get(cont).add(p);
            map.putIfAbsent(cont,lPaises);
        }
        return map;
    }

    public Set<Pais> conjOrdPaisesDelContinente(String continente){
        Map<String,List<Pais>> map = paisesPorContinente();
        List<Pais> lista = map.get(continente);
        Set<Pais> res = new TreeSet<>();
        for (Pais p : lista){
            res.add(p);
        }
        /*Set<Pais> set = new TreeSet<>();
        for (Pais p :paises){
            if (p.getContinente().equalsIgnoreCase(continente)){
                set.add(p);
            }
        }*/
        return res;
    }

    public Map<String,Set<Double>> alturasPorContinente(){
        Map<String,Set<Double>> map = new HashMap<>();
        for (Pais p : paises){
            String cont = p.getContinente();
            Set<Double> lAlt = new TreeSet<Double>();
            Set<Double> lAlturas =map.computeIfAbsent(cont, key -> lAlt);
            lAlturas.add(p.getAlturaMedia());
            //map.get(cont).add(p.getAlturaMedia());
            //map.putIfAbsent(cont,lAlturas); estas dos lineas no hacen falta, pero el resultado es el mismo
        }
        return map;
    }
}

