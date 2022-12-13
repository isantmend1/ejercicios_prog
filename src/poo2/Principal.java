package poo2;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        //Descomentar para probar cada apartado del ejercicio
//        apartado1();
//        apartado2();
//        apartado3();
//        apartado4();
//        apartado5();
//        apartado6();
        apartado7();
    }
    /**
     * Instancia un objeto de la clase cuadrado de lado 6.0 y muestra por consola su per�metro y su �rea.
     */
    public static void apartado1(){
        
        Cuadrado cuad = new Cuadrado();
        cuad.lado = 6.0;
        System.out.println("Per�metro: "+cuad.getPerimetro());
        System.out.println("�rea: "+cuad.getArea());
    }
    
    /**
     *  Instancia un objeto de la clase c�rculo de radio 6.0 y muestra por consola su per�metro y su �rea
     */
    public static void apartado2(){
        Circulo cir = new Circulo();
        cir.radio = 6.0;
        System.out.println("Per�metro: "+cir.getPerimetro());
        System.out.println("�rea: "+cir.getArea());
    }
    
    /**
     * Instancia un objeto de la clase rect�ngulo de base 10.0 y altura 4.0 y muestra por consola su per�metro y su �rea.
     */
    public static void apartado3(){
        Rectangulo rec = new Rectangulo();
        rec.base = 10.0;
        rec.altura = 4.0;
        System.out.println("Per�metro: "+rec.getPerimetro());
        System.out.println("�rea: "+rec.getArea());
    }
    
    /**
     *  Instancia un objeto de la clase tri�ngulo de base 5.0 y altura 7.5 y muestra por consola su per�metro y su �rea.

     */
    public static void apartado4(){
        Triangulo trian = new Triangulo();
        trian.setBase(5.0);
        trian.setAltura(7.5);
        System.out.println("Per�metro: "+trian.getPerimetro());
        System.out.println("�rea: "+trian.getArea());
    }
    
    /**
     *  Muestra el �rea y el per�metro de los c�rculos con radio de 1.0 a 100.0
     */
    public static void apartado5(){
        for(int i=1;i<=100;i++){
            Circulo cir = new Circulo();
            cir.radio = i;
            System.out.println(cir);
        }
        
    }
    
    /**
     *  Muestra el �rea y el per�metro de los tri�ngulos de base 10.0 y altura variable de -20.0 hasta 20.0. 
     * Para los tri�ngulos con atributos no v�lidos se debe mostrar un mensaje 
     * �No es posible calcular el �rea para un tri�ngulo de base b y altura a" (siendo a y b la altura y la base del tri�ngulo
     */
    public static void apartado6(){
        for(int i= -20;i<=20;i++){
            Triangulo t = new Triangulo();
            t.setBase(10.0);
            t.setAltura(i);
            if(t.valido){
                System.out.println(t);
            }else{
                System.out.println("No es posible calcular el �rea para un tri�ngulo de base %f y altura %f".formatted(t.base,t.altura));
            }
        }
    }
    
    /**
     *  Crea un cuadrado, un tri�ngulo, un circulo y un rect�ngulo con datos introducidos por el usuario. 
     * A continuaci�n devuelve los datos de cada figura y la suma de sus �reas
     */
    public static void apartado7(){
        Scanner sc = new Scanner(System.in);
        //Creo los objetos vac�os.
        Triangulo t = new Triangulo();
        Circulo cir = new Circulo();
        Cuadrado cua = new Cuadrado();
        Rectangulo r = new Rectangulo();
        //Interacci�n con el usuario
        System.out.println("--Creando tri�ngulo--");
        System.out.print("Base: ");
        t.setBase(sc.nextDouble());
        System.out.print("Altura: ");
        t.setAltura(sc.nextDouble());
        
        System.out.println("--Creando c�rculo--");
        System.out.print("Radio: ");
        cir.radio = sc.nextDouble();
        
        System.out.println("--Creando rect�ngulo--");
        System.out.print("Base: ");
        r.base = sc.nextDouble();
        System.out.print("Altura: ");
        r.altura = sc.nextDouble();
        
        System.out.println("--Creando cuadrado--");
        System.out.print("Lado: ");
        cua.lado = sc.nextDouble();
        
        //Salida
        System.out.println("--SALIDA--");
        System.out.println(t+"\n"+cir+"\n"+r+"\n"+cua);
        System.out.println("�rea total="+(t.getArea()+cir.getArea()+r.getArea()+cua.getArea()));
        
    }
}

