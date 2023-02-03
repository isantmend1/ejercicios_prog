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
          int[] arr = new int[99999];
          Random r = new Random();
          
          for(int i=0;i<arr.length;i++){
            arr[i]=r.nextInt(9999);
          }
          int[] sArr = MisArrays.eliminarRepetidos(arr);
          System.out.println(sArr.length);
          System.out.println(Arrays.toString(sArr));
    }
    
}
