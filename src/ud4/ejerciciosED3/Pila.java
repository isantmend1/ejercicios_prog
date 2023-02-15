package ud4.ejerciciosED3;


/**
 * Clase que representa una estructura LIFO.
 * Permite manejar cualquier tipo de objeto.
 * @author Samuel Loureiro Cardoso

 */
public class Pila{

    private Nodo cabeza;
    
    /**
     * Crea una pila vacía 
     */
    public Pila() {
        cabeza = null;
    }
    
    /**
     * Introduce un elemento en la pila.
     * @param dato Elemento a introducir.
     */
    public void push(char dato){
        cabeza = new Nodo(dato,cabeza);       
    }
    
    /**
     * Extrae un elemneto de la pila.
     * @return Elemento extraido.
     */
    public char pop(){
        if(cabeza==null){
            throw new IndexOutOfBoundsException();
        }
        
        char dato = cabeza.getDato();
        cabeza = cabeza.next();
        
        return dato;
    }
    
    /**
     * Devuelve el elemento que ocupa la cabeza de la pila sin extraerlo.
     * @return Objeto en la cabeza de la pila.
     */
    public char peek(){
        if(cabeza==null){
            throw new IndexOutOfBoundsException();
        }
        return cabeza.getDato();
    }
    
    /**
     * Indica si la pila está vacía.
     * @return True si la pila no tiene ningún objeto.
     */
    public boolean isEmpty(){
        return cabeza==null;
    }  
    
}
