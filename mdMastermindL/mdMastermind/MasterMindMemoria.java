package org.uma.mbd.mdMastermindL.mdMastermind;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MasterMindMemoria extends MasterMind{
    private List<Movimiento> movimientos;

    public MasterMindMemoria(int lon){
        if (lon>10 && lon<0){
            throw new MasterMindException("El argumento introducido es negativo o mayor que el numero de cifras diponibles(10).");
        }
        else{
            movimientos=new LinkedList<>();
            longitud=lon;
            generaCombinacionSecreta(longitud);
        }
    }

    public MasterMindMemoria(){
        movimientos=new LinkedList<>();
        longitud=TAMANO_POR_DEFECTO;
        generaCombinacionSecreta(longitud);
    }

    public MasterMindMemoria(String num){
        movimientos=new LinkedList<>();
        longitud=Integer.parseInt(num);
        generaCombinacionSecreta(longitud);
    }
    public List<Movimiento> movimientos(){
        return movimientos;
    }

    @Override
    public Movimiento intento(String cifra){
        Movimiento newMovimiento = super.intento(cifra);
        Scanner teclado = new Scanner(System.in);
        while (movimientos.contains(newMovimiento)){
            System.out.print("El movimiento anterior está repetido, introduce una nueva cifra: ");
            cifra = teclado.next();
            newMovimiento=super.intento(cifra);
        }
        movimientos.add(newMovimiento);
        return newMovimiento;
    }

    @Override
    public String toString(){
        String salida="[";
        int pos=0;
        int l=movimientos.size();
        for (Movimiento el:movimientos){
            salida+=el;
            if (pos<l){
                salida+=", ";
            }
            pos+=1;
        }
        salida+="]";
        return salida;
    }
}
