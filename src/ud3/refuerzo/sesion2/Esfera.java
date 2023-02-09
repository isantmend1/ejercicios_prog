package ud3.refuerzo.sesion2;

import java.time.LocalDateTime;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Esfera {
    public final static double MAX_VOL = 500000.0;
    public final static double MIN_VOL = 1.0;
    private double radio;
    private LocalDateTime modificado;
    
    public Esfera(){
        this.radio = 5.0;
        this.modificado = LocalDateTime.now();
        
    }
    
    public double getVolumen(){
        double volumen = 4*Math.PI*Math.pow(radio, 3)/3;
        return volumen;  
        
    }
    
    
    
    public double getArea(){
        double area = 4*Math.PI*Math.pow(radio, 2);
        return area;
    }
    
    public boolean dilatar(){
        boolean salida = true;
        this.radio++;
        if(getVolumen()<Esfera.MAX_VOL){
            this.radio--;
            salida = false;
        }else{
            this.modificado = LocalDateTime.now();
        }
        return salida;
    }
    
    public boolean contraer(){
        
        boolean salida = true;
        this.radio--;
        if(getVolumen()<Esfera.MIN_VOL){
            this.radio++;
            salida = false;
        }else{
            this.modificado = LocalDateTime.now();
        }
        return salida;
        
    }
    
    public  Esfera getMegaEsfera(){
        Esfera nueva = new Esfera();
        double x = 3*Esfera.MAX_VOL/(4*Math.PI);
        double radioMax = Math.cbrt(x);
        
        nueva.setRadio(radioMax);
        return nueva;
    }
    
    public static Esfera getNanoEsfera(){
        Esfera nueva = new Esfera();
        double x = 3*Esfera.MIN_VOL/(4*Math.PI);
        double radioMin = Math.cbrt(x);
        nueva.setRadio(radioMin);
        return nueva;
    }
    
    public void setRadio(double radio){
        this.radio = radio;
    }

    @Override
    public String toString() {
        String formato = "Esfera de radio "+this.radio+" cm";
        formato+="\nVolumen: "+getVolumen()+" cm3";
        formato+="\nÁrea: "+getArea()+" cm2";
        String fecha = modificado.getDayOfMonth()+"/"+modificado.getMonthValue()+"/"+modificado.getYear()+" "+modificado.getHour()+":"+modificado.getMinute()+":"+modificado.getSecond();
        formato+="\nÚltima modificación: "+fecha;
        return formato;
    }
    
    
}
