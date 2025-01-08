package ec.edu.uce.dominio;

import java.util.Arrays;

public class Estudiante extends Usuario {
    private String matricula;
    private int calificacion;
    private Asignatura[] asignaturas;

    // Constructor por defecto
    public Estudiante() {
        super();
        this.matricula = " ";
        this.calificacion = 0;
        this.asignaturas = new Asignatura[3];
    }

    // Constructor con parámetros
    public Estudiante(int idUsuario,String Nombre, String Email, String Contrasenia, String tipoUsuario, String Matricula, int Calificacion, Asignatura[] Asignaturas) {
        super(idUsuario,Nombre, Email, Contrasenia, tipoUsuario);
        this.matricula = Matricula;
        this.calificacion = Calificacion;
        this.asignaturas = Asignaturas;
    }

    // Constructor con referencia a otro objeto
    public Estudiante(Estudiante otroEstudiante) {
        super(otroEstudiante.getIdUsuario(),otroEstudiante.getNombre(), otroEstudiante.getEmail(), otroEstudiante.getContrasenia(), otroEstudiante.getTipoUsuario()); // Copia atributos de Usuario
        this.matricula = otroEstudiante.matricula; // Copia matrícula
        this.calificacion = otroEstudiante.calificacion; // Copia calificación

        // Copiar el array de asignaturas (referencias)
        this.asignaturas = new Asignatura[otroEstudiante.asignaturas.length];
        for (int i = 0; i < otroEstudiante.asignaturas.length; i++) {
            this.asignaturas[i] = otroEstudiante.asignaturas[i];
        }
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String Matricula) {
        this.matricula = Matricula;
    }

    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int Calificacion) {
        this.calificacion = Calificacion;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(Asignatura[] Asignaturas) {
        this.asignaturas = Asignaturas;
    }

    @Override
    public String toString() {
        return super.toString() + "Estudiante" + "\r\n" +
                "Matricula: " + matricula + "\r\n" +
                ", Calificacion: " + calificacion + "\r\n" +
                ", Asignaturas: " + Arrays.toString(asignaturas) ;
    }

}