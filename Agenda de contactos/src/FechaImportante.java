import java.time.LocalDate;

public class FechaImportante {
    private LocalDate fecha;
    private String evento;

    public FechaImportante(LocalDate fecha, String evento) {
        this.fecha = fecha;
        this.evento = evento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (fecha != null && evento != null && !evento.trim().isEmpty()) {
            sb.append(evento).append(": ").append(fecha.toString());
        }
        return sb.toString();
    }
}