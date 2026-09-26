/**
 * Clase que gestiona la estructura del Árbol Binario de Búsqueda (BST)
 * para el inventario de productos.
 * 
 * En este árbol:
 * - El subárbol izquierdo contiene nodos con IDs menores a la raíz.
 * - El subárbol derecho contiene nodos con IDs mayores a la raíz.
 * - No se admiten elementos con claves duplicadas.
 * 
 * Actividad: S30 - EA3. Actividad Final - Manipulación de Árboles en Java
 * Materia: Estructura de Datos (Carlos Arturo Castro) - PREICA2602B010159
 * Estudiante: Manuela Duque Contreras
 */
public class ArbolInventario {
    
    // Puntero principal que apunta a la raíz del árbol de inventario.
    // Si la raíz es null, significa que el inventario está vacío.
    private Producto raiz;

    /**
     * Constructor del árbol. Inicializa el inventario vacío con la raíz en null.
     */
    public ArbolInventario() {
        this.raiz = null;
    }

    /**
     * Método público para insertar un nuevo producto al inventario.
     * Inicia la llamada recursiva desde la raíz del árbol.
     * 
     * @param id Identificador único del producto.
     * @param nombre Nombre descriptivo del producto.
     */
    public void insertar(int id, String nombre) {
        // Asignamos a la raíz el resultado del método recursivo de inserción.
        this.raiz = insertarRecursivo(this.raiz, id, nombre);
    }

    /**
     * Método privado recursivo que navega por los punteros del árbol
     * para ubicar la posición correcta del nuevo producto.
     * 
     * @param actual Puntero al nodo actual evaluado en la recursión.
     * @param id Identificador del producto a insertar.
     * @param nombre Nombre del producto a insertar.
     * @return El puntero al nodo (actualizado o nuevo).
     */
    private Producto insertarRecursivo(Producto actual, int id, String nombre) {
        // CASO BASE: Si el puntero actual apunta a null, hemos encontrado
        // el espacio vacío (hoja) donde se debe colocar el nuevo nodo.
        if (actual == null) {
            System.out.println("-> Producto registrado con éxito: [" + id + "] " + nombre);
            return new Producto(id, nombre);
        }

        // PASO RECURSIVO 1: Si el ID a insertar es MENOR que el ID del nodo actual,
        // nos desplazamos hacia la izquierda a través del puntero 'izquierdo'.
        if (id < actual.id) {
            // Se hace la llamada recursiva enviando el subárbol izquierdo.
            // El resultado de la recursión se enlaza al puntero izquierdo del nodo actual.
            actual.izquierdo = insertarRecursivo(actual.izquierdo, id, nombre);
        } 
        // PASO RECURSIVO 2: Si el ID a insertar es MAYOR que el ID del nodo actual,
        // nos desplazamos hacia la derecha a través del puntero 'derecho'.
        else if (id > actual.id) {
            // Se hace la llamada recursiva enviando el subárbol derecho.
            // El resultado de la recursión se enlaza al puntero derecho del nodo actual.
            actual.derecho = insertarRecursivo(actual.derecho, id, nombre);
        } 
        // CASO DE DUPLICADO: Si el ID ya existe en el árbol, evitamos duplicarlo.
        else {
            System.out.println("-> Advertencia: El ID " + id + " ya existe en el inventario. No se permiten duplicados.");
        }

        // Retornamos el puntero al nodo actual sin modificar su estructura hacia arriba en la pila recursiva.
        return actual;
    }

    /**
     * Método público para realizar el recorrido inorden del árbol.
     * En un BST, el recorrido inorden (Izquierda -> Raíz -> Derecha)
     * garantiza que los productos se visiten en orden ascendente por su ID.
     */
    public void recorridoInorden() {
        if (this.raiz == null) {
            System.out.println("El inventario se encuentra actualmente vacío.");
            return;
        }

        System.out.println("==================================================");
        System.out.println("        LISTADO DE PRODUCTOS (ORDENADOS POR ID)   ");
        System.out.println("==================================================");
        // Iniciamos el recorrido recursivo desde el nodo raíz
        inordenRecursivo(this.raiz);
        System.out.println("==================================================");
    }

    /**
     * Método privado recursivo que implementa la lógica del recorrido inorden.
     * 
     * @param nodo Puntero al nodo actual que se está procesando.
     */
    private void inordenRecursivo(Producto nodo) {
        // CASO BASE: Si el nodo es null, llegamos más allá de un nodo hoja, retornamos.
        if (nodo != null) {
            // 1. RECURSIÓN IZQUIERDA: Descendemos primero por el puntero izquierdo
            // hasta alcanzar el valor más pequeño del subárbol.
            inordenRecursivo(nodo.izquierdo);

            // 2. VISITA DE LA RAÍZ / NODO ACTUAL: Imprimimos la información del producto.
            System.out.printf("  [ID: %-5d] | Nombre: %-25s\n", nodo.id, nodo.nombre);

            // 3. RECURSIÓN DERECHA: Descendemos luego por el puntero derecho
            // para procesar los valores mayores.
            inordenRecursivo(nodo.derecho);
        }
    }

    /**
     * Método público para buscar un producto por su ID.
     * Inicia la búsqueda recursiva a partir del nodo raíz.
     * 
     * @param id Identificador que se desea buscar.
     * @return El objeto Producto encontrado o null si no existe.
     */
    public Producto buscar(int id) {
        // Llamada a la función recursiva comenzando por la raíz
        return buscarRecursivo(this.raiz, id);
    }

    /**
     * Método privado recursivo para buscar un nodo por su ID.
     * Aprovecha la propiedad del árbol binario de búsqueda para descartar
     * la mitad de las opciones en cada paso (complejidad O(log n) en promedio).
     * 
     * @param actual Puntero al nodo en evaluación actual.
     * @param id Identificador que se busca.
     * @return El Producto correspondiente si existe; null en caso contrario.
     */
    private Producto buscarRecursivo(Producto actual, int id) {
        // CASO BASE 1: Si el puntero actual es null, el producto no existe en el árbol.
        if (actual == null) {
            return null;
        }

        // CASO BASE 2: Si el ID del nodo actual coincide con el buscado, ¡lo encontramos!
        if (actual.id == id) {
            return actual;
        }

        // PASO RECURSIVO 1: Si el ID buscado es menor, sabemos que solo puede estar
        // en el subárbol izquierdo; avanzamos mediante el puntero 'izquierdo'.
        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        // PASO RECURSIVO 2: Si el ID buscado es mayor, solo puede estar
        // en el subárbol derecho; avanzamos mediante el puntero 'derecho'.
        return buscarRecursivo(actual.derecho, id);
    }

    /**
     * Determina si el árbol está completamente vacío.
     * 
     * @return true si la raíz es null, false en caso contrario.
     */
    public boolean estaVacio() {
        return this.raiz == null;
    }
}
