package ud4.ejerciciosED1;



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
     * Ejercicio 5: Define un método estático en la clase MisArrays que reciba como parámetro
     * un array de enteros y devuelva un array de enteros correspondiente al primero pero sin
     * números repetidos.Nota: el array que se recibe como parámetro no puede ser alterado.

     * @param array 
     * @return  
     */
    public static int[] eliminarRepetidos(int[]array){
        int[] sinRepes = new int[array.length];
        int numRepetidos = 0;
        int i2 = 0;
        for(int i=0;i<array.length;i++){
            boolean repe = false;
            for(int j = i+1; j<array.length; j++){
                if(array[i]==array[j]){
                    repe=true;
                    break;
                }
            }
            if(repe){
                numRepetidos++;
            }else{
                sinRepes[i2] = array[i];
                i2++;
            }
        }
        int[] toRet = new int[array.length-numRepetidos];
        for(int i=0; i<toRet.length;i++){
            toRet[i] = sinRepes[i];
        }
        return toRet;
    }
    
    public static int[] eliminarRepetidos2(int[] array){
        int toret[] = null;
        int sinRepes[]= new int[array.length];
        int noRepes = 0;
        for(int i =0;i<array.length;i++){
            boolean repetido = false;
            for(int j=0; j<noRepes;j++){
                if(array[i]==sinRepes[j]){
                    repetido = true;
                    break;
                }
            }
            if(!repetido){
                sinRepes[noRepes]=array[i];
                noRepes++;
            }
            
        }
        toret = new int[noRepes];
        for(int i=0;i<noRepes;i++){
            toret[i] = sinRepes[i];
        }
        return toret;
    }

}
