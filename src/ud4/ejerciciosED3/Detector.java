
package ud4.ejerciciosED3;

/**
 *
 * @author Samuel Loureiro Cardoso
 */
public class Detector {
    
    public static boolean comprobarAnidamiento(String cadena) throws Exception{
        boolean salida = true;
        Pila llaves = new Pila();
        for(char c:  cadena.toCharArray()){
            if("({[".contains(c+"")){
                llaves.push(c);
                continue;
            }
            if(")}]".contains(c+"")){
                char oc = opuesto(c);
                if(oc!=llaves.pop()){
                    salida = false;
                    break;
                }
            }            
        }
        
        if(salida&&!llaves.isEmpty()){
            salida = false;
        }
        
        return salida;
    }
    //Devuelve la llave opuesta
    private static char opuesto(char llave) throws Exception{
        char ret ;
        if(llave=='}'){
            ret = '{';
        }
        else if(llave==']'){
            ret = '[';
        }
        else if(llave==')'){
            ret = '(';
        }else{
            throw new Exception(llave+" No es una llave.");
        }
        return ret;
    }
    
}
