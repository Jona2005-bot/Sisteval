package ec.edu.uce.consola.gui;
import ec.edu.uce.dominio.Examen;
import ec.edu.uce.dominio.SesionExamen;
import ec.edu.uce.util.Validacion;
import java.util.Scanner;

public class MenuPrincipal {
    private SubMenuUsuario SubMenuUsuario;
    private Scanner scanner = new Scanner(System.in);

    public MenuPrincipal(){
        this.SubMenuUsuario = new SubMenuUsuario();
        seleccionMenu();
    }

    public void mostrarMenuPrincipal() {
        System.out.println("==================================================");
        System.out.println("                    MENU PRINCIPAL                ");
        System.out.println("==================================================");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. registrarse");
        System.out.println("3. Salir");
        System.out.println("==================================================");
        System.out.print("Seleccione una opción (1-3): ");
    }

    private void seleccionMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarMenuPrincipal();

            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida. Ingrese un numero entero positivo.");
                sc.next();
                mostrarMenuPrincipal();
            }
            opcion = sc.nextInt();
            if (opcion <= 0) {
                System.out.println("Opcion no valida. Ingrese un numero entero positivo.");
                continue;
            }
            sc.nextLine();

            switch (opcion) {
                case 1:
                    ingresarAlSistema();
                    break;
                case 2:
                    //SubMenuUsuario.crearNuevoUsuario();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 3);
    }

    /**
     * Método para ingresar al sistema. Solicita el nombre de usuario y la contraseña,
     * los valida y permite el acceso si las credenciales son correctas.
     */
    private void ingresarAlSistema() {
        String usuario;
        String contrasena;

        do {
            System.out.print("Ingrese su nombre de usuario: ");
            usuario = scanner.nextLine();
            if (!Validacion.validarNombres(usuario)) {
                System.out.println("Nombre de usuario no valido. Debe contener letras, numeros, guiones bajos y espacios.");
            }
        } while (!Validacion.validarNombres(usuario));

        // Validación de la contraseña
        do {
            System.out.print("Ingrese su contrasena: ");
            contrasena = scanner.nextLine();
            if (!Validacion.validarContrasena(contrasena)) {
                System.out.println("Contrasena no válida. Debe tener al menos 6 caracteres, una letra y un numero.");
            }
        } while (!Validacion.validarContrasena(contrasena));

        System.out.println("Acceso concedido.");

        // Llamar al menú TrackCity después de conceder acceso
        new MenuSistEval().MenuSistEval();
    }

    //Método principal que inicia el programa.

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
