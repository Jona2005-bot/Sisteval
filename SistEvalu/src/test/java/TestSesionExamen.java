import ec.edu.uce.dominio.Asignatura;
import ec.edu.uce.dominio.Estudiante;
import ec.edu.uce.dominio.Examen;
import ec.edu.uce.dominio.SesionExamen;

import java.util.Arrays;

public class TestSesionExamen {

    public static void main(String[] args) {
        testConstructorPorDefecto();
        testConstructorConParametros();
        testSetters();
    }

    private static void testConstructorPorDefecto() {
        System.out.println("Prueba del constructor por defecto:");

        SesionExamen sesion = new SesionExamen();

        if (sesion.getCalificacion() == 0 &&
                sesion.getIdSesion() == 0 &&
                sesion.getExamen() != null &&
                sesion.getEstudiantes().length == 0) {
            System.out.println("Constructor por defecto: PASADO");
        } else {
            System.out.println("Constructor por defecto: FALLIDO");
        }

        System.out.println();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Examen examen = new Examen(1, "Matematicas", null, null, 0);
        Estudiante estudiante1 = new Estudiante (123,"Juan", "juan@example.com", "password", "Estudiante", "E001", 80, new Asignatura[0]);
        Estudiante[] estudiantes = {estudiante1};

        SesionExamen sesion = new SesionExamen(90.0f, 1, examen, estudiantes);

        if (sesion.getCalificacion() == 90.0f &&
                sesion.getIdSesion() == 1 &&
                sesion.getExamen() != null &&
                sesion.getEstudiantes().length == 1) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Examen examen = new Examen(1, "Historia", null, null, 0);
        Estudiante estudiante2 = new Estudiante(123,"Ana", "ana@example.com", "password", "Estudiante", "E002", 85, new Asignatura[0]);
        Estudiante[] estudiantes = {estudiante2};

        SesionExamen sesion = new SesionExamen();
        sesion.setCalificacion(95.0f);
        sesion.setIdSesion(2);
        sesion.setExamen(examen);
        sesion.setEstudiantes(estudiantes);

        if (sesion.getCalificacion() == 95.0f &&
                sesion.getIdSesion() == 2 &&
                sesion.getExamen() != null &&
                sesion.getEstudiantes().length == 1) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }
}
