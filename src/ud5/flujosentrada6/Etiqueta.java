/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud5.flujosentrada6;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samu
 */
public class Etiqueta {
    //Caracteres que no pueden ser parte del nombre de una etiqueta XML.
    public final static String NO_PERMITIDOS_NOMBRE = "!\"#$%&'()*+,/;<=>?@[\\]^`{|}~";
    private String nombre;
    private boolean cierre;
    
    /**
     * Crea una nueva etiqueta a partir de un nombre.
     * @param nombre Nombre del elemento XML sin llaves <>
     * @param cierre Si la etiqueta es de cierre </> vale true.
     * @throws ud5.flujosentrada6.EtiquetaMalNombradaException
     */
    public Etiqueta(String nombre, boolean cierre) throws EtiquetaMalNombradaException{
        this.nombre = nombre;
        if(!nombreEtiquetaEsValido(this.nombre))
            throw new EtiquetaMalNombradaException();
        this.cierre = cierre;
    }
    
    /**
     * Representación completa de la etiqueta.Incluye llaves '<etiqueta>'
     * @param nombreConLlaves 
     * @throws ud5.flujosentrada6.EtiquetaMalNombradaException 
     */
    public Etiqueta(String nombreConLlaves) throws EtiquetaMalNombradaException{
        //Eliminamos espacios absurdos al principio y al final.
        this.nombre = nombreConLlaves.trim();
        //Si el primer o el último caracter no son llaves lanzamos excepcion
        if(nombre.charAt(0)!='<' || nombre.charAt(nombre.length()-1)!='>')
            throw new EtiquetaMalNombradaException();
        //Eliminamos las llaves (primer y ultimo caracter).
        nombre = nombre.substring(1, nombre.length()-1);
        //Comprobamos si el primer caracter es / para determinar si
        //la etiqueta es de apertura o cierre.
        this.cierre = false;
        if(nombre.charAt(0)=='/'){
            this.cierre = true;
            //Eliminamos la / del nombre
            nombre = nombre.substring(1);
        }
        //Comprobamos los caracteres del nombre
        if(!nombreEtiquetaEsValido(this.nombre))
            throw new EtiquetaMalNombradaException();
        
    }
    
    public static boolean nombreEtiquetaEsValido(String nombre){
        for(int i=0;i<nombre.length();i++){
            if(Etiqueta.NO_PERMITIDOS_NOMBRE.contains(nombre.charAt(i)+""))
                return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }


    public boolean isCierre() {
        return cierre;
    }
    
    /**
     * Devuelve la etiqueta de cierre o apertura para esta etiqueta. <br>
     * 
     * @return Si la etiqueta actual es de apertura devolverá la etiqueta
     * correspondiente de cierre y viceversa. 
     */
    public Etiqueta getEtiquetaInversa(){
        Etiqueta et = null;
        try {
            //Controlamos la excepcion porque nunca llegará a este método un nombre invalido
            et =  new Etiqueta(this.nombre, !cierre);
        } catch (EtiquetaMalNombradaException ex) {
            
        }
        return et;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + (this.cierre ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Etiqueta other = (Etiqueta) obj;
        if (this.cierre != other.cierre) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        String etiqueta =  this.cierre?"</":"<";
        etiqueta+= this.nombre+">";
        return etiqueta;
    }
    
    
    
       
    
    
}
