package org.uma.mbd.mdJarras;
import org.uma.mbd.mdJarras.jarra.Mesa;
import org.uma.mbd.mdJarras.jarra.Jarra;

public class main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa(7,5);
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        mesa.vaciaB();
        mesa.vuelcaAsobreB();
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        mesa.vaciaB();
        mesa.vuelcaAsobreB();
        mesa.llenaA();
        mesa.vuelcaAsobreB();
        mesa.vaciaB();
        mesa.vuelcaAsobreB();
        System.out.print(mesa.getContenidoA());
    }
}
