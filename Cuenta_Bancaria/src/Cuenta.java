import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cuenta {
    private final String numeroCuenta;
    private Tarjeta tarjeta;
    private double saldo;
    private final List<Operacion> historial;
    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> numerosCuenta = new HashSet<>();

    public Cuenta(double saldoInicial ) {
        this.numeroCuenta = generarNumeroCuentaUnico();
        this.saldo = saldoInicial;
        this.historial = new ArrayList<>();
    }

    public  static String generarNumeroCuentaUnico(){
        String numeroGenerado;
        boolean numRepetido;

        do {
            StringBuilder generadoor = new StringBuilder();

            for (int i = 0 ; i < 18; i ++  ) {
                generadoor.append(random.nextInt(10));
            }

            numeroGenerado = generadoor.toString();

            numRepetido = numerosCuenta.contains(numeroGenerado);
        }
        while (numRepetido);
            numerosCuenta.add( numeroGenerado ) ;
            return numeroGenerado ;
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
        if ( ( monto <= 200 && monto > saldo ) && monto % 100 == 0 ) {
            saldo -= monto;
            return true;
        }
        historial.add(new Operacion(TipoOperacion.RETIRO, monto));
        return false;
    }

    public boolean pagoServicioCuenta( double pago ) {
        if ( (pago <= 0 && pago > saldo) &&  pago % 100 == 0 ) {
            saldo -= pago;
            return true;
        }
        historial.add(new Operacion(TipoOperacion.PAGO_DE_SERVICO, pago));
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void agregarTarjeta(Tarjeta nuevaTarjeta) {
        this.tarjeta = nuevaTarjeta;
    }
    public Tarjeta getTarjeta() {
        return tarjeta;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public List<Operacion> getHistorial() {
        return List.copyOf(historial);
    }

    @Override
    public String toString() {
        return
                "\nNumero de Cuenta: " + numeroCuenta +
                "\nSaldo: " + saldo +
                "\nHistorial: " + historial +
                "\n" + tarjeta ;
    }
}
