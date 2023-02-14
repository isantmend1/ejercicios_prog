package ud4.ejerciciosED4;


/**
 * Lista que enlaza sus elementos en posiciones discontiguas de memoria.
 * @author Samuel Loureiro Cardoso
 * @param <E> Tipo de objetos que almacena la lista
 */
public class ListaEnlazada<E>{

    private Nodo<E> cabecera;
    private Nodo<E> actual;
    private int size;

    /**
     * Crea una lista vacía de enteros.
     */
    public ListaEnlazada() {
        cabecera = null;
        actual = null;
        size = 0;
    }

    /**
     * Inserta un elemento en una lista. <br>
     * Para que se produzca la inserción la posición debe ser: <i>0<=posición<=tamaño</i>.
     * Sieno <i>tamaño</i> el tamaño actual de la lista.
     * @param elemento objeto a introducir en la lista.
     * @param posicion índice de la lista en el que se desea introducir el número.
     * @return true si se ha producido la inserción, false en caso contrario.
     */
    public boolean insert(E elemento, int posicion) {
        Nodo nuevo;
        boolean toret = true;
        if (posicion == 0) {
            nuevo = new Nodo(elemento, cabecera);
            cabecera = nuevo;
        } else {
            try {
                Nodo anterior = getNodoAtIndex(posicion - 1);
                nuevo = new Nodo(elemento, anterior.next());
                anterior.setNext(nuevo);

            } catch (IndexOutOfBoundsException e) {
                toret = false;
            }
        }
        if (toret) {
            size++;
        }
        return toret;
    }

    /**
     * Inserta un elemento en la última posición de la lista
     * <i>size()</i>.
     * @param elemento objeto a insertar. 
     */
    public void append(E elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (cabecera == null) {
            cabecera = nuevo;
        } else {
            Nodo aux = cabecera;
            while (aux.hasNext()) {
                aux = aux.next();
            }
            aux.setNext(nuevo);
        }
        size++;
    }


    /**
     * Elimina el elemento de la posición indicada. 
     * Si la posición pasada no es un índice de la lista no se produce la
     * eliminación y se devuelve false.
     * @param posicion índice del elemento a suprimir.
     * @return true si se produce la operación y false en caso contrario.
     */
    public boolean remove(int posicion) {
        boolean toret = true;
        //Si es el primero
        if (posicion == 0) {
            try {
                cabecera = cabecera.next();
            } catch (NullPointerException e) {
                toret = false;
            }
        } else {
            try {
                Nodo anterior = getNodoAtIndex(posicion - 1);
                Nodo siguiente = anterior.next().next();
                anterior.setNext(siguiente);

            } catch (IndexOutOfBoundsException e) {
                toret = false;
            }
        }
        
        if(toret){
            size--;
        }
        return toret;

    }

    /**
     * Recupera un elemento de una posición de la lista.
     * @param posicion índice del elemento a recuperar.
     * @return el elemento que ocupa la posición indicada.
     * @throws IndexOutOfBoundsException se produce la excepción en caso de que
     * la posición pasada no se corresponda con un índice de la lista.
     */
    public E getElementAt(int posicion) throws IndexOutOfBoundsException {
        return (E) getNodoAtIndex(posicion).getDato();
    }


    /**
     * Número de elementos que contiene la lista.
     * @return número de elementos de la lista.
     */
    public int size() {
        return size;
    }


    /**
     * Devuelve el siguiente elemento al actual. <br>
     * Junto con hasNext() y reset() permite iterar sobre la lista.
     * @return el siguiente elemento al actual.
     * @throws IndexOutOfBoundsException se produce la excepción en caso de que
     * el elemento actual sea el último de la lista.
     * @see #hasNext() 
     * @see #reset() 
     */
    public E next() throws IndexOutOfBoundsException {
         if(actual==null){
             actual = cabecera;
         }else{
             actual = actual.next();
         }
         if(actual==null){
             throw new IndexOutOfBoundsException();
         }
         return actual.getDato();
    }


    /**
     * Indica si existe siguiente elemento al actual.
     * @return true si hay siguiente elemento al actual o false
     * en caso que el elemento actual sea el último o la lista esté vacía.
     */
    public boolean hasNext() {
        if(actual==null){
            return cabecera !=null;
        }
        return actual.hasNext();
    }


    /**
     * Establece el elemento actual a la posción de partida. 
     * Después de ejecutar este método, si se ejecuta next() se obtendrá el
     * primer elemento de la lista.
     */
    public void reset() {
        actual = null;
    }

    private Nodo getNodoAtIndex(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return cabecera;
        }
        Nodo actual = cabecera;
        for (int i = 1; i <= index; i++) {
            actual = actual.next();
        }
        return actual;
    }

}
