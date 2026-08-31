package com.empresa.services;

import com.empresa.exceptions.DatosVaciosException;
import com.empresa.exceptions.ArchivoNoEncontradoException;
import com.empresa.model.Empresa;
import com.empresa.model.Empleado;
import com.empresa.model.Cliente;

import javax.swing.JFileChooser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaService {

    private Empresa empresa;

    public EmpresaService(Empresa empresa) {
        this.empresa = empresa;
    }

    // VALIDACIÓN DATOS EN SISTEMA PARA EXPORTAR
    public void validarDatosParaExportar() throws DatosVaciosException {
        if (empresa.getEmpleados().isEmpty() && empresa.getClientes().isEmpty()) {
            throw new DatosVaciosException("No hay empleados ni clientes para exportar.");
        }
    }


    // EXPORTACIÓN EN TEXTO PLANO
    public void exportarDatos() {

        try {
            validarDatosParaExportar();

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Guardar datos de la empresa");

            int seleccion = chooser.showSaveDialog(null);
            if (seleccion != JFileChooser.APPROVE_OPTION) {
                System.out.println("Exportación cancelada.");
                return;
            }

            File ruta = chooser.getSelectedFile();

            // Listas finales sin duplicados
            List<Empleado> empleadosFinal = new ArrayList<>(empresa.getEmpleados());
            List<Cliente> clientesFinal = new ArrayList<>(empresa.getClientes());

            // Si el fichero existe, leerlo y evitar duplicados
            if (ruta.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(ruta));
                String linea;

                while ((linea = reader.readLine()) != null) {

                    // EMPLEADOS
                    if (linea.startsWith("E:")) {
                        String[] datos = linea.substring(2).split(",");
                        int id = Integer.parseInt(datos[0]);

                        boolean existe = false;
                        for (Empleado e : empleadosFinal) {
                            if (e.getId() == id) {
                                existe = true;
                                break;
                            }
                        }

                        if (!existe) {
                            int salario = Integer.parseInt(datos[3]);
                            Empleado nuevo = new Empleado(id, datos[1], datos[2], salario, datos[4]);
                            empleadosFinal.add(nuevo);
                        }
                    }

                    // CLIENTES
                    if (linea.startsWith("C:")) {
                        String[] datos = linea.substring(2).split(",");
                        int id = Integer.parseInt(datos[0]);

                        boolean existe = false;
                        for (Cliente c : clientesFinal) {
                            if (c.getId() == id) {
                                existe = true;
                                break;
                            }
                        }

                        if (!existe) {
                            // Cliente(id, nombre, email, telefono)
                            Cliente nuevo = new Cliente(id, datos[1], datos[2], datos[3]);
                            clientesFinal.add(nuevo);
                        }
                    }
                }

                reader.close();
            }

            // Escritura en texto plano
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));

            // EMPLEADOS
            for (Empleado e : empleadosFinal) {
                writer.write("E:" + e.getId() + "," + e.getNombre() + "," +
                             e.getEmail() + "," + e.getSalario() + "," +
                             e.getDepartamento() + "\n");
            }

            // CLIENTES
            for (Cliente c : clientesFinal) {
                writer.write("C:" + c.getId() + "," + c.getNombre() + "," +
                             c.getEmail() + "," + c.getTelefono() + "\n");
            }

            writer.close();

            System.out.println("Datos exportados correctamente.");

        } catch (DatosVaciosException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al exportar datos: " + e.getMessage());
        }
    }

    // IMPORTACIÓN
    public void importarDatos() throws ArchivoNoEncontradoException {

        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Selecciona el archivo a importar");

            int seleccion = chooser.showOpenDialog(null);
            if (seleccion != JFileChooser.APPROVE_OPTION) {
                System.out.println("Importación cancelada.");
                return;
            }

            File ruta = chooser.getSelectedFile();

            if (!ruta.exists()) {
                throw new ArchivoNoEncontradoException("La ruta seleccionada no existe");
            }

            // Listas actuales
            List<Empleado> empleadosFinal = new ArrayList<>(empresa.getEmpleados());
            List<Cliente> clientesFinal = new ArrayList<>(empresa.getClientes());

            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = reader.readLine()) != null) {

                if (linea.startsWith("E:")) {
                    String[] datos = linea.substring(2).split(",");
                    int id = Integer.parseInt(datos[0]);
                    int salario = Integer.parseInt(datos[3]);

                    Empleado nuevo = new Empleado(id, datos[1], datos[2], salario, datos[4]);
                    empleadosFinal.add(nuevo);
                }

                if (linea.startsWith("C:")) {
                    String[] datos = linea.substring(2).split(",");
                    int id = Integer.parseInt(datos[0]);

                    Cliente nuevo = new Cliente(id, datos[1], datos[2], datos[3]);
                    clientesFinal.add(nuevo);
                }
            }

            reader.close();

            // Actualizar empresa
            empresa.setEmpleados(empleadosFinal);
            empresa.setClientes(clientesFinal);

            System.out.println("Datos importados correctamente.");

        } catch (ArchivoNoEncontradoException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al importar datos: " + e.getMessage());
        }
    }   

}
