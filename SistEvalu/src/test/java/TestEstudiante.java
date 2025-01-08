import ec.edu.uce.dominio.Asignatura;
import ec.edu.uce.dominio.Estudiante;

public class TestEstudiante {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorConParametros();
        testSetters();
    }

    private static void testConstructorPorDefecto() {
        System.out.println("Prueba del constructor por defecto:");

        Estudiante estudiante = new Estudiante();

        if (estudiante.getNombre() == null &&
                estudiante.getEmail() == null &&
                estudiante.getContrasenia() == null &&
                estudiante.getTipoUsuario() == null &&
                estudiante.getMatricula() == null &&
                estudiante.getCalificacion() == 0 &&
                estudiante.getAsignaturas().length == 0) {
            System.out.println("Constructor por defecto: PASADO");
        } else {
            System.out.println("Constructor por defecto: FALLIDO");
        }

        System.out.println();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Asignatura[] asignaturas = {
                new Asignatura("Matemáticas", 101),
                new Asignatura("Física", 102)
        };

        Estudiante estudiante = new Estudiante(
                123,
                "María García",
                "maria.garcia@example.com",
                "Maria2024*",
                "Estudiante",
                "20240001",
                85,
                asignaturas
        );

        boolean nombreCorrecto = estudiante.getNombre().equals("María García");
        boolean emailCorrecto = estudiante.getEmail().equals("maria.garcia@example.com");
        boolean contraseñaCorrecta = estudiante.getContrasenia().equals("Maria2024*");
        boolean tipoUsuarioCorrecto = estudiante.getTipoUsuario().equals("Estudiante");
        boolean matriculaCorrecta = estudiante.getMatricula().equals("20240001");
        boolean calificacionCorrecta = estudiante.getCalificacion() == 85;
        boolean asignaturasCorrectas = estudiante.getAsignaturas().length == 2 &&
                estudiante.getAsignaturas()[0].getNombre().equals("Matemáticas") &&
                estudiante.getAsignaturas()[1].getNombre().equals("Física");

        if (nombreCorrecto && emailCorrecto && contraseñaCorrecta && tipoUsuarioCorrecto &&
                matriculaCorrecta && calificacionCorrecta && asignaturasCorrectas) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Estudiante estudiante = new Estudiante();

        Asignatura[] nuevasAsignaturas = {
                new Asignatura("Química", 103),
                new Asignatura("Historia", 104)
        };

        estudiante.setNombre("Luis Pérez");
        estudiante.setEmail("luis.perez@example.com");
        estudiante.setContrasenia("Luis2024*");
        estudiante.setTipoUsuario("Estudiante");
        estudiante.setMatricula("20240002");
        estudiante.setCalificacion(90);
        estudiante.setAsignaturas(nuevasAsignaturas);

        boolean nombreCorrecto = estudiante.getNombre().equals("Luis Pérez");
        boolean emailCorrecto = estudiante.getEmail().equals("luis.perez@example.com");
        boolean contraseñaCorrecta = estudiante.getContrasenia().equals("Luis2024*");
        boolean tipoUsuarioCorrecto = estudiante.getTipoUsuario().equals("Estudiante");
        boolean matriculaCorrecta = estudiante.getMatricula().equals("20240002");
        boolean calificacionCorrecta = estudiante.getCalificacion() == 90;
        boolean asignaturasCorrectas = estudiante.getAsignaturas().length == 2 &&
                estudiante.getAsignaturas()[0].getNombre().equals("Química") &&
                estudiante.getAsignaturas()[1].getNombre().equals("Historia");

        if (nombreCorrecto && emailCorrecto && contraseñaCorrecta && tipoUsuarioCorrecto &&
                matriculaCorrecta && calificacionCorrecta && asignaturasCorrectas) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }
}
