package ud5.flujosalida4.mibiblio;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa a una <b>Biblioteca</b> que contiene un conjunto de libros.
 * Los libros pueden estar repetidos o no:
 * Actualmente un objeto biblioteca puede realizar las siguientes operaciones:
 * <ol>
 * <li>Agregar libros a la colección.</li>
 * <li>Obtener el número total de libros (contando  o excluyendo repetidos</li>
 * <li>Obtener libros buscando por alguno de sus autores</li>
 * <li>Obtener libros buscando por su título o parte de su título.</li>
 * <li>Obtener todos los autores para los que existe algún libro almacenado</li>
 * </ol>
 * @author Aquí tu nombre
 * @see Libro
 * @see Autor
 */
public class Biblioteca {
    /**
     * Capacidad máxima de ejemplares que pueden ser almacenados en la biblioteca.
     */
    public static int CAPACIDAD_MAX = 1000;
    //private List<Libro> libros;
    private final static String RUTA_FICHERO = "ficheros/libros.csv";

    /**
     * Crea una biblioteca vacía.
     */
    public Biblioteca() {
        //libros = new ArrayList();
    }
    
    private List<Libro> obtenerLibrosFichero() throws FileNotFoundException, IOException{
        List<Libro> libros = new ArrayList();
        FileReader fr= new FileReader(RUTA_FICHERO);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        br.readLine();
        while((linea=br.readLine())!=null){
            libros.add(new Libro(linea));
        }
        br.close();
        
        return libros;
    }
    
    private void guardarLibrosFichero(List<Libro> libros){
        try {
            //Abrir flujo escritura de texto.
            FileWriter fw = new FileWriter(RUTA_FICHERO);
            //Recorrer la lista de libros y
            fw.write("isbn;titulo;fecha_pub;Autores(separados por -)\n");
            for(Libro l: libros){
                //Escribir por cada libro una línea en el fichero
                fw.write(l.getLibroformatoCSV()+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.err.println("Error de escritura.");
        }
        
    }
    
    /**
     * Agrega un libro a la biblioteca. <br>
     * Los libros se mantendrán ordenados alfabéticamente según su título.
     * @param lib Libro a agregar.
     * @return True si se agrega el libro y false si no se agrega por haber alcanzado
     * la capacidad máxima.
     * @see #CAPACIDAD_MAX
     */
    public boolean addLibro(Libro lib) throws IOException{
        List<Libro> libros = obtenerLibrosFichero();
        if(libros.size()==Biblioteca.CAPACIDAD_MAX)
            return false;
        
        int i = 0;
        for(i=0;i<libros.size();i++){
            if(libros.get(i).getTitulo().compareTo(lib.getTitulo())>=0){
                break;
            }
        }
        libros.add(i,lib);
        guardarLibrosFichero(libros);
        return true;
    }
    
    /**
     * Devuelve el número total de ejemplares almacenados. <br>
     * Se incluyen repetidos.
     * @return Número de libros almacenados.
     */
    public int getNumLibros() throws IOException{
        List<Libro> libros = obtenerLibrosFichero();
        return libros.size();
    }
    
    /**
     * Devuelve el número de libros almacenados sin contar repetidos.
     * @return Número de libros diferentes almacenados.
     */
    public int getNumTitulos() throws IOException{
        List<Libro> libros = obtenerLibrosFichero();
        return (new HashSet(libros)).size();
    }
    
    /**
     * Devuelve una lista de libros almacenados escritos por el autor indicado.
     * @param autor Autor por el que se desea filtrar.
     * @return Libros de la biblioteca escritos por el autor.
     * @throws mibiblio.AutorNuloException Si el autor es null.
     */
    public List<Libro> getLibrosPorAutor(Autor autor) throws AutorNuloException, IOException{
        HashSet<Libro> librosHash = new HashSet();
        List<Libro> libros = obtenerLibrosFichero();
        for(Libro l:libros){
            if(l.esDeAutor(autor)){
                librosHash.add(l);
            }
        }
        return new ArrayList(librosHash);
    }
    
    /**
     * Deveuelve una lista de libros filtrando por el título. <br>
     * El título del libro debe contener todo parte del texto pasado como parámetro.
     * @param titulo Filtro a aplicar sobre el título del libro.
     * @return Conjunto de libros cuyo título contienen parte del texto indicado en el parámetro.
     */
    public List<Libro> getLibrosPorTitulo(String titulo) throws IOException{
        HashSet<Libro> librosHash = new HashSet();
        List<Libro> libros = obtenerLibrosFichero();
        for(Libro l:libros){
            if(l.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                librosHash.add(l);
            }
        }
        return new ArrayList(librosHash); 
    } 
    
    /**
     * Devuelve una lista ordenada alfabéticamente con todos los autores
     * de los que se tiene algún libro almacenado.
     * @return Lista de autores.
     */
    public List<Autor> getAutores() throws IOException{
        HashSet<Autor> autores = new HashSet();
        List<Libro> libros = obtenerLibrosFichero();
        for(Libro l:libros){
            autores.addAll(l.getAutores());
        }
        List<Autor> ordenados = new ArrayList(autores);
        //Los ordeno con un comparator
        Comparator<Autor> cmp = (Autor a1, Autor a2) -> {            
            String sA1 = a1.getApellidos().toLowerCase()+a1.getNombre();
            String sA2 = a2.getApellidos()+a2.getNombre();
            return sA1.compareToIgnoreCase(sA2);
        };
        
        Collections.sort(ordenados, cmp);
        return ordenados;        
    }
    

    @Override
    public String toString() {
        String librosS = "";
        List<Libro> libros;
        try {
            libros = obtenerLibrosFichero();
            for(Libro l:libros){
            librosS+="-----------------------------------------\n";
            librosS+=l;
            librosS+="\n-----------------------------------------\n";
        }
        } catch (IOException ex) {
            
        }
        
        return librosS;
    }
    
    
    
    
}
