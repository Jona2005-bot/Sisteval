package ec.edu.uce.dominio;

import java.util.Arrays;

public class Pregunta {
    private int idPregunta;
    private String enunciado;
    private Respuesta[] respuestas;

    // Constructor con parámetros
    public Pregunta(int idPregunta, String enunciado, Respuesta[] respuestas) {
        this.idPregunta = idPregunta;
        this.enunciado = enunciado;
        this.respuestas = respuestas;
    }

    // Constructor por defecto
    public Pregunta() {
        this.enunciado = "";
        this.respuestas = new Respuesta[3];
    }

    // Getters y Setters
    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        // Validamos que el enunciado no sea nulo ni vacío
        if (enunciado != null && !enunciado.isEmpty()) {
            this.enunciado = enunciado;
        } else {
            System.out.println("El enunciado no puede ser nulo o vacío.");
        }
    }

    public Respuesta[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Respuesta[] respuestas) {
        this.respuestas = respuestas;
    }

    @Override
    public String toString() {
        return "Pregunta" + "\r\n" +
                "ID: " + idPregunta + "\r\n" +
                ", Enunciado: " + enunciado + "\r\n" +
                ", Respuestas: " + Arrays.toString(respuestas);
    }

    // Métodos CRUD para respuestas

    // Agregar respuesta
    public void agregarRespuesta(Respuesta respuesta) {
        Respuesta[] resAux = new Respuesta[respuestas.length + 1];
        System.arraycopy(respuestas, 0, resAux, 0, respuestas.length);
        resAux[respuestas.length] = respuesta;
        respuestas = resAux;
    }

    // Consultar respuestas
    public String consultarRespuestas() {
        String texto = "";
        for (Respuesta respuesta : respuestas) {
            texto += respuesta.toString() + "\r\n";
        }
        return texto;
    }

    // Buscar respuesta por índice
    public Respuesta buscarRespuesta(int pos) {
        if (pos >= 0 && pos < respuestas.length) {
            return respuestas[pos];
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
            return null;
        }
    }

    // Editar respuesta
    public boolean editarRespuesta(int pos, String nuevoTexto) {
        if (pos >= 0 && pos < respuestas.length) {
            respuestas[pos].setRespuestaTexto(nuevoTexto);  // Aquí debe ser setRespuestaTexto(), no setTexto()
            return true;
        }
        return false;
    }

    // Eliminar respuesta
    public void eliminarRespuesta(int pos) {
        if (pos >= 0 && pos < respuestas.length) {
            Respuesta[] resAux = new Respuesta[respuestas.length - 1];
            System.arraycopy(respuestas, 0, resAux, 0, pos);
            System.arraycopy(respuestas, pos + 1, resAux, pos, respuestas.length - pos - 1);
            respuestas = resAux;
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
        }
    }
}
