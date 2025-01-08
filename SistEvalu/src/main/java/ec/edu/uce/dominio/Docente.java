package ec.edu.uce.dominio;

import java.util.Arrays;
import java.util.Date;

public class Docente extends Usuario {
    private int numExamen;
    private String asignatura;
    private Examen[] examenesCreados;

    // Constructor por defecto
    public Docente() {
        super();
        this.asignatura = "Sin asignatura asignada";
        this.examenesCreados = new Examen[3];
    }

    // Constructor con parámetros
    public Docente(int idUsuario,String Nombre, String Email, String Contrasenia, String tipoUsuario, String Asignatura, Examen[] ExamenesCreados) {
        super(idUsuario,Nombre, Email, Contrasenia, tipoUsuario);
        this.asignatura = Asignatura;
        this.examenesCreados = ExamenesCreados;
    }

    // Constructor con referencia a otro objeto
    public Docente(Docente otroDocente) {
        super(otroDocente.getIdUsuario(),otroDocente.getNombre(), otroDocente.getEmail(), otroDocente.getContrasenia(), otroDocente.getTipoUsuario()); // Copia atributos de Usuario
        this.asignatura = otroDocente.asignatura; // Copia la asignatura

        // Copiar el array de examenesCreados (referencias)
        this.examenesCreados = new Examen[otroDocente.examenesCreados.length];
        for (int i = 0; i < otroDocente.examenesCreados.length; i++) {
            this.examenesCreados[i] = otroDocente.examenesCreados[i];
        }
    }

    // Getters y Setters
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String Asignatura) {
        this.asignatura = Asignatura;
    }

    public Examen[] getExamenesCreados() {
        return examenesCreados;
    }
    public void setExamenesCreados(Examen[] ExamenesCreados) {
        this.examenesCreados = ExamenesCreados;
    }

    @Override
    public String toString() {
        return super.toString() + "Docente: " + "\r\n" +
                "Asignatura: '" + asignatura + "\r\n" +
                ", Exámenes Creados: " + Arrays.toString(examenesCreados);
    }

    //Metodos Cruds Examen

    //Agregar Examen

    public void agregarExamen(int idExamen, String asignatura, Date fecha, float clificaciones) {
        if (numExamen >= examenesCreados.length) {
            Examen[] exaAux = examenesCreados;
            examenesCreados = new Examen [numExamen + 1];
            System.arraycopy(exaAux, 0, examenesCreados, 0, examenesCreados.length);
        }
        examenesCreados[numExamen] = new Examen();
        numExamen++;
    }
    //Consultar Examen

    public String consultarExamen() {
        String texto = "";
        for (int i = 0; i < numExamen; i++) {
            texto += examenesCreados[i].toString() + "\r\n";
        }
        return texto;
    }
    //Validar Consultar Examen

    public Examen buscarExamen(int pos) {
        if (pos >= 0 && pos < numExamen) {
            return examenesCreados[pos];
        } else {
            System.out.println("ERROR. POSICION NO VALIDA");
            return null;
        }
    }
    //Editar Examen

    public boolean editarExamen (int pos, int idExamen, String asignatura, Date fecha,float clificaciones){
        boolean resp = false ;
        if (pos > 0 && pos < examenesCreados.length){
            examenesCreados [pos] = new Examen();

        }
        return resp;
    }
    //Método para eliminar un Examen al arreglo.

    public void eliminarExamen (int pos){
        if (pos>=0 && pos <= numExamen){
            Examen[]exaAux = examenesCreados;
            examenesCreados = new Examen[numExamen-1];
            if (pos == 0){ //primera posicion array
                System.arraycopy(exaAux,1,examenesCreados,0,exaAux.length-1);
                numExamen--;
            }
            else if (pos == numExamen-1){//ultima posicion array
                System.arraycopy(exaAux,0,examenesCreados,0,exaAux.length -1);

            }else{//posicion del medio del array
                System.arraycopy(exaAux,0,examenesCreados,0,pos);
                System.arraycopy(exaAux,pos+1,examenesCreados,pos,exaAux.length -pos-1);

            }
        }
    }
}