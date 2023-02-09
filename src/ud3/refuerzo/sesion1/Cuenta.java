package ud3.refuerzo.sesion1;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Cuenta {

    private Persona titular;
    private Double saldo;
    public final static double DESCUBIERTO = 1000.0;

    public Cuenta(Persona titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public Cuenta(Persona titular) {
        this.titular = titular;

    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;

        }

    }
    
    public void retirar(double cantidad){
        if(cantidad>0){
            double resta = this.saldo - cantidad;
            if(resta > -Cuenta.DESCUBIERTO){
                this.saldo = resta;
            }
        }
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
