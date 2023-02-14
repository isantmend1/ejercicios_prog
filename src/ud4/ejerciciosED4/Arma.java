package ud4.ejerciciosED4;

import java.util.Random;

/**
 * Arma que puede realizar unos ataques determinados.
 * @author Samuel Loureiro Cardoso
 */
public class Arma {
    private String nombre;
    private ListaContigua<Ataque> ataques;

    /**
     * @param nombre Nombre del arma
     * @param ataques Ataques asociados al arma.
     */
    public Arma(String nombre, ListaContigua<Ataque> ataques) {
        this.nombre = nombre;
        this.ataques = ataques;
    }
    
    /**
     * Devuelve un ataque aleatorio del arma.
     * @return ataque.
     */
    public Ataque ataqueRandom(){
        Random rand = new Random();
        int ataqueRand = rand.nextInt(ataques.size());
        return ataques.getElementAt(ataqueRand);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaContigua<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ListaContigua<Ataque> ataques) {
        this.ataques = ataques;
    }

    @Override
    public String toString() {
        return "Arma{" + "nombre=" + nombre + ", ataques=" + ataques + '}';
    }
    
    
    
}
