package ec.edu.uce.consola.gui;
import ec.edu.uce.consola.SubMenuAsignatura;

import java.util.Scanner;

public class MenuSistEval {

    private final Scanner teclado = new Scanner(System.in);
    private final SubMenuUsuario subMenuUsuario;
    private final SubMenuAsignaturas subMenuAsignaturas;
    private final SubMenuExamen subMenuExamen;
    private final SubMenuAsignaturas SubMenuMaterial;
    private final SubMenuSesiones SubMenuSesiones;

    public MenuSistEval() {
        this.subMenuAsignaturas = new SubMenuAsignaturas();
        this.subMenuUsuario = new SubMenuUsuario();
        this.subMenuExamen = new SubMenuExamen();
        this.SubMenuMaterial = new SubMenuAsignaturas();
        this.SubMenuSesiones = new SubMenuSesiones();

    }

    void MenuSistEval() {
        int opcion;

        do {
            System.out.println("====================================");
            System.out.println("             ¡SISTEVAL¡");
            System.out.println("====================================");
            System.out.println("¿que desea hacer hoy?");
            System.out.println("1. Gestionar Usuario");
            System.out.println("2. Gestionar Examen");
            System.out.println("3. Gestionar Asignatura");
            System.out.println("4. Gestionar Sesiones De Examen");
            System.out.println("5. salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción (1-6): ");

            while (!teclado.hasNextInt()) {
                System.out.println("Por favor ingrese un numero valido");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    subMenuUsuario.procesarOpcionUsuario();
                    break;
                case 2:
                    subMenuExamen.procesarOpcionExamen();
                    break;
                case 3:
                    SubMenuSesiones.procesarOpcionSesion();
                    break;
                case 4:
                    SubMenuAsignatura.procesarOpcionAsignatura();
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (opcion != 6);
    }
    //Método que da paso al menu de sisteval.
    public static void main(String[] args) {
        new MenuSistEval();
    }
}
