package ud3.refuerzo.sesion1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona titular = new Persona("Paco", 29, "123123456F");
        Cuenta c = new Cuenta(titular, 2000);
        System.out.println(c);
        c.retirar(2100);
        System.out.println(c);
    
    }
    
   
    
}
