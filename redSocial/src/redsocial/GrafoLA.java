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

    /**
     * Constructor de la clase GrafoLA.
     * 
     * @param n La capacidad máxima inicial de vértices del grafo.
     * @param d Indica si el grafo es dirigido (true) o no dirigido (false).
     */
    public GrafoLA(int n, boolean d) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.listaAdy = new Lista[n];
        this.nombres = new String[n];
    }
    
    /**
     * Obtiene el número actual de vértices en el grafo.
     *
     * @return El número de vértices.
     */
    public int getNumVertices() { return numVertices; }
    
    /**
     * Obtiene el arreglo de nombres de los vértices.
     *
     * @return El arreglo de Strings con los nombres de los vértices.
     */
    public String[] getNombres() { return nombres;}
    
    /**
     * Inserta un nuevo vértice al grafo con el nombre especificado.
     * Si el grafo alcanza su capacidad máxima, esta se duplica automáticamente.
     *
     * @param nombre El nombre (String) del nuevo vértice a insertar.
     */
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

    /**
     * Inserta una arista entre dos vértices.
     * Nota: Si el grafo es no dirigido, se inserta una arista bidireccional.
     *
     * @param origen El nombre del vértice de origen.
     * @param destino El nombre del vértice de destino.
     */
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
    
    /**
     * Elimina una arista entre dos vértices.
     * Nota: Si el grafo es no dirigido, se elimina la arista bidireccional.
     *
     * @param origen El nombre del vértice de origen.
     * @param destino El nombre del vértice de destino.
     */
    public void eliminarArista(String origen, String destino) {
        int i = buscarIndice(origen);
        int j = buscarIndice(destino);
        if (i == -1 || j == -1) return;
        listaAdy[i].eliminar(destino);
        if (!dirigido) listaAdy[j].eliminar(origen);
    }
    
    /**
     * Verifica si existe una arista dirigida desde el vértice de origen al de destino.
     *
     * @param origen El nombre del vértice de origen.
     * @param destino El nombre del vértice de destino.
     * @return {@code true} si la arista existe, {@code false} en caso contrario.
     */
    public boolean existeArista(String origen, String destino) {
        int i = buscarIndice(origen);
        if (i == -1) return false;
        return listaAdy[i].busqueda(destino);
    }
    
    /**
     * Busca el índice (posición en los arreglos internos) de un vértice dado su nombre.    
     *
     * @param nombre El nombre del vértice a buscar.
     * @return El índice del vértice, o -1 si no se encuentra.
     */
    private int buscarIndice(String nombre) {
        for (int i = 0; i < numVertices; i++) {
            if (nombres[i].equals(nombre)) return i;
        }
        return -1;
    }
    
    /**
     * Muestra por consola la lista de adyacencia completa del grafo, imprimiendo cada vértice y sus respectivos vecinos.
     */
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
    
    /*
     * Elimina un vértice del grafo dado su nombre, junto con todas las aristas que llegan o salen de él.
     *
     * @param nombre El nombre del vértice a eliminar.
     * @return Un mensaje de confirmación o error.
     */
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
    
    /**
     * Obtiene un arreglo con los nombres de todos los vértices vecinos (adyacentes)V de un vértice dado.
     *
     * @param usuario El nombre del vértice del cual se quieren obtener los vecinos.
     * @return Un arreglo de Strings con los nombres de los vecinos, o un arreglo vacío si el vértice no existe.
     */
    public String[] obtenerVecinos(String usuario) {
        int i = buscarIndice(usuario);
        if (i == -1) return new String[0];
        return listaAdy[i].obtenerElementos();
    }
    
    
    /**
    * Identifica y muestra los Componentes Fuertemente Conectados (CFC) del grafo dirigido usando el algoritmo de Kosaraju.
    * 
    */
    public void encontrarComponentesFuertementeConectados() {
        boolean[] visitado = new boolean[numVertices];
        String[] pila = new String[numVertices];
        int[] tope = new int[1];

        // Primer DFS: llena pila según el tiempo de finalización
        for (int i = 0; i < numVertices; i++) {
            if (!visitado[i]) {
                dfs1(i, visitado, pila, tope);
            }
        }

        //Transponer el grafo
        GrafoLA transpuesto = this.transponer();

        //Segundo DFS: recorrer según orden inverso
        for (int i = 0; i < numVertices; i++) {
            visitado[i] = false;
        }

        String[] colores = {"Rojo", "Verde", "Azul", "Amarillo", "Cian", "Magenta", "Gris", "Naranja", "Violeta"};
        int componenteId = 0;

        System.out.println("\nComponentes Fuertemente Conectados:");
        while (tope[0] > 0) {
            String nombreVertice = pila[--tope[0]];
            int indice = transpuesto.buscarIndice(nombreVertice);
            if (!visitado[indice]) {
                System.out.print("CFC #" + (componenteId + 1) + " (" + colores[componenteId % colores.length] + "): ");
                transpuesto.dfs2(indice, visitado);
                System.out.println();
                componenteId++;
            }
        }
    }

    /**
     * DFS de la primera pasada: llena la pila según finalización.
     */
    private void dfs1(int v, boolean[] visitado, String[] pila, int[] tope) {
        visitado[v] = true;
        String[] vecinos = listaAdy[v].obtenerElementos();
        for (int i = 0; i < vecinos.length; i++) {
            int j = buscarIndice(vecinos[i]);
            if (j != -1 && !visitado[j]) {
                dfs1(j, visitado, pila, tope);
            }
        }
        // guarda vértice al terminar
        pila[tope[0]++] = nombres[v]; 
    }

    /**
     * DFS de la segunda pasada: imprime vértices del mismo componente.
     */
    private void dfs2(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(nombres[v] + " ");
        String[] vecinos = listaAdy[v].obtenerElementos();
        for (int i = 0; i < vecinos.length; i++) {
            int j = buscarIndice(vecinos[i]);
            if (j != -1 && !visitado[j]) {
                dfs2(j, visitado);
            }
        }
    }

    /**
     * Crea y devuelve un nuevo grafo con todas las aristas invertidas.
     */
    private GrafoLA transponer() {
        GrafoLA gT = new GrafoLA(numVertices, true);
        // Copiar vértices
        for (int i = 0; i < numVertices; i++) {
            gT.insertarVertice(nombres[i]);
        }
        // Invertir aristas
        for (int i = 0; i < numVertices; i++) {
            String origen = nombres[i];
            String[] vecinos = listaAdy[i].obtenerElementos();
            for (int j = 0; j < vecinos.length; j++) {
                gT.insertarArista(vecinos[j], origen);
            }
        }
        return gT;
    }
    
}
