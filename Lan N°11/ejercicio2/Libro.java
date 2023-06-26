package ejercicio2;

import java.util.*;

public class Libro {

    private String titulo;
    private String autor;
    private int ventas;
    private int calificacion;
    private String especialidad;
    private String comentarios;

    public Libro(String titulo, String autor, int ventas, int calificacion, String especialidad, String comentarios) {
        this.titulo = titulo;
        this.autor = autor;
        this.ventas = ventas;
        this.calificacion = calificacion;
        this.especialidad = especialidad;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}