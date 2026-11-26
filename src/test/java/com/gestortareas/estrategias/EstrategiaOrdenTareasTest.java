package com.gestortareas.estrategias;

import com.gestortareas.nucleo.Tarea;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstrategiaOrdenTareasTest {

    @Test
    void debeOrdenarTareasPorPrioridad() {
        Tarea baja = new Tarea("Tarea baja", 1);
        Tarea alta = new Tarea("Tarea alta", 3);
        Tarea media = new Tarea("Tarea media", 2);

        OrdenPorPrioridad estrategia = new OrdenPorPrioridad();

        List<Tarea> resultado = estrategia.ordenar(
                List.of(baja, alta, media)
        );

        assertEquals("Tarea alta", resultado.get(0).getTitulo());
        assertEquals("Tarea media", resultado.get(1).getTitulo());
        assertEquals("Tarea baja", resultado.get(2).getTitulo());
    }

    @Test
    void debeOrdenarTareasPorTitulo() {
        Tarea tareaC = new Tarea("Casa", 1);
        Tarea tareaA = new Tarea("Agenda", 2);
        Tarea tareaB = new Tarea("Biblioteca", 3);

        OrdenPorTitulo estrategia = new OrdenPorTitulo();

        List<Tarea> resultado = estrategia.ordenar(
                List.of(tareaC, tareaA, tareaB)
        );

        assertEquals("Agenda", resultado.get(0).getTitulo());
        assertEquals("Biblioteca", resultado.get(1).getTitulo());
        assertEquals("Casa", resultado.get(2).getTitulo());
    }
}