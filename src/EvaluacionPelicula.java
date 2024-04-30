import java.util.Scanner;
import java.util.ArrayList;

public class EvaluacionPelicula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> calificaciones = new ArrayList<>();
        double suma = 0;
        int contador = 0;

        try {
            System.out.println("Ingrese el nombre de la película que desea calificar:");
            String nombrePelicula = scanner.nextLine();

            System.out.println("Ingrese las calificaciones de la película. Para terminar, ingrese un número negativo.");

            while (true) {
                System.out.print("Ingrese calificación (de 1 a 5): ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Descartar entrada inválida
                    continue;
                }
                double calificacion = scanner.nextDouble();

                if (calificacion < 0) {
                    break; // Terminar el ciclo si la calificación es negativa
                }

                if (calificacion > 5 || calificacion < 1) {
                    System.out.println("La calificación debe estar entre 1 y 5. Por favor, intente nuevamente.");
                    continue;
                }

                // Agregar la calificación válida a la lista y actualizar suma y contador
                calificaciones.add(calificacion);
                suma += calificacion;
                contador++;
            }

            // Calcular el promedio de las calificaciones
            if (contador > 0) {
                double promedio = suma / contador;
                System.out.printf("Usted ha calificado la película: %s%n", nombrePelicula);
                System.out.printf("La calificación media de la película es: %.2f%n", promedio);
                System.out.println("El detalle de las calificaciones es el siguiente:");
                calificaciones.forEach(calificacion -> System.out.println(calificacion));
            } else {
                System.out.println("No se ingresaron calificaciones válidas.");
            }
        } finally {
            scanner.close();
        }
    }
}
