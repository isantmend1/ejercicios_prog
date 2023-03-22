package ud5.flujosalida4.mibiblio;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class BibliotecaLoader {

    /**
     * Devuelve una biblioteca con una colección seudoaletoriad de libros.
     * @param numEjemplares Cantidad de libros que tendrá la biblioteca.
     * @return Biblioteca con el número de libros indicado en <i>numEjemplares</i>
     */
    public static Biblioteca getBlbliotecaRandom(int numEjemplares) throws IOException {
        Biblioteca b = new Biblioteca();
        
        List<Autor> autores = loadAutores();
        List<String> titulos = loadTitulos();
        String[] editoriales = loadEditoriales();
        Random rand = new Random();
        int copias = 1;
        int ed = 0;
        for (String t : titulos) {
            Libro l = new Libro(getRandomIsbn(), 
                    t, 
                    getRandomAutores(autores), 
                    getRandomFecha(),
                    editoriales[ed%editoriales.length]);
                copias = rand.nextInt(5);

            while(copias!=0){
                b.addLibro(l);
                if(b.getNumLibros()>=numEjemplares){
                    return b;
                }
                copias--;
            }
            ed++;
        }

        return b;

    }
    
    /**
     * Devuelve una lista de seudoaleatoria de libros cuyos autores podrán ser uno
     * o varios de los usuarios del sistema (windows).
     * @return Lista seudoaleatoria de libros.
     */
    public static List<Libro> getWindowsBaseLibros(){
        List<Libro> libros = new ArrayList();
        List<Autor> autores = getWindowsUsersAsAutores();
        List<String> titulos = loadTitulos();
        String[] editoriales = loadEditoriales();
        int ed = 0;
        for (String t : titulos) {
            Libro l = new Libro(getRandomIsbn(), 
                    t, 
                    getRandomAutores(autores), 
                    getRandomFecha(),
                    editoriales[ed%editoriales.length]);
               ed++;
               libros.add(l);
        }
        
        return libros;
    }
    
    /**
     * Devuelve una lista de seudoaleatoria de libros cuyos autores podrán ser uno
     * o varios de los usuarios del sistema (linux).
     * @return Lista seudoaleatoria de libros.
     */
    public static List<Libro> getLinuxBaseLibros(){
        List<Libro> libros = new ArrayList();
        List<Autor> autores = getLinuxUsersAsAutores();
        List<String> titulos = loadTitulos();
        String[] editoriales = loadEditoriales();
     
        int ed = 0;
        for (String t : titulos) {
            Libro l = new Libro(getRandomIsbn(), 
                    t, 
                    getRandomAutores(autores), 
                    getRandomFecha(),
                    editoriales[ed%editoriales.length]);
               ed++;
               libros.add(l);
        }
        
        return libros;
    }
    
    /**
     * Crea una lista de autores correspondiente con los usuarios del sistema.
     * Solo válido para sistemas Windows.
     * @return Lista de autores.
     */
    public static List<Autor> getWindowsUsersAsAutores(){
        List<Autor> autores = new ArrayList();
        String s;
        Process p;
        try {
            p = Runtime.getRuntime().exec("net user");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            boolean esperar = true;
            ArrayList<String> entradas = new ArrayList();
            
            while ((s = br.readLine()) != null){
                if(esperar){
                    esperar=!s.contains("---");
                    continue;
                }
                entradas.add(s);                
            }
            p.waitFor();
            p.destroy();
            
            String[] usuarios;
            for(int i=0; i<entradas.size()-2;i++){
                usuarios = entradas.get(i).split(" +");
                for(String user: usuarios){
                    autores.add(new Autor(user,"Usuario-windows"));
                }                
            }
                
            
        } catch (Exception e) {
            System.err.println("Error recuperando usuarios de windows.");
        }
        return autores;
    }
    
    /**
     * Crea una lista de autores correspondiente con los usuarios del sistema.
     * Solo válido para sistemas linux.
     * @return Lista de autores.
     */
    public static List<Autor> getLinuxUsersAsAutores(){
        List<Autor> autores = new ArrayList();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("/etc/passwd");
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine())!=null){
                autores.add(new Autor(linea.split(":")[0],"Usuario-linux"));
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error detectando el fichero.");
        } catch (IOException ex) {
            System.err.println("Error de lectura");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.err.println("Error cerrando el flujo");
            }
        }
        return autores;
        
    }

    private static  List<Autor> getRandomAutores(List<Autor> autoresTodos) {
        Random rand = new Random();
        int num = rand.nextInt(4);
        
        HashSet<Integer> set = new HashSet();
        while (num != 0) {
            int pos = rand.nextInt(autoresTodos.size());
            set.add(pos);            
            num--;
        }
        ArrayList<Autor> auts = new ArrayList();
        for(int i : set){
            auts.add(autoresTodos.get(i));
        }
        return auts;
    }

    private static String getRandomIsbn() {
        String isbn = "";
        Random rand = new Random();
        isbn += String.format("%03d-", rand.nextInt(1000));
        isbn += rand.nextInt(10) + "-";
        isbn += String.format("%02d-", rand.nextInt(100));
        isbn += String.format("%06d-", rand.nextInt(1000000));
        isbn += rand.nextInt(10);

        return isbn;

    }

    private static LocalDate getRandomFecha() {
        Random rand = new Random();
        return LocalDate.ofYearDay(rand.nextInt(100)+1920, rand.nextInt(364)+1);
    }

    private static List<Autor> loadAutores() {
        List<Autor> autores = new ArrayList();
        autores.add(new Autor("Cuesta Morales","Drope"));
        autores.add(new Autor("Laza Fidalgo","Liaros"));
        autores.add(new Autor("González Rufino","Cionencarna"));
        autores.add(new Autor("Pérez-García Schofield","Saltabar"));
        autores.add(new Autor("Mendez Penin","Tonioan"));
        autores.add(new Autor("Fontella","Noar"));
        autores.add(new Autor("Olivieri","Vidda"));
        autores.add(new Autor("Bueno Galán","María José"));
        return autores;
    }

    private static List<String> loadTitulos() {
        ArrayList<String> titulos = new ArrayList();
        titulos.add("Dolores ...  de cabeza o El colegial atrevido : parodia de la ópera española 'La Dolores' en un acto y tres cuadros y medio, original y en verso");
        titulos.add("Una aldeana aprovechada");
        titulos.add("Lo que no son pesetas son puñetas");
        titulos.add("El adivino oriental");
        titulos.add("El rascacielos");
        titulos.add("Aspasia o la liberación de la Mujer");
        titulos.add("El amor a los hijos");
        titulos.add("Música de piedra");
        titulos.add("La cuerda del reloj");
        titulos.add("Una señora de la limpieza");
        titulos.add("Una feligresa impenitente");
        titulos.add("Un lord inglés");
        titulos.add("Yo, Judas Iscariote");
        titulos.add("Cartas anónimas");
        titulos.add("Monólogo total");
        titulos.add("La sanguinaria");
        titulos.add("Yo fui novio de la Lewinsky");
        titulos.add("El Conde Drácula tiene SIDA");
        titulos.add("Una alcaldesa feminista");
        titulos.add("Larra, dolor por España");
        titulos.add("¡¡Horror, terror y furor!! o Víctimas a granel : Disparate cómico-bufo-espeluznante en un acto, original en verso y prosa ...");
        titulos.add("Ángel Guerra");
        titulos.add("El valle de los cipreses en 'La Galatea' de Cervantes");
        titulos.add("Tensión de valores (honor-riqueza) en 'La prueba de los amigos' de Lope de Vega");
        titulos.add("Media docena de cuentos de Lope de Vega");
        titulos.add("América en Galdós");
        titulos.add("La densidad genérica y la novela del ochocientos : Los pazos de Ulloa de Emilia Pardo Bazán");
        titulos.add("Traducción e historia del teatro : el siglo XVIII español");
        titulos.add("Histeria y narración en 'La Regenta'");
        titulos.add("El escepticismo filosófico de don Juan Valera");
        titulos.add("Reducción de NOx en efluentes gaseosos mediante materiales de potasio / carbón conformados. Desarrollo de un modelo cinético");
        titulos.add("Luis Antonio de Villena : la belleza impura");
        titulos.add("Pedro Orgambide, in memoriam");
        titulos.add("Cuento patoso");
        titulos.add("Don Pirulí");
        titulos.add("Culinaría");
        titulos.add("Canción de la rana");
        titulos.add("Cucú");
        titulos.add("Novela de Rinconete y Cortadillo [versión Porras de la Cámara]");
        titulos.add("Navidad");
        titulos.add("El paranocaidas");
        titulos.add("Pelines en Mayo");
        titulos.add("Canciones para niños");
        titulos.add("El corazón del muñeco");
        titulos.add("El niño desmemoriado");
        titulos.add("Pelines Cazador");
        titulos.add("Vida y fin de 'Tranquilón' : el triste camaleón");
        titulos.add("Deporte celestial : historieta en verso");
        titulos.add("En la Plaza de Oriente");
        titulos.add("Recital poético de Ramón Fernández Larrea");
        titulos.add("Llegir Tirant lo Blanc (I i II)");
        titulos.add("[Prólogo a Postfígaro: artículos no coleccionados de Mariano José de Larra (Fígaro)]");
        titulos.add("Sonetos");
        titulos.add("La doctrina cavalleresca lul·liana en l'obra de Joanot Martorell : l'episodi de l'ermità");
        titulos.add("El 'Tirant lo Blanc' i la 'Història del rei Omar an-Numan'");
        titulos.add("Tirant lo Blanch [British Library]");
        titulos.add("Funus triumpho simillimum? : consideracions al voltant de la mort i del dol per Tirant lo Blanc");
        titulos.add("Miguelito, el perro Pachón y Bruno el oso jacarondoso");
        titulos.add("Emilia Pardo Bazán y José María de Pereda: algunas cartas inéditas");
        titulos.add("La primera redacción, autógrafa e inédita de los 'apuntes autobiográficos' de Emilia Pardo Bazán");
        titulos.add("Un inédito de Emilia Pardo Bazán : 'Apuntes de un viaje. De España a Ginebra (1873)'");
        titulos.add("Los libros de viajes de Emilia Pardo Bazán : el hallazgo del género en la crónica periodística");
        titulos.add("Feijoo en el siglo XIX (Concepción Arenal, Emilia Pardo Bazán y Marcelino Menéndez Pelayo)");
        titulos.add("Los verdaderos sabios de la poesía");
        titulos.add("Emilia Pardo Bazán y el Naturalismo");
        titulos.add("'La Tribuna', de Emilia Pardo Bazán, y un posible modelo real de su protagonista");
        titulos.add("La volupté des mots dans Clélie de Mademoiselle de Scudéry");
        titulos.add("Desarrollo y diferenciación de la hipófisis en vertebrados");
        titulos.add("Mesa redonda : materiales educativos [Resumen]");
        titulos.add("Las mocedades del Cid");
        titulos.add("Diálogo de mujeres");
        titulos.add("Hacia el modelo de novela regional : 'El sabor de la tierruca' de José María de Pereda");
        titulos.add("Out of the Garden and into the City : José María de Pereda's Pedro Sánchez");
        titulos.add("Schopenhauer, Zola y Clarín");
        titulos.add("Peonza : Revista de literatura infantil y juvenil");
        titulos.add("La perfecta casada");
        titulos.add("Obras escogidas");
        titulos.add("La familia de Alvareda : novela de costumbres populares");
        titulos.add("Comedia del Príncipe Ynocente");
        titulos.add("Presentación del Diccionario de Mímica y Dactilología de Francisco Fernández Villabrille");
        titulos.add("Epistolario espiritual");
        titulos.add("Educadores: Revista de la Federación Española de Religiosos de Enseñanza, núm. 67 (marzo-abril 1972).Teatro infantil y juvenil");
        titulos.add("Libros de teatro al servicio de la educación");
        titulos.add("En torno al IV Congreso Mundial de Teatro Infantil y Juvenil");
        titulos.add("La formación del profesorado de dramatización para la E.G.B.");
        titulos.add("El teatro, cenicienta de la literatura infantil");
        titulos.add("Las nuevas corrientes de la literatura infantil");
        titulos.add("La dramatización, eje de la expresión dinámica");
        titulos.add("Historia crítica del teatro infantil español");
        titulos.add("La educación en el futuro. Tomo I");
        titulos.add("El copo de nieve");
        titulos.add("Aproximación a la literatura infantil");
        titulos.add("La literatura infantil en la escuela");
        titulos.add("Ante el neologismo");
        titulos.add("Palabra y juego en los libros para niños");
        titulos.add("Lo infantil y lo juvenil en la literatura");
        titulos.add("La propuesta de modelos en la literatura infantil");
        titulos.add("La dramatización en los programas de literatura infantil");
        titulos.add("Adquisición y desarrollo del lenguaje en Preescolar y Ciclo Inicial");
        titulos.add("Presencia de la literatura en preescolar y en E.G.B.");
        titulos.add("En torno a la literatura infantil");
        titulos.add("Diálogo de doctrina cristiana");
        titulos.add("La literatura infantil : los límites de la didáctica");
        titulos.add("La literatura de transición");
        titulos.add("Los contenidos del programa de literatura infantil");
        titulos.add("La contribución hispanoamericana al desarrollo del estudio de la literatura infantil en España");
        titulos.add("Aproximación a la poesía infantil : tres poetas, tres modos");
        titulos.add("La literatura infantil en la construcción de la conciencia del niño");
        titulos.add("Mundos Imaginarios. Entrevista a Ana Pelegrín");
        titulos.add("La lira argentina o Colección de las piezas poéticas dadas a luz en Buenos Aires durante la guerra de su independencia");
        titulos.add("Crónica de los Señores Reyes Católicos Don Fernando y Doña Isabel de Castilla y de Aragón");
        titulos.add("Mejora en la eficacia de los quelatos de hierro sintéticos a través de sustancias húmicas y aminoácidos");
        titulos.add("Emilia Pardo Bazán en el epistolario de Marcelino Menéndez Pelayo");
        titulos.add("Iluminismo e ideal burgués en 'El sí de las niñas'");
        titulos.add("Novela de La tia fingida [versión Porras de la Cámara por Franceson-Wolf]");
        titulos.add("Nobela de La Tia Fingida [versión del Códice A2-141-4 de la Biblioteca Colombina; folios 77-a a 88-a]");
        titulos.add("Homenaje a Jorge Luis Borges");
        titulos.add("Interacción del mundo artístico y psicológico en 'Doña Luz' de Juan Valera");
        titulos.add("Una nota a la correspondencia de Valera : la fuente griega de una estrofa alemana citada por don Juan");
        titulos.add("¿Qué dice usted? Que es otra cosa");
        titulos.add("El Víctor Hugo romántico en la España realista");
        titulos.add("Del hueso de una aceituna : (o qué será eso de la poesía infantil)");
        titulos.add("La terapia de los cuentos");
        titulos.add("Cuentos de miedo, ¿por qué?");
        titulos.add("Al salir del paraíso");
        titulos.add("El Comendador Mendoza ; La cordobesa ; Un poco de crematística");
        titulos.add("Bibliografía de Juan Valera");
        titulos.add("Soldadesca");
        titulos.add("Sobre los ideales neoclásicos y su realización escénica");
        titulos.add("Lletra feta per Petrarcha: traducció catalana que es conserva al Ms. 7811. Lletres de Batalla, de la Biblioteca Nacional de Madrid");
        titulos.add("Lletra de Francesc Ferrer a Joan Roís de Corella, conservada al Ms. 7811. Lletres de Batalla, de la Biblioteca Nacional de Madrid");
        titulos.add("Guillem de Varoic conservat al Ms. 7811. Lletres de Batalla de la Biblioteca Nacional de Madrid");
        titulos.add("Correspondència entre Joanot Martorell i Joan de Monpalau conservada al Ms. 7811. Lletres de Batalla, de la Biblioteca Nacional de Madrid");
        titulos.add("Correspondència de Galceran Martorell amb Manuel de Villanova i Ausias March conservada al Ms. 7811. Lletres de Batalla, de la Biblioteca Nacional de Madrid");
        titulos.add("Correspondència entre Joanot Martorell i Perot Mercader conservada al Ms. 7811. Lletres de Batalla, de la Biblioteca Nacional de Madrid");
        titulos.add("Lletra de Jacomach, soldà de Babilònia, a Joan, rei de Xipre conservada al Ms. 7811. Lletres de Batalla de la Biblioteca Nacional de Madrid");
        titulos.add("Correspondència de Bernat de Vilarig amb Joanot de la Serra i amb Jofre Pardo, algunes frases de la qual es reprodueixen al Tirant. Conservada al Ms. 7811. Lletres de Batalla de la Biblioteca Nacional de Madrid");
        titulos.add("'Flor de cavalleria' fragment conservat al Ms. 7811. Lletres de Batalla de la Biblioteca Nacional de Madrid");
        titulos.add("El Valdemaro");
        titulos.add("Animales trabajadores. Selección");
        titulos.add("Automating the Production of Facsimiles and Transcriptions for Manuscripts and Rare Old Books at the Miguel de Cervantes Digital Library");
        titulos.add("Bajo el sol y sin abrigo. Selección");
        titulos.add("Cangura para todo. Selección");
        return titulos;
    }

    private static String[] loadEditoriales() {

        String[] ed = {"Acribia",
            "Actas",
            "Adams",
            "AdN",
            "Adriana Hidalgo Editora",
            "Aebius",
            "Aena",
            "Aenor",
            "Aguilar",
            "Aguilar Ocio",
            "Akal",
            "Akiara",
            "Biblioteca Nueva",
            "Blackie Books",
            "BlackList",
            "Blume",
            "Boileau",
            "Boira",
            "Booket",
            "Bookolia",
            "Books4pocket",
            "Boreal",
            "Coco Books",
            "Colex",
            "Collins",
            "Combel",
            "Complutense, Ediciones",
            "Comunicación Social",
            "Conecta",
            "Confluencias",
            "Consonni",
            "Contra",
            "Edigol",
            "Edigrama",
            "Edimat",
            "Edinumen",
            "Editex",
            "Editum",
            "EDL",
            "Gakoa",
            "Galaxia Gutenberg",
            "GaliNova",
            "Gallo Nero",
            "Garceta",
            "Gatopardo",
            "Gedisa",
            "GeoPlaneta",
            "Gestión 2000",
            "GEU Editorial",
            "Gigamesh",
            "Glyphos",
            "Good Books"};
        return ed;
    }
}
