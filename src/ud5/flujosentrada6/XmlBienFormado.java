
package ud5.flujosentrada6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class XmlBienFormado {
    
    
    public static void main(String[] args) {
        try {
            //Programa principal
            String rutaXml = JOptionPane.showInputDialog("Ruta");
            if(isBienFormado(rutaXml)){
                System.out.println("Bien formado!");
            }else{
                System.out.println("Mal formado.");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error abriendo fichero.");
        }
        
    }
    
    private static boolean isBienFormado(String xmlPath) throws FileNotFoundException{
        boolean bienFormado = true;
        //Abrimos xml
        FileReader fw = new FileReader(xmlPath);
        BufferedReader br = new BufferedReader(fw);
        Stack<Etiqueta> pila = new Stack();
        //Leemos linea a linea
        String linea;
        try {
            //TODO: Root element
            while((linea=br.readLine())!=null){
                //Extraemos etiquetas de la linea.
                List<Etiqueta> etiquetas = extraerEtiquetas(linea);
                //Comprobamos anidamiento
                for(Etiqueta et:etiquetas){
                    
                    if(et.isCierre()){
                        //Si es de cierre tiene que coincidir con la cabeza de la pila.
                        //Si no coincide lanzamos la excepción para dejar de buscar, ya que el XML esta mal formado.
                        if(!et.equals(pila.pop().getEtiquetaInversa())){
                            throw new XmlMalFormadoException();
                        }
                    }else{//Si es de apertura la metemos en la pila
                        pila.push(et);
                    }
                }
            }
            //Al terminar de analizar el documento, si los elementos XML están
            //bien anidados, la pila debe estár vacía.
            if(!pila.isEmpty()){
                bienFormado = false;
            }
        } catch (IOException ex) {
            System.err.println("Error de entrada/salida."); 
            bienFormado = false;
        } catch (EtiquetaMalNombradaException ex) {//Si el nombre de la etiqueta no es correcto.
            bienFormado = false;
        }catch (EmptyStackException ex) {//Si al tratar de hacer pila.pop la pila está vacía.
            bienFormado = false;
        }catch(XmlMalFormadoException ex){//Si nos encontramos una etiqueta de cierre mal anidada
            bienFormado = false;
        }finally{
            try {
                br.close();
            } catch (IOException ex1) {
                System.err.println("Error cerrando el flujo a "+xmlPath);                        
            }
        }
        return bienFormado;
    }
    
    /**
     * Extrae etiquetas XML de un String.
     * @param linea Texto a analizar y extraer todos los elementos XML.
     * @return Lista con las etiquetas xml <b>ordenadas</b> por posición en 
     * el String linea.
     */
    private static List<Etiqueta> extraerEtiquetas(String linea) throws EtiquetaMalNombradaException{
        List<Etiqueta> detectadas = new ArrayList();
        String et = "";
        for(int i=0; i<linea.length();i++){
            char actual = linea.charAt(i);
            //Detectamos una etiqueta o ya estamos analizando una.
            if(actual=='<'||!et.isEmpty()){
                et+=actual;
                //Si es llave de cierre la guardamos y reiniciamos et
                if(actual=='>'){
                    detectadas.add(new Etiqueta(et));
                    et = "";
                }
            }
        }
        
        return detectadas;
    }
}
