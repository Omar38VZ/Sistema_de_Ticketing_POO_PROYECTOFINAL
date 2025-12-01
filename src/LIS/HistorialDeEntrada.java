package LIS;
import java.time.LocalDateTime; 
public class HistorialDeEntrada {
    private LocalDateTime fechaHora; 
    private String descripcion; 

    HistorialDeEntrada (LocalDateTime fechaHora, String descripcion) { 
        this.fechaHora = fechaHora; 
        this.descripcion = descripcion; 
    }

    public LocalDateTime getFechaHora () { 
        return fechaHora; 
    }
    public String getDescripcion () { 
        return descripcion; 
    }

    @Override
    public String toString () { 
        return "[" + fechaHora + "]" + descripcion;
    }

    }

