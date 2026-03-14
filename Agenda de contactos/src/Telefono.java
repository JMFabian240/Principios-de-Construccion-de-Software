public class Telefono {
    private String numero;
    private TipoTelefono tipoTelefono;

    public Telefono(String numero) {
        this.numero = numero;
        this.tipoTelefono = TipoTelefono.MOVIL;
    }

    public Telefono(String numero, TipoTelefono tipoTelefono) {
        this.numero = numero;
        this.tipoTelefono = tipoTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (numero != null && !numero.trim().isEmpty()) {
            sb.append(numero);
            if (tipoTelefono != null) {
                sb.append(" (").append(tipoTelefono).append(")");
            }
        }
        return sb.toString();
    }
}