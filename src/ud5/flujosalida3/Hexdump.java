package ud5.flujosalida3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Hexdump {
    public final static int CAMBIO_LINEA = 10;
    public static void main(String[] args) {
        //Solicitar ruta del fichero.
        String ruta = JOptionPane.showInputDialog("Ruta fichero.");
        //Abrir un flujo de entrada binario.
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ruta);
            //Leer byte a byte
            int byt;
            int offset = 0;
            while((byt=fis.read())!=-1){
                if(offset%CAMBIO_LINEA==0){
                    System.out.print("\n"+offset+":\t");
                }
                System.out.printf("%02X",byt);
                System.out.print("\t");
                offset++;
                
            }
            //Por cada Byte escribir en salida estandar en formato hexadecimal.
            //Al principio de cada linea poner el offset.
            //Saltar de linea cada CAMBIO_LINEA BYTES.
        
            
        } catch (FileNotFoundException e) {
            System.err.println("No se encuentra el fichero en la ruta: "+ruta);
        }catch (IOException e) {
            System.err.println("Error leyendo el fichero.");
        }finally{
           //Cerrar el flujo.
           if(fis!=null){
               try {
                   fis.close();
               } catch (IOException ex) {
                   System.err.println("Error cerrando el fichero.");
               }
           }
        }
        
    }
    
}
