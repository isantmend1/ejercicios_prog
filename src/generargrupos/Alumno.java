/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generargrupos;

/**
 *
 * @author alumno
 */
public class Alumno {
    
    private String nombre;
    private String correo;
    private String usuarioAR;

    public Alumno(String nombre, String correo, String usuarioAR) {
        this.nombre = nombre;
        this.correo = correo;
        this.usuarioAR = usuarioAR;
    }
    
    public Alumno(){
        this.nombre = "falso";
        this.correo = "falso";
        this.usuarioAR = "falso";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuarioAR() {
        return usuarioAR;
    }

    public void setUsuarioAR(String usuarioAR) {
        this.usuarioAR = usuarioAR;
    }
    
    
    public String toString(){
        return "Alumno\n\tNombre: "+nombre+"\n\tcorreo:"+this.correo+"\n\tusuario:"+usuarioAR;
    }
    
    
}
