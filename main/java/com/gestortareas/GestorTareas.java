package com.gestortareas.nucleo;

import com.gestortareas.estrategias.EstrategiaOrdenTareas;
import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    private final List<Tarea> tareas = new ArrayList<>();
    private EstrategiaOrdenTareas estrategia;

    public GestorTareas(EstrategiaOrdenTareas estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaOrdenTareas estrategia) {
        this.estrategia = estrategia;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> obtenerTareasOrdenadas() {
        if (estrategia == null) {
            return List.copyOf(tareas);
        }
        return estrategia.ordenar(tareas);
    }
}