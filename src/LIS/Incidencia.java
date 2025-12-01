package LIS;
import java.time.LocalDateTime; 
import java.util.ArrayList;
import java.util.List; 

public class Incidencia {

    private int id; 
    private String descripcion; 
    private TipoIncidencia tipo;
    private Prioridad prioridad;
    private EstadoDeIncidencia estado;
    private LocalDateTime fechaRegistro; 
    private Equipo equipo;
    private Tecnico tecnicoAsignado;
    private Usuario usuarioReporta;
    private List<HistorialDeEntrada> historial;

    Incidencia (int id,
                String descripcion,
                TipoIncidencia tipo,
                Equipo equipo,
                Usuario usuarioReporta) { 

        this.id = id; 
        this.descripcion = descripcion; 
        this.tipo = tipo; 
        this.prioridad = null; // sin prioridad hasta que el técnico la asigne
        this.estado = EstadoDeIncidencia.Registrada;
        this.fechaRegistro = LocalDateTime.now();
        this.equipo = equipo;
        this.usuarioReporta = usuarioReporta;
        this.historial = new ArrayList<>(); 

        agregarHistorial("Incidencia creada por: " 
                + usuarioReporta.getNombre() 
                + " (" + usuarioReporta.getMatricula() + ")");
    }

    public int getId () { 
        return id; 
    }

    public EstadoDeIncidencia getEstado () { 
        return estado;
    }

    public TipoIncidencia getTipo () { 
        return tipo;    
    }

    public Prioridad getPrioridad () { 
        return prioridad;
    }

    public Tecnico getTecnicoAsignado () { 
        return tecnicoAsignado;
    }

    public Usuario getUsuarioReporta () { 
        return usuarioReporta;
    }

    public void asignarTecnico (Tecnico tecnico) {
        this.tecnicoAsignado = tecnico;
        agregarHistorial("Técnico asignado: " 
                + tecnico.getNombre() 
                + " (" + tecnico.getMatricula() + ")");
    }
        
    public void cambiarEstado (EstadoDeIncidencia nuevoEstadoDeIncidencia) {
        this.estado = nuevoEstadoDeIncidencia;
        agregarHistorial("Estado cambiado a: " + nuevoEstadoDeIncidencia);
    }

    //cambiar prioridad (lo usa el técnico)
    public void cambiarPrioridad(Prioridad nuevaPrioridad) {
        this.prioridad = nuevaPrioridad;
        agregarHistorial("Prioridad cambiada a: " + nuevaPrioridad);
    }

    public void agregarHistorial (String descripcion) { 
        historial.add(new HistorialDeEntrada(LocalDateTime.now(), descripcion)); 
    }

    public List<HistorialDeEntrada> getHistorial() { 
        return historial;
    }

    @Override
    public String toString() { 
        String tecnicoInfo = (tecnicoAsignado == null)
                ? "SIN TÉCNICO"
                : tecnicoAsignado.getNombre() + " (" + tecnicoAsignado.getMatricula() + ")";

        String prioridadInfo = (prioridad == null)
                ? "SIN PRIORIDAD"
                : prioridad.toString();

        return "Incidencia #" + id +
                " | Tipo: " + tipo +
                " | Prioridad: " + prioridadInfo +
                " | Estado: " + estado +
                " | Equipo: " + equipo.getNumero() +
                " | IP: " + equipo.getIp() +
                " | Fecha Registro: " + fechaRegistro +
                " | Reporta: " + usuarioReporta.getNombre() +
                " (" + usuarioReporta.getMatricula() + ")" +
                " | Técnico: " + tecnicoInfo +
                " | Desc: " + descripcion;
    }

}