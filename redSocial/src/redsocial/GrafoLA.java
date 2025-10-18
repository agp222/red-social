/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial;

/**
 *
 * @author Antonio Guzzo
 */
public class GrafoLA {
    private boolean dirigido;
    private int maxNodos;
    private int numVertices;
    private Lista[] listaAdy;

    public GrafoLA(int n, boolean d) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.listaAdy = new Lista[n];
    }
    
    public void insertaVertice(int n) {
        if (n > maxNodos - numVertices) {
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        } else {
            for (int i = numVertices; i < numVertices + n; i++) {
                listaAdy[i] = new Lista();
            }
            numVertices += n;
        }
    }

    public void insertaArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error, vértice no válido");
            return;
        }
        listaAdy[i].insertar(j);
        if (!dirigido) listaAdy[j].insertar(i);
    }
    
    public void eliminaArista(int i, int j) {
        if (i >= numVertices || j >= numVertices) {
            System.out.println("Error, vértice no válido");
            return;
        }
        listaAdy[i].eliminar(j);
        if (!dirigido) listaAdy[j].eliminar(i);
    }
    
    public boolean existeArista(int i, int j) {
        return listaAdy[i].busqueda(j);
    }
    
    
}
