package ud4.ejerciciosED4;

/**
 * Representa un jugador que dispone de una serie de armas ordenadas con las que
 * puede realizar ataques a otros jugadores.
 * @author Samuel Loureiro Cardoso
 */
public class Jugador {
    private String nombre;
    private Cola<Arma> armas;
    private int salud;
    private Pila<Ataque> ataquesRealizados;

    public Jugador(String nombre, Cola<Arma> armas, int salud, Pila<Ataque> ataquesRealizados) {
        this.nombre = nombre;
        this.armas = armas;
        this.salud = salud;
        this.ataquesRealizados = ataquesRealizados;
    }
    /**
     *  Resta el daño del ataque pasado como parámetro a la salud del jugador.
     * @param ataque Ataque recibido.
     */
    public void recibirAtaque(Ataque ataque){
        salud-=ataque.getDanho();
        //Para evitar salud negativa.
        if(salud<0){
            salud = 0;
        }
    }
    
    /**
     * Utilizara un arma del jugador para realizar un ataque aleatorio al
     * jugador adversario. Al adversario se le restarán tantos puntos de salud
     * como indique el daño del ataque generado. Si el jugador se ha quedado sin
     * armas no infringirá daño alguno al adversario. Además, cada vez que se
     * realiza un ataque debe quedar registrado en la pila de ataquesRealizados.
     * Una vez utilizada un arma, el jugador ya no dispondrá de ella.
     * @param adversario Jugador al que se le realiza el ataque.
     * @return 
     */
    public int atacar(Jugador adversario){
        Ataque atac = armas.dequeue().ataqueRandom();
        int dano = 0;
        if(atac!=null){
            adversario.recibirAtaque(atac);
            ataquesRealizados.push(atac);
            dano = atac.getDanho();
        }
        return dano;
    }
    
    public boolean estaVivo(){
        return salud >0;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cola<Arma> getArmas() {
        return armas;
    }

    public void setArmas(Cola<Arma> armas) {
        this.armas = armas;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public Pila<Ataque> getAtaquesRealizados() {
        return ataquesRealizados;
    }

    public void setAtaquesRealizados(Pila<Ataque> ataquesRealizados) {
        this.ataquesRealizados = ataquesRealizados;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", armas=" + armas + ", salud=" + salud + ", ataquesRealizados=" + ataquesRealizados + '}';
    }
    
    
    
    
}
