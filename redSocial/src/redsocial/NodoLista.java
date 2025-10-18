/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial;

/**
 *
 * @author Antonio Guzzo
 */
public class NodoLista {
    public int clave;
    public NodoLista sig;

    public NodoLista(int dato, NodoLista siguiente) {
        this.clave = dato;
        this.sig = siguiente;
    }
    
    
}
