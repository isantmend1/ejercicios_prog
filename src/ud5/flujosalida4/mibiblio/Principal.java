package ud5.flujosalida4.mibiblio;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {



    public static void main(String[] args) throws AutorNuloException, IOException {
       
        Biblioteca biblio = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        String op;
        do {
            //Menu
            System.out.println("\t- - Menú - -");
            System.out.println("(1)Ver todos los libros");
            System.out.println("(2)Ver todos los autores");
            System.out.println("(3)Buscar libros por autor");
            System.out.println("(4)Buscar libros por palabras del título");
            System.out.println("(5)Agregar libro");
            System.out.println("(6)Salir");
            System.out.print("Introduzca opción: ");
            op = sc.nextLine().trim();
            
            //Procesar entrada de usuario
            List<Libro> libs;
            switch (op) {
                case "1":
                    System.out.println(biblio);
                    break;
                case "2":
                    for (Autor a : biblio.getAutores()) {
                        System.out.println(a);
                    }
                    break;
                case "3":
                    System.out.print("Apellidos del autor: ");
                    String ap = sc.nextLine().trim();
                    System.out.print("Nombre del autor: ");
                    String nm = sc.nextLine().trim();
                    libs = biblio.getLibrosPorAutor(new Autor(ap, nm));
                    for (Libro l : libs) {
                        System.out.println("-----------------------------------------\n");
                        System.out.println(l);
                        System.out.println("\n-----------------------------------------\n");
                    }
                    break;
                case "4":
                    System.out.print("Título ( total o parcial ):  ");
                    op = sc.nextLine().trim();
                    libs = biblio.getLibrosPorTitulo(op);
                    for (Libro l : libs) {
                        System.out.println("-----------------------------------------\n");
                        System.out.println(l);
                        System.out.println("\n-----------------------------------------\n");
                    }
                    break;
                case "5":
                    System.out.println("Agregando LIBRO...");
                    ArrayList<Autor> auts = new ArrayList();
                    auts.add(new Autor("Garcia","Pedro"));
                    auts.add(new Autor("Lopez","Juan"));
                    Libro nuevo = new Libro("12-12225-666","La insoportable levedad del ser.",auts , LocalDate.now(), "DAM");
                    biblio.addLibro(nuevo);
                    System.out.println("Agregado libro\n "+nuevo);
                    
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    
                    break;

                default:
                    System.err.println("Opción incorrecta");
                    ;
            }
            
            //Limpiar pantalla
            System.out.print("Presione Enter para continuar...");
            sc.nextLine();
            limpiarPantalla();

        } while (!op.equals("6"));
    }

    private static void limpiarPantalla() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

}
