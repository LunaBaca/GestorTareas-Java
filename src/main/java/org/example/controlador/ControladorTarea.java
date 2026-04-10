package org.example.controlador;

import org.example.modelo.Tarea;
import org.example.vista.VistaTarea;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorTarea {
    private VistaTarea vista;
    private List<Tarea> listaMaestra; // Aquí guardamos todas las tareas originales

    public ControladorTarea(VistaTarea vista) {
        this.vista = vista;
        this.listaMaestra = new ArrayList<>();
        initEventos();
    }

    // Configura qué pasa al tocar cada botón
    private void initEventos() {
        vista.btnAgregar.addActionListener(e -> agregarTarea());
        vista.btnCompletar.addActionListener(e -> completarTarea());
        vista.btnEliminar.addActionListener(e -> eliminarTarea());
        vista.comboFiltro.addActionListener(e -> aplicarFiltro());
    }

    private void agregarTarea() {
        String texto = vista.txtTarea.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "¡No puedes agregar una tarea vacía!");
            return;
        }
        listaMaestra.add(new Tarea(texto));
        vista.txtTarea.setText(""); // Limpiar el cuadro de texto
        aplicarFiltro(); // Refrescar la lista visual
    }

    private void completarTarea() {
        Tarea seleccionada = vista.listaTareas.getSelectedValue();
        if (seleccionada != null) {
            seleccionada.setCompletada(true);
            aplicarFiltro();
        } else {
            JOptionPane.showMessageDialog(vista, "Selecciona una tarea de la lista.");
        }
    }

    private void eliminarTarea() {
        Tarea seleccionada = vista.listaTareas.getSelectedValue();
        if (seleccionada != null) {
            listaMaestra.remove(seleccionada);
            aplicarFiltro();
        } else {
            JOptionPane.showMessageDialog(vista, "Selecciona qué tarea quieres borrar.");
        }
    }

    private void aplicarFiltro() {
        String filtro = (String) vista.comboFiltro.getSelectedItem();
        List<Tarea> tareasFiltradas;

        // Lógica para filtrar según el ComboBox
        if (filtro.equals("Pendientes")) {
            tareasFiltradas = listaMaestra.stream()
                    .filter(t -> !t.isCompletada())
                    .collect(Collectors.toList());
        } else if (filtro.equals("Completadas")) {
            tareasFiltradas = listaMaestra.stream()
                    .filter(Tarea::isCompletada)
                    .collect(Collectors.toList());
        } else {
            tareasFiltradas = listaMaestra; // "Todas"
        }

        // Actualizar la lista que el usuario ve en la ventana
        vista.modeloLista.clear();
        for (Tarea t : tareasFiltradas) {
            vista.modeloLista.addElement(t);
        }
    }
}