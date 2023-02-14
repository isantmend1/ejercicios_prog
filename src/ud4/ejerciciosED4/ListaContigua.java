package ud4.ejerciciosED4;

import java.util.Arrays;

/**
 * Lista que almacena sus elementos en posiciones contiguas de memoria.
 * @author Samuel Loureiro Cardoso
 */
public class ListaContigua<E>{

    private E[] datos;
    private int size;
    //Para implementar iterador.
    private int actual;

    /**
     * Crea una lista vacia.
     * Para utilizar este método siempre debe pasarse un array vacío del tipo deseado.
     */
    public ListaContigua(E[] array) {
        this.datos = array;
        this.actual = -1;
        this.size = 0;
    }
    
    
    /**
     * Inserta un elemento en una lista. <br>
     * Para que se produzca la inserción la posición debe ser: <i>0<=posición<=tamaño</i>.
     * Sieno <i>tamaño</i> el tamaño actual de la lista.
     * @param elemento objeto a introducir en la lista.
     * @param posicion índice de la lista en el que se desea introducir el elemento.
     * @return true si se ha producido la inserción, false en caso contrario.
     */
    public boolean insert(E elemento, int posicion) {
        if(posicion>size || posicion<0){
            return false;
        }
        datos = Arrays.copyOf(datos, size+1);
        size++;
        for(int i = size-1; i>posicion; i--){
            datos[i] = datos[i-1];
        }
        datos[posicion] = elemento;
        return true;
    }

    /**
     * Inserta un elemento en la última posición de la lista
     * <i>size()</i>.
     * @param elemento número a insertar. 
     */
    public void append(E elemento) {
        datos = Arrays.copyOf(datos, size+1);
        size++;
        datos[size-1] = elemento;
    }

    /**
     * Elimina el elemento de la posición indicada. 
     * Si la posición pasada no es un índice de la lista no se produce la
     * eliminación y se devuelve false.
     * @param posicion índice del elemento a suprimir.
     * @return true si se produce la operación y false en caso contrario.
     */
    public boolean remove(int posicion) {
        if(posicion>size || posicion<0){
            return false;
        }
        E[]nuevo = Arrays.copyOf(datos, size-1);
        int j = 0;
        for(int i=0;i<size;i++){
            if(i==posicion)
                continue;
            nuevo[j] = datos[i];
            j++;
        }
        datos = nuevo;
        size--;
        return true;
    }

    /**
     * Recupera un elemento de una posición de la lista.
     * @param posicion índice del elemento a recuperar.
     * @return el elemento que ocupa la posición indicada.
     * @throws IndexOutOfBoundsException se produce la excepción en caso de que
     * la posición pasada no se corresponda con un índice de la lista.
     */
    public E getElementAt(int posicion) throws IndexOutOfBoundsException {
        if(posicion>=size){
            throw new IndexOutOfBoundsException("Elemento fuera de rango de la lista. Pruebe a restablecer el iterador con el método reset().");
        }
        return datos[posicion];
    }

    /**
     * Número de elementos que contiene la lista.
     * @return número de elementos de la lista.
     */
    public int size() {
        return this.size;
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
        actual++;
        if(actual>=size){
            throw new IndexOutOfBoundsException("Elemento fuera de rango de la lista. Pruebe a restablecer el iterador con el método reset().");
        }
        return datos[actual];
    }

    /**
     * Indica si existe siguiente elemento al actual.
     * @return true si hay siguiente elemento al actual o false
     * en caso que el elemento actual sea el último o la lista esté vacía.
     */
    public boolean hasNext() {
        return actual+1 < size;
    }

    /**
     * Establece el elemento actual a la posción de partida. 
     * Después de ejecutar este método, si se ejecuta next() se obtendrá el
     * primer elemento de la lista.
     */
    public void reset() {
        actual = -1;
    }
    
    
}
