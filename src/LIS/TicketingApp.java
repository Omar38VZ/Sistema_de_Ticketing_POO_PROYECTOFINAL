package LIS;
import java.util.Scanner;

public class TicketingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaTicketing sistema = new SistemaTicketing();

        boolean salirSistema = false;

        while (!salirSistema) {

            // Menú principal para seleccionar tipo de usuario
            System.out.println("===== Selección de tipo de usuario =====");
            System.out.println("1. Usuario que reporta");
            System.out.println("2. Técnico");
            System.out.println("0. Salir del sistema");
            System.out.print("Elige una opción: ");

            String lineaTipo = sc.nextLine();
            if (lineaTipo.isEmpty()) {
                System.out.println("Opción inválida.");
                continue;
            }

            int tipoUsuario = Integer.parseInt(lineaTipo);

            switch (tipoUsuario) {
                case 1 -> {
                    // mode de usuario que reporta
                    int opcionUsuario = -1;
                    do {
                        mostrarMenuUsuario();
                        System.out.print("Elige una opción: ");
                        String linea = sc.nextLine();
                        if (linea.isEmpty()) {
                            continue;
                        }

                        opcionUsuario = Integer.parseInt(linea);

                        switch (opcionUsuario) {
                            case 1 -> sistema.registrarIncidencia(sc);
                            case 0 -> System.out.println("Regresando al menú principal de tipo de usuario...");
                            default -> System.out.println("Opción inválida.");
                        }

                        System.out.println();
                    } while (opcionUsuario != 0);
                }

                case 2 -> {
                    // modo tecnmico 
                    int opcionTecnico = -1;
                    do {
                        mostrarMenuTecnico();
                        System.out.print("Elige una opción: ");
                        String linea = sc.nextLine();
                        if (linea.isEmpty()) {
                            continue;
                        }

                        opcionTecnico = Integer.parseInt(linea);

                        switch (opcionTecnico) {
                            case 1 -> sistema.registrarIncidencia(sc);
                            case 2 -> sistema.listarIncidencias();
                            case 3 -> sistema.flitrarPorEstado(sc);
                            case 4 -> sistema.asignarTecnico(sc);
                            case 5 -> sistema.cambiarEstadoIncidencia(sc);
                            case 6 -> sistema.generarReporteBasico();
                            case 7 -> sistema.cambiarPrioridadIncidencia(sc);
                            case 8 -> sistema.listarIncidenciasEnProcesoPorPrioridad(sc);
                            case 0 -> System.out.println("Regresando al menú principal de tipo de usuario...");
                            default -> System.out.println("Opción inválida.");
                        }

                        System.out.println();
                    } while (opcionTecnico != 0);
                }

                case 0 -> {
                    System.out.println("Saliendo del sistema por completo...");
                    salirSistema = true;
                }

                default -> System.out.println("Opción inválida.");
            }

            System.out.println();
        }

        sc.close();
    }

    // Menú para usuario normal solo con opción de registrar incidencia
    private static void mostrarMenuUsuario() {
        System.out.println("===== Ticketing LAB-LIS - Usuario que reporta =====");
        System.out.println("1. Registrar incidencia");
        System.out.println("0. Regresar");
    }

    // Menú para técnico todas las opciones
    private static void mostrarMenuTecnico() {
        System.out.println("===== Ticketing LAB-LIS - Técnico =====");
        System.out.println("1. Registrar incidencia");
        System.out.println("2. Listar incidencias");
        System.out.println("3. Filtrar incidencias por estado");
        System.out.println("4. Asignar técnico a incidencia");
        System.out.println("5. Cambiar estado de incidencia");
        System.out.println("6. Generar reporte básico");
        System.out.println("7. Cambiar prioridad de incidencia");
        System.out.println("8. Listar incidencias EN PROCESO por prioridad");
        System.out.println("0. Regresar");
    }
}
