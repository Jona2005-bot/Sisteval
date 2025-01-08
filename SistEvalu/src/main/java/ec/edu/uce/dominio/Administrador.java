package ec.edu.uce.dominio;

public class Administrador extends Usuario {
    private Usuario[] usuarios;
    private int numUsuarios;
    private int idAdministrador;

    // Constructor por defecto
    public Administrador() {
        super(); // Llama al constructor por defecto de Usuario
        this.usuarios = new Usuario[3]; // Inicializa el arreglo de usuarios con tamaño predeterminado
        this.numUsuarios = 0;
        this.idAdministrador = 1; // Se asigna un valor predeterminado para idAdministrador
    }

    //Constructor con this



    // Constructor con parámetros
    public Administrador(int idAdministrador,String nombre, String email, String contrasenia, String tipoUsuario) {
        super(idAdministrador,nombre, email, contrasenia, tipoUsuario); // Llama al constructor de Usuario
        this.usuarios = new Usuario[3]; // Inicializa el arreglo de usuarios
        this.numUsuarios = 0;
        this.idAdministrador = 1; // Se asigna un valor predeterminado para idAdministrador
    }

    // Constructor con idAdministrador asignado
    public Administrador(String nombre, String contrasenia, String tipoUsuario, int idAdministrador) {
        super(idAdministrador,nombre, "maty@gmail.com", contrasenia, tipoUsuario); // Correo predeterminado para el Administrador
        this.idAdministrador = idAdministrador; // Se asigna el idAdministrador pasado por parámetro
        this.usuarios = new Usuario[3]; // Inicializa el arreglo de usuarios
        this.numUsuarios = 0;
    }

    // Getter y Setter para idAdministrador
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        if (idAdministrador <= 0) {
            throw new IllegalArgumentException("El idAdministrador debe ser positivo.");
        }
        this.idAdministrador = idAdministrador;
    }

    @Override
    public String toString() {
        return "Administrador "  + "\r\n" +
                " idAdministrador: " + idAdministrador +
                "\r\n" + super.toString();
    }

    // Métodos CRUD para usuarios

    // Agregar Usuario
    public void agregarUsuario(String nombre, String email, String contrasenia, String tipoUsuario) {
        if (numUsuarios >= usuarios.length) {
            // Redimensionar el arreglo si es necesario
            Usuario[] usuAux = usuarios;
            usuarios = new Usuario[numUsuarios + 1];
            System.arraycopy(usuAux, 0, usuarios, 0, usuAux.length);
        }
        usuarios[numUsuarios] = new Usuario(idAdministrador,nombre, email, contrasenia, tipoUsuario);
        numUsuarios++;
    }

    // Consultar Usuario
    public String consultarUsuario() {
        String texto = "";
        for (int i = 0; i < numUsuarios; i++) {
            texto += usuarios[i].toString() + "\r\n";
        }
        return texto;
    }

    // Buscar Usuario por posición
    public Usuario buscarUsuarios(int pos) {
        if (pos >= 0 && pos < numUsuarios) {
            return usuarios[pos];
        } else {
            System.out.println("ERROR. POSICION NO VALIDA");
            return null;
        }
    }

    // Editar Usuario
    public boolean editarUsuario(int pos, String nombre, String email, String contrasenia, String tipoUsuario) {
        if (pos >= 0 && pos < numUsuarios) {
            usuarios[pos] = new Usuario(idAdministrador,nombre, email, contrasenia, tipoUsuario);
            return true;
        }
        return false;
    }

    // Eliminar Usuario
    public void eliminarUsuario(int pos) {
        if (pos >= 0 && pos < numUsuarios) {
            Usuario[] usuAux = usuarios;
            usuarios = new Usuario[numUsuarios - 1];
            if (pos == 0) {
                System.arraycopy(usuAux, 1, usuarios, 0, usuAux.length - 1);
            } else if (pos == numUsuarios - 1) {
                System.arraycopy(usuAux, 0, usuarios, 0, usuAux.length - 1);
            } else {
                System.arraycopy(usuAux, 0, usuarios, 0, pos);
                System.arraycopy(usuAux, pos + 1, usuarios, pos, usuAux.length - pos - 1);
            }
            numUsuarios--;
        }
    }
}
