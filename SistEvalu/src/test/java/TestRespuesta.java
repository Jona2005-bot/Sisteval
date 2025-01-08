import ec.edu.uce.dominio.Respuesta;

public class TestRespuesta {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorConParametros();
        testSetters();
    }

    private static void testConstructorPorDefecto() {
        System.out.println("Prueba del constructor por defecto:");

        Respuesta respuesta = new Respuesta("Madrid", false);

        if (respuesta.getRespuestaTexto() == null &&
                respuesta.getEsCorrecta() == false) {
            System.out.println("Constructor por defecto: PASADO");
        } else {
            System.out.println("Constructor por defecto: FALLIDO");
        }

        System.out.println();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Respuesta respuesta = new Respuesta("Madrid");

        if (respuesta.getRespuestaTexto().equals("Madrid") &&
                respuesta.getEsCorrecta() == true) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Respuesta respuesta = new Respuesta("Madrid", false);
        respuesta.setRespuestaTexto("Barcelona");
        respuesta.setEsCorrecta(false);

        if (respuesta.getRespuestaTexto().equals("Barcelona") &&
                respuesta.getEsCorrecta() == false) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }
}
