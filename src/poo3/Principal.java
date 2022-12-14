package poo3;

import java.util.Scanner;
import poo3.ejercicios1y2.Persona;

/**
 *
 * @author Samuel
 */
public class Principal {
    public static void main(String[] args) {
        ejercicio2();
    }
    
    public static void ejercicio1(){
        //TODO
    }
    
    public static void ejercicio2(){
        Scanner sc = new Scanner(System.in);
        String nombre, ap1, ap2;
        int nif, edad;
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido: ");
        ap1 = sc.nextLine();
        System.out.print("Apellido: ");
        ap2 = sc.nextLine();
        System.out.print("nif: ");
        nif = sc.nextInt();
        System.out.print("Edad: ");
        edad = sc.nextInt();
        
        Persona p1 = new Persona(nombre, ap1, ap2, edad, nif);
        System.out.println(p1);
        System.out.println("DNI completo: "+p1.getDNI());
    }
}
