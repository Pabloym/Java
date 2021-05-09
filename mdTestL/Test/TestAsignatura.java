package org.uma.mbd.mdTestL.Test;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TestAsignatura {
    protected String nombreAs;
    private double valAciertos, valErrores;
    private List<Test> examenes=new LinkedList<Test>();
    private final int APROBADO=5;

    public TestAsignatura(String nombre, double valAc, double valEr,List<String> resultados){
        nombreAs=nombre;
        valAciertos=valAc;
        valErrores=valEr;
        extraeDatos(resultados);
    }

    public TestAsignatura(String nombre, List<String> resultados){
        this(nombre,1,0,resultados);
    }

    public void extraeDatos(List<String> resultados){
        for (int i=0;i<resultados.size();i++) {  // for (String datoALumno: resultados)  aver si asi no da null
            try (Scanner sc = new Scanner(resultados.get(i))) {
                sc.useDelimiter("[:+]+");
                String nombreAlumno = sc.next();
                int ac = sc.nextInt();
                int er = sc.nextInt();
                Test test = new Test(nombreAlumno, ac, er);
                examenes.add(test);
                }
            catch (InputMismatchException ee){
                System.err.println(resultados.get(i)+"Error: Dato no numerico.");
            }
            catch (NoSuchElementException e){
                System.err.println(resultados.get(i)+"Error: Faltan datos.");
            }
            }
    }

    public String getNombre(){
        return nombreAs;
    }

    public double notaMedia(){
        double notas=0;
        for (int i=0;i<examenes.size();i++){
            notas+=examenes.get(i).calificacion(valAciertos,valErrores);
        }
        return notas/examenes.size();
    }

    public int aprobados(){
        int numApro=0;
        for (int i=0;i<examenes.size();i++){
            if (examenes.get(i).calificacion(valAciertos,valErrores)>=APROBADO) {
                numApro += 1;
            }
        }
        return numApro;
    }

    public void guardaNotaAlumno(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)){
            guardaNotaAlumno(pw);
        }
    }

    public void guardaNotaAlumno(PrintWriter pw){
        for (Test test : examenes){
            double calificacion = test.calificacion(valAciertos,valErrores);
            pw.println(test.getAlumno()+", "+calificacion);
        }
    }
}
