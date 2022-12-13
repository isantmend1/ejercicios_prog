/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo3.ejercicios1y2;

/**
 *
 * @author alumno
 */
public class Persona {
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private int nif;

    public Persona() {
        this.nombre = "N/A";
        this.apellido1 = "N/A";
        this.apellido2 = null;
        this.edad = -1;
        this.nif = -1;
    }

    public Persona(String nombre, String apellido1, String apellido2, int edad, int nif) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.nif = nif;
    }
    
    public Persona(String nombre, String apellido1, int edad, int nif) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = null;
        this.edad = edad;
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }
    
    public String getDNI(){
        String dni=nif+"-";
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int posicion = nif%23;
        dni+=letras[posicion];
        return dni;
    }
    
    public String toString(){
        String salida = "Nombre: "+this.nombre+"\n";
        salida+="Apellidos: "+apellido1+" "+apellido2!=null?apellido2:"";
        salida+="NIF: "+nif;
        salida+="Edad: "+edad;
        return salida;
    }
    
}
