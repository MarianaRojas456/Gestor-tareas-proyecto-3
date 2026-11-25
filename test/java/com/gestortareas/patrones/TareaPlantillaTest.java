package com.gestortareas.patrones;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaPlantillaTest {

    @Test
    void clonarDebeCrearCopiaIndependiente() {
        TareaPlantilla original = new TareaPlantilla(
                "Revisión de diseño",
                "Revisar diagramas del proyecto",
                "Alta",
                List.of("arquitectura", "prototipo")
        );

        TareaPlantilla clon = original.clonar();
        clon.setTitulo("Revisión de diseño - Copia");
        clon.agregarEtiqueta("urgente");

        assertNotSame(original, clon);
        assertEquals("Revisión de diseño", original.getTitulo());
        assertEquals("Revisión de diseño - Copia", clon.getTitulo());
        assertEquals(2, original.getEtiquetas().size());
        assertEquals(3, clon.getEtiquetas().size());
    }
}