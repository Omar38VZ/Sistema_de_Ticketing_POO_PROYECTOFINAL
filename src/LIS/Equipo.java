package LIS;
public class Equipo {
    private String numero; 
    private String ip; 

    Equipo (String numero, String ip) { 
        this.numero = numero; 
        this.ip = ip; 
    }

    public String getNumero() { 
        return numero;
    }

    public String getIp() { 
        return ip;
    }

    @Override
    public String toString () {     
        return "Num Equipo: " + numero + " Ip: " + ip;
    }
}
