package LIS;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaTicketing {
    private List<Incidencia> incidencias; 
    private List<Equipo> equipos; 
    private List<Tecnico> tecnicos; 
    private int siguienteIncidenciaId;

    public SistemaTicketing() {     
        incidencias = new ArrayList<>();
        equipos = new ArrayList<>();
        tecnicos = new ArrayList<>();
        siguienteIncidenciaId = 1;

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() { 
        tecnicos.add(new Tecnico("Iibanez01", "Mtro. Irwing Ibañez")); 
        // aquí se pueden agregar más técnicos

        equipos.add(new Equipo("PC-01", "192.168.1.10"));
        equipos.add(new Equipo("PC-02", "192.168.1.11"));
        equipos.add(new Equipo("PC-03", "192.168.1.12"));
        equipos.add(new Equipo("PC-04", "192.168.1.13"));
        equipos.add(new Equipo("PC-05", "192.168.1.14"));
        equipos.add(new Equipo("PC-06", "192.168.1.15"));
        equipos.add(new Equipo("PC-07", "192.168.1.16"));
        equipos.add(new Equipo("PC-08", "192.168.1.17"));
        equipos.add(new Equipo("PC-09", "192.168.1.18"));
        equipos.add(new Equipo("PC-10", "192.168.1.19"));
        equipos.add(new Equipo("PC-11", "192.168.1.20"));
        equipos.add(new Equipo("PC-12", "192.168.1.21"));
        equipos.add(new Equipo("PC-13", "192.168.1.22"));
        equipos.add(new Equipo("PC-14", "192.168.1.23"));
        equipos.add(new Equipo("PC-15", "192.168.1.24"));
        equipos.add(new Equipo("PC-16", "192.168.1.25"));
        equipos.add(new Equipo("PC-17", "192.168.1.26"));
        equipos.add(new Equipo("PC-18", "192.168.1.27"));
        equipos.add(new Equipo("PC-19", "192.168.1.28"));
        equipos.add(new Equipo("PC-20", "192.168.1.29"));
        equipos.add(new Equipo("PC-21", "192.168.1.30"));
        equipos.add(new Equipo("PC-22", "192.168.1.31"));
        equipos.add(new Equipo("PC-23", "192.168.1.32"));
        equipos.add(new Equipo("PC-24", "192.168.1.33"));
        equipos.add(new Equipo("PC-25", "192.168.1.34"));
        equipos.add(new Equipo("PC-26", "192.168.1.35"));
        equipos.add(new Equipo("PC-27", "192.168.1.36"));
        equipos.add(new Equipo("PC-28", "192.168.1.37"));
        equipos.add(new Equipo("PC-29", "192.168.1.38"));
        equipos.add(new Equipo("PC-30", "192.168.1.39"));
        equipos.add(new Equipo("PC-31", "192.168.1.40"));
        equipos.add(new Equipo("PC-32", "192.168.1.41"));
        equipos.add(new Equipo("PC-33", "192.168.1.42"));
        equipos.add(new Equipo("PC-34", "192.168.1.43"));
        equipos.add(new Equipo("PC-35", "192.168.1.44"));
        equipos.add(new Equipo("PC-36", "192.168.1.45"));
        equipos.add(new Equipo("PC-37", "192.168.1.46"));
        equipos.add(new Equipo("PC-38", "192.168.1.47"));
        equipos.add(new Equipo("PC-39", "192.168.1.48"));
        equipos.add(new Equipo("PC-40", "192.168.1.49"));
        equipos.add(new Equipo("PC-41", "192.168.1.50"));
        equipos.add(new Equipo("PC-42", "192.168.1.51"));
        equipos.add(new Equipo("PC-43", "192.168.1.52"));
        equipos.add(new Equipo("PC-44", "192.168.1.53"));
        equipos.add(new Equipo("PC-45", "192.168.1.54"));
        equipos.add(new Equipo("PC-46", "192.168.1.55"));
        equipos.add(new Equipo("PC-47", "192.168.1.56"));
        equipos.add(new Equipo("PC-48", "192.168.1.57"));
        equipos.add(new Equipo("PC-49", "192.168.1.58"));
        equipos.add(new Equipo("PC-50", "192.168.1.59"));
    }

    public void registrarIncidencia(Scanner sc) { 
        System.out.println("Registrar Nueva Incidencia");

        // Datos del usuario que reporta
        System.out.print("Matrícula del usuario que reporta: ");
        String matriculaUsuario = sc.nextLine();

        System.out.print("Nombre del usuario que reporta: ");
        String nombreUsuario = sc.nextLine();

        Usuario usuarioReporta = new Usuario(matriculaUsuario, nombreUsuario);

        // Datos de la incidencia
        System.out.print("Descripción de la incidencia: ");
        String descripcion = sc.nextLine();

        TipoIncidencia tipo = leerTipo(sc);
    
        Equipo equipo = seleccionarEquipo(sc);

        Incidencia incidencia = new Incidencia(
                siguienteIncidenciaId++,
                descripcion,
                tipo,
                equipo,
                usuarioReporta
        );

        incidencias.add(incidencia);

        System.out.println("Incidencia registrada con ID: " + incidencia.getId());
    }

    public void listarIncidencias() {
        System.out.println("--- Lista de incidencias ---");
        if (incidencias.isEmpty()) {
            System.out.println("No hay incidencias registradas.");
            return;
        }
        for (Incidencia i : incidencias) {
            System.out.println(i);
        }
    }
    
    public void flitrarPorEstado(Scanner sc) { 
        System.out.println("Filtrar incidencias por estado: ");
        EstadoDeIncidencia estadoFiltro = leerEstado(sc);
        boolean encontrado = false;
        for (Incidencia i : incidencias) {
            if (i.getEstado() == estadoFiltro) {
                System.out.println(i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron incidencias con el estado: " + estadoFiltro);
        }
    }
    
    public void asignarTecnico(Scanner sc) { 
        System.out.println("--- Asignar Técnico a Incidencia ---");
        listarIncidencias();
        System.out.print("Id de incidencia: " );
        int idIncidencia = Integer.parseInt(sc.nextLine());
        
        Incidencia incidencia = buscarIncidenciaPorId(idIncidencia);
        if (incidencia == null) {  
            System.out.println("Incidencia no encontrada.");
            return;
        }
        Tecnico tecnico = seleccionarTecnico(sc);
        if (tecnico != null) {
            incidencia.asignarTecnico(tecnico);
            System.out.println("Técnico asignado correctamente.");
        }
    }

    public void cambiarEstadoIncidencia(Scanner sc) { 
        System.out.println("--- Cambiar Estado de Incidencia ---");
        listarIncidencias();
        System.out.print("Id de incidencia: " );
        int idIncidencia = Integer.parseInt(sc.nextLine());
        
        Incidencia incidencia = buscarIncidenciaPorId(idIncidencia);
        if (incidencia == null) {  
            System.out.println("Incidencia no encontrada.");
            return;
        }
        EstadoDeIncidencia nuevoEstado = leerEstado(sc);
        incidencia.cambiarEstado(nuevoEstado);
        System.out.println("Estado cambiado correctamente.");
    }

    // cambiar prioridad 
    public void cambiarPrioridadIncidencia(Scanner sc) {
        System.out.println("--- Cambiar Prioridad de Incidencia ---");
        listarIncidencias();
        System.out.print("Id de incidencia: ");
        int idIncidencia = Integer.parseInt(sc.nextLine());

        Incidencia incidencia = buscarIncidenciaPorId(idIncidencia);
        if (incidencia == null) {
            System.out.println("Incidencia no encontrada.");
            return;
        }

        System.out.println("Seleccione la nueva prioridad:");
        Prioridad nuevaPrioridad = leerPrioridad(sc);

        incidencia.cambiarPrioridad(nuevaPrioridad);
        System.out.println("Prioridad cambiada correctamente.");
    }

    // Listar incidencias en proceso por prioridad
public void listarIncidenciasEnProcesoPorPrioridad(Scanner sc) {
    System.out.println("--- Listar incidencias EN PROCESO por prioridad ---");

    // Pedimos la prioridad a buscar
    Prioridad prioridadFiltro = leerPrioridad(sc);

    boolean encontrado = false;
    for (Incidencia i : incidencias) {
        // Solo incidencias en proceso
        if (i.getEstado() == EstadoDeIncidencia.EnProceso 
                && i.getPrioridad() == prioridadFiltro) {

            System.out.println(i);
            encontrado = true;
        }
    }

    if (!encontrado) {
        System.out.println("No se encontraron incidencias EN PROCESO con prioridad " 
                           + prioridadFiltro);
    }
}

    public void generarReporteBasico() { 
        System.out.println("--- Reporte básico de laboratorio ---");
        int totalIncidencias = incidencias.size();
        int registradas = 0, enProceso = 0, resueltas = 0, cerradas = 0;

        for (Incidencia i : incidencias) {
            switch (i.getEstado()) {
                case Registrada -> registradas++;
                case EnProceso -> enProceso++;
                case Resuelta -> resueltas++;
                case Cerrada -> cerradas++;
            }
        }
        System.out.println("Total de incidencias: " + totalIncidencias);
        System.out.println("Registradas: " + registradas);
        System.out.println("En Proceso: " + enProceso);
        System.out.println("Resueltas: " + resueltas);
        System.out.println("Cerradas: " + cerradas);
    }

    private Incidencia buscarIncidenciaPorId(int id) { 
        for (Incidencia i : incidencias) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    private Equipo seleccionarEquipo(Scanner sc) { 
        System.out.println("Seleccionar equipo:");
        for (Equipo e : equipos) {
            System.out.println(e);
        }
        System.out.print("Número de equipo: ");
        String numeroEquipo = sc.nextLine();

        for (Equipo e : equipos) {
            if (e.getNumero().equalsIgnoreCase(numeroEquipo)) {
                return e;
            }
        }
        System.out.println("Equipo no encontrado. Seleccionando el primer equipo por defecto.");
        return equipos.get(0);
    }
    
    private Tecnico seleccionarTecnico(Scanner sc) { 
        System.out.println("Seleccionar técnico:");
        for (Tecnico t : tecnicos) {
            System.out.println(t);
        }
        System.out.print("Matrícula del técnico: ");
        String matriculaTecnico = sc.nextLine();

        for (Tecnico t : tecnicos) {
            if (t.getMatricula().equalsIgnoreCase(matriculaTecnico)) {
                return t;
            }
        }
        System.out.println("Técnico no encontrado.");
        return null;
    }

    private TipoIncidencia leerTipo(Scanner sc) {
        System.out.println("Tipo de incidencia:");
        System.out.println("1. Hardware");
        System.out.println("2. Software");
        System.out.println("3. Red");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());
        return switch (op) {
            case 1 -> TipoIncidencia.Hardware;
            case 2 -> TipoIncidencia.Software;
            case 3 -> TipoIncidencia.Red;
            default -> TipoIncidencia.Software;
        };
    }

    private Prioridad leerPrioridad(Scanner sc) {
        System.out.println("Prioridad:");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Baja");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());
        return switch (op) {
            case 1 -> Prioridad.Alta;
            case 2 -> Prioridad.Media;
            case 3 -> Prioridad.Baja;
            default -> Prioridad.Media;
        };
    }

    private EstadoDeIncidencia leerEstado(Scanner sc) {
        System.out.println("Estado:");
        System.out.println("1. Registrada");
        System.out.println("2. EnProceso");
        System.out.println("3. Resuelta");
        System.out.println("4. Cerrada");
        System.out.print("Opción: ");
        int op = Integer.parseInt(sc.nextLine());
        return switch (op) {
            case 1 -> EstadoDeIncidencia.Registrada;
            case 2 -> EstadoDeIncidencia.EnProceso;
            case 3 -> EstadoDeIncidencia.Resuelta;
            case 4 -> EstadoDeIncidencia.Cerrada;
            default -> EstadoDeIncidencia.Registrada;
        };
    }
}
