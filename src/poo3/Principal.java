package poo3;

import java.util.Scanner;
import poo3.ejercicio3.Coche;
import poo3.ejercicios1y2.Persona;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Principal {

    public static void main(String[] args) {
//        ejercicio2();
//        ejercicio3a();
        ejercicio3b();

    }

    public static void ejercicio1() {
        //TODO
    }

    public static void ejercicio2() {
        Scanner sc = new Scanner(System.in);
        String nombre, ap1, ap2;
        int nif, edad;
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido: ");
        ap1 = sc.nextLine();
        System.out.print("Apellido: ");
        ap2 = sc.nextLine();
        System.out.print("nif: ");
        nif = sc.nextInt();
        System.out.print("Edad: ");
        edad = sc.nextInt();

        Persona p1 = new Persona(nombre, ap1, ap2, edad, nif);
        System.out.println(p1);
        System.out.println("DNI completo: " + p1.getDNI());
    }

    public static void ejercicio3a() {

        Coche coche1 = new Coche();
        Coche coche2 = new Coche(false, 80, 0, 300, 80, 7);
//        2. Muestra el estado inicial de ambos coches.
        System.out.println(coche1);
        System.out.println(coche2);
//        3. Enciende ambos coches.
        coche1.arrancar();
        coche2.arrancar();
//        4. Utilizando un bucle avanza el coche1 y acelera hasta que alcances la mitad de su
//        velocidad máxima. Muestra por pantalla cuantos km han sido necesarios para alcanzar
//        dicha velocidad.
        double kmTotales1 = 0;
        while (coche1.getVelocidadActual() <= coche1.getVelocidadMax() / 2) {
            kmTotales1 += coche1.avanzar();
            coche1.acelerar();
        }
        System.out.println("Coche1 avanza " + kmTotales1 + "km");

//        5. Haz lo mismo que en el punto 4 con el coche2.
        double kmTotales2 = 0;
        while (coche2.getVelocidadActual() <= coche2.getVelocidadMax() / 2) {
            kmTotales2 += coche2.avanzar();
            coche2.acelerar();
        }

        System.out.println("Coche2 avanza " + kmTotales2 + "km");

//        6. Muestra el estado de ambos coches.
        System.out.println("***********************");
        System.out.println(coche1);
        System.out.println(coche2);

    }

    public static void ejercicio3b() {
        // 1. Crea los siguientes objetos:

        Coche c1 = new Coche(false, 0, 0, 300, 80, 4.5);
        Coche c2 = new Coche(false, 0, 0, 150, 110, 7);
        //2. Muestra el estado inicial de ambos coches.
        System.out.println("------- Coche 1 -------");
        System.out.println(c1);
        System.out.println("------- Coche 2 -------");
        System.out.println(c2);
        //3. Enciende ambos coches.
        c1.arrancar();
        c2.arrancar();
        //4. Utilizando un bucle avanza con el coche1 hasta que haya recorrido 1000km a la
        //máxima velocidad posible. Si el coche se queda sin combustible, debe rellenar todo el
        //depósito, arrancar y volver a acelerar todo lo que pueda.
        double km = 0;
        int repostar1 = 0, minutos1 = 0;
        while (km < 2000) {
            c1.acelerar();
            km += c1.avanzar();
            //Cada vez que avanzo lo hago durante 1 minuto
            minutos1++;
            if (!c1.isEncendido()) {
                //Repostar
                c1.setCombustible(c1.getCombustibleMax());
                repostar1++;
                c1.arrancar();
            }
        }
        //5. Haz lo mismo con el coche2.
        km = 0;
        int repostar2 = 0, minutos2 = 0;
        while (km < 2000) {
            c2.acelerar();
            km += c2.avanzar();
            //Cada vez que avanzo lo hago durante 1 minuto
            minutos2++;
            if (!c2.isEncendido()) {
                //Repostar
                c2.setCombustible(c2.getCombustibleMax());
                repostar2++;
                c2.arrancar();
            }
        }
        //6. Apaga ambos vehículos.
        c1.detener();
        c2.detener();
        //7. Al finalizar, por cada coche se mostrará por pantalla cuantas veces ha repostado y los
        //minutos que ha tardado en recorrer 1000km. También es deseable conocer el estado final
        //de cada vehículo.

        System.out.println("FINAL");
        System.out.println("El coche 1 a repostado " + repostar1 + " veces y ha tardado " + minutos1 + " minutos.");
        System.out.println(c1);
        System.out.println("El coche 2 a repostado " + repostar2 + " veces y ha tardado " + minutos2 + " minutos.");
        System.out.println(c2);
    }
}
