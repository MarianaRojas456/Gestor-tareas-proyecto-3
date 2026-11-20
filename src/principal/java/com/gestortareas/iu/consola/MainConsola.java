package com.gestortareas.iu.consola;

import com.gestortareas.patrones.TareaPlantilla;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TareaPlantilla plantillaSemanal = new TareaPlantilla(
                "Tarea de seguimiento",
                "Revisión periódica de pendientes",
                "MEDIA",
                new ArrayList<>(List.of("seguimiento", "rutina"))
        );

        List<TareaPlantilla> tareasCreadas = new ArrayList<>();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTOR DE TAREAS (CONSOLA) ---");
            System.out.println("1. Crear tarea clonando plantilla");
            System.out.println("2. Listar tareas creadas");
            System.out.println("3. Ver plantilla base");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> {
                    TareaPlantilla nueva = plantillaSemanal.clonar();
                    System.out.print("Título de la nueva tarea: ");
                    nueva.setTitulo(scanner.nextLine().trim());

                    System.out.print("Etiqueta adicional (deja vacío si no aplica): ");
                    String extra = scanner.nextLine().trim();
                    if (!extra.isEmpty()) {
                        nueva.agregarEtiqueta(extra);
                    }

                    tareasCreadas.add(nueva);
                    System.out.println("Tarea creada: " + nueva);
                }
                case "2" -> {
                    if (tareasCreadas.isEmpty()) {
                        System.out.println("Aún no hay tareas creadas.");
                    } else {
                        for (int i = 0; i < tareasCreadas.size(); i++) {
                            System.out.println((i + 1) + ". " + tareasCreadas.get(i));
                        }
                    }
                }
                case "3" -> System.out.println("Plantilla base: " + plantillaSemanal);
                case "0" -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }

        scanner.close();
        System.out.println("Hasta luego.");
    }
}
