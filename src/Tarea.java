import java.time.LocalDate;

public class Tarea {
    private String titulo;
    private String descripcion;
    private TipoTarea tipo;
    private LocalDate fecha;
    private boolean notificar;
    private boolean terminada = false;

    public Tarea(String titulo, TipoTarea tipoTarea, String descripcion, LocalDate fecha, boolean notificar) {
        this.titulo = titulo;
        this.tipo = tipoTarea;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.notificar = notificar;
    }
    public Tarea(String titulo, TipoTarea tipoTarea, LocalDate fecha, boolean notificar) {
        this.titulo = titulo;
        this.tipo = tipoTarea;
        this.descripcion = "";
        this.fecha = fecha;
        this.notificar = notificar;
    }

    public String getTitulo() {return titulo;}
    public TipoTarea getTipo() {return tipo;}
    public String getDescripcion() {return descripcion;}
    public LocalDate getFecha() {return fecha;}
    public boolean getNotificar(){return notificar;}
    public boolean getTerminada(){return terminada;}

    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setTipo(TipoTarea tipoTarea) {this.tipo = tipoTarea;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public void setNotificar(boolean notificar){this.notificar = notificar;}
    public void setTerminada(boolean terminada){this.terminada = terminada;}
}

