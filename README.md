### Descripción del Repositorio: Evaluación de Películas
Este repositorio contiene un programa Java que permite a los usuarios ingresar calificaciones para una película y calcular la calificación media basada en las entradas. 
Es ideal para entornos donde se desea obtener feedback instantáneo de los espectadores sobre una película específica.

#### Características:
- **Entrada de Usuario:** El programa solicita al usuario que ingrese el nombre de la película y las calificaciones individuales.
- **Validación de Calificaciones:** Se validan las entradas para asegurar que las calificaciones estén en el rango de 1 a 5.
- **Visualización de Resultados:** Al final de la entrada de datos, el programa muestra el nombre de la película, el promedio de las calificaciones,
  y un detalle de todas las calificaciones ingresadas.
- **Manejo de Errores:** El programa maneja entradas no numéricas y verifica que las calificaciones estén dentro del rango permitido.

#### Cómo Usar:
1. Ejecute el programa.
2. Ingrese el nombre de la película que desea calificar.
3. Ingrese las calificaciones como se solicita; para finalizar la entrada de datos, ingrese un número negativo.
4. Revise la salida que incluye el promedio de calificaciones y el detalle de todas las calificaciones válidas ingresadas.

#### Demo:
[![Demo](https://img.youtube.com/vi/sK0f8DxIg7o/maxresdefault.jpg)](https://www.youtube.com/watch?v=sK0f8DxIg7o)

## Explicación del código:
El código del programa `EvaluacionPelicula` en Java está diseñado para recopilar y procesar calificaciones de películas dadas por los usuarios, 
y luego calcular y mostrar la calificación media junto con detalles de todas las calificaciones ingresadas. 
A continuación, te detallo cada componente del código y su función:

### Importación de Bibliotecas
```java
import java.util.Scanner;
import java.util.ArrayList;
```
- `java.util.Scanner`: Esta clase se utiliza para leer la entrada de datos del teclado. Es parte de `java.util`, que contiene las clases de utilidad como colecciones.
- `java.util.ArrayList`: Esta clase implementa una matriz redimensionable de objetos. Se usa para almacenar las calificaciones ingresadas por los usuarios.

### Definición de la Clase y Método Principal
```java
public class EvaluacionPelicula {
    public static void main(String[] args) {
        ...
    }
}
```
- `public class EvaluacionPelicula`: Define la clase `EvaluacionPelicula`. En Java, un archivo fuente puede contener una clase pública que debe tener el mismo nombre que el archivo.
- `public static void main(String[] args)`: Este es el método principal desde donde comienza la ejecución de cualquier programa Java. `public` hace que el método
  sea accesible desde cualquier lugar, `static` permite que se llame al método sin crear una instancia de la clase, y `void` indica que no devuelve ningún valor.

### Inicialización de Variables y Objetos
```java
Scanner scanner = new Scanner(System.in);
ArrayList<Double> calificaciones = new ArrayList<>();
double suma = 0;
int contador = 0;
```
- `Scanner scanner = new Scanner(System.in)`: Crea una instancia de `Scanner` para leer la entrada desde la consola.
- `ArrayList<Double> calificaciones = new ArrayList<>()`: Inicializa un `ArrayList` para almacenar las calificaciones como objetos `Double`.
- `double suma = 0;`: Inicializa una variable para sumar todas las calificaciones.
- `int contador = 0;`: Inicializa un contador para mantener el número de calificaciones ingresadas.

### Entrada y Validación de Datos
```java
while (true) {
    ...
    double calificacion = scanner.nextDouble();

    if (calificacion < 0) {
        break;
    }

    if (calificacion > 5 || calificacion < 1) {
        ...
        continue;
    }
    ...
}
```
- El ciclo `while (true)` se ejecuta indefinidamente hasta que se rompe explícitamente. Dentro del ciclo, se solicita al usuario que ingrese una calificación.
- `scanner.nextDouble()`: Lee un número `double` de la entrada del teclado.
- El primer `if` verifica si la calificación es negativa, en cuyo caso se rompe el ciclo con `break`.
- El segundo `if` verifica que la calificación esté dentro del rango permitido (1 a 5). Si no lo está, imprime un mensaje de error y
  continúa con la siguiente iteración del ciclo sin procesar la entrada incorrecta.

### Cálculo y Visualización del Promedio
```java
if (contador > 0) {
    double promedio = suma / contador;
    ...
    calificaciones.forEach(calificacion -> System.out.println(calificacion));
} else {
    System.out.println("No se ingresaron calificaciones válidas.");
}
```
- Después de salir del ciclo `while`, se verifica si se ingresaron calificaciones (`contador > 0`). Si es así, se calcula el promedio dividiendo `suma` por `contador`.
- Se imprime el nombre de la película, la calificación media y todas las calificaciones individuales.
- Si no se ingresaron calificaciones válidas, se muestra un mensaje adecuado.

Dentro de esta parte se incluyó un método `forEach` con una expresión `lambda` que paso a explicar en detalle, a continuación:
El método `forEach` es parte de las capacidades introducidas en Java 8, específicamente como parte de la interfaz `Iterable`. 
Este método permite realizar una acción para cada elemento de una colección (como `ArrayList`, `Set`, etc.) de manera más concisa y legible en comparación 
con las estructuras de iteración tradicionales como `for` o `while`.

### Uso del método `forEach`
En el contexto de mi programa `EvaluacionPelicula`, el método `forEach` se utiliza para imprimir todas las calificaciones almacenadas en el `ArrayList<Double> calificaciones`. 
Aquí está la línea específica del código:

```java
calificaciones.forEach(calificacion -> System.out.println(calificacion));
```

### Desglose del método `forEach`

- **Colección sobre la que se itera**: `calificaciones`, que es una instancia de `ArrayList<Double>`.
- **Lambda Expression**: `calificacion -> System.out.println(calificacion)`. Esta expresión lambda define una acción simple que se debe realizar para cada elemento de la colección. En este caso, la acción es imprimir cada calificación.
  - **Parámetro de la lambda**: `calificacion`, que representa un elemento individual de la colección `calificaciones`. Cada `calificacion` es automáticamente del tipo `Double`
    porque el `ArrayList` está definido como `ArrayList<Double>`.
  - **Cuerpo de la lambda**: `System.out.println(calificacion)`. Esto indica que para cada `calificacion` en `calificaciones`,
    el programa debe ejecutar `System.out.println()` para imprimir esa calificación en la consola.

### Ventajas del método `forEach` con lambda expressions

- **Mejor legibilidad**: El código es más limpio y fácil de entender, especialmente para operaciones que requieren una acción simple por cada elemento.
- **Menos código**: Reduce la necesidad de una estructura explícita de bucle, como un `for` o `while`, y manejo manual de índices o iteradores.

### Cierre de Recursos
```java
scanner.close();
```
- Finalmente, se cierra el objeto `scanner` para liberar los recursos asociados.
  Es una buena práctica cerrar todos los recursos de entrada/salida para evitar fugas de memoria.

Este programa es un ejemplo de cómo manejar entradas del usuario, realizar cálculos y mostrar resultados en Java, 
aplicando buenas prácticas como la validación de entrada y el manejo adecuado de recursos.

Este programa es una excelente herramienta para recolectar y analizar la opinión del público sobre películas en eventos, 
festivales de cine, o incluso en plataformas de revisión de contenido multimedia.
