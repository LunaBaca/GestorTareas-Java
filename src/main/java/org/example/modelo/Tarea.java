package org.example.modelo;

public class Tarea {
    private String nombre;
    private boolean completada;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.completada = false;
    }

    public String getNombre() { return nombre; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean estado) { this.completada = estado; }

    @Override
    public String toString() {
        // Usamos "X" en lugar de símbolos especiales para evitar el cuadro vacío en algunas fuentes
        return (completada ? "[X] " : "[ ] ") + nombre;
    }
}