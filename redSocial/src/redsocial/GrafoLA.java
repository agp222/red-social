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
    
    public int getNumVertices() { return numVertices; }
    
    public void insertarVertice(String nombre) {
        // Si se alcanza el límite, duplicar la capacidad
        if (numVertices >= maxNodos) {
            int nuevaCapacidad = maxNodos * 2;
            Lista[] nuevaLista = new Lista[nuevaCapacidad];
            String[] nuevosNombres = new String[nuevaCapacidad];

            // Copiar elementos actuales
            for (int i = 0; i < numVertices; i++) {
                nuevaLista[i] = listaAdy[i];
                nuevosNombres[i] = nombres[i];
            }

            listaAdy = nuevaLista;
            nombres = nuevosNombres;
            maxNodos = nuevaCapacidad;
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
    
    public void mostrar() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(nombres[i] + " -> ");
            String[] vecinos = listaAdy[i].obtenerElementos();
            for (int j = 0; j < vecinos.length; j++) {
                System.out.print(vecinos[j] + (j < vecinos.length - 1 ? ", " : ""));
            }
            System.out.println();
        }
    }
    
    public String eliminarVertice(String nombre) {
    int indice = buscarIndice(nombre);
    if (indice == -1) {
        System.out.println("Error: el vértice no existe.");
        return "";
    }

    //Eliminar todas las aristas que llegan al vértice
    for (int i = 0; i < numVertices; i++) {
        if (listaAdy[i] != null) {
            listaAdy[i].eliminar(nombre);
        }
    }

    //Eliminar la lista de adyacencia del vértice (aristas que salen)
    listaAdy[indice] = null;

    //Desplazar los nombres y listas para compactar el arreglo
    for (int i = indice; i < numVertices - 1; i++) {
        nombres[i] = nombres[i + 1];
        listaAdy[i] = listaAdy[i + 1];
    }

    //Vaciar la última posición (ahora libre)
    nombres[numVertices - 1] = null;
    listaAdy[numVertices - 1] = null;

    numVertices--;

    return("Vértice " + nombre + " eliminado correctamente.");
}
}
