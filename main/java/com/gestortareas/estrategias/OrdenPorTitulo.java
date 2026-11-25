package com.gestortareas.estrategias;

import com.gestortareas.nucleo.Tarea;
import java.util.Comparator;
import java.util.List;

public class OrdenPorTitulo implements EstrategiaOrdenTareas {
    @Override
    public List<Tarea> ordenar(List<Tarea> tareas) {
        return tareas.stream()
                .sorted(Comparator.comparing(Tarea::getTitulo, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }
}