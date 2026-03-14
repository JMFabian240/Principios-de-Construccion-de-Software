import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private static int contadorId = 1;
    private int idContacto;

    private String nombre;
    private String segundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String alias;

    private List<Telefono> telefonos;
    private List<Correo> correos;
    private List<Direccion> direcciones;
    private List<FechaImportante> fechasImportantes;

    public Contacto(String nombre) {
        this.idContacto = contadorId++;
        this.nombre = nombre;
        this.telefonos = new ArrayList<>();
        this.correos = new ArrayList<>();
        this.direcciones = new ArrayList<>();
        this.fechasImportantes = new ArrayList<>();
    }

    public void agregarTelefono(Telefono telefono) {
        this.telefonos.add(telefono);
    }

    public boolean eliminarTelefono(Telefono telefono) {
        return this.telefonos.remove(telefono);
    }

    public void agregarCorreo(Correo correo) {
        this.correos.add(correo);
    }

    public void agregarDireccion(Direccion direccion) {
        this.direcciones.add(direccion);
    }

    public void agregarFechaImportante(FechaImportante fecha) {
        this.fechasImportantes.add(fecha);
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<Correo> correos) {
        this.correos = correos;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<FechaImportante> getFechasImportantes() {
        return fechasImportantes;
    }

    public void setFechasImportantes(List<FechaImportante> fechasImportantes) {
        this.fechasImportantes = fechasImportantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Contacto ---\n");

        if ( nombre != null && !nombre.trim().isEmpty() ) sb.append("Nombre: ").append(nombre).append("\n");
        if ( segundoNombre != null && !segundoNombre.trim().isEmpty() ) sb.append("Segundo Nombre: ").append(segundoNombre).append("\n");
        if ( apellidoPaterno != null && !apellidoPaterno.trim().isEmpty() ) sb.append("Apellido Paterno: ").append(apellidoPaterno).append("\n");
        if ( apellidoMaterno != null && !apellidoMaterno.trim().isEmpty() ) sb.append("Apellido Materno: ").append(apellidoMaterno).append("\n");
        if ( alias != null && !alias.trim().isEmpty() ) sb.append("Alias: ").append(alias).append("\n");

        if ( telefonos != null && !telefonos.isEmpty()) {
            sb.append("Teléfonos:\n");
            for (Telefono t : telefonos) sb.append("  - ").append(t.toString()).append("\n");
        }

        if (correos != null && !correos.isEmpty()) {
            sb.append("Correos:\n");
            for (Correo c : correos) sb.append("  - ").append(c.toString()).append("\n");
        }

        if (direcciones != null && !direcciones.isEmpty()) {
            sb.append("Direcciones:\n");
            for (Direccion d : direcciones) sb.append("  - ").append(d.toString()).append("\n");
        }

        if (fechasImportantes != null && !fechasImportantes.isEmpty()) {
            sb.append("Fechas Importantes:\n");
            for (FechaImportante f : fechasImportantes) sb.append("  - ").append(f.toString()).append("\n");
        }

        return sb.toString();
    }
}