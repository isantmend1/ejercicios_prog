
package ud3.poo2;

/**
 *
 * @author Samu
 */
public class Rectangulo {
    
    double base;
    double altura;
    boolean valido;
    
    double getArea(){
        double areaCuadrado = base * altura;
        return areaCuadrado;
    }
    
    double getPerimetro(){
        double preimetroCuadrado = base * 4;
        return preimetroCuadrado;
    }
    
    void setBase(double l){
        base = l;
        if(l>0){
            valido = true; 
        }else{
            valido = false;
        }
    }
    
    void setAltura(double l){
        altura = l;
        if(l>0){
            valido = true; 
        }else{
            valido = false;
        }
    }
    
    public String toString(){
        return "Rect�ngulo de base "+base+" y altula "+altura+"\n\t�rea = "+getArea()+"\n\tPer�metro = "+getPerimetro();
    }
    
}
