import java.util.Scanner;

/**
 * Clase principal que actúa como interfaz de consola para el sistema Tree-Stock.
 * Contiene el menú interactivo, la lectura de datos mediante Scanner y la
 * validación de entradas numéricas para evitar errores de ejecución.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();

        boolean continuar = true;

        System.out.println("==================================================");
        System.out.println("       BIENVENIDO AL SISTEMA TREE-STOCK           ");
        System.out.println("   Gestión de Inventarios con Árboles Binarios    ");
        System.out.println("==================================================");

        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarProducto(scanner, inventario);
                    break;

                case 2:
                    mostrarInventario(inventario);
                    break;

                case 3:
                    buscarProducto(scanner, inventario);
                    break;

                case 4:
                    System.out.println("\nGracias por utilizar Tree-Stock. ¡Hasta pronto!");
                    continuar = false;
                    break;

                default:
                    System.out.println("\n[!] Opción no válida. Por favor, ingrese un número del 1 al 4.");
                    break;
            }

            if (continuar) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    /**
     * Despliega las opciones del menú principal en pantalla.
     */
    private static void mostrarMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("                  MENÚ PRINCIPAL                  ");
        System.out.println("--------------------------------------------------");
        System.out.println(" 1. Registrar Producto");
        System.out.println(" 2. Mostrar Inventario (Recorrido Inorden)");
        System.out.println(" 3. Buscar Producto por ID");
        System.out.println(" 4. Salir");
        System.out.println("--------------------------------------------------");
    }

    /**
     * Gestiona el registro de un nuevo producto solicitando ID y nombre.
     * 
     * @param scanner Objeto Scanner para capturar datos.
     * @param inventario Instancia del árbol donde se insertará el nodo.
     */
    private static void registrarProducto(Scanner scanner, ArbolInventario inventario) {
        System.out.println("\n--- REGISTRAR NUEVO PRODUCTO ---");
        int id = leerEntero(scanner, "Ingrese el ID del producto (número entero positivo): ");
        if (id <= 0) {
            System.out.println("[!] El ID debe ser un número entero positivo mayor a cero.");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("[!] El nombre del producto no puede estar vacío.");
            return;
        }

        inventario.insertar(id, nombre);
    }

    /**
     * Muestra todos los productos del inventario ordenados ascendentemente por su ID.
     * 
     * @param inventario Instancia del árbol de inventario.
     */
    private static void mostrarInventario(ArbolInventario inventario) {
        System.out.println("\n--- INVENTARIO ACTUAL ---");
        inventario.recorridoInorden();
    }

    /**
     * Solicita un ID y busca si el producto existe en el árbol binario.
     * 
     * @param scanner Objeto Scanner para capturar el ID.
     * @param inventario Instancia del árbol de inventario.
     */
    private static void buscarProducto(Scanner scanner, ArbolInventario inventario) {
        System.out.println("\n--- BÚSQUEDA DE PRODUCTO ---");
        if (inventario.estaVacio()) {
            System.out.println("El inventario está vacío. No hay productos para buscar.");
            return;
        }

        int id = leerEntero(scanner, "Ingrese el ID del producto a buscar: ");
        Producto productoEncontrado = inventario.buscar(id);

        if (productoEncontrado != null) {
            System.out.println("\n[OK] Producto encontrado:");
            System.out.println("----------------------------------------");
            System.out.println(" ID     : " + productoEncontrado.id);
            System.out.println(" Nombre : " + productoEncontrado.nombre);
            System.out.println("----------------------------------------");
        } else {
            System.out.println("\n[X] Producto con ID " + id + " no encontrado en el inventario.");
        }
    }

    /**
     * Lee un número entero de la consola con manejo de excepciones
     * para evitar que el programa se detenga ante entradas inválidas de texto.
     * 
     * @param scanner Objeto Scanner para lectura.
     * @param mensaje Mensaje explicativo que se mostrará al usuario.
     * @return El número entero validado.
     */
    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("[!] Error: Ingrese un valor numérico válido.");
            }
        }
    }
}
