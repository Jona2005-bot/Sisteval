package ec.edu.uce.consola;

import ec.edu.uce.dominio.Examen;
import ec.edu.uce.dominio.Pregunta;
import java.util.Scanner;

public class MenuSistEval {

    private final Scanner teclado = new Scanner(System.in);
    private final SubMenuUsuario subMenuUsuario;
    private final SubMenuAsignatura subMenuAsignatura;
    private final SubMenuExamen subMenuExamen;
    private final SubMenuSesiones SubMenuSesiones;
    private final SubMenuPreguntas SubMenuPreguntas;
    private final SubMenuRespuestas SubMenuRespuestas;

    public MenuSistEval() {
        this.subMenuAsignatura = new SubMenuAsignatura();
        this.subMenuUsuario = new SubMenuUsuario();
        this.subMenuExamen = new SubMenuExamen();
        this.SubMenuSesiones = new SubMenuSesiones();
        this.SubMenuPreguntas = new SubMenuPreguntas();
        this.SubMenuRespuestas = new SubMenuRespuestas();
    }

    void MenuSistEval() {
        int opcion;

        do {
            System.out.println("====================================");
            System.out.println("             ¡SISTEVAL¡");
            System.out.println("====================================");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1. Gestionar Usuario");
            System.out.println("2. Gestionar Examen");
            System.out.println("3. Gestionar Asignatura");
            System.out.println("4. Gestionar Sesiones De Examen");
            System.out.println("5. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción (1-5): ");

            while (!teclado.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    subMenuUsuario.procesarOpcionUsuario();
                    break;
                case 2:
                    // Crear un Examen para pasar al SubMenuExamen
                    Examen examen = new Examen();
                    subMenuExamen.procesarOpcionExamen(examen); // Pasamos el objeto Examen al submenú
                    break;
                case 3:
                    subMenuAsignatura.procesarOpcionAsignatura();
                    break;
                case 4:
                    SubMenuSesiones.procesarOpcionSesion();
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while (opcion != 5);
    }

    public static void main(String[] args) {
        new MenuSistEval().MenuSistEval();
    }
}
