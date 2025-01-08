package ec.edu.uce.dominio;

public class Respuesta {

    // Atributos
    private String respuestaTexto;
    private boolean esCorrecta;

    // Constructor por defecto
    public Respuesta(String madrid, boolean b) {
        this.respuestaTexto = null;
        this.esCorrecta = false;
    }

    // Constructor con parámetros
    public Respuesta(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
        this.esCorrecta = esCorrecta;
    }

    // Getters y Setters
    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    @Override
    public String toString() {
        return "Respuesta" + "\r\n" +
                "respuesta " + respuestaTexto + "\r\n" +
                ", La respuesta " + esCorrecta;
    }
}
