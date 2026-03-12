public class Cajero {
    private Usuario usuarioActivo;
    private Cuenta cuenta;


    public boolean autenticar(Usuario usuarioRegistrado, String usuario, String contrasena) {
        if ( usuarioRegistrado.getNombreUsuario().equals(usuario) && usuarioRegistrado.verificarContrasena(contrasena)) {
            this.usuarioActivo = usuarioRegistrado;
            return true;
        }
        return false;
    }
    public boolean validarTarjeta(String numeroTarjeta, String pin){
        validarSesion();

        Tarjeta tarjetaUsuario = usuarioActivo.getCuenta().getTarjeta();
        if (tarjetaUsuario == null){
            System.out.println(" ERROR: La cuenta no tiene tarjetas");
            return false;
        }

        boolean numeroTajertaCorrecto = tarjetaUsuario.getNumeroTarjeta().equals(numeroTarjeta);
        boolean pinCorrecto = tarjetaUsuario.getPin().equals(pin);

        return  numeroTajertaCorrecto && pinCorrecto;
    }

    public void cerrarSesion() {
        this.usuarioActivo = null;
    }

    private void validarSesion() {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario autenticado.");
        }
    }

    public double consultarSaldo() {
        validarSesion();
        return usuarioActivo.getCuenta().getSaldo();
    }

    public boolean depositar(double monto) {
        validarSesion();
        return usuarioActivo.getCuenta().depositar(monto);
    }

    public boolean retirar(double monto) {
        validarSesion();
        return usuarioActivo.getCuenta().retirar(monto);
    }

    public String pagoServicioEfectivo (double pago, double costoServico){
        validarSesion();

        if ( pago % 100 != 0 ){
            return "ERROR: EL cajero solo acepta billetes multiplos de 100.\n" +
                                "Devolviendo su dinero. " +
                                "\nOperacion Canselada\n";
        }
        if ( pago < costoServico ){
            return "Fondos insucientes.  El costo del servicio es de" + costoServico +
                                "\nDevolviendo su dinero." +
                                "\nOperacion Canselada\n";
        }

        double cambio =  pago - costoServico;

        if (cambio > 0 ){
            return "Su cambio es de " + cambio;
        }
        else if (pago == costoServico){
            return "Su pago fue exacto" ;
        }
        return "¡Su pago fue realizado con exito!" ;

    }

    public void mostrarHistorial() {
        validarSesion();
        var historial = usuarioActivo.getCuenta().getHistorial();
        if (historial.isEmpty()) {
            System.out.println("Sin operaciones registradas.");
            return;
        }
        for (Operacion op : historial) {
            System.out.println(op);
        }
    }

}
