/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generargrupos;

/**
 *
 * @author alumno
 */
public class Grupo {
    
    private Alumno[] alumnos;
    private String nombre;
    private int numMiembros;

    public Grupo(String nombre, int numMiembros) {
        this.nombre = nombre;
        this.numMiembros = numMiembros;
        this.alumnos = new Alumno[numMiembros];
    }

    public Grupo(Alumno[] alumnos, String nombre) {
        this.alumnos = alumnos;
        this.nombre = nombre;
        this.numMiembros = alumnos.length;
    }

    public boolean addAlumno(Alumno nuevo){
       boolean toRet = false;
        for(int i = 0; i<alumnos.length;i++){
           if(alumnos[i]==null){
              alumnos[i] = nuevo;
              toRet = true;
              break;
           }
       }
        return toRet;        
        
    }
    
    
    public Alumno[] getAlumnos() {
        return alumnos;
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getNumMiembros() {
        return numMiembros;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumMiembros(int numMiembros) {
        this.numMiembros = numMiembros;
    }
    
    

    @Override
    public String toString() {
        String salida = nombre+"---\n";
        for(int i=0; i<alumnos.length;i++){
            if(alumnos[i]==null){
                continue;
            }
            salida+= alumnos[i]+"\t\n";
        }
        
        return salida;
    }
    
    
    
    
    
}
