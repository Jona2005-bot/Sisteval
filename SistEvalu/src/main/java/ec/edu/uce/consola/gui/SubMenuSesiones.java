package ec.edu.uce.consola.gui;

import java.util.Scanner;

public class SubMenuSesiones {
    private final Scanner scanner = new Scanner(System.in);
    public void mostrarSubMenuSesiones() {
        System.out.println("------------------------------");
        System.out.println("      Sesiones de Examen      ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Sesion");
        System.out.println("2. Modificar Sesion");
        System.out.println("3. Eliminar Sesion");
        System.out.println("4. Consultar Sesion");
        System.out.println("5. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opcion deseada: ");
    }

    public void procesarOpcionSesion() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            mostrarSubMenuSesiones();
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                sc.next();
                mostrarSubMenuSesiones();
            }
            opcion = sc.nextInt();
            if (opcion <= 0) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                continue;
            }
            sc.nextLine();

            switch (opcion) {
                case 1:
                    //configurarSesionExamen();
                    break;
                case 2:
                    //controlarSesionExamen();
                    break;
                case 3:
                    //finalizarSesionExamen();
                    break;
                case 4:
                    //asignarCalificacion();
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
    //metodos de sub menu
}
