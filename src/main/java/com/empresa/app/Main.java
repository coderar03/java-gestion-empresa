package com.empresa.app;

import com.empresa.model.Empresa;
import com.empresa.model.Empleado;
import com.empresa.model.Cliente;
import com.empresa.services.EmpresaService;
import com.empresa.exceptions.ArchivoNoEncontradoException;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        EmpresaService service = new EmpresaService(empresa);

        int opcion;

        do {
            System.out.println("\n=== MENÚ EMPRESA ===");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Listar personas");
            System.out.println("6. Guardar/Exportar datos");
            System.out.println("7. Importar datos");
            System.out.println("0. Salir");

            opcion = leerOpcion("Selecciona una opción: ");

            switch (opcion) {

                case 1:
                    System.out.println("\n=== Registrar empleado ===");

                    int idE = leerEntero("ID: ");
                    String nombreE = leerTexto("Nombre: ");
                    String emailE = leerTexto("Email: ");
                    int salario = leerEntero("Salario: ");
                    String departamento = leerTexto("Departamento: ");

                    empresa.registrarPersona(new Empleado(idE, nombreE, emailE, salario, departamento));
                    System.out.println("Empleado registrado.");
                    break;

                case 2:
                    System.out.println("\n=== Registrar cliente ===");

                    int idC = leerEntero("ID: ");
                    String nombreC = leerTexto("Nombre: ");
                    String emailC = leerTexto("Email: ");
                    String telefono = leerTexto("Teléfono: ");

                    empresa.registrarPersona(new Cliente(idC, nombreC, emailC, telefono));
                    System.out.println("Cliente registrado.");
                    break;

                case 3:
                    System.out.println("\n=== Eliminar persona ===");
                    int idEliminar = leerEntero("ID a eliminar: ");
                    empresa.eliminarPersona(idEliminar);
                    System.out.println("Persona eliminada (si existía).");
                    break;

                case 4:
                    System.out.println("\n=== Buscar persona ===");
                    String nombreBuscar = leerTexto("Nombre: ");

                    var persona = empresa.buscarPersona(nombreBuscar);
                    if (persona != null) {
                        System.out.println("Persona encontrada:");
                        persona.mostrarInfo();
                    } else {
                        System.out.println("No se encontró ninguna persona con ese nombre.");
                    }
                    break;

                case 5:
                    System.out.println("\n=== Listado de personas ===");
                    empresa.listarPersonas();
                    break;

                case 6:
                    System.out.println("\n=== Guardar/Exportar datos ===");
                    service.exportarDatos();
                    break;

                case 7:
                    System.out.println("\n=== Importar datos ===");
                    try {
                        service.importarDatos();
                    } catch (ArchivoNoEncontradoException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // ============================
    // VALIDACIONES PROFESIONALES
    // ============================

    // Validación de opciones del menú
    private static int leerOpcion(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            if (!entrada.matches("\\d+")) {
                System.out.println("Error: debes ingresar un número.");
                continue;
            }

            return Integer.parseInt(entrada);
        }
    }

    // Validación de enteros (ID, salario, etc.)
    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            if (!entrada.matches("\\d+")) {
                System.out.println("Error: ingresa un número válido.");
                continue;
            }

            return Integer.parseInt(entrada);
        }
    }

    // Validación de texto (nombre, email, teléfono)
    private static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacío.");
                continue;
            }

            return entrada;
        }
    }
}
