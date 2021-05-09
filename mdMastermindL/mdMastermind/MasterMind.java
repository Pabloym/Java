package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.Random;

public class MasterMind{
    public static int TAMANO_POR_DEFECTO = 4;
    private Random alea = new Random();

    protected int longitud;
    protected String secreto;

    public MasterMind(int lon){
        if (lon>10 && lon<0){
            throw new MasterMindException("El argumento introducido es negativo o mayor que el numero de cifras diponibles(10).");
        }
        else{
            longitud=lon;
            generaCombinacionSecreta(longitud);
        }
    }

    public MasterMind(){
        longitud=TAMANO_POR_DEFECTO;
        generaCombinacionSecreta(longitud);
    }

    public MasterMind(String num){
        longitud = Integer.parseInt(num);
        generaCombinacionSecreta(longitud);
    }

    protected void generaCombinacionSecreta(int tam){
        longitud=tam;
        int[] cifras = new int[longitud];
        int numero;
        String secret="";
        for (int i=0;i<longitud;i++){
            numero= alea.nextInt(10);
            if (i>0){
                while (pertenece(numero,cifras)){ //Asi nos aseguramos que el numero no este repetido
                    numero=alea.nextInt(10);
                }
            }
            cifras[i]=numero;
            secret+=numero;
        }
        secreto=secret;
    }

    public int getLongitud() {
        return longitud;
    }

    private boolean pertenece(int num, int[] lista){
        boolean esta =false;
        int pos=0;
        while(pos<lista.length && !esta){
            esta=num==lista[pos];
            pos+=1;
        }
        return esta;
    }
    private int[] numALista(int num) {
        int[] digitos = new int[longitud];
        for (int j = 0; j < longitud; j++) {
            digitos[j] = num % 10;
            num = (num - num % 10) / 10;
        }
        return digitos;
    }

        protected boolean validaCombinacion(String cifras){
            boolean forma = true;
            boolean cifrasRepes = false;
            int num = 0;
            try {
                num = Integer.parseInt(cifras);
            } catch (NumberFormatException e) {
                forma = false;
            }
            boolean longit = longitud==cifras.length();
            if (forma && longit) {
                int[] digitos = numALista(num);
                for (int i = 0; i < 10; i++) {
                    int cont = 0;
                    int pos = 0;
                    while (cont <= 1 && pos < cifras.length() && !cifrasRepes) {
                        if (i == digitos[pos]) {
                            cont += 1;
                        }
                        pos += 1;
                    }
                    if (cont > 1) {
                        cifrasRepes = true;//Hay cifras repetidas
                    }
                }
                return !cifrasRepes;
            } else {
                return forma;
            }
        }

        public Movimiento intento (String num){
            if (!validaCombinacion(num)) {
                throw new MasterMindException("La cadena de cifras introducida no es válida.");
            }
            else {
                int[] digitos =numALista(Integer.parseInt(num));
                int colocadas = 0;
                int descolocadas =0;
                int[] listaSecreta = numALista(Integer.parseInt(secreto));
                for (int i=0;i<longitud;i++){
                    if (pertenece(digitos[i],listaSecreta)){
                        if (digitos[i]==listaSecreta[i]){
                            colocadas+=1;
                        }
                        else{
                            descolocadas+=1;
                        }
                    }
                }
                return new Movimiento(num,colocadas,descolocadas);
            }
        }
        public String getSecreto(){
            return secreto;
        }
    }
