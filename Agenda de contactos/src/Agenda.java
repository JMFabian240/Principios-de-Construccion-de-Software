import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private String titular;
    private List<Contacto> contactosEmergencia;
    private List<Contacto> contactos;

    public Agenda(String titular) {
        this.titular = titular;
        this.contactosEmergencia = new ArrayList<>();
        this.contactos = new ArrayList<>();
    }

    public boolean agregarContacto(Contacto nuevoContacto) {
        if (nuevoContacto != null && !contactos.contains(nuevoContacto)) {
            return contactos.add(nuevoContacto);
        }
        return false;
    }

    public List<Contacto> buscarContacto(String nombre) {
        List<Contacto> resultados = new ArrayList<>();
        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    public boolean eliminarContacto(Contacto contactoAEliminar) {
        return contactos.remove(contactoAEliminar);
    }

    public boolean editarContacto(Contacto contactoAntiguo, Contacto contactoActualizado) {
        int indice = contactos.indexOf(contactoAntiguo);
        if (indice != -1) {
            contactos.set(indice, contactoActualizado);
            return true;
        }
        return false;
    }

    public String getTitular() { return titular; }

    @Override
    public String toString() {
        return "AGENDA DE: " + titular + "\nTotal de contactos: " + contactos.size() + "\n" + contactos;
    }
}