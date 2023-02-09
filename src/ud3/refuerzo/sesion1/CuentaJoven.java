package ud3.refuerzo.sesion1;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class CuentaJoven {

    public final static double DESCUBIERTO = 1000.0;
    public final static int TOPE_JOVEN = 25;
    private Persona titular;
    private Double saldo;
    private double bonificacion;

    public CuentaJoven(Persona titular, double saldo, double bonificacio) {
        this.titular = titular;
        this.saldo = saldo;
        this.bonificacion = bonificacion;
    }

    public CuentaJoven(Persona titular, double bonificacion) {
        this.titular = titular;
        

    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;

        }

    }
    
    public void retirar(double cantidad){
        if(cantidad>0 && esTitularValido()){
            double resta = this.saldo - cantidad;
            if(resta > -CuentaJoven.DESCUBIERTO){
                this.saldo = resta;
            }
        }
    }
    
    public boolean esTitularValido(){
        boolean salida = false;
        if(this.titular.esMayorDeEdad()&&this.titular.getEdad()<CuentaJoven.TOPE_JOVEN){
            salida = true;
        }
        return salida;
    }

    public double calcularBonificacion(){
        return bonificacion*saldo;
    }
    
    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "titular=" + titular + ", saldo=" + saldo + '}';
    }

}
