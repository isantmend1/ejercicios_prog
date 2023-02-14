package ud4.ejerciciosED4;

/**
 * Clase que representa una estructura LIFO.
 * Permite manejar cualquier tipo de objeto.
 * @author Samuel Loureiro Cardoso
 * @param <E>
 */
public class Pila<E> {

    private Nodo<E> cabeza;
    
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
    public void push(E dato){
        cabeza = new Nodo(dato,cabeza);       
    }
    
    /**
     * Extrae un elemneto de la pila.
     * @return Elemento extraido.
     */
    public E pop(){
        if(cabeza==null){
            return null;
        }
        
        E dato = cabeza.getDato();
        cabeza = cabeza.next();
        
        return dato;
    }
    
    /**
     * Devuelve el elemento que ocupa la cabeza de la pila sin extraerlo.
     * @return Objeto en la cabeza de la pila.
     */
    public E peek(){
        if(cabeza==null){
            return null;
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
