package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Scanner;
import java.io.*;

public class ClubManager {
    private String fichEntrada=null, fichSalida=null;
    private boolean consola;
    private Club club;
    protected String delimitadores;
    protected String salida;

    public ClubManager(Club c){
        club=c;
    }

    public ClubManager setEntrada(String fEntrada, String delim){
        fichEntrada=fEntrada;
        delimitadores=delim;
        return this;
    }

    public ClubManager setSalida(String salida){
        fichSalida=salida;
        return this;
    }

    public ClubManager setConsola(boolean con){
        consola=con;
        return this;
    }

    private void verify(){
        if (fichEntrada==null){
            throw new AmigoException("No existe ningún fichero de entrada.");
        }
        if (fichSalida==null && !consola){
            throw new AmigoException("No existe una salida o fichero de salida.");
        }
    }

    public void build() throws FileNotFoundException{
        verify();
        club.leeSocios(fichEntrada,delimitadores);
        club.hacerAmigos();
        if(consola){
            for (Persona p : club.socios){
                System.out.println(p);
            }
        }
        else{
            try(PrintWriter pw = new PrintWriter(fichSalida)){
                for (Persona p : club.socios) {
                    pw.println(p);
                }
            }
        }
    }
}
