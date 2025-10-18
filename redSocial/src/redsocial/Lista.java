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

    public Lista() {
        inicio = null;
    }

    /**
     * Inserta un nuevo nodo al inicio de la lista con la clave especificada.
     *
     * @param x valor entero que se insertará como clave en el nuevo nodo.
     */
    public void insertar(int x) {
        inicio = new NodoLista(x, inicio);
    }

     /**
     * Elimina el primer nodo de la lista cuya clave sea igual al valor especificado.
     * Si la clave no existe en la lista, no se realiza ninguna modificación.
     *
     * @param x valor entero de la clave del nodo que se desea eliminar.
     */
    public void eliminar(int x) {
        NodoLista actual = inicio, anterior = null;
        while (actual != null && actual.clave != x) {
            anterior = actual;
            actual = actual.sig;
        }
        if (actual != null) {
            if (anterior == null) {
                inicio = actual.sig;
            } else {
                anterior.sig = actual.sig;
            }
        }
    }

    /**
     * Busca un nodo en la lista cuya clave sea igual al valor especificado.
     *
     * @param x valor entero que se desea buscar en la lista.
     * @return {@code true} si la clave existe en la lista; {@code false} en caso contrario.
     */
    public boolean busqueda(int x) {
        NodoLista actual = inicio;
        while (actual != null) {
            if (actual.clave == x) return true;
            actual = actual.sig;
        }
        return false;
    }

    /**
     * Devuelve una referencia al primer nodo de la lista.
     *
     * @return el nodo inicial de la lista, o {@code null} si la lista está vacía.
     */
    public NodoLista obtenerInicio() {
        return inicio;
    }
}
