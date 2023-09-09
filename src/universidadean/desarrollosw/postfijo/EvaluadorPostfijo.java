/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Permite saber si la expresión en la lista está balanceada
     * o no. Cada elemento de la lista es un elemento. DEBE OBlIGATORIAMENTE
     * USARSE EL ALGORITMO QUE ESTÁ EN EL ENUNCIADO.
     */

    static boolean Apertura(String element){
        return element.equals("(") || element.equals("[") || element.equals("{");
    }

    static boolean Cierre(String element){
        return element.equals(")") || element.equals("]") || element.equals("}");
    }

    static boolean Par(String apertura, String cierre){
        return (apertura.equals("(") && cierre.equals(")")) ||
                (apertura.equals("[") && cierre.equals("]")) ||
                (apertura.equals("{") && cierre.equals("}"));
    }
    static boolean estaBalanceada(List<String> expresion) {
        Stack<String> delimitadores = new Stack<>();

        for (String element : expresion) {
            if (Apertura(element)) {
                delimitadores.push(element);
            } else if (Cierre(element)) {
                if (delimitadores.isEmpty()){
                    return false;
                }
                if (!Par(delimitadores.peek(), element)){
                    return false;
                }
                else {
                    delimitadores.pop();
                }
            }
        }
        return delimitadores.isEmpty();
    }
    /**
     * Transforma la expresión, cambiando los símbolos de agrupación
     * de corchetes ([]) y llaves ({}) por paréntesis ()
     */
    static void reemplazarDelimitadores(List<String> expresion) {
        for (int i = 0; i < expresion.size(); i++) {
            String element = expresion.get(i);
            if (element.equals("[") || element.equals("{")) {
                expresion.set(i, "(");
            } else if (element.equals("]") || element.equals("}")) {
                expresion.set(i, ")");
            }
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     * OJO: Debe usarse el algoritmo que está en el enunciado OBLIGATORIAMENTE
     */
    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // TODO: Escriba el algoritmo aquí

        return salida;
    }

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        // TODO: Realiza la evaluación de la expresión en formato postfijo

        return pila.pop();
    }

}
