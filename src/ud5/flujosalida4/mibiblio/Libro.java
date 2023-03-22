package ud5.flujosalida4.mibiblio;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Libro {
    private String isbn;
    private String titulo;
    private List<Autor> autores;
    private LocalDate publicacion;
    private String editorial;

    public Libro(String isbn, String titulo, List<Autor> autores, LocalDate publicacion, String editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores!=null?autores:new ArrayList();
        this.publicacion = publicacion;
        this.editorial = editorial;
    }
    
    /**
     * ISBN;Titulo;fecha;autores (separadoso por -)
     * @param lineaCSV 
     */
    public Libro(String lineaCSV){
        String[] campos = lineaCSV.split(";");
        this.isbn = campos[0];
        this.titulo = campos[1];
        this.publicacion = LocalDate.parse(campos[2], DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        autores = new ArrayList();
        if(campos.length==4){
            String[] autors = campos[3].split("-");
            for(String s : autors){
                autores.add(new Autor(s));
            }
        }
        
        this.editorial = null;
        
    }

    /**
     * Devuelve un valor lógico indicando si el autor pasado es uno de los 
     * autores del libro.
     * @param autor Autor a comprobar.
     * @return True si el libro ha sido escrito por el autor
     * @throws AutorNuloException Se escala la excepción si el autor pasado es null.
     */
    public boolean esDeAutor(Autor autor) throws AutorNuloException{
        if(autor==null){
            throw new AutorNuloException();
        }
        return autores.contains(autor);
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }


    public LocalDate getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(LocalDate publicacion) {
        this.publicacion = publicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.isbn);

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
        final Libro other = (Libro) obj;
        
        return Objects.equals(this.isbn, other.isbn);
    }
    
    public String getLibroformatoCSV(){
        String lineaCSV=this.isbn+";";
        lineaCSV+=this.titulo+";";
        lineaCSV+=publicacion.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"))+";";
        for(Autor a :this.autores){
            lineaCSV+=a.getAutorformatoCSV()+"-";
        }
        if(!this.autores.isEmpty())
            lineaCSV = lineaCSV.substring(0, lineaCSV.length()-1);
        
        
        return lineaCSV;
    }

    @Override
    public String toString() {
        String autores="";
        for(Autor a : this.autores){
            autores += "\t"+a+"\n";
        }
        if(autores.equals(""))
            autores = "\tAnónimo\n";
        String auxEd = this.editorial!=null?this.editorial:"";
        return titulo+"\n"+autores+auxEd+" ("+publicacion.getYear()+")\n"+isbn;
    }
    
   
    
    

    
    
}
