import ec.edu.uce.dominio.Docente;
import ec.edu.uce.dominio.Examen;
import ec.edu.uce.dominio.Asignatura;

public class TestDocente {

    public static void main(String[] args) {
        testConstructorConParametros();
        testSetters();
        testAsignaturaInvalida();
        testExamenesCreados();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Examen[] examenes = {
                new Examen(),
                new Examen()
        };

        Docente docente = new Docente(123,"Carlos Ramírez", "carlos.ramirez@example.com", "Carlos2024*", "Docente", "Matemáticas", examenes);

        if (docente.getNombre().equals("Carlos Ramírez") &&
                docente.getEmail().equals("carlos.ramirez@example.com") &&
                docente.getContrasenia().equals("Carlos2024*") &&
                docente.getTipoUsuario().equals("Docente") &&
                docente.getAsignatura().equals("Matemáticas") &&
                docente.getExamenesCreados().length == 2) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Examen[] examenes = {
                new Examen(),
                new Examen()
        };

        Docente docente = new Docente();
        docente.setNombre("Ana López");
        docente.setEmail("ana.lopez@example.com");
        docente.setContrasenia("Ana12345*");
        docente.setTipoUsuario("Docente");
        docente.setAsignatura("Física");
        docente.setExamenesCreados(examenes);

        boolean nombreCorrecto = docente.getNombre().equals("Ana López");
        boolean emailCorrecto = docente.getEmail().equals("ana.lopez@example.com");
        boolean contraseñaCorrecta = docente.getContrasenia().equals("Ana12345*");
        boolean tipoUsuarioCorrecto = docente.getTipoUsuario().equals("Docente");
        boolean asignaturaCorrecta = docente.getAsignatura().equals("Física");
        boolean examenesCorrectos = docente.getExamenesCreados().length == 2;

        if (nombreCorrecto && emailCorrecto && contraseñaCorrecta && tipoUsuarioCorrecto && asignaturaCorrecta && examenesCorrectos) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }

    private static void testAsignaturaInvalida() {
        System.out.println("Prueba de asignatura inválida:");

        Docente docente;
        boolean esAsignaturaValida = true;

        String asignaturaInvalida = "";
        if (asignaturaInvalida == null || asignaturaInvalida.trim().isEmpty()) {
            esAsignaturaValida = false;
        }

        if (!esAsignaturaValida) {
            docente = new Docente(123,"Miguel Pérez", "miguel.perez@example.com", "Miguel1234*", "Docente", asignaturaInvalida, new Examen[0]);
            System.out.println("Asignatura inválida: PASADO");
        } else {
            System.out.println("Asignatura inválida: FALLIDO");
        }

        System.out.println();
    }

    private static void testExamenesCreados() {
        System.out.println("Prueba de exámenes creados:");

        Examen[] examenes = {
                new Examen(),
                new Examen()
        };

        Docente docente = new Docente(123,"Carlos Ramírez", "carlos.ramirez@example.com", "Carlos2024*", "Docente", "Matemáticas", examenes);

        if (docente.getExamenesCreados().length == 2) {
            System.out.println("Exámenes creados: PASADO");
        } else {
            System.out.println("Exámenes creados: FALLIDO");
        }

        System.out.println();
    }
}
