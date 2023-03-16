package ud5.flujosalida2;

import java.util.Objects;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Registro {
    private String nombre;
    private String ciudad;
    private int edad;

    public Registro(String nombre, String ciudad, int edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }
    
    /**
     * 
     * @param registroString formato nombre,ciudad,edad
     */
    public Registro(String registroString) throws Exception{
        String[] campos = registroString.split(",");
        if(campos.length!=3){
            throw new Exception("Formato incorrecto de registro.");
        }
        try {
            this.edad = Integer.parseInt(campos[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Formato incorrecto de registro. El tercer dato debe ser un entero.");
        }
        this.nombre = campos[0];
        this.ciudad = campos[1];
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.ciudad);
        hash = 59 * hash + this.edad;
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
        final Registro other = (Registro) obj;
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.ciudad, other.ciudad);
    }
    
    public String getRegistroString(){
        return nombre+","+ciudad+","+edad;
    }

    @Override
    public String toString() {
        return "\tnombre=" + nombre + "\n\tciudad=" + ciudad + "\n\tedad=" + edad;
    }
    
    
    
}
