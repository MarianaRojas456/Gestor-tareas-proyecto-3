
package com.gestortareas.iu.grafica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;

import com.gestortareas.patrones.TareaPlantilla;
import com.gestortareas.patrones.NotificadorTareas;

public class VentanaPrincipal extends JFrame {

    private DefaultTableModel modelo;
    private JTable tabla;

    private JTextField campoNombre;
    private JTextField campoFecha;

    private JComboBox<String> prioridad;
    private JComboBox<String> estado;

    // PATRON OBSERVER
    private NotificadorTareas notificador;

    public VentanaPrincipal() {

        setTitle("Gestor de Tareas y Proyectos");
        setSize(950, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // CONFIGURACION OBSERVER
        notificador = new NotificadorTareas();

        // OBSERVADOR 1: NOTIFICACION EN CONSOLA
        notificador.agregarObservador((nombreTarea, nuevoEstado) -> {
            System.out.println(
                    "NOTIFICACION: La tarea '" + nombreTarea
                            + "' cambio al estado: " + nuevoEstado
            );
        });

        // OBSERVADOR 2: NOTIFICACION EN INTERFAZ
        notificador.agregarObservador((nombreTarea, nuevoEstado) -> {
            JOptionPane.showMessageDialog(
                    this,
                    "La tarea '" + nombreTarea
                            + "' cambio al estado: " + nuevoEstado,
                    "Notificacion Observer",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // ENCABEZADO
        JLabel titulo = new JLabel(
                "GESTOR DE TAREAS Y PROYECTOS",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE);

        JPanel encabezado = new JPanel();
        encabezado.setBackground(new Color(35, 75, 120));
        encabezado.add(titulo);

        add(encabezado, BorderLayout.NORTH);

        // TABLA
        modelo = new DefaultTableModel(
                new String[]{"Tarea", "Prioridad", "Fecha limite", "Estado"}, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        tabla = new JTable(modelo);
        tabla.setRowHeight(30);

        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // FORMULARIO
        JPanel formulario = new JPanel(new GridLayout(2, 4, 10, 10));

        campoNombre = new JTextField();
        campoFecha = new JTextField();

        prioridad = new JComboBox<>(
                new String[]{"Alta", "Media", "Baja"}
        );

        estado = new JComboBox<>(
                new String[]{"Pendiente", "En curso", "En revision", "Terminada"}
        );

        formulario.add(new JLabel("Nombre de la tarea:"));
        formulario.add(new JLabel("Fecha limite:"));
        formulario.add(new JLabel("Prioridad:"));
        formulario.add(new JLabel("Estado:"));

        formulario.add(campoNombre);
        formulario.add(campoFecha);
        formulario.add(prioridad);
        formulario.add(estado);

        // BOTONES
        JButton crear = new JButton("Crear tarea");
        JButton eliminar = new JButton("Eliminar tarea");
        JButton proyecto = new JButton("Crear proyecto");
        JButton plantilla = new JButton("Crear desde plantilla");
        JButton cambiarEstado = new JButton("Cambiar estado");

        crear.addActionListener(e -> crearTarea());
        eliminar.addActionListener(e -> eliminarTarea());
        plantilla.addActionListener(e -> crearDesdePlantilla());
        cambiarEstado.addActionListener(e -> cambiarEstadoTarea());

        proyecto.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Modulo de proyectos en desarrollo."
                )
        );

        JPanel botones = new JPanel();
        botones.add(crear);
        botones.add(eliminar);
        botones.add(proyecto);
        botones.add(plantilla);
        botones.add(cambiarEstado);

        JPanel inferior = new JPanel(new BorderLayout(10, 10));
        inferior.add(formulario, BorderLayout.CENTER);
        inferior.add(botones, BorderLayout.SOUTH);

        add(inferior, BorderLayout.SOUTH);
    }

    // CREAR TAREA
    private void crearTarea() {

        String nombre = campoNombre.getText().trim();
        String fecha = campoFecha.getText().trim();

        if (nombre.isEmpty() || fecha.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Completa el nombre y la fecha limite."
            );
            return;
        }

        modelo.addRow(new Object[]{
                nombre,
                prioridad.getSelectedItem(),
                fecha,
                estado.getSelectedItem()
        });

        campoNombre.setText("");
        campoFecha.setText("");
    }

    // ELIMINAR TAREA
    private void eliminarTarea() {

        int fila = tabla.getSelectedRow();

        if (fila >= 0) {
            modelo.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona una tarea para eliminar."
            );
        }
    }

    // CAMBIAR ESTADO CON OBSERVER
    private void cambiarEstadoTarea() {

        int fila = tabla.getSelectedRow();

        if (fila >= 0) {

            String nombre = modelo.getValueAt(fila, 0).toString();
            String estadoAnterior = modelo.getValueAt(fila, 3).toString();
            String nuevoEstado = estado.getSelectedItem().toString();

            if (estadoAnterior.equals(nuevoEstado)) {
                JOptionPane.showMessageDialog(
                        this,
                        "La tarea ya tiene ese estado."
                );
                return;
            }

            modelo.setValueAt(nuevoEstado, fila, 3);

            // NOTIFICAR A LOS OBSERVADORES
            notificador.notificarCambio(nombre, nuevoEstado);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Selecciona una tarea para cambiar su estado."
            );
        }
    }

    // CREAR DESDE PLANTILLA - PROTOTYPE
    private void crearDesdePlantilla() {

        TareaPlantilla plantillaBase = new TareaPlantilla(
                "Reunion de proyecto",
                "Revisar avances del proyecto",
                "Media",
                Arrays.asList("Trabajo", "Organizacion")
        );

        TareaPlantilla nuevaTarea = plantillaBase.clonar();

        String nombre = JOptionPane.showInputDialog(
                this,
                "Nombre de la nueva tarea:",
                nuevaTarea.getTitulo()
        );

        if (nombre != null && !nombre.trim().isEmpty()) {

            modelo.addRow(new Object[]{
                    nombre,
                    nuevaTarea.getPrioridad(),
                    "Sin fecha",
                    "Pendiente"
            });

            JOptionPane.showMessageDialog(
                    this,
                    "Tarea creada utilizando Prototype."
            );
        }
    }

    // INICIAR PROGRAMA
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}
