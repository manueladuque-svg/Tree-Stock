/**
 * Clase que representa un nodo dentro del Árbol Binario de Búsqueda (BST).
 * Cada nodo almacena la información de un producto del inventario
 * y contiene las referencias (punteros) a sus hijos izquierdo y derecho.
 */
public class Producto {
    // Identificador único del producto (clave para ordenar el árbol)
    public int id;
    
    // Nombre descriptivo del producto
    public String nombre;

    // Puntero / referencia al subárbol izquierdo:
    // Contendrá productos con IDs estrictamente menores al ID actual.
    public Producto izquierdo;

    // Puntero / referencia al subárbol derecho:
    // Contendrá productos con IDs estrictamente mayores al ID actual.
    public Producto derecho;

    /**
     * Constructor que inicializa el nodo con los datos del producto.
     * Al crearse un nuevo nodo, los punteros izquierdo y derecho apuntan a null,
     * indicando que es un nodo hoja inicialmente (sin descendientes).
     *
     * @param id Identificador numérico único del producto.
     * @param nombre Nombre comercial o descripción del producto.
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // Inicialización explícita de punteros en null
        this.izquierdo = null;
        this.derecho = null;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
}
