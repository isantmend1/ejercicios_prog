package ud4.ejerciciosED1;

/**
 * Clase para probar el código.
 * @author Samuel Loureiro Cardoso
 */
public class Principal {
    
    public static void main(String[] args) {
        String[] prueba = {"hola","HI","ola","boas"};
        boolean esta = MisArrays.estaEnArray(prueba, "Hip");
        System.out.println("esta="+esta);
    }
    
}
