package ud4.ejerciciosED2;

/**
 * Esta clase representa un aposición de una ListaEnlazada.
 * En su versión actual el nodo unicamente puede almacenar números enteros.
 * @author Samuel Loureiro Cardoso
 * @see ListaEnlazada
 */
public class Nodo {
    private int dato;
    private Nodo siguiente;

    /**
     * Permite crear un nodo independiente que almacena un dato.
     * Este nodo no tiene referencia al siguiente nodo.<br>
     * Útil cuando se quiere añadir por el final de la lista.
     * @param dato número a almacenar.
     */
    public Nodo(int dato) {
        this.dato = dato;
    }

    /**
     * Permite crear un nodo enlazado que almacena un dato.Útil cuando se quiere añadir un nodo en cualquier posición de una lista.
     * @param dato número a almacenar.
     * @param siguiente referencia al siguiente nodo.
     */
    public Nodo(int dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    /**
     * Permite saber si este nodo está enlazado con otro.
     * @return true si el nodo tiene una rederencia a un siguiente nodo. 
     */
    public boolean hasNext(){
        return siguiente != null;
    }
    /**
     * Devuelve el siguiente nodo enlazado al actual.
     * @return Siguiente nodo o null de no existir siguiente.
     */
    public Nodo next(){
        return siguiente;
    }
    
    public void setNext(Nodo nuevo){
        siguiente = nuevo;
    }
    
    public int getDato(){
        return dato;
    }
    
}
