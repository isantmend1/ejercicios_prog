package generargrupos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Genera_grupos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alumno[] arrayAlumnos = getAlumnosFromCSV("alumnos.csv");
        arrayAlumnos = desordenarAlumnos(arrayAlumnos);
        int tamanhoGrupo = 3;
        
        int numGrupos = arrayAlumnos.length / tamanhoGrupo;
      
        numGrupos += arrayAlumnos.length % tamanhoGrupo !=0?1:0;
        
        Grupo[]  grupos = new Grupo[numGrupos];
        
        
        for(int i= 0; i<grupos.length;i++){
            Grupo aux = new Grupo("G"+i,tamanhoGrupo);
            grupos[i] = aux;            
        }        
        //Utilizo g para avanzar por el array de grupos.
        int g = 0;
        for(int i=0; i<arrayAlumnos.length; i++){
            if(!grupos[g].addAlumno(arrayAlumnos[i])){
                g++;
                grupos[g].addAlumno(arrayAlumnos[i]);
            }            
            
        }
        
        for(int i= 0; i < grupos.length; i++){
            System.out.println(grupos[i]);
        }        
        
    }
    
    public static Alumno[] desordenarAlumnos(Alumno[] ordenados){
        Alumno[] desordenados = new Alumno[ordenados.length];
        int x = 0;
        Random r = new Random();
        for (int i = 0; i < ordenados.length; i++) {
            do{                
                x = r.nextInt(desordenados.length);
            }while(desordenados[x]!=null);
            desordenados[x] = ordenados[i];
        }
        
        return desordenados;
    }

    
    public static Alumno[] getAlumnosFromCSV(String rutaFichero) {
        //TODO Pilla la primera linea del csv
        ArrayList<Alumno> auxAls = new ArrayList<Alumno>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
            String linea;
            while((linea=br.readLine())!=null){
                String[] valores = linea.split(";");
                auxAls.add(new Alumno(valores[0],valores[1],valores[2]));
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Genera_grupos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Genera_grupos.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alumno[] als = new Alumno[auxAls.size()];
        als = auxAls.toArray(als);
        return als;
    }
    

}
