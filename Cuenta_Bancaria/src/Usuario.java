import java.time.LocalDate;

public class Usuario {

    private final String nombreCompleto;
    private String nombreUsuario;
    private final String contrasena;
    private final LocalDate fechaRegistro;
    private final LocalDate fechaNacimiento;
    private final Cuenta cuenta;

    public Usuario(String nombreUsuario,String nombreCompleto, String contrasena, LocalDate fechaNacimiento, Cuenta cuenta) {
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.cuenta = cuenta;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "=== Usuario ====" +
                "\nNombre Completo: " + nombreCompleto +
                "\nFecha de Registro: " + fechaRegistro +
                "\nFechaNacimiento: " + fechaNacimiento +
                "\n" + cuenta ;
    }
}
