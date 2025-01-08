import ec.edu.uce.dominio.PreguntaBase;

public class TestPreguntaBase {
    public static void main(String[] args) {


        String[] resultados = new String[4];
        int casoActual = 0;
        // Caso 1: Crear una PreguntaBase válida

        int idPreguntaValida = 1;
        String preguntaValida = "¿Cuál es la capital de España?";
        String respuestaValida = "Madrid";
        if (idPreguntaValida > 0) {
            if (preguntaValida != null && !preguntaValida.trim().isEmpty()) {
                if (respuestaValida != null && !respuestaValida.trim().isEmpty()) {
                    PreguntaBase preguntaBase1 = new PreguntaBase(idPreguntaValida, preguntaValida, respuestaValida);
                    if (preguntaBase1.getIdPreguntaBase() == idPreguntaValida &&
                            preguntaBase1.getPregunta().equals(preguntaValida) &&
                            preguntaBase1.getRespuestas().equals(respuestaValida)) {
                        resultados[casoActual] = " Se creo una PreguntaBase ";
                    } else {
                        resultados[casoActual] = " Falló al verificar los datos de PreguntaBase.";
                    }
                } else {
                    resultados[casoActual] = " La respuesta no debe estar vacía.";
                }
            } else {
                resultados[casoActual] = " La pregunta no debe estar vacía.";
            }
        } else {
            resultados[casoActual] = " El idPreguntaBase debe ser positivo.";
        }
        casoActual++;

        // Caso 2: Intentar crear una PreguntaBase con idPreguntaBase inválido

        int idPreguntaInvalido = -5;
        if (idPreguntaInvalido > 0) {
            resultados[casoActual] = "idPreguntaBase inválido.";
        } else {
            resultados[casoActual] = " Falló, el idPreguntaBase debe ser positivo.";
        }
        casoActual++;

        // Caso 3: Intentar crear una PreguntaBase con pregunta vacía

        String preguntaInvalida = " ";
        if (preguntaInvalida != null && !preguntaInvalida.trim().isEmpty()) {
            resultados[casoActual] = "No se validó la pregunta vacía.";
        } else {
            resultados[casoActual] = "La pregunta no debe estar vacía.";
        }
        casoActual++;

        // Caso 4: Intentar crear una PreguntaBase con respuesta vacía
        String respuestaInvalida = null;
        if (respuestaInvalida != null && !respuestaInvalida.trim().isEmpty()) {
            resultados[casoActual] = "No se validó la respuesta vacía.";
        } else {
            resultados[casoActual] = "La respuesta no debe estar vacía.";
        }
        casoActual++;

        // Imprimir resultados
        for (int i = 0; i < resultados.length; i++) {
            System.out.println(resultados[i]);
        }
    }
}

