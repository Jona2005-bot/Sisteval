package ec.edu.uce.consola.gui;

import java.util.Scanner;

public class SubMenuAsignaturas {
    private final Scanner scanner = new Scanner(System.in);
    public void mostrarSubMenuMaterial() {
        System.out.println("------------------------------");
        System.out.println("     MATERIAL DE ESTUDIO      ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Asignatura");
        System.out.println("2. Modificar Asignatura");
        System.out.println("3. Eliminar Asignatura");
        System.out.println("4. Consultar Asignatura");
        System.out.println("5. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opcion deseada: ");
    }

    public void procesarOpcionMaterial() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        do {
            mostrarSubMenuMaterial();
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                sc.next(); // Consumir entrada inválida
                mostrarSubMenuMaterial();
            }
            opcion = sc.nextInt();
            if (opcion <= 0) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                continue;
            }
            sc.nextLine();

            switch (opcion) {
                case 1:
                    //crearAsignatura();
                case 2:
                    //modificarAsignatura();
                    break;
                case 3:
                    //eliminarAsignatura();
                    break;
                case 4:
                    //consultarAsignatura();
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
