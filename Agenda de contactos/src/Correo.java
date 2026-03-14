public class Correo {
    private String direccion;
    private TipoCorreo tipoCorreo;

    public Correo(String direccion) {
        this.direccion = direccion;
        this.tipoCorreo = TipoCorreo.PERSONAL;
    }

    public Correo(String direccion, TipoCorreo tipoCorreo) {
        this.direccion = direccion;
        this.tipoCorreo = tipoCorreo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCorreo getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(TipoCorreo tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (direccion != null && !direccion.trim().isEmpty()) {
            sb.append(direccion);
            if (tipoCorreo != null) {
                sb.append(" (").append(tipoCorreo).append(")");
            }
        }
        return sb.toString();
    }
}