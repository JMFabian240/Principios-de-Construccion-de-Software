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
    public boolean validarTarjeta( String pin){
        validarSesion();

        Tarjeta tarjetaUsuario = usuarioActivo.getCuenta().getTarjeta();
        if (tarjetaUsuario == null){
            System.out.println(" ERROR: La cuenta no tiene tarjetas");
            return false;
        }

        boolean pinCorrecto = tarjetaUsuario.getPin().equals(pin);

        return  pinCorrecto;
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

        if ( (monto >= 200 && monto <= usuarioActivo.getCuenta().getSaldo() ) && monto % 100 == 0 ){
            return usuarioActivo.getCuenta().retirar(monto);
        }
        return false;
    }

    public boolean pagarServicio(double pago, double costoServico){
        validarSesion();
        return usuarioActivo.getCuenta().pagoServicio(pago,costoServico);
    }

    public double calcularCambio(double pago, double costo){
        double cambio;
        return  cambio = pago - costo;
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
