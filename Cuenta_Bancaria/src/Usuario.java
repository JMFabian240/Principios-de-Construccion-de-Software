import java.time.LocalDate;

public class Usuario {
    private final String nombreCompleto;
    private final String contrasena;
    private final LocalDate fechaRegistro;
    private final LocalDate fechaNacimiento;
    private final Cuenta cuenta;

    public Usuario(String nombreCompleto, String contrasena, LocalDate fechaNacimiento, Cuenta cuenta) {
        this.nombreCompleto = nombreCompleto;
        this.contrasena = contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
        this.cuenta = cuenta;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
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
}
