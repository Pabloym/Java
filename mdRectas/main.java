package org.uma.mbd.mdRectas;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Recta;
import org.uma.mbd.mdRectas.rectas.Vector;

public class main {
    public static void main(String[] args) {
        Punto A = new Punto(2,5);
        Punto B = new Punto(-1,3);
        Punto C = new Punto(0,5);
        Punto pMedio = new Punto((A.getX()+B.getX())/2,(A.getY()+B.getY())/2);
        double h = pMedio.distancia(C);
        double b = A.distancia(B);
        double AreaTriangulo = b*h/2;
        System.out.println("El area del triangulo determinado por los puntos "+A.toString()+ ", "+ B.toString()+" y "+C.toString()+" es "+AreaTriangulo);

        System.out.println("Calcula la interseccion de las siguientes rectas:");
        Recta r1 = new Recta(new Vector(1,2),A);
        Recta r2 = new Recta(new Vector(1,5),B);
        System.out.println("Recta 1: "+r1);
        System.out.println("Recta 2: "+r2);
        System.out.println("La interseccion entre ambas rectas es el punto: "+ r1.interseccionCon(r2));

         /*
        // Calcular el área del triángulo formado por tres puntos
        Punto p1 = new Punto(0,0);
        Punto p2 = new Punto(4,0);
        Punto p3 = new Punto(2,3);
        // Se calcula la distancia entre p2 y p3
        double base = p2.distancia(p3);
        // Se calcula la recta que pasa por p2 y p3
        Recta rBase = new Recta(p2,p3);
        // se calcula la distancia entre p1 y rBase
        double altura = rBase.distanciaDesde(p1);
        // El area es base*altura/2
        double area = base*altura/2;
        System.out.printf ("Puntos %s %s %s\n",p1,p2,p3);
        System.out.println ("area = " + area);
        // La perpendicular a rBase por p3
        Punto p4 = new Punto(1,-4);
        Recta rPerpe = rBase.perpendicularPor(p4);
        System.out.println("Perpendicular a " + rBase + " que pasa por " + p4 +"  es: " + rPerpe);
        Recta rPara = rBase.paralelaPor(p1);
        System.out.println("Paralela a " + rBase + " que pasa por " + p1 + " es: " + rPara);
        Punto inter = rPerpe.interseccionCon(rPara);
        System.out.println("Intersección de " + rPerpe + " con " + rPara + " es: " + inter );

         */
    }
}
