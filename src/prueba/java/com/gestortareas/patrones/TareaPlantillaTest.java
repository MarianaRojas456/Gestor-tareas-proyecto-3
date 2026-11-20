package com.gestortareas.patrones;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TareaPlantillaTest {

    @Test
    void clonarGeneraInstanciaIndependiente() {
        TareaPlantilla base = new TareaPlantilla(
                "Entrega parcial",
                "Subir avance al repositorio",
                "ALTA",
                List.of("universidad", "java")
        );

        TareaPlantilla copia = base.clonar();
        copia.setTitulo("Entrega parcial - Copia");
        copia.agregarEtiqueta("urgente");

        assertNotSame(base, copia);
        assertEquals("Entrega parcial", base.getTitulo());
        assertEquals("Entrega parcial - Copia", copia.getTitulo());
        assertFalse(base.getEtiquetas().contains("urgente"));
        assertTrue(copia.getEtiquetas().contains("urgente"));
    }
}
