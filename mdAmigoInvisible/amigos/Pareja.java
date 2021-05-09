package org.uma.mbd.mdAmigoInvisible.amigos;

public class Pareja {
    private Persona uno, otro;
    public Pareja(Persona n1, Persona n2){
        uno=n1;
        otro=n2;
    }
    @Override
    public boolean equals(Object obj){
        boolean pers = obj instanceof Pareja;
        if (pers){
            boolean r1 = this.uno.equals(((Pareja) obj).uno);
            boolean r2 = this.uno.equals(((Pareja) obj).otro);
            boolean s1 = this.otro.equals(((Pareja) obj).uno);
            boolean s2 = this.otro.equals(((Pareja) obj).otro);
            pers = (r1||r2)&&(s1||s2);
        }
        return pers;
    }

    @Override
    public int hashCode(){
        return uno.hashCode()+otro.hashCode();
        // No hace falta irme al nombre y hacer el toUpperCase pues ya esta puesto en el hashCode persona, que es que estamosutilizando para la pareja
    }

    @Override
    public String toString(){
        return "("+uno+","+otro+")";
    }
}
