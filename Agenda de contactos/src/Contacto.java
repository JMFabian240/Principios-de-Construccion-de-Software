import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private String nombre;
    private String segundoNombre;
    private String apellido;
    private String alias;

    private List<Telefono> telefono;
    private List<Correo> correo;
    private List<Direccion> direccion;
    private List<FechaImportante> fechaImportante;

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = new ArrayList<>();
        this.correo = new ArrayList<>();
        this.direccion = new ArrayList<>();
        this.fechaImportante = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getSegundoNombre() { return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) { this.segundoNombre = segundoNombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public void agregarTelefono(Telefono t) { this.telefono.add(t); }
    public boolean eliminarTelefono(Telefono t) { return this.telefono.remove(t); }
    public void agregarCorreo(Correo c) { this.correo.add(c); }
    public void agregarDireccion(Direccion d) { this.direccion.add(d); }
    public void agregarFechaImportante(FechaImportante f) { this.fechaImportante.add(f); }

    @Override
    public String toString() {
        return "\n\n--- Contacto: " + nombre + " " + (apellido != null ? apellido : "") + " ---\n" +
                "Teléfonos: " + telefono + "\n" +
                "Correos: " + correo + "\n" +
                "Direcciones: " + direccion + "\n" +
                "Fechas: " + fechaImportante;
    }
}