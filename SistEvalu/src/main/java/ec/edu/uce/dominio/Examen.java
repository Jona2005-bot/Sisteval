package ec.edu.uce.dominio;

import java.util.Arrays;
import java.util.Date;

public class Examen {
    private int idExamen;
    private String asignatura;
    private Date fecha;
    private Pregunta[] preguntas;
    private SesionExamen[] sesiones;
    private int numExamen;
    private int numPreguntas;
    private int numSesiones;
    private float calificaciones;

    // Constructor por defecto
    public Examen() {
        this.idExamen = 0;
        this.asignatura = "";
        this.fecha = new Date();
        this.preguntas = new Pregunta[3];
        this.sesiones = new SesionExamen[3];
        this.numPreguntas = 0;
        this.numSesiones = 0;
        this.calificaciones = 0;
    }

    // Constructor con parámetros
    public Examen(int idExamen, String asignatura, Date fecha, Pregunta[] preguntas, float calificaciones) {
        this.idExamen = idExamen;
        this.asignatura = asignatura;
        this.fecha = fecha;
        this.preguntas = preguntas != null ? preguntas : new Pregunta[3];
        this.sesiones = new SesionExamen[3];
        this.numPreguntas = preguntas != null ? preguntas.length : 0;
        this.numSesiones = 0;
        this.calificaciones = calificaciones;
    }

    // Getters y Setters
    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int IdExamen) {
        this.idExamen = IdExamen;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date Fecha) {
        this.fecha = Fecha;
    }

    public Pregunta[] getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Pregunta[] Preguntas) {
        this.preguntas = Preguntas;
    }

    public float getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(float Calificaciones) {
        this.calificaciones = Calificaciones;
    }

    @Override
    public String toString() {
        return "Examen" + "\r\n" +
                "IdExamen: "  + idExamen + "\r\n" +
                ", Asignatura: " + asignatura + "\r\n" +
                ", Fecha: " + fecha + "\r\n" +
                ", Preguntas: " + Arrays.toString(preguntas) + "\r\n" +
                ", Calificaciones: " + calificaciones ;
    }

    // Método para agregar una pregunta al examen
    public void agregarPregunta(String enunciado, Respuesta[] respuestas) {
        // Aumentar el tamaño del arreglo de preguntas
        Pregunta[] preAux = preguntas;
        preguntas = new Pregunta[numPreguntas + 1];
        System.arraycopy(preAux, 0, preguntas, 0, preAux.length);

        // Crear una nueva pregunta con el enunciado y las respuestas proporcionadas
        preguntas[numPreguntas] = new Pregunta(numPreguntas + 1, enunciado, respuestas);
        numPreguntas++;
    }

    // Método para consultar las preguntas del examen
    public String consultarPreguntas() {
        StringBuilder texto = new StringBuilder();
        for (int i = 0; i < numPreguntas; i++) {
            texto.append(preguntas[i].toString()).append("\r\n");
        }
        return texto.toString();
    }

    // Método para buscar una pregunta en el examen por su posición
    public Pregunta buscarPreguntas(int pos) {
        if (pos >= 0 && pos < numPreguntas) {
            return preguntas[pos];
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
            return null;
        }
    }

    // Método para editar una pregunta en el examen
    public boolean editarPreguntas(int pos, String enunciado, Respuesta[] respuestas) {
        if (pos >= 0 && pos < preguntas.length) {
            preguntas[pos].setEnunciado(enunciado);  // Actualiza el enunciado de la pregunta
            preguntas[pos].setRespuestas(respuestas);  // Actualiza las respuestas de la pregunta
            return true;
        }
        return false;
    }

    // Método para eliminar una pregunta del examen
    public void eliminarExamen(int pos) {
        if (pos >= 0 && pos < numPreguntas) {
            Pregunta[] preAux = preguntas;
            preguntas = new Pregunta[numPreguntas - 1];
            // Eliminar la pregunta en la posición 'pos' y mover el resto
            if (pos == 0) {
                System.arraycopy(preAux, 1, preguntas, 0, preAux.length - 1);
            } else if (pos == numPreguntas - 1) {
                System.arraycopy(preAux, 0, preguntas, 0, preAux.length - 1);
            } else {
                System.arraycopy(preAux, 0, preguntas, 0, pos);
                System.arraycopy(preAux, pos + 1, preguntas, pos, preAux.length - pos - 1);
            }
            numPreguntas--;
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
        }
    }
    // Métodos CRUD Sesiones de Examen

    // Agregar Sesión
    public void agregarSesionExamen(float calificaciones, int idSesion, Examen examen,Estudiante[] estudiantes) {
        if (numSesiones >= sesiones.length) {
            SesionExamen[] sesionAux = sesiones;
            sesiones = new SesionExamen[numSesiones + 1];
            System.arraycopy(sesionAux, 0, sesiones, 0, sesionAux.length);
        }
        sesiones[numSesiones] = new SesionExamen(calificaciones, idSesion,examen,estudiantes);
        numSesiones++;
    }

    // Consultar Sesiones
    public String consultarSesionesExamen() {
        String texto = "";
        for (int i = 0; i < numSesiones; i++) {
            texto += sesiones[i].toString() + "\r\n";
        }
        return texto;
    }

    // Buscar Sesión
    public SesionExamen buscarSesionExamen(int pos) {
        if (pos >= 0 && pos < numSesiones) {
            return sesiones[pos];
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
            return null;
        }
    }

    // Editar Sesión
    public boolean editarSesionExamen(int pos,float calificaciones, int idSesion, Examen examen,Estudiante[] estudiantes) {
        boolean resp = false;
        if (pos >= 0 && pos < sesiones.length) {
            sesiones[pos] = new SesionExamen(calificaciones, idSesion,examen,estudiantes);
            resp = true;
        }
        return resp;
    }

    // Eliminar Sesión
    public void eliminarSesionExamen(int pos) {
        if (pos >= 0 && pos < numSesiones) {
            SesionExamen[] sesionAux = sesiones;
            sesiones = new SesionExamen[numSesiones - 1];
            if (pos == 0) { // Primera posición
                System.arraycopy(sesionAux, 1, sesiones, 0, sesionAux.length - 1);
            } else if (pos == numSesiones - 1) { // Última posición
                System.arraycopy(sesionAux, 0, sesiones, 0, sesionAux.length - 1);
            } else { // Posición intermedia
                System.arraycopy(sesionAux, 0, sesiones, 0, pos);
                System.arraycopy(sesionAux, pos + 1, sesiones, pos, sesionAux.length - pos - 1);
            }
            numSesiones--;
        }
    }
}