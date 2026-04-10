package org.example;

import org.example.vista.VistaTarea;
import org.example.controlador.ControladorTarea;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        java.awt.EventQueue.invokeLater(() -> {
            VistaTarea vista = new VistaTarea();
            new ControladorTarea(vista);
            vista.setVisible(true);
        });
    }
}