package pe.certus.AdoptaVida.model;

public class Notification {

    private String icono;
    private String color;
    private String titulo;
    private String mensaje;
    private String hora;
    private boolean leido;

    public Notification(String icono, String color, String titulo, String mensaje, String hora, boolean leido) {
        this.icono = icono;
        this.color = color;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.hora = hora;
        this.leido = leido;
    }

    public String getIcono() { 
    	return icono; 
    }
    
    public String getColor() { 
    	return color; 
    }
    
    public String getTitulo() { 
    	return titulo; 
    }
    
    public String getMensaje() { 
    	return mensaje; 
    }
    
    public String getHora() { 
    	return hora; 
    }
    
    public boolean isLeido() { 
    	return leido; 
    }
}
