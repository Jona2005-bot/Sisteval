package ec.edu.uce.dominio;

import java.util.Arrays;

public class PreguntaBase {
    private int idPreguntaBase;
    private Pregunta pregunta;
    private Respuesta[] respuestas;

    // Constructor por defecto
    public PreguntaBase(int idPreguntaValida, String preguntaValida, String respuestaValida) {
        this.idPreguntaBase = 0;

        // Crear respuestas válidas para la pregunta
        Respuesta[] respuestas = {
                new Respuesta("París", true),
                new Respuesta("Madrid", false),
                new Respuesta("Londres", false)
        };

        // Crear la pregunta y asignar las respuestas
        this.pregunta = new Pregunta(1, "¿Cuál es la capital de Francia?", respuestas);
        this.respuestas = respuestas;
    }

    // Constructor con parámetros
    public PreguntaBase(int IdPreguntaBase, Pregunta Pregunta, Respuesta[] Respuestas) {
        this.idPreguntaBase = IdPreguntaBase;
        this.pregunta = Pregunta;
        this.respuestas = Respuestas;
    }

    // Getters y Setters
    public int getIdPreguntaBase() {
        return idPreguntaBase;
    }

    public void setIdPreguntaBase(int IdPreguntaBase) {
        this.idPreguntaBase = IdPreguntaBase;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta Pregunta) {
        this.pregunta = Pregunta;  // Corregido para asignar la pregunta correctamente
    }

    public Respuesta[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Respuesta[] respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "PreguntaBase" + "\r\n" +
                "IdPreguntaBase: " + idPreguntaBase + "\r\n" +
                ", Pregunta: " + pregunta + "\r\n" +
                ", Respuestas: " + Arrays.toString(respuestas);
    }
}
