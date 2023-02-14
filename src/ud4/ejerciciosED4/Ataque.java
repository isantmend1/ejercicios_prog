package ud4.ejerciciosED4;

/**
 * Ataque.
 * Un ataque se caracteriza por un nombre y puede infringir un daño.
 * @author Samuel Loureiro Cardoso
 */
public class Ataque {
    private String nombre;
    private int danho;

    /**
     * 
     * @param nombre Nombre del ataque
     * @param danho Cantidad de daño asociado al ataque.
     */
    public Ataque(String nombre, int danho) {
        this.nombre = nombre;
        this.danho = danho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanho() {
        return danho;
    }

    public void setDanho(int danho) {
        this.danho = danho;
    }

    @Override
    public String toString() {
        return "Ataque{" + "nombre=" + nombre + ", danho=" + danho + '}';
    }
    
    
    
}
