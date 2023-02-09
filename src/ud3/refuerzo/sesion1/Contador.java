
package ud3.refuerzo.sesion1;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Contador {
    private int topeAforo;
    private int aforo;
    private double nivelAlarma;
    private boolean alarma;
    
    public Contador(int aforoMaximo, double nivelAlarma){
        this.topeAforo = aforoMaximo;
        this.aforo = 0;
        this.nivelAlarma = nivelAlarma;
        this.alarma = false;
    }

    public Contador(int topeAforo, int aforo, double nivelAlarma) {
        this.topeAforo = topeAforo;
        if(aforo>topeAforo){
            this.aforo = topeAforo;
        }else{
            this.aforo = aforo;
        }
        
        this.nivelAlarma = nivelAlarma;
        //TODO AFORO
        double topePersonasAlarma = topeAforo * nivelAlarma;
        if(aforo>=topePersonasAlarma){
            alarma = true;
        }else{
            alarma = false;
        }
        
    }

    public int getTopeAforo() {
        return topeAforo;
    }

    public void setTopeAforo(int topeAforo) {
        this.topeAforo = topeAforo;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public double getNivelAlarma() {
        return nivelAlarma;
    }

    public void setNivelAlarma(double nivelAlarma) {
        this.nivelAlarma = nivelAlarma;
    }
    
    
    
    
    public boolean aumentar(){
        boolean salida = false;
        if(this.aforo < this.topeAforo){            
            this.aforo++;
            salida = true;
        }
        
        double topePersonasAlarma = topeAforo * nivelAlarma;
        if(aforo>=topePersonasAlarma){
            alarma = true;
        }
        return salida;
    }
    
    public boolean reducir(){
        boolean salida = false;
        if(this.aforo > 0){            
            this.aforo--;
            salida = true;
        }
        double topePersonasAlarma = topeAforo * nivelAlarma;
        if(aforo<topePersonasAlarma){
            alarma = false;
        }
        return salida;
    }
    
    public boolean isAlarma(){      
        
        return this.alarma;
    }

    @Override
    public String toString() {
        return "Contador{" + "topeAforo=" + topeAforo + ", aforo=" + aforo + ", nivelAlarma=" + nivelAlarma + ", alarma=" + alarma + '}';
    }
    
    
    
    
}
