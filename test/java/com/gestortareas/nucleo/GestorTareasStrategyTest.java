package com.gestortareas.nucleo;

import com.gestortareas.estrategias.OrdenPorPrioridad;
import com.gestortareas.estrategias.OrdenPorTitulo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestorTareasStrategyTest {

    @Test
    void debeOrdenarPorPrioridadYCambiarEstrategiaATitulo() {
        GestorTareas gestor = new GestorTareas(new OrdenPorPrioridad());
        gestor.agregarTarea(new Tarea("Documentar", 1));
        gestor.agregarTarea(new Tarea("Arquitectura", 3));
        gestor.agregarTarea(new Tarea("Pruebas", 2));

        List<Tarea> porPrioridad = gestor.obtenerTareasOrdenadas();
        assertEquals("Arquitectura", porPrioridad.get(0).getTitulo());
        assertEquals("Pruebas", porPrioridad.get(1).getTitulo());
        assertEquals("Documentar", porPrioridad.get(2).getTitulo());

        gestor.setEstrategia(new OrdenPorTitulo());
        List<Tarea> porTitulo = gestor.obtenerTareasOrdenadas();
        assertEquals("Arquitectura", porTitulo.get(0).getTitulo());
        assertEquals("Documentar", porTitulo.get(1).getTitulo());
        assertEquals("Pruebas", porTitulo.get(2).getTitulo());
    }
}