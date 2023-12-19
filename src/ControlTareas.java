import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Optional;

public class ControlTareas {
    private static final ControlTareas INSTANCE = new ControlTareas();
    private ControlTareas(){
        genDatos();
    }
    public static ControlTareas getInstance() {return INSTANCE;}
    private final HashMap<String, Tarea> tareas = new HashMap<>(); // <Título tarea, Tarea>

    public void addTarea(Tarea tarea) throws IllegalAccessException {
        if (this.tareas.containsKey(tarea.getTitulo()))
            throw new IllegalAccessException("Ya existe una tarea llmada '" + tarea.getTitulo() + "'");
        this.tareas.put(tarea.getTitulo(), tarea);
    }
    public Optional<Tarea> getTarea(String tituo){
        if (this.tareas.containsKey(tituo))
            return Optional.of(this.tareas.get(tituo));
        return Optional.empty();
    }

    public String[][] getTareas(){
        Tarea[] tareas = this.tareas.values().toArray(new Tarea[0]);
        String[][] datosTareas = new String[tareas.length][6];
        int i = 0;
        for (Tarea tarea : tareas){
            datosTareas[i][0] = tarea.getTitulo();
            datosTareas[i][1] = tarea.getTipo().toString();
            datosTareas[i][2] = tarea.getDescripcion();
            datosTareas[i][3] = tarea.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            datosTareas[i][4] = String.valueOf(tarea.getNotificar());
            datosTareas[i++][5] = String.valueOf(tarea.getTerminada());
        }
        return datosTareas;
    }

    private void genDatos(){
        try{
            addTarea(new Tarea(
                    "Tender la cama", TipoTarea.HOGAR, "Tender la cama", LocalDate.now(), true
            ));
            addTarea(new Tarea(
                    "Ir de Compras", TipoTarea.HOGAR,
                    """
                            - Pan
                            - Mortadela
                            - Ketchup
                            """, LocalDate.now(), true
            ));
            addTarea(new Tarea(
                    "Estudiar para la prueba de Cálculo", TipoTarea.ESTUDIOS,
                    "Repasar límites, derivadas, e integrales. Además de recordar conceptos clave",
                    LocalDate.now(), true
            ));
            addTarea(new Tarea(
                    "Cumpleaños de mi Primo", TipoTarea.AMIGOS,
                    "- Llevar torta de chocolate",
                    LocalDate.of(2024, 10, 15), true
            ));

        }
        catch(IllegalAccessException ignored){}
    }

    public void completarTarea(String nombreTarea){
        if (this.tareas.containsKey(nombreTarea)){
            this.tareas.get(nombreTarea).setTerminada(true);
        }
    }
}
