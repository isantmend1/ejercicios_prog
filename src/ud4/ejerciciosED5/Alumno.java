package ud4.ejerciciosED5;

import java.util.Objects;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Alumno {
    private String nombre;
    private String dni;
    private Double nota;

    public Alumno(String nombre, String dni, Double nota) {
        this.nombre = nombre;
        this.dni = dni;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.dni);
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
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.dni, other.dni);
    }
    
    

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", dni=" + dni + ", nota=" + nota + '}';
    }
    
    
    
}
