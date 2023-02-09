package ud3.refuerzo.sesion1;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Portero {
    private Contador contador;
    private int limitePaciencia;
    private int pacienciaActual;

    public Portero(Contador contador, int limitePaciencia) {
        this.contador = contador;
        this.limitePaciencia = limitePaciencia;
        pacienciaActual = 0;
    }
    
    public int dejarPasar(int personas){
        int noPasan = personas;
        while(noPasan>0
                &&pacienciaActual<limitePaciencia
                &&contador.aumentar()
                ){
            noPasan--;
            if(contador.isAlarma()){
                pacienciaActual++;
            }
        }
        
        return noPasan;
    }
    
    public void dejarSalir(int personas){
        while(personas>0 && contador.reducir()){
            personas--;
        }
        
        if(!contador.isAlarma()){
            pacienciaActual=0;
        }
        
    }
    
    public void confrontar(int personas){
        pacienciaActual += personas*2;
    }
    
    public boolean pacienciaAgotada(){
        return pacienciaActual>=limitePaciencia;
    }

    @Override
    public String toString() {
        return pacienciaActual+"/"+limitePaciencia;
    }
    
    
    
    
}
