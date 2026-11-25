package com.gestortareas.patrones;

import java.util.ArrayList;
import java.util.List;

public class NotificadorTareas {

    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarCambio(String nombreTarea, String nuevoEstado) {
        for (Observador observador : observadores) {
            observador.actualizar(nombreTarea, nuevoEstado);
        }
    }
}