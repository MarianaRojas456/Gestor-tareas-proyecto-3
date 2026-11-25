package com.gestortareas.estrategias;

import com.gestortareas.nucleo.Tarea;
import java.util.List;

public interface EstrategiaOrdenTareas {
    List<Tarea> ordenar(List<Tarea> tareas);
}