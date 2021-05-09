package org.uma.mbd.mdNPI;

import org.uma.mbd.mdNPI.npi.NPI;

public class EjercicioNPI {
     public static void main(String[] args) {
          System.out.println("Primera operacion: 3*(6-2)+5 = 17");
          NPI npi = new NPI();
          npi.entra(3);
          System.out.println(npi.toString());
          npi.entra(6);
          System.out.println(npi.toString());
          npi.entra(2);
          System.out.println(npi.toString());
          npi.resta();
          System.out.println(npi.toString());
          npi.multiplica();
          System.out.println(npi.toString());
          npi.entra(5);
          System.out.println(npi.toString());
          npi.suma();
          System.out.println(npi.toString());
          System.out.println(npi.getResultado());

          System.out.println("Segunda operacion: 3*(6-2)+(7+2)/5 = 13.8");
          NPI npi2 = new NPI();
          npi2.entra(3);
          npi2.entra(6);
          npi2.entra(2);
          npi2.resta();
          npi2.multiplica();
          npi2.entra(2);
          npi2.entra(7);
          npi2.suma();
          npi2.entra(5);
          npi2.divide();
          npi2.suma();
          System.out.println(npi2.getResultado());
     }

}
