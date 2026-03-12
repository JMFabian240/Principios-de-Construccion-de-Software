import java.time.LocalDateTime;

public class Operacion {
    private final TipoOperacion tipo;
    private final double monto;
    private final LocalDateTime fecha;

    public Operacion(TipoOperacion tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
    }

    public TipoOperacion getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "[" + fecha + "] " + tipo + " - $" + String.format("%.2f", monto);
    }
}
