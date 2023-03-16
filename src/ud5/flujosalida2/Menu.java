package ud5.flujosalida2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Menu {

    public final static String RUTA_FICHERO = "ficheros/registros.txt";

    public static void main(String[] args) {

        String menu = "1.Añadir un nuevo registro.\n"
                + "2.Mostrar todos los registros.\n"
                + "3.Buscar un registro.\n"
                + "4.Modificar un registro.\n"
                + "5.Eliminar un registro.\n"
                + "6.Salir del programa.";

        Scanner sc = new Scanner(System.in);
        String entrada;
        try {
            System.out.println(menu);
            while (!(entrada = sc.nextLine()).equals("6")) {

                switch (entrada) {
                    case "1":
                        //Alta
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ciudad: ");
                        String ciudad = sc.nextLine();
                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(sc.nextLine());
                        addRegistro(new Registro(nombre, ciudad, edad));
                        break;
                    case "2":
                        //Listar
                        for(Registro r: getRegistros()){
                            System.out.println(r+"\n-------------");
                        }
                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;

                    default:
                        System.err.println("Opción incorrecta.");

                }
                System.out.println(menu);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado.");
        }
    }

    public static void addRegistro(Registro r) throws FileNotFoundException {
        //Abrir fichero con append
        FileOutputStream fos = new FileOutputStream(RUTA_FICHERO, true);
        PrintWriter pw = new PrintWriter(fos);
        //Escribir registro por el final
        pw.println(r.getRegistroString());
        //Cerrar el flujo
        pw.close();
    }

    public static List<Registro> buscarRegistroPorNombre(String nombre) throws FileNotFoundException {
        List<Registro> regs = getRegistros();
        List<Registro> ret = new ArrayList();
        for (Registro r : regs) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                regs.add(r);
            }
        }
        return ret;

    }

    public static List<Registro> getRegistros() throws FileNotFoundException {
        List<Registro> regs = new ArrayList();
        //Abrir flujo lectura
        FileInputStream fis = new FileInputStream(RUTA_FICHERO);
        Scanner sc = new Scanner(fis);
        //Leer buscar y agregar a regs
        while (sc.hasNext()) {
            try {
                Registro r = new Registro(sc.nextLine());
                regs.add(r);

            } catch (Exception ex) {
                continue;
            }
        }
        //Cerrar flujo
        sc.close();
        return regs;
    }

    public static int eliminarRegistro(Registro r) throws FileNotFoundException {
        int eliminados = 0;
        List<Registro> regs = getRegistros();
        //Busco y quito de la lista
        while (regs.contains(r)) {
            regs.remove(r);
            eliminados++;
        }

        //Sobrescribo fichero
        PrintWriter pw = new PrintWriter(RUTA_FICHERO);
        for (Registro reg : regs) {
            pw.println(reg.getRegistroString());
        }
        //Cerrar
        pw.close();
        return eliminados;
    }

    public static int modificarRegistro(Registro old, Registro nuevo) throws FileNotFoundException {
        int veces = eliminarRegistro(old);
        for (int i = 0; i < veces; i++) {
            addRegistro(nuevo);
        }

        return veces;
    }

}
