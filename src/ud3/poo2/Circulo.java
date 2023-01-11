package ud3.poo2;

/**
 *
 * @author Samu
 */
public class Circulo {
    
    double radio;
    boolean valido;
    
    double getArea(){
        double areaCuadrado = radio * radio * Math.PI;
        return areaCuadrado;
    }
    
    double getPerimetro(){
        double preimetroCuadrado = radio * 4;
        return preimetroCuadrado;
    }
    
    void setLado(double l){
        radio = l;
        if(l>0){
            valido = true; 
        }else{
            valido = false;
        }
    }
    
    public String toString(){
        return "C�rculo de radio "+radio+"\n\t�rea = "+getArea()+"\n\tPer�metro = "+getPerimetro();
    }
    
}
