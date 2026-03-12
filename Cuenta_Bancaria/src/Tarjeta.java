import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Tarjeta {
    private final String numeroTarjeta;
    private String pin;
    private static final SecureRandom random = new SecureRandom();
    private static final Set<String> numerosCuenta = new HashSet<>();

    Tarjeta(String pin){
        this.numeroTarjeta =  generarNumeroTarjeta();
        this.pin = pin;
    }

    public static String generarNumeroTarjeta(){
        String numeroGenerado;
        boolean numRepetido;

        do {
            StringBuilder generadoor = new StringBuilder();

            for (int i = 0 ; i < 16; i ++  ) {
                generadoor.append(random.nextInt(10));
            }

            numeroGenerado = generadoor.toString();
            numRepetido = numerosCuenta.contains(numeroGenerado);
        }
        while (numRepetido);
        numerosCuenta.add( numeroGenerado ) ;
        return numeroGenerado ;
    }

    public String getPin() {
        return pin;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setPin(String nuevoPin ){
        this.pin = nuevoPin;

    }

    @Override
    public String toString() {
        return  "\nNumero de Tarjeta: " + numeroTarjeta +
                "\nPin:" + pin ;
    }
}
