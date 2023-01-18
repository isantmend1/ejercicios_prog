package ud4.ejerciciosED1;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase para probar el código.
 * @author Samuel Loureiro Cardoso
 */
public class Principal {
    
    public static void main(String[] args) {
//        String[] prueba = {"hola","HI","ola","boas"};
//        boolean esta = MisArrays.estaEnArray(prueba, "Hip");
//        System.out.println("esta="+esta);

//          int[] arr = new int[1000000];
//          Random rand = new Random();
//          for(int i=0; i<arr.length; i++){
//              arr[i] = rand.nextInt(100000);
//          }
//          int[] arr2 = MisArrays.eliminarRepetidos(arr);
//          
//          System.out.println(Arrays.toString(arr2));
//          System.out.println(arr2.length);

            int[] arr = MisArrays.rellenaPares(20, 50);
            System.out.println(Arrays.toString(arr));
    }
    
}
