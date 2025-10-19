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
 * Nodo simple enlazado para lista de adyacencia.
 * Guarda un dato tipo String (nombre de usuario).
 */
public class NodoLista {
    public String dato;
    public NodoLista siguiente;

    public NodoLista(String x, NodoLista s) {
        dato = x;
        siguiente = s;
    }
}