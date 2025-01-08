package ec.edu.uce.dominio;

public class Asignatura {
    private String nombre;
    private int idAsignatura;
    private Asignatura[] asignaturas;

    // Constructor por defecto
    public Asignatura() {
        this.nombre = "";
        this.idAsignatura = 0;
    }

    // Constructor con parámetros
    public Asignatura(String Nombre, int IdAsignatura) {
        this.nombre = Nombre;
        this.idAsignatura = IdAsignatura;
    }

    // Constructor con referencia a otro objeto
    public Asignatura(Asignatura otraAsignatura) {
        this.nombre = otraAsignatura.nombre;
        this.idAsignatura = otraAsignatura.idAsignatura;
    }


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }
    public void setIdAsignatura(int IdAsignatura) {
        this.idAsignatura = IdAsignatura;
    }


    @Override
    public String toString() {
        return "Asignatura" +"\r\n" +
                "Nombre: " + nombre + "\r\n" +
                ", IdAsignatura: " + idAsignatura ;
    }
}