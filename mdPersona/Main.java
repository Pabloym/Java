package org.uma.mbd.mdPersona;
import org.uma.mbd.mdPersona.persona.OrdenNombre;
import org.uma.mbd.mdPersona.persona.Persona;

import java.util.*;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("juan",36);
        Persona p2 = new Persona("Maria",24);
        Persona p3 = new Persona("Juan",36);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        List<Persona> personas = List.of(p1,p2);

        System.out.println(personas.contains(p3));
        System.out.println(personas.indexOf(p3));

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode()); //Al tener una en mayuscula y otra en minuscula, que son iguales debido al
        // equalsIgnoreCase hay que preocuparse que tengan el mismo hashCode
        Persona p4=p1;
        Comparator<Persona> comp = new OrdenNombre();
        Set<Persona> set = new TreeSet<>(comp);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
    }
}
