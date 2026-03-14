public class Direccion {
    private String calle;
    private String colonia;
    private String ciudad;
    private String estado;
    private String pais;
    private String cp;

    public Direccion(String calle, String ciudad, String estado, String pais) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
    }

    public Direccion(String calle, String colonia, String ciudad, String estado, String pais, String cp) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.cp = cp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if ( calle != null && !calle.trim().isEmpty() ) sb.append( calle ).append( ", " );
        if ( colonia != null && !colonia.trim().isEmpty() ) sb.append( "Col. " ).append( colonia ).append( ", " );
        if ( ciudad != null && !ciudad.trim().isEmpty() ) sb.append( ciudad).append( ", " );
        if ( estado != null && !estado.trim().isEmpty() ) sb.append( estado).append( ", " );
        if ( pais != null && !pais.trim().isEmpty() ) sb.append( pais ).append( " " );
        if ( cp != null && !cp.trim().isEmpty() ) sb.append( "C.P. " ).append(cp);

        String resultado = sb.toString().trim();
        if ( resultado.endsWith( "," ) ) {
            resultado = resultado.substring( 0, resultado.length() - 1 );
        }
        return resultado;
    }
}