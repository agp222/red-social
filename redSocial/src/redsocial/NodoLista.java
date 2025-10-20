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
 * Representa un nodo en una lista simple enlazada,
 */
public class NodoLista {
    public String dato;
    public NodoLista siguiente;
    
    
    /**
     * Constructor para crear un nuevo nodo.
     * * @param x Nombre de usuario
     * @param s Siguiente nodo.
     */
    public NodoLista(String x, NodoLista s) {
        dato = x;
        siguiente = s;
    }
}