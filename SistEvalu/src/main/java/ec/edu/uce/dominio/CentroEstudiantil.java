package ec.edu.uce.dominio;

import java.util.Arrays;
import java.util.Date;

public class CentroEstudiantil {
    private int numExamenes;
    private int numUsuarios;
    private int numAsignaturas;
    private Usuario[] usuarios;
    private Asignatura[] asignaturas;
    private Examen[] examenes;

    // Constructor por defecto
    public CentroEstudiantil() {
        this.usuarios = new Usuario[3];
        this.asignaturas = new Asignatura[3];
        this.examenes = new Examen[3];
        this.numExamenes = 0;
        this.numAsignaturas = 0;
        this.numUsuarios = 0;
    }


    // Constructor con parámetros
    public CentroEstudiantil(Usuario[] Usuarios, Asignatura[] Asignaturas, Examen[] Examenes) {
        this.usuarios = new Usuario[3];
        this.asignaturas = new Asignatura[3];
        this.examenes = new Examen[3];
        this.numExamenes = 0;
        this.numAsignaturas = 0;
        this.numUsuarios = 0;
    }

    // Constructor con referencia a otro objeto
    public CentroEstudiantil(CentroEstudiantil otroCentro) {
        // Copiar usuarios
        this.usuarios = new Usuario[otroCentro.usuarios.length];
        for (int i = 0; i < otroCentro.usuarios.length; i++) {
            this.usuarios[i] = otroCentro.usuarios[i]; // Copia las referencias de los usuarios
        }

        // Copiar asignaturas
        this.asignaturas = new Asignatura[otroCentro.asignaturas.length];
        for (int i = 0; i < otroCentro.asignaturas.length; i++) {
            this.asignaturas[i] = otroCentro.asignaturas[i]; // Copia las referencias de las asignaturas
        }

        // Copiar examenes
        this.examenes = new Examen[otroCentro.examenes.length];
        for (int i = 0; i < otroCentro.examenes.length; i++) {
            this.examenes[i] = otroCentro.examenes[i]; // Copia las referencias de los exámenes
        }
    }

    // Getters y Setters
    public Usuario[] getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Usuario[] Usuarios) {
        this.usuarios = Usuarios;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }
    public void setAsignaturas(Asignatura[] Asignaturas) {
        this.asignaturas = Asignaturas;
    }

    public Examen[] getExamenes() {
        return examenes;
    }
    public void setExamenes(Examen[] Examenes) {
        this.examenes = Examenes;
    }

    @Override
    public String toString() {
        return "CentroEstudiantil" +
                "Usuarios: " + Arrays.toString(usuarios) +
                ", Asignaturas: " + Arrays.toString(asignaturas) +
                ", Examenes: " + Arrays.toString(examenes) +
                '}';
    }

    //Metodos Cruds Asignatura

    //Agregar Asignatura

    public void agregarAsignatura(String nombre,int idAsignatura) {
        if (numAsignaturas >= asignaturas.length) {
            Asignatura[] asigAux = asignaturas;
            asignaturas = new Asignatura [numAsignaturas + 1];
            System.arraycopy(asigAux, 0, asignaturas, 0, asignaturas.length);
        }
        asignaturas[numAsignaturas] = new Asignatura(nombre,idAsignatura);
        numAsignaturas++;
    }
    //Consultar Asignaturas

    public String consultarAsignatura() {
        String texto = "";
        for (int i = 0; i < numAsignaturas; i++) {
            texto += asignaturas[i].toString() + "\r\n";
        }
        return texto;
    }
    //Validar Consultar Asignatura

    public Asignatura buscarAsignaturas(int pos) {
        if (pos >= 0 && pos < numAsignaturas) {
            return asignaturas[pos];
        } else {
            System.out.println("ERROR. POSICION NO VALIDA");
            return null;
        }
    }
    //Editar Asignatura

    public boolean editarAsignatura (int pos, String nombre,int idAsignatura){
        boolean resp = false ;
        if (pos > 0 && pos < asignaturas.length){
            asignaturas [pos] = new Asignatura ();

        }
        return resp;
    }
    //Método para eliminar una Asignatura al arreglo.

    public void eliminarAsignatura (int pos){
        if (pos>=0 && pos <= numAsignaturas){
            Asignatura[]asiaux = asignaturas;
            asignaturas = new Asignatura[numAsignaturas-1];
            if (pos == 0){ //primera posicion array
                System.arraycopy(asiaux,1,asignaturas,0,asiaux.length-1);
                numAsignaturas--;
            }
            else if (pos == numAsignaturas-1){//ultima posicion array
                System.arraycopy(asiaux,0,asignaturas,0,asiaux.length -1);

            }else{//posicion del medio del array
                System.arraycopy(asiaux,0,asignaturas,0,pos);
                System.arraycopy(asiaux,pos+1,asignaturas,pos,asiaux.length -pos-1);

            }
        }
    }
    // Métodos CRUD Usuarios

    // Agregar Usuario
    public void agregarUsuario(int idUsuario, String nombre, String email, String contrasenia, String tipoUsuario) {
        if (numUsuarios >= usuarios.length) {
            Usuario[] userAux = usuarios;
            usuarios = new Usuario[numUsuarios + 1];
            System.arraycopy(userAux, 0, usuarios, 0, userAux.length);
        }
        usuarios[numUsuarios] = new Usuario(idUsuario,nombre,email,contrasenia,tipoUsuario);
        numUsuarios++;
    }

    // Consultar Usuarios
    public String consultarUsuarios() {
        String texto = "";
        for (int i = 0; i < numUsuarios; i++) {
            texto += usuarios[i].toString() + "\r\n";
        }
        return texto;
    }

    // Buscar Usuario
    public Usuario buscarUsuario(int pos) {
        if (pos >= 0 && pos < numUsuarios) {
            return usuarios[pos];
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
            return null;
        }
    }

    // Editar Usuario
    public boolean editarUsuario(int pos,int idUsuario, String nombre, String email, String contrasenia, String tipoUsuario) {
        boolean resp = false;
        if (pos >= 0 && pos < usuarios.length) {
            usuarios[pos] = new Usuario(idUsuario, nombre, email, contrasenia, tipoUsuario);
            resp = true;
        }
        return resp;
    }

    // Eliminar Usuario
    public void eliminarUsuario(int pos) {
        if (pos >= 0 && pos < numUsuarios) {
            Usuario[] userAux = usuarios;
            usuarios = new Usuario[numUsuarios - 1];
            if (pos == 0) { // Primera posición
                System.arraycopy(userAux, 1, usuarios, 0, userAux.length - 1);
            } else if (pos == numUsuarios - 1) { // Última posición
                System.arraycopy(userAux, 0, usuarios, 0, userAux.length - 1);
            } else { // Posición intermedia
                System.arraycopy(userAux, 0, usuarios, 0, pos);
                System.arraycopy(userAux, pos + 1, usuarios, pos, userAux.length - pos - 1);
            }
            numUsuarios--;
        }
    }

