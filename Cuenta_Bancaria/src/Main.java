import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("001-123456-7", "4111111111111111", 5000.00);
        Usuario usuario = new Usuario("Juan Pérez López", "miPass123", LocalDate.of(1995, 6, 15), cuenta);

        Cajero cajero = new Cajero();

        System.out.println("=== Autenticación ===");
        boolean autenticado = cajero.autenticar(usuario, "miPass123");
        System.out.println("Acceso: " + (autenticado ? "concedido" : "denegado"));

        System.out.println("\n=== Saldo inicial ===");
        System.out.printf("Saldo: $%.2f%n", cajero.consultarSaldo());

        System.out.println("\n=== Depósito $1,500 ===");
        boolean dep = cajero.depositar(1500.00);
        System.out.println("Depósito exitoso: " + dep);
        System.out.printf("Saldo: $%.2f%n", cajero.consultarSaldo());

        System.out.println("\n=== Retiro $200 ===");
        boolean ret1 = cajero.retirar(200.00);
        System.out.println("Retiro exitoso: " + ret1);
        System.out.printf("Saldo: $%.2f%n", cajero.consultarSaldo());

        System.out.println("\n=== Retiro inválido $9,000 ===");
        boolean ret2 = cajero.retirar(9000.00);
        System.out.println("Retiro exitoso: " + ret2);
        System.out.printf("Saldo: $%.2f%n", cajero.consultarSaldo());

        System.out.println("\n=== Historial de operaciones ===");
        cajero.mostrarHistorial();

        cajero.cerrarSesion();
    }
}
