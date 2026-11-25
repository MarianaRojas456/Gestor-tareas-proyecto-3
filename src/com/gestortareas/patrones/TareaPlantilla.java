
package com.gestortareas.patrones;

import java.util.ArrayList;
import java.util.List;

public class TareaPlantilla implements PrototipoTarea {

    private String titulo;
    private String descripcion;
    private String prioridad;
    private List<String> etiquetas;

    public TareaPlantilla(
            String titulo,
            String descripcion,
            String prioridad,
            List<String> etiquetas) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.etiquetas = new ArrayList<>(etiquetas);
    }

    @Override
    public TareaPlantilla clonar() {

        return new TareaPlantilla(
                titulo,
                descripcion,
                prioridad,
                etiquetas
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

    public String getPrioridad() {
        return prioridad;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void agregarEtiqueta(String etiqueta) {
        etiquetas.add(etiqueta);
    }
}
