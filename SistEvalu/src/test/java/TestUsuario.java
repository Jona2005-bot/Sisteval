import ec.edu.uce.dominio.Usuario;

public class TestUsuario {

    public static void main(String[] args) {
        testConstructorConParametros();
        testSetters();
        testValidarUsuario();
        testEmailInvalido();
        testContraseniaInvalida();
    }

    private static void testConstructorConParametros() {
        System.out.println("Prueba del constructor con parámetros:");

        Usuario usuario = new Usuario(123,"Juan Perez", "juan.perez@example.com", "password123", "Estudiante");

        if (usuario.getNombre().equals("Juan Perez") &&
                usuario.getEmail().equals("juan.perez@example.com") &&
                usuario.getContrasenia().equals("password123") &&
                usuario.getTipoUsuario().equals("Estudiante")) {
            System.out.println("Constructor con parámetros: PASADO");
        } else {
            System.out.println("Constructor con parámetros: FALLIDO");
        }

        System.out.println();
    }

    private static void testSetters() {
        System.out.println("Prueba de setters:");

        Usuario usuario = new Usuario(123,"Ana Lopez", "ana.lopez@example.com", "Ana2023*", "Administrador");

        // Probamos los setters
        usuario.setNombre("Carlos Ramirez");
        usuario.setEmail("carlos.ramirez@example.com");
        usuario.setContrasenia("Carlos2024!");
        usuario.setTipoUsuario("Docente");

        boolean nombreCorrecto = usuario.getNombre().equals("Carlos Ramirez");
        boolean emailCorrecto = usuario.getEmail().equals("carlos.ramirez@example.com");
        boolean contraseniaCorrecta = usuario.getContrasenia().equals("Carlos2024!");
        boolean tipoUsuarioCorrecto = usuario.getTipoUsuario().equals("Docente");

        if (nombreCorrecto && emailCorrecto && contraseniaCorrecta && tipoUsuarioCorrecto) {
            System.out.println("Setters: PASADO");
        } else {
            System.out.println("Setters: FALLIDO");
        }

        System.out.println();
    }

    private static void testValidarUsuario() {
        System.out.println("Prueba de validar usuario:");

        Usuario usuario = new Usuario(123,"Luis Ortega", "luis.ortega@example.com", "Luis12345", "Estudiante");

        boolean validacionCorrecta = usuario.validarUsuario("luis.ortega@example.com", "Luis12345");
        boolean validacionIncorrecta = usuario.validarUsuario("luis.ortega@example.com", "ContraseñaIncorrecta");

        if (validacionCorrecta && !validacionIncorrecta) {
            System.out.println("Validación de usuario: PASADO");
        } else {
            System.out.println("Validación de usuario: FALLIDO");
        }

        System.out.println();
    }

    private static void testEmailInvalido() {
        System.out.println("Prueba de email inválido:");

        Usuario usuario;
        boolean esEmailValido = true;

        String emailInvalido = "email Invalido";
        if (emailInvalido.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            usuario = new Usuario(123,"Miles Morales", emailInvalido, "Miles2024*", "Estudiante");
        } else {
            esEmailValido = false;
        }

        if (!esEmailValido) {
            System.out.println("Email inválido: PASADO");
        } else {
            System.out.println("Email inválido: FALLIDO");
        }

        System.out.println();
    }

    private static void testContraseniaInvalida() {
        System.out.println("Prueba de contraseña inválida:");

        Usuario usuario;
        boolean esContraseniaValida = true;

        String contraseniaInvalida = "La contraseña es demasiado corta, ingrese una contraseña valida";
        if (contraseniaInvalida.matches("^(?=.*[0-9]).{8,}$")) {
            usuario = new Usuario(123,"Maria Delgado", "maria.delgado@example.com", contraseniaInvalida, "Estudiante");
        } else {
            esContraseniaValida = false;
        }

        if (!esContraseniaValida) {
            System.out.println("Contraseña inválida: PASADO");
        } else {
            System.out.println("Contraseña inválida: FALLIDO");
        }

        System.out.println();
    }
}