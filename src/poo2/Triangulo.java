package poo2;

/**
 *
 * @author Samu
 */
public class Triangulo {
    
    double base;
    double altura;
    boolean valido;
    
    double getArea(){
        double area = base * altura / 2;
        return area;
    }
    
    double getPerimetro(){
        //Calculo del lado aplicando t. de Pit�goras
        double catetoBase = base/2;
        double lado = Math.sqrt((catetoBase*catetoBase)+(altura*altura));
        
        return (2*lado) + base;
    }
    
    void setBase(double l){
        base = l;
        valido = l>0;
    }
    
    void setAltura(double l){
        altura = l;
        valido = l>0;
    }
    
    public String toString(){
        return "Tri�ngulo de base "+base+" y altula "+altura+"\n\t�rea = "+getArea()+"\n\tPer�metro = "+getPerimetro();
    }
    
}
