package com.empresa.model;

import com.empresa.interfaces.OperacionesEmpresa;
import java.util.ArrayList;
import java.util.List;

public class Empresa implements OperacionesEmpresa {

    private List<Empleado> empleados;
    private List<Cliente> clientes;

    public Empresa() {
        empleados = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    @Override
    public void registrarPersona(Persona p) {
        if (p instanceof Empleado) {
            empleados.add((Empleado) p);
        } 
        else if (p instanceof Cliente) {
            clientes.add((Cliente) p);
        }
    }

    @Override
    public void eliminarPersona(int id) {
        empleados.removeIf(e -> e.getId() == id);
        clientes.removeIf(c -> c.getId() == id);
    }

    @Override
    public Persona buscarPersona(String nombre) {
        for (Empleado e : empleados) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void listarPersonas() {
        System.out.println("=== Empleados ===");
        for (Empleado e : empleados) {
            e.mostrarInfo();
        }

        System.out.println("=== Clientes ===");
        for (Cliente c : clientes) {
            c.mostrarInfo();
        }
    }

    // GETTERS NECESARIOS PARA EmpresaService
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    // SETTERS NECESARIOS PARA EmpresaService
    public void setEmpleados(List<Empleado> empleados) {
    this.empleados = empleados;
    }   

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }



}
