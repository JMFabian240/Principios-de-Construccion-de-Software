import java.time.LocalDate;
import java.util.List;

public class App {

    // Se utiliza varargs (String... args) para evitar los caracteres no permitidos
    public static void main(String... args) {
        System.out.println("=== INICIANDO PRUEBAS DE AGENDA CON DATOS REALES ===");

        Agenda miAgenda = new Agenda("Harry Hernandez");

        // Contacto 1: Local
        Contacto c1 = new Contacto("Carlos");
        c1.setSegundoNombre("Arturo");
        c1.setApellido("Ramos");
        c1.agregarTelefono(new Telefono("9211234567", TipoTelefono.MOVIL));
        c1.agregarTelefono(new Telefono("9219876543", TipoTelefono.CASA));
        c1.agregarTelefono(new Telefono("9215550000", TipoTelefono.TRABAJO));
        c1.agregarTelefono(new Telefono("9211112222", TipoTelefono.EMERGENCIA));
        c1.agregarCorreo(new Correo("carlos.ramos@universidad.edu.mx", TipoCorreo.INSTITUCIONAL));
        c1.agregarCorreo(new Correo("cramos@empresa.com.mx", TipoCorreo.TRABAJO));
        c1.agregarCorreo(new Correo("carlos.arturo99@gmail.com", TipoCorreo.PERSONAL));
        c1.agregarDireccion(new Direccion("Malecón Costero 102", "Centro", "Coatzacoalcos", "Veracruz", "México", "96400"));
        c1.agregarFechaImportante(new FechaImportante(LocalDate.of(1998, 10, 15), "Cumpleaños"));

        // Contacto 2: Nacional
        Contacto c2 = new Contacto("Maria");
        c2.setSegundoNombre("Fernanda");
        c2.setApellido("Lopez");
        c2.agregarTelefono(new Telefono("5523456789", TipoTelefono.MOVIL));
        c2.agregarTelefono(new Telefono("5587654321", TipoTelefono.CASA));
        c2.agregarTelefono(new Telefono("5550001111", TipoTelefono.TRABAJO));
        c2.agregarTelefono(new Telefono("5559998888", TipoTelefono.EMERGENCIA));
        c2.agregarCorreo(new Correo("mlopez@ipn.mx", TipoCorreo.INSTITUCIONAL));
        c2.agregarCorreo(new Correo("maria.lopez@corporativo.com", TipoCorreo.TRABAJO));
        c2.agregarCorreo(new Correo("mafer.lopez@hotmail.com", TipoCorreo.PERSONAL));
        c2.agregarDireccion(new Direccion("Paseo de la Reforma 222", "Juárez", "Ciudad de México", "CDMX", "México", "06600"));
        c2.agregarFechaImportante(new FechaImportante(LocalDate.of(1995, 4, 22), "Aniversario Laboral"));

        // Contacto 3: Nacional Norte
        Contacto c3 = new Contacto("Roberto");
        c3.setApellido("Chen");
        c3.agregarTelefono(new Telefono("8181234567", TipoTelefono.MOVIL));
        c3.agregarTelefono(new Telefono("8189876543", TipoTelefono.CASA));
        c3.agregarTelefono(new Telefono("8185550000", TipoTelefono.TRABAJO));
        c3.agregarTelefono(new Telefono("8181112222", TipoTelefono.EMERGENCIA));
        c3.agregarCorreo(new Correo("roberto.chen@uanl.edu.mx", TipoCorreo.INSTITUCIONAL));
        c3.agregarCorreo(new Correo("rchen@industriasnorte.com", TipoCorreo.TRABAJO));
        c3.agregarCorreo(new Correo("robert.chen.mx@yahoo.com", TipoCorreo.PERSONAL));
        c3.agregarDireccion(new Direccion("Av. Constitución 100", "Centro", "Monterrey", "Nuevo León", "México", "64000"));
        c3.agregarFechaImportante(new FechaImportante(LocalDate.of(2001, 8, 10), "Titulación"));

        // Contacto 4: Internacional Sur
        Contacto c4 = new Contacto("Valentina");
        c4.setApellido("Suarez");
        c4.agregarTelefono(new Telefono("3101234567", TipoTelefono.MOVIL));
        c4.agregarTelefono(new Telefono("6019876543", TipoTelefono.CASA));
        c4.agregarTelefono(new Telefono("6015550000", TipoTelefono.TRABAJO));
        c4.agregarTelefono(new Telefono("3201112222", TipoTelefono.EMERGENCIA));
        c4.agregarCorreo(new Correo("vsuarez@uniandes.edu.co", TipoCorreo.INSTITUCIONAL));
        c4.agregarCorreo(new Correo("valentina.suarez@bancolombia.com", TipoCorreo.TRABAJO));
        c4.agregarCorreo(new Correo("valen.suarez90@gmail.com", TipoCorreo.PERSONAL));
        c4.agregarDireccion(new Direccion("Carrera 7 No. 71-21", "Chapinero", "Bogotá", "Cundinamarca", "Colombia", "110231"));
        c4.agregarFechaImportante(new FechaImportante(LocalDate.of(1992, 12, 5), "Cumpleaños"));

        // Contacto 5: Internacional Europa
        Contacto c5 = new Contacto("Alejandro");
        c5.setSegundoNombre("Miguel");
        c5.setApellido("Garcia");
        c5.agregarTelefono(new Telefono("6123456780", TipoTelefono.MOVIL));
        c5.agregarTelefono(new Telefono("9189876540", TipoTelefono.CASA));
        c5.agregarTelefono(new Telefono("9155500000", TipoTelefono.TRABAJO));
        c5.agregarTelefono(new Telefono("6111122220", TipoTelefono.EMERGENCIA));
        c5.agregarCorreo(new Correo("agarcia@ucm.es", TipoCorreo.INSTITUCIONAL));
        c5.agregarCorreo(new Correo("alejandro.garcia@telefonica.es", TipoCorreo.TRABAJO));
        c5.agregarCorreo(new Correo("alex.garcia.madrid@outlook.com", TipoCorreo.PERSONAL));
        c5.agregarDireccion(new Direccion("Calle Gran Vía 28", "Centro", "Madrid", "Madrid", "España", "28013"));
        c5.agregarFechaImportante(new FechaImportante(LocalDate.of(1988, 2, 28), "Día de San Valentín"));

        // Agregando todos a la agenda
        miAgenda.agregarContacto(c1);
        miAgenda.agregarContacto(c2);
        miAgenda.agregarContacto(c3);
        miAgenda.agregarContacto(c4);
        miAgenda.agregarContacto(c5);

        System.out.println("\n(+) Todos los contactos reales han sido agregados.");
        System.out.println(miAgenda);

        // Prueba de búsqueda
        System.out.println("\n(*) Buscando contacto con el nombre 'Alejandro':");
        List<Contacto> resultados = miAgenda.buscarContacto("Alejandro");

        for (Contacto encontrado : resultados) {
            System.out.println(encontrado);
        }
    }
}