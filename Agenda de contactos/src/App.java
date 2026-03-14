import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Agenda agenda = new Agenda("Harry Jose Manuel Fabian Hernandez");

        Contacto c1 = agenda.agregarContacto("Alejandro", "Gomez");
        c1.setSegundoNombre("Daniel");
        c1.setApellidoMaterno("Silva");
        c1.setAlias("Alex");
        c1.agregarTelefono(new Telefono("5512345678", TipoTelefono.MOVIL));
        c1.agregarTelefono(new Telefono("5587654321", TipoTelefono.CASA));
        c1.agregarCorreo(new Correo("alex.gomez@email.com", TipoCorreo.PERSONAL));
        c1.agregarCorreo(new Correo("agomez@empresa.com.mx", TipoCorreo.TRABAJO));
        c1.agregarDireccion(new Direccion("Insurgentes Sur", "Del Valle", "CDMX", "CDMX", "Mexico", "03100"));
        c1.agregarFechaImportante(new FechaImportante(LocalDate.of(1995, 8, 20), "Cumpleanos"));
        agenda.agregarContactoEmergencia(c1);

        Contacto c2 = agenda.agregarContacto("Maria", "");
        c2.agregarTelefono(new Telefono("3311223344", TipoTelefono.MOVIL));

        Contacto c3 = agenda.agregarContacto("Roberto", "Martinez");
        c3.agregarTelefono(new Telefono("8144556677", TipoTelefono.TRABAJO));
        c3.agregarTelefono(new Telefono("8199887766", TipoTelefono.MOVIL));
        c3.agregarTelefono(new Telefono("8122334455", TipoTelefono.CASA));
        c3.agregarDireccion(new Direccion("Constitucion", "Centro", "Monterrey", "Nuevo Leon", "Mexico", "64000"));
        c3.agregarDireccion(new Direccion("Calzada San Pedro", "Del Valle", "San Pedro", "Nuevo Leon", "Mexico", "66220"));

        Contacto c4 = agenda.agregarContacto("Sofia", "Lopez");
        c4.agregarCorreo(new Correo("sofia.lopez@gmail.com", TipoCorreo.PERSONAL));
        c4.agregarCorreo(new Correo("slopez@universidad.edu.mx", TipoCorreo.INSTITUCIONAL));

        Contacto c5 = agenda.agregarContacto("Carlos", "Ruiz");
        c5.agregarTelefono(new Telefono("2223334455", TipoTelefono.MOVIL));
        c5.agregarFechaImportante(new FechaImportante(LocalDate.of(2023, 11, 2), "Aniversario"));

        Contacto c6 = agenda.agregarContacto("Fernando", "");
        c6.setAlias("Fer");
        c6.agregarTelefono(new Telefono("9981122334", TipoTelefono.EMERGENCIA));
        agenda.agregarContactoEmergencia(c6);

        Contacto c7 = agenda.agregarContacto("Lucia", "Fernandez");
        c7.setApellidoMaterno("Cruz");
        c7.agregarTelefono(new Telefono("6645566778", TipoTelefono.MOVIL));
        c7.agregarDireccion(new Direccion("Revolucion", "Tijuana", "Baja California", "Mexico"));

        Contacto c8 = agenda.agregarContacto("Jorge", "Herrera");
        c8.agregarTelefono(new Telefono("4429988776", TipoTelefono.TRABAJO));
        c8.agregarCorreo(new Correo("jorge.herrera@negocio.com", TipoCorreo.TRABAJO));

        Contacto c9 = agenda.agregarContacto("Elena", "");
        c9.setApellidoMaterno("Vargas");
        c9.agregarTelefono(new Telefono("9994455667", TipoTelefono.CASA));

        Contacto c10 = agenda.agregarContacto("Proteccion Civil", "");
        c10.agregarTelefono(new Telefono("5556832222", TipoTelefono.EMERGENCIA));
        agenda.agregarContactoEmergencia(c10);

        System.out.println("IMPRIMIENDO TODOS LOS CONTACTOS");
        for (Contacto c : agenda.getContactos()) {
            System.out.print(c.toString());
        }

        System.out.println("\nCONSULTANDO CONTACTO ESPECIFICO");
        List<Contacto> busquedaConsultar = agenda.buscarContacto("Maria");
        if (!busquedaConsultar.isEmpty()) {
            int idTemporalConsultar = busquedaConsultar.get(0).getIdContacto();
            Contacto contactoConsultado = agenda.buscarContactoPorId(idTemporalConsultar);
            System.out.print(contactoConsultado.toString());
        }

        System.out.println("\nEDITANDO CONTACTO");
        List<Contacto> busquedaEditar = agenda.buscarContacto("Carlos");
        if (!busquedaEditar.isEmpty()) {
            int idTemporalEditar = busquedaEditar.get(0).getIdContacto();

            Contacto carlosModificado = new Contacto("Carlos");
            carlosModificado.setApellidoPaterno("Ruiz");
            carlosModificado.setApellidoMaterno("Guzman");
            carlosModificado.agregarTelefono(new Telefono("2223334455", TipoTelefono.MOVIL));
            carlosModificado.agregarTelefono(new Telefono("2229998877", TipoTelefono.TRABAJO));
            carlosModificado.agregarCorreo(new Correo("carlos.ruiz@nuevo.com", TipoCorreo.PERSONAL));

            agenda.editarContacto(idTemporalEditar, carlosModificado);

            Contacto contactoEditado = agenda.buscarContactoPorId(idTemporalEditar);
            System.out.print(contactoEditado.toString());
        }

        System.out.println("\nELIMINANDO CONTACTO");
        List<Contacto> busquedaEliminar = agenda.buscarContacto("Roberto");
        if (!busquedaEliminar.isEmpty()) {
            int idTemporalEliminar = busquedaEliminar.get(0).getIdContacto();
            agenda.eliminarContacto(idTemporalEliminar);

            Contacto comprobacion = agenda.buscarContactoPorId(idTemporalEliminar);
            if (comprobacion == null) {
                System.out.println("El contacto Roberto fue eliminado exitosamente de la memoria y la agenda.");
            }
        }

        System.out.println("\nIMPRIMIENDO LISTA DESPUES DE ELIMINACION");
        for (Contacto c : agenda.getContactos()) {
            System.out.println("- " + c.getNombre() + (c.getApellidoPaterno() != null ? " " + c.getApellidoPaterno() : ""));
        }

        System.out.println("\nIMPRIMIENDO LISTA DE CONTACTOS DE EMERGENCIA");
        for (Contacto c : agenda.getContactosEmergencia()) {
            System.out.print(c.toString());
        }
    }
}