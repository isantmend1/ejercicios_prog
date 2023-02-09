package ud3.refuerzo.sesion1;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conversarPortero();

    }

    public static void conversarPortero() {
        Scanner sc = new Scanner(System.in);
        String entrada;
        //Creo un aforo de 100 con un nivel de alarma del 75% porque me da la gana ya que el enunciado no lo especifíca.
        Contador c = new Contador(100, 0.75);
        Portero portero = new Portero(c, 10);
        
        do {
            System.out.println("Hola, quieres salir o entrar?");
            entrada = sc.nextLine();
            switch (entrada) {
                case "entrar":
                    if (portero.pacienciaAgotada()) {
                        System.out.println("Fuera de aquí!");
                    } else {
                        System.out.println("Cuantos sois?");
                        entrada = sc.nextLine();
                        int num = Integer.parseInt(entrada);
                        if (portero.dejarPasar(num) != 0) {
                            System.out.println("Se ha alcanzado el aforo.");
                        } else {
                            System.out.println("podéis pasar");
                        }
                    }

                    break;
                case "salir":
                    System.out.println("Cuantos sois?");
                    entrada = sc.nextLine();
                    int num = Integer.parseInt(entrada);
                    portero.dejarSalir(num);
                    break;
                case "aobrtar programa":
                    //Aqui no hacemos nada, pero lo ponemos para que no entre por default.
                    break;
                default:
                    System.out.println("Me estás cabreando");
                    portero.confrontar(1);

            }

        } while (!entrada.equalsIgnoreCase("abortar programa"));
    }

}
