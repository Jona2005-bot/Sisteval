package ec.edu.uce.consola.gui;
import ec.edu.uce.util.Validacion;
import java.util.Scanner;

public class  SubMenuUsuario {
    private final Scanner scanner = new Scanner(System.in);
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
        System.out.print("Ingresa la opcion deseada: ");
    }

    public void procesarOpcionUsuario() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarSubMenuUsuario();

            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                sc.next(); // Consumir entrada inválida
                mostrarSubMenuUsuario();
            }

            opcion = sc.nextInt();

            if (opcion <= 0) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                continue;
            }

            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    //crearNuevoUsuario();
                    break;
                case 2:
                    //modificarUsuario();
                    break;
                case 3:
                    //eliminarUsuario();
                    break;
                case 4:
                    //ConsultarUsuario();
                    break;
                case 5:
                    System.out.println("Volviendo al Menu SistEval");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }
    //cruds
}
