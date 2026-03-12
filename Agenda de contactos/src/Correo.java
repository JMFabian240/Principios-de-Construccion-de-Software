public class Correo {
    private String direccion;
    private TipoCorreo tipoCorreo;

    public Correo(String direccion) {
        this.direccion = direccion;
    }

    public Correo(String direccion, TipoCorreo tipoCorreo) {
        this.direccion = direccion;
        this.tipoCorreo = tipoCorreo;
    }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public TipoCorreo getTipoCorreo() { return tipoCorreo; }
    public void setTipoCorreo(TipoCorreo tipoCorreo) { this.tipoCorreo = tipoCorreo; }

    @Override
    public String toString() {
        return direccion + (tipoCorreo != null ? " " + tipoCorreo + " " : "");
    }
}