// Métodos CRUD Exámenes

    // Agregar Examen
    public void agregarExamen(int idExamen, String asignatura, Date fecha, Pregunta[] preguntas, float calificaciones) {
        if (numExamenes >= examenes.length) {
            Examen[] examAux = examenes;
            examenes = new Examen[numExamenes + 1];
            System.arraycopy(examAux, 0, examenes, 0, examAux.length);
        }
        examenes[numExamenes] = new Examen(idExamen, asignatura, fecha, preguntas,calificaciones);
        numExamenes++;
    }

    // Consultar Exámenes
    public String consultarExamenes() {
        String texto = "";
        for (int i = 0; i < numExamenes; i++) {
            texto += examenes[i].toString() + "\r\n";
        }
        return texto;
    }

    // Buscar Examen
    public Examen buscarExamen(int pos) {
        if (pos >= 0 && pos < numExamenes) {
            return examenes[pos];
        } else {
            System.out.println("ERROR. POSICIÓN NO VÁLIDA");
            return null;
        }
    }

    // Editar Examen
    public boolean editarExamen(int pos, int idExamen, String asignatura, Date fecha, Pregunta[] preguntas, float calificaciones) {
        boolean resp = false;
        if (pos >= 0 && pos < examenes.length) {
            examenes[pos] = new Examen(idExamen, asignatura, fecha, preguntas,calificaciones);
            resp = true;
        }
        return resp;
    }

    // Eliminar Examen
    public void eliminarExamen(int pos) {
        if (pos >= 0 && pos < numExamenes) {
            Examen[] examAux = examenes;
            examenes = new Examen[numExamenes - 1];
            if (pos == 0) { // Primera posición
                System.arraycopy(examAux, 1, examenes, 0, examAux.length - 1);
            } else if (pos == numExamenes - 1) { // Última posición
                System.arraycopy(examAux, 0, examenes, 0, examAux.length - 1);
            } else { // Posición intermedia
                System.arraycopy(examAux, 0, examenes, 0, pos);
                System.arraycopy(examAux, pos + 1, examenes, pos, examAux.length - pos - 1);
            }
            numExamenes--;
        }
    }

}
