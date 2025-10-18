/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial;

/**
 *
 * @author Antonio Guzzo
 */
public class Lista {
    public NodoLista inicio;

    public Lista() {
        inicio = null;
    }

    public void insertar(int x) {
        inicio = new NodoLista(x, inicio);
    }

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

    public boolean busqueda(int x) {
        NodoLista actual = inicio;
        while (actual != null) {
            if (actual.clave == x) return true;
            actual = actual.sig;
        }
        return false;
    }

    public NodoLista obtenerInicio() {
        return inicio;
    }
}
