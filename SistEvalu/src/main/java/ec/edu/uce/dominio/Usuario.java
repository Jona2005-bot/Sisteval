package ec.edu.uce.dominio;

public class Usuario {
    protected int idUsuario;
    protected String nombre;
    protected String email;
    protected String contrasenia;
    protected String tipoUsuario;
    protected boolean sesionIniciada;

    // Constructor por defecto
    public Usuario() {
        this.idUsuario = 0000000001;
        this.nombre = "S/N";
        this.email = "S/A";
        this.contrasenia = "Contrasenia12";
        this.tipoUsuario = "Docente";
    }

    // Constructor con parámetros
    public Usuario(int idUsuario,String nombre, String email, String contrasenia, String tipoUsuario) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.setTipoUsuario(tipoUsuario);
    }

    // Constructor con referencia a un objeto Usuario
    public Usuario(Usuario usuario) {
        this.nombre = usuario.nombre;
        this.email = usuario.email;
        this.contrasenia = usuario.contrasenia;
        this.tipoUsuario = usuario.tipoUsuario;
        this.sesionIniciada = usuario.sesionIniciada;
        this.idUsuario = usuario.idUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.length() < 8 || !contrasenia.matches(".*\\d.*")) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres y contener un número.");
        }
        this.contrasenia = contrasenia;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        if (tipoUsuario == null || tipoUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de usuario no puede estar vacío.");
        }
        // Añadir "Docente" a las opciones válidas
        if (!tipoUsuario.equals("Admin") && !tipoUsuario.equals("Estudiante") &&
                !tipoUsuario.equals("Profesor") && !tipoUsuario.equals("Invitado") &&
                !tipoUsuario.equals("Administrador") && !tipoUsuario.equals("Docente")) {
            throw new IllegalArgumentException("Tipo de usuario inválido.");
        }
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Método para iniciar sesión
    public void iniciarSesion(String nombre, String contrasenia) {
        if (this.nombre.equals(nombre) && this.contrasenia.equals(contrasenia)) {
            this.sesionIniciada = true;
            System.out.println("Sesión iniciada correctamente.");
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }

    // Método para validar usuario
    public boolean validarUsuario(String email, String contrasenia) {
        return this.email.equals(email) && this.contrasenia.equals(contrasenia);
    }

    @Override
    public String toString() {
        return "Usuario:" +
                "nombre: '" + nombre + "\r\n" +
                ", email: '" + email + "\r\n" +
                ", contraseña: '" + contrasenia + "\r\n" +
                ", tipoUsuario: '" + tipoUsuario + "\r\n" +
                ", sesionIniciada: " + sesionIniciada;
    }

}
