package org.uma.mbd.mdJarras.jarra;
import org.uma.mbd.mdJarras.jarra.Jarra;

public class Mesa {
    private Jarra j1, j2;
    public Mesa(int cap1, int cap2){
        j1 = new Jarra(cap1);
        j2 = new Jarra(cap2);
    }
    public void llenaA(){j1.llena();}
    public void llenaB(){j2.llena();}
    public void vaciaA(){j1.vacia();}
    public void vaciaB(){j2.vacia();}
    public void vuelcaAsobreB(){j2.llenarDesde(j1);}
    public void vuelcaBsobreA(){j1.llenarDesde(j2);}
    public int getCapacidadA(){
        return j1.capacidad;
    }
    public int getCapacidadB(){
        return j2.capacidad;
    }
    public int getContenidoA(){
        return j1.contenido;
    }
    public int getContenidoB(){
        return j2.contenido;
    }
    public int getContenido(){
        return j1.contenido+j2.contenido;
    }
    public String toString() {
        return "Mesa(" + j1 + "," + j2 + ")";
    }
}
