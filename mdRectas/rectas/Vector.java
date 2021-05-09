package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;
    public Vector(double a, double b){
        extremo = new Punto(a,b);
    }

    public Vector(Punto pto){
        extremo=pto;
    }

    public Vector(Punto p1, Punto p2){
        Punto origen = p1;
        extremo = p2;
    }

    public double getComponenteX(){
        return extremo.getX();
    }

    public double getComponenteY(){
        return extremo.getY();
    }

    public Vector ortogonal(){
        Vector ort = new Vector(-extremo.getY(),extremo.getX());
        return ort;
    }
    public double modulo(){
        Punto or = new Punto();
        double mod = extremo.distancia(or);
        return mod;
    }

    public boolean paraleloA(Vector v){
        return extremo.getX()*v.getComponenteY()-extremo.getY()*v.getComponenteX()==0;
    }

    public Punto extremoDesde(Punto origen){
        Punto pto = new Punto(extremo.getX(),extremo.getY());
        pto.trasladar(origen.getX(),origen.getY());
        return pto;
    }

    public String toString(){
        return "V("+extremo.getX()+","+extremo.getY()+")";
    }
}
