package ec.edu.uce.consola;

import ec.edu.uce.dominio.*;

import java.util.Scanner;

public class SubMenuUsuario {
    private final Scanner scanner = new Scanner(System.in);
    private Usuario[] usuarios;
    private int numUsuarios;

    public SubMenuUsuario() {
        this.usuarios = new Usuario[10];
        this.numUsuarios = 0;

        inicializarUsuarios();
    }

    private void inicializarUsuarios() {
        // Usuarios predeterminados
        Docente docente1 = new Docente(123,"Juan Perez", "juan.perez@gmail.com", "contrasenia123", "Docente", "Matemáticas", new Examen[0]);
        Estudiante estudiante1 = new Estudiante(123,"Carlos García", "carlos.garcia@gmail.com", "12345678", "Estudiante", "MATRICULA123", 0, new Asignatura[0]);
        Administrador administrador1 = new Administrador(123,"Ana Ruiz", "ana.ruiz@gmail.com", "admin123", "Administrador");

        // Añadimos los usuarios al arreglo
        usuarios[numUsuarios++] = docente1;
        usuarios[numUsuarios++] = estudiante1;
        usuarios[numUsuarios++] = administrador1;
    }

    public void mostrarSubMenuUsuario() {
        System.out.println("------------------------------");
        System.out.println("       MENU DE USUARIO        ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Usuario");
        System.out.println("2. Modificar Usuario");
        System.out.println("3. Eliminar Usuario");
        System.out.println("4. Consultar Usuario");
        System.out.println("5. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opción deseada: ");
    }

    public void procesarOpcionUsuario() {
        int opcion = -1;

        do {
            mostrarSubMenuUsuario();
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un numero valido");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearNuevoUsuario();
                    break;
                case 2:
                    modificarUsuario();
                    break;
                case 3:
                    eliminarUsuario();
                    break;
                case 4:
                    consultarUsuario();
                    break;
                case 5:
                    System.out.println("Volviendo al Menu Principal");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);
    }

    private void crearNuevoUsuario() {
        System.out.println("------------------------------");
        System.out.println("        CREAR USUARIO         ");
        System.out.println("------------------------------");

        String nombreUsuario;
        System.out.print("Ingrese el nombre de usuario: ");
        nombreUsuario = scanner.nextLine();

        String contrasena;
        System.out.print("Ingrese la contraseña (debe tener al menos 8 caracteres y contener un número): ");
        contrasena = scanner.nextLine();
        if (contrasena.length() < 8 || !contrasena.matches(".*\\d.*")) {
            System.out.println("La contraseña no cumple con los requisitos.");
            return;
        }

        String correoElectronico;
        System.out.print("Ingrese el correo electrónico (debe contener '@gmail.com'): ");
        correoElectronico = scanner.nextLine();
        if (!correoElectronico.matches("^[a-zA-Z0-9._%+-]+@gmail\\.com$")) {
            System.out.println("El correo electrónico no tiene el formato adecuado.");
            return;
        }

        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Docente");
        System.out.println("2. Estudiante");
        System.out.println("3. Administrador");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Usuario usuario = null;
        String matricula;

        switch (tipo) {
            case 1:
                System.out.print("Ingrese la asignatura del docente: ");
                String asignatura = scanner.nextLine();
                usuario = new Docente(123,nombreUsuario, correoElectronico, contrasena, "Docente", asignatura, new Examen[0]);
                break;
            case 2:
                System.out.print("Ingrese el número de matrícula: ");
                matricula = scanner.nextLine();
                usuario = new Estudiante(123,nombreUsuario, correoElectronico, contrasena, "Estudiante", matricula, 0, new Asignatura[0]);
                break;
            case 3:
                usuario = new Administrador(123,nombreUsuario, correoElectronico, contrasena, "Administrador");
                break;
            default:
                System.out.println("Tipo de usuario inválido.");
                return;
        }

        // Asegurarse de que haya espacio en el arreglo
        if (numUsuarios >= usuarios.length) {
            Usuario[] nuevoArreglo = new Usuario[usuarios.length + 5];
            System.arraycopy(usuarios, 0, nuevoArreglo, 0, usuarios.length);
            usuarios = nuevoArreglo;
        }

        usuarios[numUsuarios++] = usuario;
        System.out.println("Usuario creado exitosamente.");
    }

    private void modificarUsuario() {
        System.out.println("------------------------------");
        System.out.println("        MODIFICAR USUARIO     ");
        System.out.println("------------------------------");

        System.out.print("Ingrese el nombre del usuario a modificar: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = obtenerUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
            System.out.print("Ingrese el nuevo nombre (deje en blanco para no modificar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                usuario.setNombre(nuevoNombre);
            }

            System.out.print("Ingrese el nuevo correo electrónico (deje en blanco para no modificar): ");
            String nuevoEmail = scanner.nextLine();
            if (!nuevoEmail.isEmpty()) {
                usuario.setEmail(nuevoEmail);
            }

            System.out.print("Ingrese la nueva contraseña (deje en blanco para no modificar): ");
            String nuevaContrasenia = scanner.nextLine();
            if (!nuevaContrasenia.isEmpty()) {
                usuario.setContrasenia(nuevaContrasenia);
            }

            System.out.println("Usuario modificado exitosamente.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void eliminarUsuario() {
        System.out.println("------------------------------");
        System.out.println("        ELIMINAR USUARIO      ");
        System.out.println("------------------------------");

        System.out.print("Ingrese el nombre del usuario a eliminar: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = obtenerUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            for (int i = 0; i < numUsuarios; i++) {
                if (usuarios[i].equals(usuario)) {
                    for (int j = i; j < numUsuarios - 1; j++) {
                        usuarios[j] = usuarios[j + 1];
                    }
                    usuarios[--numUsuarios] = null;
                    System.out.println("Usuario eliminado exitosamente.");
                    break;
                }
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void consultarUsuario() {
        System.out.println("------------------------------");
        System.out.println("        CONSULTAR USUARIO     ");
        System.out.println("------------------------------");

        System.out.print("Ingrese el nombre del usuario a consultar: ");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = obtenerUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private Usuario obtenerUsuarioPorNombre(String nombreUsuario) {
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i].getNombre().equalsIgnoreCase(nombreUsuario)) {
                return usuarios[i];
            }
        }
        return null;
    }
}
