package ec.edu.uce.dominio;

import java.util.Arrays;

public class SesionExamen {
    private float calificacion;
    private int idSesion;
    private Examen examen;
    private Estudiante[] estudiantes;
    private int numEstudiantes;

    // Constructor por defecto
    public SesionExamen() {
        this.calificacion = 0;
        this.idSesion = 0;
        this.examen = new Examen(); // No asignamos un examen por defecto
        this.estudiantes = new Estudiante[3]; // Inicializamos con un arreglo vacío
    }

    // Constructor con parámetros
    public SesionExamen(float calificacion, int idSesion, Examen examen, Estudiante[] estudiantes) {
        this.calificacion = calificacion;
        this.idSesion = idSesion;
        this.examen = examen;
        this.estudiantes = estudiantes;
    }

    // Constructor con referencia a un objeto SesionExamen
    public SesionExamen(SesionExamen sesion) {
        this.calificacion = sesion.calificacion;
        this.idSesion = sesion.idSesion;
        this.examen = sesion.examen;
        this.estudiantes = sesion.estudiantes; // Copia del arreglo de estudiantes
    }

    // Getters y Setters
    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "SesionExamen " + "\r\n" +
                "calificacion: " + calificacion + "\r\n" +
                ", idSesion: " + idSesion + "\r\n" +
                ", examen: " + examen + "\r\n" +
                ", estudiantes: " + Arrays.toString(estudiantes) ;
    }
}
