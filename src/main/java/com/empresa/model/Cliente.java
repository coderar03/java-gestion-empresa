package com.empresa.model;

import java.util.ArrayList;

public class Cliente extends Persona {

    private int telefono;
    private ArrayList<Integer> historialCompras;

    // Constructor vacío
    public Cliente() {
        super();
        this.historialCompras = new ArrayList<>();
    }

    // Constructor completo (cuando ya tienes historial)
    public Cliente(int id, String nombre, String email, int telefono, ArrayList<Integer> historialCompras) {
        super(id, nombre, email);
        this.telefono = telefono;
        this.historialCompras = new ArrayList<>(historialCompras);
    }

    // Constructor para importación desde texto plano
    public Cliente(int id, String nombre, String email, String telefono) {
        super(id, nombre, email);
        this.telefono = Integer.parseInt(telefono);
        this.historialCompras = new ArrayList<>();
    }

    // Getters y setters
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Integer> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(ArrayList<Integer> historialCompras) {
        this.historialCompras = historialCompras;
    }

    // Implementación del método abstracto
    @Override
    public void mostrarInfo() {
        System.out.println(
            "Id: " + getId() +
            " | Cliente: " + getNombre() +
            " | Email: " + getEmail() +
            " | Teléfono: " + getTelefono() +
            " | Historial de Compras: " + getHistorialCompras()
        );
    }

    // Método para agregar compra al historial
    public void agregarCompra(int compra) {
        historialCompras.add(compra);
    }
}

