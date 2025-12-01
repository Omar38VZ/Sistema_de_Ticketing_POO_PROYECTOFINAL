package LIS;
public class Tecnico extends Usuario {

    Tecnico ( String matricula, String nombre) { 
        super(matricula, nombre);
    }

    @Override
    public String toString () { 
        return "Tecnico: " + getNombre() + " Matricula: " + getMatricula();
    }
}
