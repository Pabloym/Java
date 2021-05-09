package org.uma.mbd.mdNPI.npi;

public class NPI {
    public double x,y,z,t;

    public void entra(double valor){
            t=z;
            z=y;
            y=x;
            x=valor;
    }
    public void suma(){
        x=x+y;
        y=z;
        z=t;
        t=0;
    }
    public void resta(){
        x=y-x;
        y=z;
        z=t;
        t=0;
    }
    public void multiplica(){
        x=x*y;
        y=z;
        z=t;
        t=0;
    }
    public void divide(){
        x=y/x;
        y=z;
        z=t;
        t=0;
    }
    public double getResultado(){
        return x;
    }
    public String toString(){
        return "NPI(x="+x+", y="+y+", z="+z+", t="+t+")";
    }

}
