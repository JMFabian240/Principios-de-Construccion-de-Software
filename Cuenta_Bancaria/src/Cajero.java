public class Cajero {
    private Usuario usuarioActivo;

    public boolean autenticar(Usuario usuario, String contrasena) {
        if (usuario.verificarContrasena(contrasena)) {
            this.usuarioActivo = usuario;
            return true;
        }
        return false;
    }

    public void cerrarSesion() {
        this.usuarioActivo = null;
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

    private void validarSesion() {
        if (usuarioActivo == null) {
            throw new IllegalStateException("No hay un usuario autenticado.");
        }
    }
}
