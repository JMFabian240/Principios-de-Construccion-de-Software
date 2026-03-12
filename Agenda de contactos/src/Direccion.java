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
        this(calle, ciudad, estado, pais);
        this.colonia = colonia;
        this.cp = cp;
    }

    public String getCalle() { return calle; }
    public String getColonia() { return colonia; }
    public String getCiudad() { return ciudad; }
    public String getEstado() { return estado; }
    public String getPais() { return pais; }
    public String getCp() { return cp; }

    public void corregirCodigoPostal(String nuevoCp) { this.cp = nuevoCp; }

    public void actualizarUbicacion(String nuevaCalle, String nuevaColonia) {
        this.calle = nuevaCalle;
        this.colonia = nuevaColonia;
    }

    @Override
    public String toString() {
        return calle + (colonia != null ? ", Col. " + colonia : "") + ", " + ciudad + ", " + estado + ", " + pais + ", " + (cp != null ? " CP: " + cp : "");
    }
}