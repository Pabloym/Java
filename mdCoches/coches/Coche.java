package org.uma.mbd.mdCoches.coches;

public class Coche {
    private String nombre;
    private double precio;
    private static double IVA = 0.16;

    public Coche(String name, double precio){
        nombre=name;
        this.precio=precio;
    }

    public static void setPiva(double newIVA){
        IVA=newIVA;
    }

    public double precioTotal(){
        return precio*(1+IVA);
    }
    @Override
    public String toString(){
        return nombre+" -> "+precioTotal();
    }
}
