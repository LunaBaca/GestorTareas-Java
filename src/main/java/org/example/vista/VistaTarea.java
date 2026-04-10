package org.example.vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import org.example.modelo.Tarea;

public class VistaTarea extends JFrame {
    public JTextField txtTarea = new JTextField(25);
    public JButton btnAgregar = new JButton("Agregar Tarea");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnCompletar = new JButton("Completar Tarea");

    public DefaultListModel<Tarea> modeloLista = new DefaultListModel<>();
    public JList<Tarea> listaTareas = new JList<>(modeloLista);

    public JComboBox<String> comboFiltro = new JComboBox<>(new String[]{"Todas", "Pendientes", "Completadas"});

    // --- PALETA DE COLORES ACTUALIZADA ---
    Color verdeOscuroFondo = new Color(52, 90, 52);
    Color verdeBotonClaro = new Color(180, 220, 180); // Verde pastel para que resalte la letra negra
    Color grisBotonClaro = new Color(220, 220, 220);  // Gris claro para botones de acción
    Color verdeListaFondo = new Color(225, 240, 225);
    Color blancoHueso = new Color(245, 255, 245);

    public VistaTarea() {
        setTitle("🌿 Gestor de Tareas Estilizado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

        getContentPane().setBackground(verdeOscuroFondo);

        // --- 2. PARTE SUPERIOR ---
        JPanel pnlNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        pnlNorte.setBackground(verdeOscuroFondo);
        JLabel lblNueva = new JLabel("Nueva Tarea:");
        lblNueva.setForeground(Color.WHITE); // Texto blanco para que resalte en el fondo oscuro
        pnlNorte.add(lblNueva);
        pnlNorte.add(txtTarea);

        // Botón agregar en verde claro con letras negras
        estilizarBoton(btnAgregar, verdeBotonClaro);
        pnlNorte.add(btnAgregar);

        // --- 3. PARTE CENTRAL ---
        listaTareas.setBackground(verdeListaFondo);
        listaTareas.setSelectionBackground(new Color(170, 210, 170));
        listaTareas.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JScrollPane scrollLista = new JScrollPane(listaTareas);
        TitledBorder bordeLista = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2, true), " Lista de Pendientes "
        );
        bordeLista.setTitleColor(Color.WHITE);
        scrollLista.setBorder(bordeLista);
        scrollLista.setOpaque(false);
        scrollLista.getViewport().setOpaque(false);

        add(scrollLista, BorderLayout.CENTER);

        // --- 4. PARTE INFERIOR ---
        JPanel pnlSurAcciones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        pnlSurAcciones.setBackground(verdeOscuroFondo);

        // Botones de acción en gris claro con letras negras
        estilizarBoton(btnCompletar, grisBotonClaro);
        estilizarBoton(btnEliminar, new Color(255, 200, 200)); // Rojo muy suave para eliminar

        pnlSurAcciones.add(btnCompletar);
        pnlSurAcciones.add(btnEliminar);

        JLabel lblVer = new JLabel("Ver:");
        lblVer.setForeground(Color.WHITE);
        pnlSurAcciones.add(lblVer);
        pnlSurAcciones.add(comboFiltro);

        add(pnlNorte, BorderLayout.NORTH);
        add(pnlSurAcciones, BorderLayout.SOUTH);

        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        setSize(750, 550); // Un poco más ancho para los botones grandes
        setLocationRelativeTo(null);
    }

    /**
     * MODIFICADO: Botones planos, letras negras y más grandes (padding)
     */
    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.BLACK); // Letras negras
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);   // Quita el borde 3D/cuadriculado
        boton.setFont(new Font("Segoe UI", Font.BOLD, 13));

        // El "cuadro más grande" se logra con este borde vacío (arriba, izquierda, abajo, derecha)
        // Esto le da relleno (padding) al botón
        boton.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));

        // Cambia el cursor a mano para indicar que es clickeable
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}