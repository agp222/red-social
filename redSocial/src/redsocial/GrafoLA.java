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
    private String[] nombres;

    public GrafoLA(int n, boolean d) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.listaAdy = new Lista[n];
        this.nombres = new String[n];
    }
    
    public void insertarVertice(String nombre) {
        if (numVertices >= maxNodos) {
            System.out.println("No se pueden agregar más vértices.");
            return;
        }
        nombres[numVertices] = nombre;
        listaAdy[numVertices] = new Lista();
        numVertices++;
    }

    public void insertarArista(String origen, String destino) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) {
            System.out.println("Error: vértice no encontrado.");
            return;
        }
        listaAdy[i].insertar(destino);
        if (!dirigido) {
            listaAdy[j].insertar(origen);
        }
    }
    
     public void eliminarArista(String origen, String destino) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) return;
        listaAdy[i].eliminar(destino);
        if (!dirigido) listaAdy[j].eliminar(origen);
    }
    
    public boolean existeArista(String origen, String destino) {
        int i = buscarIndice(origen);
        if (i == -1) return false;
        return listaAdy[i].busqueda(destino);
    }
    
    private int buscarIndice(String nombre) {
        for (int i = 0; i < numVertices; i++) {
            if (nombres[i].equals(nombre)) return i;
        }
        return -1;
    }
    
    
}
