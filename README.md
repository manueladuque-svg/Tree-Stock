# Tree-Stock: Gestión de Inventarios con Árbol Binario de Búsqueda (BST)

Sistema interactivo de consola desarrollado en **Java** para la gestión y organización de inventarios utilizando la estructura de datos de un **Árbol Binario de Búsqueda (Binary Search Tree - BST)**. El sistema permite registrar productos, visualizarlos ordenados de forma ascendente por su ID y realizar búsquedas eficientes en tiempo logarítmico.

---

## 📋 Información Académica

- **Estudiante**: Manuela Duque Contreras
- **Actividad**: S30 - EA3. Actividad Final - Manipulación de Árboles en Java
- **Materia**: [Estructura de Datos (Carlos Arturo Castro) - PREICA2602B010159](https://iudigital.instructure.com/courses/28318)
- **Docente**: Carlos Arturo Castro
- **Período**: Periodo_2026_2_B1

---

## 🎯 Objetivo del Proyecto

El objetivo de **Tree-Stock** es modelar y aplicar los conceptos fundamentales de estructuras de datos no lineales (árboles binarios), haciendo énfasis en:
- El uso de **punteros y referencias en memoria** entre nodos (`izquierdo` y `derecho`).
- La implementación de algoritmos **recursivos** para la inserción, búsqueda y recorrido en profundidad (*inorden*).
- El aseguramiento de la integridad de los datos evitando duplicados y controlando excepciones de entrada en consola.

---

## 📁 Estructura del Proyecto

```text
tree-stock/
├── src/
│   ├── Producto.java           # Clase nodo: ID, nombre y punteros izquierdo/derecho
│   ├── ArbolInventario.java    # Lógica del BST: insertar, recorrido inorden y buscar
│   └── Main.java               # Interfaz de usuario por consola con menú y validaciones
├── capturas/
│   ├── menu.png                # Captura del menú principal
│   ├── insercion.png           # Captura del registro e inserción de productos
│   └── busqueda.png            # Captura de búsqueda exitosa y fallida
├── .gitignore                  # Exclusión sencilla de archivos .class, bin/ e IDEs
└── README.md                   # Documentación completa del proyecto
```

---

## 🧠 Conceptos Clave: Punteros y Recursividad

### 1. Nodos y Punteros (`Producto.java`)
Cada producto actúa como un nodo del árbol:
- **`izquierdo`**: Puntero (referencia de memoria) hacia el nodo hijo cuyo ID es estrictamente menor.
- **`derecho`**: Puntero hacia el nodo hijo cuyo ID es estrictamente mayor.
- Si un puntero apunta a `null`, indica la ausencia de descendencia en esa rama (nodo hoja).

### 2. Algoritmos Recursivos (`ArbolInventario.java`)
- **Inserción**: Compara el ID a registrar contra el nodo actual. Si es menor, delega recursivamente por `izquierdo`; si es mayor, por `derecho`. Al alcanzar un enlace `null`, enlaza una nueva instancia `Producto`.
- **Recorrido Inorden**: Aplica la secuencia:
  1. Llamada recursiva al subárbol izquierdo (`nodo.izquierdo`).
  2. Procesamiento/Impresión del nodo actual (`nodo`).
  3. Llamada recursiva al subárbol derecho (`nodo.derecho`).
  *Esto garantiza la salida ordenada de menor a mayor.*
- **Búsqueda**: En cada paso compara la clave y descarta la mitad de las opciones restantes navegando hacia la izquierda o la derecha, con una complejidad promedio de $O(\log n)$.

---

## 🚀 Requisitos e Instalación

- **Java Development Kit (JDK)**: JDK 17, 21 o **Temurin JDK 25**.
- **Terminal**: PowerShell, CMD o bash (o desde la terminal integrada de VS Code).

### Verificar la versión de Java
```bash
java -version
javac -version
```

---

## 💻 Instrucciones de Compilación y Ejecución

### Opción 1: Desde la Terminal (Recomendado)

1. Abrir la terminal en la raíz del proyecto (`Tree-Stock/`).
2. Compilar los archivos fuente en la carpeta `bin/`:
   ```bash
   javac -d bin src/*.java
   ```
3. Ejecutar la aplicación:
   ```bash
   java -cp bin Main
   ```

### Opción 2: Desde Visual Studio Code

1. Abrir la carpeta `Tree-Stock` en VS Code.
2. Asegurarse de tener instalada la extensión **Extension Pack for Java**.
3. Abrir el archivo `src/Main.java`.
4. Hacer clic en el botón **Run** (o presionar `F5`).

---

## 📸 Evidencias de Ejecución (Capturas de Pantalla)

### 1. Menú Principal
Muestra las opciones disponibles para el usuario con validación de entradas.

![Menú Principal](capturas/menu.png)

### 2. Inserción de Productos
Registro de productos con IDs desordenados y prevención de identificadores duplicados.

![Inserción de Productos](capturas/insercion.png)

### 3. Búsqueda y Recorrido Inorden
Listado ordenado ascendentemente por ID y resultados de búsqueda de IDs existentes y no existentes.

![Búsqueda e Inventario](capturas/busqueda.png)

---

## 📹 Video de Sustentación

- **Enlace al video**: [Enlace de YouTube / Loom / Drive aquí](https://youtube.com/) *(Reemplazar con el enlace de sustentación)*
- **Duración máxima**: 3 minutos.
- **Contenido del video**: Explicación del funcionamiento de los punteros en la clase `Producto`, la recursividad en `ArbolInventario` y demostración de ejecución del menú en `Main`.

---

## 👤 Autor

- **Estudiante**: Manuela Duque Contreras
- **Curso**: Estructura de Datos (Carlos Arturo Castro) - PREICA2602B010159
- **Período**: Periodo_2026_2_B1
