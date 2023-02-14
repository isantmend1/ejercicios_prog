package ud4.ejerciciosED4;

/**
 * Clase que representa una estructura FIFO.
 * Permite manejar cualquier tipo de objeto.
 * @author Samuel Loureiro Cardoso
 */
public class Cola<E> {
    private Nodo<E> cabeza;

    /**
     * Crea una cola vacía.
     */
    public Cola() {
        cabeza = null;
    }
    
    /**
     * Agrega un objeto a la cola.
     * @param dato Objeto a agregar a la cola.
     */
    public void enqueue(E dato){
        Nodo nuevo = new Nodo(dato);
        if(cabeza==null){
            cabeza = nuevo;
        }else{
            Nodo aux = cabeza;
            while(aux.hasNext()){
                aux = aux.next();
            }
            aux.setNext(nuevo);
        }
    }
    
    /**
     * Devuelve el primer elemento de la cola (y lo elimina).
     * @return Elemento más antiguo de la cola.
     */
    public E dequeue(){
        if(cabeza==null){
            return null;
        }
        
        E dato = cabeza.getDato();
        cabeza = cabeza.next();
        return dato;
    }
    
    /**
     * Muestra el primer elemento de la cola sin eliminarlo.
     * @return Valor del primer elemento de la cola.
     */
    public E peek(){
        if(cabeza==null){
            return null;
        }
        return cabeza.getDato();
    }
    
    /**
     * Indica si la cola está vacía.
     * @return True si la cola no tiene ningún objeto.
     */
    public boolean isEmpty(){
        return cabeza == null;
    }
    
    
}
