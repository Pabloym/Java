package org.uma.mbd.mdAmigoInvisible.amigos;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Club {
    protected List<Persona> socios;

    public Club(){
        socios=new LinkedList<Persona>();
    }

    public void lee(String fichEntrada, String delimitadores) throws FileNotFoundException{
        try(Scanner sc = new Scanner(new File(fichEntrada))){
            while(sc.hasNextLine()){
                String linea=sc.nextLine();
                leeSocios(linea,delimitadores);
            }
        }
    }
    protected void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(new File(linea))){
            int i = 0;
            while(sc.hasNextLine()) {
                String nombres = sc.nextLine();
                try(Scanner sc1 = new Scanner(nombres)) {
                    sc1.useDelimiter(delim);
                    while (sc1.hasNext()) {
                        String nombre = sc1.next();
                        creaSocioDesdeString(nombre);
                        i += 1;
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.err.println(linea+ "El archivo no existe");
        }
    }

    protected void creaSocioDesdeString(String nombre){
        Persona p = new Persona(nombre);
        socios.add(p);
    }

    protected void hacerAmigos(){
        LinkedList<Integer> posAmigos = new LinkedList<>();
        for (int j =0;j<socios.size();j++){
            posAmigos.add(j);
        }
        while(hayCoincidencias(posAmigos)) {
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

    public void presentaAmigos(String fichSalida) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(fichSalida);
        presentaAmigos(pw);
    }

    private void presentaAmigos(PrintWriter pw){
        Collections.sort(socios);
        for (Persona p : socios){
            pw.println(p);
        }
    }

}
