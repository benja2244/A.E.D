package ejercicio2;

import java.util.*;

public class Libreria {
   
    HashMap<String, Libro> libros;

    public Libreria() {
        libros = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro.getTitulo(), libro);
    }

    public void modificarLibro(Libro libro) {
        libros.put(libro.getTitulo(), libro);
    }

    public Libro compraSegura(String autor) {
        Libro mejorLibro = null;
        int mejorCalificacion = 0;

        for (Libro libro : libros.values()) {
            if (libro.getAutor().equals(autor) && libro.getCalificacion() > mejorCalificacion) {
                mejorLibro = libro;
                mejorCalificacion = libro.getCalificacion();
            }
        }

        return mejorLibro;
    }

    public List<Libro> listado(String especialidad) {
        List<Libro> librosEspecialidad = new ArrayList<>();

        for (Libro libro : libros.values()) {
            if (libro.getEspecialidad().equals(especialidad)) {
                librosEspecialidad.add(libro);
            }
        }

        Collections.sort(librosEspecialidad, Comparator.comparingInt(Libro::getVentas));
        return librosEspecialidad;
    }
}
