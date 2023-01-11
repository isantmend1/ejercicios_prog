package ud2.ejerciciosED1;

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
            }
        }
        return salida;
    }

}
