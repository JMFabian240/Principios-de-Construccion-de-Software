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

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public List<Contacto> getContactosEmergencia() {
        return contactosEmergencia;
    }

    public void setContactosEmergencia(List<Contacto> contactosEmergencia) {
        this.contactosEmergencia = contactosEmergencia;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    private Contacto crearContacto(String nombre, String apellido) {
        Contacto nuevoContacto = new Contacto(nombre);
        nuevoContacto.setApellidoPaterno(apellido);
        return nuevoContacto;
    }

    public Contacto agregarContacto(String nombre, String apellido) {
        Contacto nuevoContacto = crearContacto(nombre, apellido);
        this.contactos.add(nuevoContacto);
        return nuevoContacto;
    }

    public void agregarContactoEmergencia(Contacto contacto) {
        if (!contactosEmergencia.contains(contacto)) {
            contactosEmergencia.add(contacto);
        }
    }

    public List<Contacto> buscarContacto(String nombre) {
        List<Contacto> resultados = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if ( contacto.getNombre() != null && 
                contacto.getNombre().toLowerCase().contains( nombre.toLowerCase() ) ) {
                resultados.add(contacto);
            }
        }
        return resultados;
    }

    public Contacto buscarContactoPorId(int id) {
        for ( Contacto contacto : contactos ) {
            if (contacto.getIdContacto() == id) {
                return contacto;
            }
        }
        return null;
    }

    public boolean eliminarContacto(int idContacto) {
        Contacto contactoAEliminar = buscarContactoPorId(idContacto);
        if (contactoAEliminar != null) {
            contactosEmergencia.remove(contactoAEliminar);
            return contactos.remove(contactoAEliminar);
        }
        return false;
    }

    public boolean editarContacto(int idContacto, Contacto contactoActualizado) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getIdContacto() == idContacto) {
                contactoActualizado.setIdContacto(idContacto);
                contactos.set(i, contactoActualizado);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return  "AGENDA DE: " + titular 
                + "\nTotal de contactos: " + contactos.size() + "\n" 
                + contactos;
    }
}