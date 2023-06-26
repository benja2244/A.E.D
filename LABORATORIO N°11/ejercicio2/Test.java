package ejercicio2;

import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--------- MENU ---------");
            System.out.println("1. Agregar libro");
            System.out.println("2. Modificar libro");
            System.out.println("3. Compra segura");
            System.out.println("4. Listado por especialidad");
            System.out.println("5. Salir");
            System.out.print("SELECCIONA UNA DE LAS OPCIONES: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese las ventas del libro: ");
                    int ventas = scanner.nextInt();
                    System.out.print("Ingrese la calificacion del libro: ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el salto de línea
                    System.out.print("Ingrese la especialidad del libro: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Ingrese los comentarios del libro: ");
                    String comentarios = scanner.nextLine();

                    Libro nuevoLibro = new Libro(titulo, autor, ventas, calificacion, especialidad, comentarios);
                    libreria.agregarLibro(nuevoLibro);
                    System.out.println("Libro agregado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el titulo del libro a modificar: ");
                    String tituloModificar = scanner.nextLine();
                    Libro libroModificar = libreria.libros.get(tituloModificar);

                    if (libroModificar != null) {
                        System.out.print("Ingrese las ventas del libro: ");
                        int ventasModificar = scanner.nextInt();
                        System.out.print("Ingrese la calificacion del libro: ");
                        int calificacionModificar = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el salto de línea
                        System.out.print("Ingrese los comentarios del libro: ");
                        String comentariosModificar = scanner.nextLine();

                        libroModificar.setVentas(ventasModificar);
                        libroModificar.setCalificacion(calificacionModificar);
                        libroModificar.setComentarios(comentariosModificar);

                        libreria.modificarLibro(libroModificar);
                        System.out.println("Libro modificado correctamente.");
                    } else {
                        System.out.println("El libro no existe en la libreria.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el autor: ");
                    String autorCompraSegura = scanner.nextLine();
                    Libro libroCompraSegura = libreria.compraSegura(autorCompraSegura);

                    if (libroCompraSegura != null) {
                        System.out.println("Libro con mejor critica del autor: " + libroCompraSegura.getTitulo());
                    } else {
                        System.out.println("No se encontraron libros del autor en la libreria.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la especialidad: ");
                    String especialidadListado = scanner.nextLine();
                    List<Libro> librosEspecialidad = libreria.listado(especialidadListado);

                    if (!librosEspecialidad.isEmpty()) {
                        System.out.println("Listado de libros de la especialidad '" + especialidadListado + "':");

                        for (Libro libro : librosEspecialidad) {
                            System.out.println("- Titulo: " + libro.getTitulo() + ", Ventas: " + libro.getVentas());
                        }
                    } else {
                        System.out.println("No se encontraron libros de la especialidad en la libreria.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}