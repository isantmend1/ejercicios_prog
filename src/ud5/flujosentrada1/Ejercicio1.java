package ud5.flujosentrada1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Ejercicio1 {

    public static String FICHERO_PATH = "ficheros/alumni.db";

    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(FICHERO_PATH);
            //LEER
            int byt = 0;

            try {
                while ((byt = fis.read()) != -1) {
                    System.out.print((char) byt);
                }
            }catch(IOException ex){
                try {
                    fis.close();
                } catch (IOException ex1) {
                    System.err.println("Fallo al cerrar el fichero.");
                }
                
            }

        } catch (FileNotFoundException ex) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex1) {
                    System.err.println("Fallo al cerrar el fichero.");
                }
            }
        }

    }

}
