package com.gestortareas.patrones;

import java.util.ArrayList;
import java.util.List;

public class TareaPlantilla implements PrototipoTarea {
    private String titulo;
    private String descripcion;
    private String prioridad;
    private List<String> etiquetas;

    public TareaPlantilla(String titulo, String descripcion, String prioridad, List<String> etiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.etiquetas = etiquetas != null ? new ArrayList<>(etiquetas) : new ArrayList<>();
    }

    @Override
    public TareaPlantilla clonar() {
        return new TareaPlantilla(
                this.titulo,
                this.descripcion,
                this.prioridad,
                new ArrayList<>(this.etiquetas)
        );
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void agregarEtiqueta(String etiqueta) {
        this.etiquetas.add(etiqueta);
    }

    @Override
    public String toString() {
        return "TareaPlantilla{" +
                "titulo='" + titulo + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", etiquetas=" + etiquetas +
                '}';
    }
}
