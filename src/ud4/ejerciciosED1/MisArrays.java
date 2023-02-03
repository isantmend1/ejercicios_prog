package ud4.ejerciciosED1;

import java.util.Arrays;
import java.util.Random;
import ud4.ejerciciosED1.ejercicio8.Alumno;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class MisArrays {

    /**
     * Ejercicio 1. Define un método estático en la clase MisArrays que reciba
     * como parámetros un array de Strings y un String y devuelva true o false
     * si el segundo parámetro se encuentra en el array. No se deben tener en
     * cuenta mayúsculas y minúsculas y debes utilizar un bucle for mejorado
     * para recorrer el array.
     * @param array Array de Strings donde buscar el dato.
     * @param dato String a ser buscado.
     * @return True, si el dato se encuentra en el array. False en caso en caso
     *          contrario.
     */
    public static boolean estaEnArray(String[] array, String dato) {
        boolean salida = false;
        for(String actual:array){
            if(actual.equalsIgnoreCase(dato)){
                salida = true;
                break;
            }
        }
        return salida;
    }
    
    
    /**
     * Ejercicio 4. Sobrecarga los métodos de los ejercicios anteriores para que funcionen con
     * tipos de dato int.
     * @param array Array de números donde buscar el dato.
     * @param dato Número a ser buscado.
     * @return True, si el dato se encuentra en el array. False en caso en caso
     *          contrario.
     */
    public static boolean estaEnArray(int[] array, int dato) {
        boolean salida = false;
        for(int actual:array){
            if(actual== dato){
                salida = true;
            }
        }
        return salida;
    }
    
    /**
     * Ejercicio 5: Define un método estático en la clase MisArrays que reciba como parámetro
     * un array de enteros y devuelva un array de enteros correspondiente al primero pero sin
     * números repetidos. Nota: el array que se recibe como parámetro no puede ser alterado
     * @param array
     * @return un array con los elementos de <b>array</b> pero sin repetidos.
     */
    public static int[] eliminarRepetidos(int[] array){
        int[] auxSinRepes = new int[array.length];
        int introducidos = 0;
        for(int i=0; i<array.length; i++){
            boolean esta = false;
            //Comprobar si está en array[i]auxSinRepes hasta introducidos.
            for(int j=0; j< introducidos; j++){
                if(array[i]==auxSinRepes[j]){
                    esta = true;
                    break;
                }
            }
            if(!esta){
                auxSinRepes[introducidos] = array[i];
                introducidos++;
            }
            //Si no está se introduce
        }
        
        int[] sinRepes = new int[introducidos];
        for(int i=0; i<introducidos;i++){
            sinRepes[i] = auxSinRepes[i];
        }
        
        return sinRepes;
    }
    
    /**
     * Ejercicio 8. Crea una clase Alumno que tenga como parámetros nombre, edad y altura. A
     * continuación define un método estático en la clase MisArrays que reciba como parámetro
     * un array de Alumnos y los ordene de menor a mayor edad.
     * @param alumnos Array de alumnos a ordenar. 
     */
    public static void ordenarAlumnos(Alumno[] alumnos){
        for(int i = 0; i<alumnos.length;i++){
            for(int j=0; j<alumnos.length-1-i;j++){
                if(alumnos[j].getEdad()>alumnos[j+1].getEdad()){
                    Alumno aux = alumnos[j];
                    alumnos[j] = alumnos[j+1];
                    alumnos[j+1] = aux;
                }
            }
        }           
    }
    
    /**
     * Ejercicio 11. Haciendo uso de la clase Arrays del API de Java define la función int[]
     * rellenaPares(int longitu, int fin), que crea y devuelve una tabla ordenada de la longitud
     * especificada, que se encuentra rellena con números pares aleatorios del rango 2 – fin.
     * @return 
     */
    public static int[] rellenaPares(int longitud, int fin){
        //Crear un array de longitud elementos
        int[] pares = new int[longitud];
        //Cargalo con números pares aleatorios
        Random rand = new Random();
        
        for(int i=0; i<pares.length;i++){
            int numero = rand.nextInt(fin-1)+2;
            if(numero%2!=0)
                numero--;
            
            pares[i] = numero;
        }
        //Ordenarlo
        Arrays.sort(pares);
        return pares;
    }

}
