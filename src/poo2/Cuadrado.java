
package poo2;

public class Cuadrado {
    
    double lado;
    boolean valido;
    
    double getArea(){
        double areaCuadrado = lado * lado;
        return areaCuadrado;
    }
    
    double getPerimetro(){
        double preimetroCuadrado = lado * 4;
        return preimetroCuadrado;
    }
    
    void setLado(double l){
        lado = l;
        if(l>0){
            valido = true; 
        }else{
            valido = false;
        }
    }

    public String toString(){
        return "Cuadrado de lado "+lado+". �rea="+getArea()+". Per�metro="+getPerimetro();
    }    
}

