
package poo3.ejercicio3;

/**
 *
 * @author alumno
 */
public class Coche {
    private boolean encendido;
    private double combustible;
    private double velocidadActual;
    private double velocidadMax;
    private double combustibleMax;
    private double consumo;

    public Coche(boolean encendido, double combustible, double velocidadActual, double velocidadMax, double combustibleMax, double consumo) {
        this.encendido = encendido;
        this.combustible = combustible;
        this.velocidadActual = velocidadActual;
        this.velocidadMax = velocidadMax;
        this.combustibleMax = combustibleMax;
        this.consumo = consumo;
    }

    public Coche() {        
        this.encendido = false;
        this.velocidadActual = 0;
        this.velocidadMax = 230;
        this.combustibleMax = 100;
        this.combustible = combustibleMax/2;
        this.consumo = 5;
    }
    
    public boolean arrancar(){
        boolean retorno = false;
        if(combustible > 0){
            encendido = true;
            retorno = true;
        }
        
        return retorno;
    }
    
    public boolean acelerar(){
        boolean retorno = false;
        double sumaV = velocidadActual+10;
        if(encendido && sumaV<velocidadMax){
            velocidadActual = sumaV;
            retorno = true;
        }
        
        return retorno;
    }
    
    public boolean decelearar(){
        boolean retorno = false;
        double restaV = velocidadActual-5;
        if(encendido && restaV>=0){
            velocidadActual = restaV;
            retorno = true;
        }
        
        return retorno;
    }
    
    public double avanzar(){        
        double km = 0;
        km = velocidadActual/60; 
        // l/100km
        if(combustible >= ((km * consumo)/100)){
            combustible -= (km * consumo)/100;
            
        }else{
            detener();
            km = 0; 
        }
        
        return km;        
    }
    
    public void detener(){
        encendido = false;
        velocidadActual = 0;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public double getCombustibleMax() {
        return combustibleMax;
    }

    public void setCombustibleMax(double combustibleMax) {
        this.combustibleMax = combustibleMax;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    
    public String toString() {
        return "Coche{" + "encendido=" + encendido + ", combustible=" + combustible + ", velocidadActual=" + velocidadActual + ", velocidadMax=" + velocidadMax + ", combustibleMax=" + combustibleMax + ", consumo=" + consumo + '}';
    }

   
    
    
    
    
    
    
}
