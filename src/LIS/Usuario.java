package LIS;
public class Usuario {
    private String matricula; 
    private String nombre;

    Usuario(String matricula, String nombre){
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public String getMatricula () { 
        return matricula; 
    }
    public String getNombre () { 
        return nombre; 
    }

    @Override
    public String toString() { 
        return "Usuario: " + nombre + " | Matricula: " + matricula;
    }
}

