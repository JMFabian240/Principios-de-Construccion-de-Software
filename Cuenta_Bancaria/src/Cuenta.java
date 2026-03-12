import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private final String numeroCuenta;
    private final String numeroTarjeta;
    private double saldo;
    private final List<Operacion> historial;

    public Cuenta(String numeroCuenta, String numeroTarjeta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
    }

    public boolean depositar(double monto) {
        if (monto <= 0) {
            return false;
        }
        saldo += monto;
        historial.add(new Operacion(TipoOperacion.DEPOSITO, monto));
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        saldo -= monto;
        historial.add(new Operacion(TipoOperacion.RETIRO, monto));
        return true;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public List<Operacion> getHistorial() {
        return List.copyOf(historial);
    }
}
