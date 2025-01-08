package ec.edu.uce.consola.gui;

import java.util.Scanner;

public class SubMenuExamen {
    private final Scanner scanner = new Scanner(System.in);
    public void mostrarSubMenuExamen() {
        System.out.println("------------------------------");
        System.out.println("       MENU DE EXAMENES       ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Examen");
        System.out.println("2. Modificar Examen");
        System.out.println("3. Eliminar Examen");
        System.out.println("4. Consultar Examen");
        System.out.println("5. Gestionar preguntas");
        System.out.println("6. Gestionar respuestas");
        System.out.println("7. Realizar Examen");
        System.out.println("8. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opcion deseada: ");
    }

    public void procesarOpcionExamen() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarSubMenuExamen();
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                sc.next(); // Consumir entrada inválida
                mostrarSubMenuExamen();
            }
            opcion = sc.nextInt();
            if (opcion <= 0) {
                System.out.println("Opcion no valida. Por favor ingrese un numero entero positivo.");
                continue;
            }
            sc.nextLine();

            switch (opcion) {
                case 1:
                    //crearNuevoExamen();
                    break;
                case 2:
                    //modificarExamen();
                    break;
                case 3:
                    //eliminarExamen();
                    break;
                case 4:
                    //mostrarSubMenuConsultarExamen();
                    break;
                case 5:
                    //mostrarSubMenuRealizarExamen();
                    break;
                case 6:
                    //mostrarSubMenuPreguntas();
                    break;
                case 7:
                    //mostrarSubMenuRespuestas();
                    break;
                case 8:
                    System.out.println("Volviendo al Menu SistEval");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 9);
    }
    //cruds + realizar examen
}
