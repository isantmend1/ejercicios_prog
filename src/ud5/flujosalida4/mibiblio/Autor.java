package ud5.flujosalida4.mibiblio;

import java.util.Objects;


class Autor {
    
    private String nombre;
    private String apellidos;

    public Autor(String apellidos, String nombre) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    public Autor(String autorFromCSV){
        //TODO
        String[] aut = autorFromCSV.split(",");
        this.nombre = aut[1].trim();
        this.apellidos = aut[0].trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre.toUpperCase());
        hash = 71 * hash + Objects.hashCode(this.apellidos.toUpperCase());
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nombre.toUpperCase(), other.nombre.toUpperCase())) {
            return false;
        }
        return Objects.equals(this.apellidos.toUpperCase(), other.apellidos.toUpperCase());
    }

    
    public String getAutorformatoCSV(){
        return apellidos+", "+nombre;
    }
    

    @Override
    public String toString() {
        return apellidos+", "+nombre;
    }
    
    
    
}
