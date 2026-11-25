package com.gestortareas.nucleo;

public class Tarea {
    private final String titulo;
    private final int nivelPrioridad;

    public Tarea(String titulo, int nivelPrioridad) {
        this.titulo = titulo;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }
}