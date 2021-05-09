package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubPareja extends Club {
    private Set<Pareja> parejas= new HashSet<Pareja>();

    @Override
    protected void creaSocioDesdeString(String nombre){
        //ArrayList<String> personas = nombre.split("-");
        if (nombre.contains("-")){
            try(Scanner pa = new Scanner(nombre)){
                pa.useDelimiter("[-]");
                String n1 = pa.next();
                String n2 = pa.next();
                Persona p1 = new Persona(n1);
                Persona p2 = new Persona(n2);
                Pareja pare = new Pareja(p1,p2);
                parejas.add(pare);
                socios.add(p1);
                socios.add(p2);
            }
        }
        else {
            Persona p = new Persona(nombre);
            socios.add(p);
        }
    }

    @Override
    protected void hacerAmigos(){
        int cont=1;
        while(cont!=0) {
            super.hacerAmigos();
            cont=0;
            for (Persona p : socios) {
                Pareja pa = new Pareja(new Persona(p.getNombre()), new Persona(p.getAmigo()));
                if (parejas.contains(pa)) {
                    cont+=1;
                }
            }
        }
    }


/* Esto es como lo tenia antes, tambien sirve
    @Override
    protected void hacerAmigos(){
        LinkedList<Integer> posAmigos = new LinkedList<>();
        for (int j =0;j<socios.size();j++){
            posAmigos.add(j);
        }
        while(hayCoincidencias(posAmigos) || coincidenParejas(posAmigos)) {
            Collections.shuffle(posAmigos);
        }
        int i=0;
        for(Persona p:socios){
            int pos = posAmigos.get(i);
            Persona nombAmigo = socios.get(pos);
            p.setAmigo(nombAmigo.getNombre());
            i+=1;
        }
    }
    private static boolean hayCoincidencias(List<Integer> lista){
        boolean test = false;
        for (int i =0; i<lista.size();i++){
            if (lista.get(i)==i){
                test=true;
            }
        }
        return test;
    }

    private boolean coincidenParejas(List<Integer> lista){
        boolean test = false;
        for (int i =0;i<lista.size();i++){
            Pareja posiblePareja = new Pareja(socios.get(i),socios.get(lista.get(i)));
            for (Pareja par : parejas) {
                if (par.equals(posiblePareja)) {
                    test = true;
                }
            }
        }
        return test;
    }
*/

}
