/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial;

/**
 *
 * @author Antonio Guzzo
 */


/**
 * Lista simple enlazada utilizada como lista de adyacencia en grafos.
 */
public class Lista {
    public NodoLista inicio;

    /**
     * Constructor por defecto que inicializa una lista vacía.
     */
    public Lista() {
        inicio = null;
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista con la clave especificada.
     *
     * @param x Nombre de usuario que se insertará como clave en el nuevo nodo.
     */
    public void insertar(String x) {
        if (!busqueda(x)) {
            inicio = new NodoLista(x, inicio);
        }
    }

     /**
     * Elimina el primer nodo de la lista cuya clave sea igual al valor especificado.
     * Si la clave no existe en la lista, no se realiza ninguna modificación.
     *
     * @param x Nombre de usuario que se desea eliminar.
     */
    public void eliminar(String x) {
        NodoLista actual = inicio, anterior = null;
        while (actual != null && !actual.dato.equals(x)) {
            anterior = actual;
            actual = actual.siguiente;
        }
        if (actual != null) {
            if (anterior == null) inicio = actual.siguiente;
            else anterior.siguiente = actual.siguiente;
        }
    }

    /**
     * Busca un nodo en la lista cuya clave sea igual al valor especificado.
     *
     * @param x Nombre de usuario que se desea buscar en la lista.
     * @return {@code true} si la clave existe en la lista; {@code false} en caso contrario.
     */
    public boolean busqueda(String x) {
        NodoLista actual = inicio;
        while (actual != null) {
            if (actual.dato.equals(x)) return true;
            actual = actual.siguiente;
        }
        return false;
    }
    
    
    /**
     * Devuelve una referencia al primer nodo de la lista.
     *
     * @return el nodo inicial de la lista, o {@code null} si la lista está vacía.
     */
    
    /**
     * No se usa
     */
    public NodoLista obtenerInicio() {
        return inicio;
    }
    
    
    /** 
     * Devuelve todos los nombres de usuario de la lista como un arreglo de String.
     * 
     * @return Un arreglo de String con todos los datos de la lista.
     */
    public String[] obtenerElementos() {
        // Primero contar
        int count = 0;
        NodoLista actual = inicio;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        // Crear arreglo
        String[] elementos = new String[count];
        actual = inicio;
        int i = 0;
        while (actual != null) {
            elementos[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return elementos;
    }
    
    /** 
     * Devuelve la cantidad de nodos en la lista.
     * 
     * @return La cantidad total de nodos.
     */
    public int cantidad() {
        int c = 0;
        NodoLista actual = inicio;
        while (actual != null) {
            c++;
            actual = actual.siguiente;
        }
        return c;
    }
}
