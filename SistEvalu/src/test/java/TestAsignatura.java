import ec.edu.uce.dominio.Asignatura;

public class TestAsignatura {

    public static void main(String[] args) {
        testConstructorConParametros();
        testSetters();
        testCrearAsignatura();
        testEditarAsignatura();
        testEliminarAsignatura();
        testConsultarAsignatura();
    }

    private static void testConstructorConParametros() {
        System.out.println("=== Prueba del constructor con parámetros ===");

        Asignatura asignatura = new Asignatura("Matemáticas Discretas", 101);

        boolean testPassed =
                asignatura.getNombre().equals("Matemáticas Discretas") &&
                        asignatura.getIdAsignatura() == 101;

        printTestResult("Constructor con parámetros", testPassed);
    }

    private static void testSetters() {
        System.out.println("=== Prueba de setters ===");

        Asignatura asignatura = new Asignatura("Física", 102);

        // Probamos los setters
        asignatura.setNombre("Programación");
        asignatura.setIdAsignatura(103);

        boolean testPassed =
                asignatura.getNombre().equals("Programación") &&
                        asignatura.getIdAsignatura() == 103;

        printTestResult("Setters", testPassed);
    }

    private static void testCrearAsignatura() {
        System.out.println("=== Prueba de crear asignatura ===");

        Asignatura asignatura = new Asignatura();
        asignatura.setNombre("Algoritmos");
        asignatura.setIdAsignatura(104);

        boolean testPassed =
                asignatura.getNombre().equals("Algoritmos") &&
                        asignatura.getIdAsignatura() == 104;

        printTestResult("Crear asignatura", testPassed);
    }

    private static void testEditarAsignatura() {
        System.out.println("=== Prueba de editar asignatura ===");

        Asignatura asignatura = new Asignatura("Redes", 105);

        // Editar asignatura
        asignatura.setNombre("Redes Avanzadas");
        asignatura.setIdAsignatura(106);

        boolean testPassed =
                asignatura.getNombre().equals("Redes Avanzadas") &&
                        asignatura.getIdAsignatura() == 106;

        printTestResult("Editar asignatura", testPassed);
    }

    private static void testEliminarAsignatura() {
        System.out.println("=== Prueba de eliminar asignatura ===");

        // Simulamos un arreglo de asignaturas
        Asignatura[] asignaturas = {
                new Asignatura("Matemáticas", 101),
                new Asignatura("Física", 102),
                new Asignatura("Química", 103)
        };

        // Eliminamos la asignatura en la posición 1 (Física)
        asignaturas = eliminarAsignatura(asignaturas, 1);

        boolean testPassed =
                asignaturas.length == 2 &&
                        asignaturas[0].getNombre().equals("Matemáticas") &&
                        asignaturas[1].getNombre().equals("Química");

        printTestResult("Eliminar asignatura", testPassed);
    }

    private static void testConsultarAsignatura() {
        System.out.println("=== Prueba de consultar asignatura ===");

        Asignatura asignatura = new Asignatura("Inteligencia Artificial", 107);

        boolean testPassed =
                asignatura.toString().contains("Inteligencia Artificial") &&
                        asignatura.toString().contains("107");

        printTestResult("Consultar asignatura", testPassed);
    }

    // Método auxiliar para eliminar una asignatura de un arreglo
    private static Asignatura[] eliminarAsignatura(Asignatura[] asignaturas, int pos) {
        if (pos < 0 || pos >= asignaturas.length) {
            System.out.println("Posición inválida");
            return asignaturas;
        }

        Asignatura[] nuevoArreglo = new Asignatura[asignaturas.length - 1];
        for (int i = 0, j = 0; i < asignaturas.length; i++) {
            if (i != pos) {
                nuevoArreglo[j++] = asignaturas[i];
            }
        }
        return nuevoArreglo;
    }

    // Método auxiliar para imprimir resultados de pruebas
    private static void printTestResult(String testName, boolean passed) {
        if (passed) {
            System.out.println(testName + ": PASADO");
        } else {
            System.out.println(testName + ": FALLIDO");
        }
        System.out.println();
    }
}
