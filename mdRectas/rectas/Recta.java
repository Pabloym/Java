package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector director;
    private Punto pto;
    public Recta(Vector v, Punto p){
        director=v;
        pto=p;
    }
    public Recta(Punto p1, Punto p2){
        pto=p1;
        director= new Vector(p1.getX()-p2.getX(),p1.getY()-p2.getY());
    }
    public boolean paralelaA(Recta r1){
        return director.paraleloA(r1.director);
    }
    public boolean pasaPor(Punto p){
        Vector v = new Vector(p,pto);
        return v.paraleloA(director);
    }
    public Punto interseccionCon(Recta r){
        double vx = director.getComponenteX();
        double vy = director.getComponenteY();
        double ux = r.director.getComponenteX();
        double uy = r.director.getComponenteY();

        double px = pto.getX();
        double py = pto.getY();
        double qx = r.pto.getX();
        double qy = r.pto.getY();

        double d = vx*uy-ux*vy;
        double d1 = vx*py-vy*px;
        double d2 = ux*qy-uy*qx;

        double x = (d1*ux-d2*vx)/d;
        double y = (d1*uy-d2*vy)/d;
        return new Punto(x,y);
        }
    public Recta paralelaPor(Punto p){
        return new Recta(director,p);
    }

    public Recta perpendicularPor(Punto p){
        Recta r = new Recta(director.ortogonal(),p);
        return r;
    }
    public double distanciaDesde(Punto p){
        Recta per = perpendicularPor(p);
        Punto inter = interseccionCon(per);
        return p.distancia(inter);
    }
    public String toString(){
        return "R("+director.toString()+","+pto.toString()+")";
    }
}
