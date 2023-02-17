package ud4.ejerciciosED5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Principal {
    
    public static void main(String[] args) {
        Principal.ejercicio4();
    }
    
    /**
     * 1. Crea un ArrayList de números enteros positivos introducidos por
     * consola hasta que se introduzca uno negativo. A continuación recorrer con
     * un bucle for mejorado la lista y mostrar por pantalla los índices de los
     * elementos de valor par.
     */
    public static void ejercicio1(){
        
        ArrayList<Integer> numeros = new ArrayList();
        ejercicios1y2(numeros);
        
    }
    
    /**
     * 2. Modifica el ejercicio anterior para utilizar una LinkedList.
     */
    public static void ejercicio2(){
        
        LinkedList<Integer> numeros = new LinkedList();
        ejercicios1y2(numeros);
        
    }
    
    /**
     * 3. Modifica el ejercicio anterior para recorrer la lista utilizando un iterador.
     */
    public static void ejercicio3(){
        
        List<Integer> numeros = new ArrayList();
        ejercicios12y3(numeros);
        
        Iterator<Integer> iter = numeros.iterator();
        int i = 0;
        Integer num;
        while(iter.hasNext()){
            num = iter.next();
            if(num%2==0){
                System.out.println(i);
            }
            i++;
        }
    }
    
    /**
     * 4. Diseña una aplicación que permita registrar las notas obtenidas en un 
     * examen por los diferentes alumnos de una clase. Un alumno se caracteriza 
     * por tener un nombre, un DNI y una nota decimal entre 0 y 10 que puede ser
     * nula en caso de que no haya presentado al examen.
     */
    public static void ejercicio4(){
        
        List<Alumno> alumnado = new ArrayList();  
        String entrada;
        do{
            String nombre = JOptionPane.showInputDialog("Nombre alumno");
            String dni = JOptionPane.showInputDialog("DNI alumno");
            String nota = JOptionPane.showInputDialog("Nota alumno");
            
            Alumno a = new Alumno(nombre,dni,Double.parseDouble(nota));
            alumnado.add(a);
            
            entrada = JOptionPane.showInputDialog("Quieres salir (si/no)?");
            
        }while(!entrada.equals("si"));
        
        System.out.println(alumnado);
        
    }

    private static void ejercicios1y2(List<Integer> numeros) {
        ejercicios12y3(numeros);
        
        int i=0;
        for(Integer n:numeros){
            if(n%2==0){
                System.out.println(i);
            }
            i++;
        }
    }

    private static void ejercicios12y3(List<Integer> numeros) {
        Scanner sc = new Scanner(System.in);
        String entrada;
        Integer num = null;
        do{
            System.out.print ("Introduzca numero: ");
            entrada = sc.nextLine();
            System.out.println("");
            try{
                num = Integer.parseInt(entrada);
                if(num.compareTo(0)>=0){
                    numeros.add(num);
                }                
            }catch(NumberFormatException ex){
                num = 0;       
            }
        }while(num.compareTo(0)>=0);
        
        System.out.println("Lista completa:");
        System.out.println(numeros);
    }
    
}


