package com.gestortareas.estrategias;

import com.gestortareas.nucleo.Tarea;
import java.util.Comparator;
import java.util.List;

public class OrdenPorPrioridad implements EstrategiaOrdenTareas {
    @Override
    public List<Tarea> ordenar(List<Tarea> tareas) {
        return tareas.stream()
                .sorted(Comparator.comparingInt(Tarea::getNivelPrioridad).reversed())
                .toList();
    }
}