/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud3.refuerzo.sesion1;

import java.util.Scanner;

/**

 *
 * @author Samuel Loureiro Cardoso
 */
public class Persona {
    private String nombre;
    private int edad;
    private String din;

    public Persona(String nombre, int edad, String din) {
        
        this.nombre = nombre;
        this.edad = edad;
        this.din = din;
    }
    //metodos

    public boolean esMayorDeEdad(){
        return this.edad >= 18;        
    }
    
    public boolean esMayor(Persona otra){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca edad");
        int otraEdad = sc.nextInt();
        return this.edad > otra.getEdad();
    }
    
    public boolean mismoNombre(Persona otra){
        return this.nombre.equals(otra.getNombre()) ;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDin() {
        return din;
    }

    public void setDin(String din) {
        this.din = din;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + "\n edad=" + edad + "\n din=" + din;
    }
    
    
    
    
    
}
