import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajero cajero = new Cajero();

        Cuenta cuenta1 = new Cuenta( 2000,"2309" );
        Usuario usuario1 = new Usuario( "Harry", "Jose Manuel Fabian Hernandez",
                                        "012345", LocalDate.of(2006, 9, 23), cuenta1);

        int opcion;
        boolean accesoConcedido = false;

        boolean pinCorrecto = false;
        boolean cuentaBloqueda = false;
        String nip;
        int contador = 0;

        while (!accesoConcedido) {
            System.out.println("\n====== Inicio de Sesión ======");
            System.out.print("Nombre de Usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String contrasena = scanner.nextLine();

            accesoConcedido = cajero.autenticar(usuario1, usuario, contrasena);

            if (accesoConcedido) {
                System.out.println("\n¡Acceso concedido! Bienvenido, " + usuario1.getNombreCompleto());


            } else {
                System.out.println("\nERROR: Usuario o contraseña incorrectos. Intente de nuevo.");
            }
        }
                do {
                    System.out.println("Ingrese su NIP: ");
                    nip = scanner.next();

                    pinCorrecto = cajero.validarTarjeta(nip);

                    if (pinCorrecto ){
                        System.out.println(" ¡NIP Correcto! ");
                    }
                    else {

                        contador ++;
                        System.out.println( " \n¡PIN Incorrecto!.¡Intento " + contador + " de 3! \n");

                        if (contador >= 3){
                            System.out.println( "\nDemasiados intentos. ¡Cuenta bloqueda!\n");
                            cuentaBloqueda = true;
                        }
                    }

                    if ( cuentaBloqueda){
                        return;
                    }

                } while (!pinCorrecto && !cuentaBloqueda);

        do {
            menu();
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n====== Deposito ======\n");
                    System.out.println("Ingrese la cantidad que desea depositar: ");
                    double deposito = scanner.nextDouble();

                    boolean depositar = cajero.depositar(deposito);
                    System.out.println("¡El deposito ha sido existoso!");
                    break;

                case 2:

                    System.out.println( "====== Retiro ======\n" );
                    System.out.println( " La cantidad debe de ser mayor o igual a $200\n " +
                                        " y deben de ser multiplos de 100\n");
                    System.out.println("Ingrese la cantidad que desee retirar: ");

                    double retiro = scanner.nextDouble();
                    boolean retirar = cajero.retirar(retiro);

                    if (!retirar) {
                        System.out.println(" El Monto ah sido Incorrecto. ¡Operacion Canselada!");
                    } else{ System.out.println( " ¡El retiro ah sido exitoso!"); }
                    break;

                case 3:

                    System.out.println( "====== Consultar Saldo ======\n" );
                    double saldo = cajero.consultarSaldo();
                    System.out.println( " Su saldo es de: " + saldo);
                    break;

                case 4:
                        int opcionServicios = 0;
                    do {
                        double costo[] = new double[]{350,250,800};
                        boolean pagoConcretado;
                        double pago;
                        double cambio;
                        pagoDeServicios();
                        opcionServicios = scanner.nextInt();

                        switch (opcionServicios){
                            case 1:
                                System.out.println(" === Servicio de Luz ===");
                                System.out.println( " El costo del servicio es de: " + costo[0] );
                                System.out.println(" Deposite su pago: ");
                                pago = scanner.nextDouble();
                                pagoConcretado = cajero.pagarServicio(pago,costo[0]);

                                if (pago > costo[0]) {
                                    cambio = cajero.calcularCambio(pago,costo[0]);
                                    System.out.println(" Su cambio es de: " + cambio);
                                } else if ( pago < costo[0] ) {
                                    System.out.println( " Saldo Insuficiente. Intentelo más Tarde.");
                                } else if (pagoConcretado) {
                                    System.out.println( " ¡Su pago fue realizado con exito!");
                                }
                                break;

                            case 2:
                                System.out.println( "=== Servicio de Agua ===");
                                System.out.println( " El costo del servicio es de: " + costo[1]);
                                System.out.println( " Deposite su pago: ");
                                pago = scanner.nextDouble();
                                pagoConcretado = cajero.pagarServicio(pago,costo[1]);

                                if (pago > costo[1]) {
                                    cambio = cajero.calcularCambio(pago,costo[1]);
                                    System.out.println(" Su cambio es de: " + cambio);
                                } else if ( pago < costo[1] ) {
                                    System.out.println( " Saldo Insuficiente. Intentelo más Tarde.");
                                } else if (pagoConcretado) {
                                    System.out.println( " ¡Su pago fue realizado con exito!");
                                }
                                break;

                            case 3:
                                System.out.println( "=== Servicio de Internet ===");
                                System.out.println( " El costo del Servicio es de:" + costo[2]);
                                System.out.println( " Deposite su pago: ");
                                pago = scanner.nextDouble();
                                pagoConcretado = cajero.pagarServicio(pago,costo[2]);

                                if (pago > costo[2]) {
                                    cambio = cajero.calcularCambio(pago,costo[2]);
                                    System.out.println(" Su cambio es de: " + cambio);
                                } else if ( pago < costo[2] ) {
                                    System.out.println( " Saldo Insuficiente. Intentelo más Tarde.");
                                } else if (pagoConcretado) {
                                    System.out.println( " ¡Su pago fue realizado con exito!");
                                }
                                break;

                            case 0:
                                System.out.println( "Regresando...");
                                break;

                            default:
                                System.out.println("ERROR: Opcion invalida. Pruebe con otra opcion");
                                break;
                        }
                    } while (opcionServicios != 0);
                    break;
                case 5:

                    System.out.println("====== Historial de movimientos ======\n");
                    cajero.mostrarHistorial();
                    break;

                case 6:
                    System.out.println( "====== Datos del Usuario ======\n");
                    System.out.println(usuario1);
                    break;

                case 7:
                    System.out.println( "====== Datos de la Cuenta ======\n");
                    System.out.println(cuenta1);
                    break;

                case 0:
                    System.out.println(" Gracias por usar nuestro cajero. ¡Vuelva pronto!");
                    break;

                default:
                    System.out.println(" ERROR: Opcion invalida. ¡Intente de nuevo!");
                    break;

            }
        }
        while (opcion != 0);
        scanner.close();

    }

    public static void menu() {
        System.out.println( "\n============= MENÚ =============\n");
        System.out.println( "   1. Deposito\n" +
                            "   2. Retiro\n" +
                            "   3. Consultar saldo\n" +
                            "   4. Pago de servicios\n" +
                            "   5. Historial de movimientos\n" +
                            "   6. Ver Datos del Usuario\n" +
                            "   7. Ver Datos de la Cuenta\n" +
                            "   0. Salir\n");
        System.out.println("=================================\n");
        System.out.println("Ingresa el numero de opcion de su preferencia:");
    }

    public static void pagoDeServicios(){
        System.out.println( "======= PAGO DE SERVICIOS =======");
        System.out.println( "   1. LUZ\n" +
                            "   2. AGUA\n" +
                            "   3. INTERNET\n" +
                            "   0. Regresar\n");
        System.out.println( "   Seleccione el servicio que desee pagar:");

    }
}