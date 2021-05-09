package org.uma.mbd.mdCoches.coches;

public class CocheImportado extends Coche {
    private double homologacion;

    public CocheImportado(String name, double precio, double homologacion) {
        super(name, precio);
        this.homologacion = homologacion;
    }

    public double precioTotal(){
        return super.precioTotal()+homologacion;
    }
}
