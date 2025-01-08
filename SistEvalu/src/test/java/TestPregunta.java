import ec.edu.uce.dominio.Pregunta;
import ec.edu.uce.dominio.Respuesta;

public class TestPregunta {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorConParametros();
        testSetters();
    }

    private static void testConstructorPorDefecto() {
        System.out.println("Prueba del constructor por defecto:");

        Pregunta pregunta = new Pregunta();

        if (pregunta.getEnunciado() == null && pregunta.getRespuestas().length == 0) {
            System.out.println("Constructor por defecto: PASADO");
        } else {
            System.out.println("Constructor por defecto: FALLIDO");
        }

        System.out.println();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Respuesta[] respuestas = {
                new Respuesta("Respuesta 1"),
                new Respuesta("Respuesta 2")
        };
        Pregunta pregunta = new Pregunta();

        boolean enunciadoCorrecto = pregunta.getEnunciado().equals("¿Cuál es la capital de Francia?");
        boolean respuestasCorrectas = pregunta.getRespuestas().length == 2 &&
                pregunta.getRespuestas()[0].getRespuestaTexto().equals("Respuesta 1") &&
                pregunta.getRespuestas()[0].getEsCorrecta() &&
                pregunta.getRespuestas()[1].getRespuestaTexto().equals("Respuesta 2") &&
                !pregunta.getRespuestas()[1].getEsCorrecta();

        if (enunciadoCorrecto && respuestasCorrectas) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Pregunta pregunta = new Pregunta();
        pregunta.setEnunciado("¿Cuál es el lenguaje de programación más popular?");
        Respuesta[] respuestas = {
                new Respuesta("Java"),
                new Respuesta("Python")
        };
        pregunta.setRespuestas(respuestas);

        boolean enunciadoCorrecto = pregunta.getEnunciado().equals("¿Cuál es el lenguaje de programación más popular?");
        boolean respuestasCorrectas = pregunta.getRespuestas().length == 2 &&
                pregunta.getRespuestas()[0].getRespuestaTexto().equals("Java") &&
                pregunta.getRespuestas()[0].getEsCorrecta() &&
                pregunta.getRespuestas()[1].getRespuestaTexto().equals("Python") &&
                !pregunta.getRespuestas()[1].getEsCorrecta();

        if (enunciadoCorrecto && respuestasCorrectas) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }
}