package ec.edu.uce.consola;

import ec.edu.uce.dominio.Asignatura;
import java.util.Scanner;

public class SubMenuAsignatura {
    private static Asignatura[] asignaturas = new Asignatura[10];
    private static int contador = 0; // Contador para llevar el control de las asignaturas en el arreglo
    private final Scanner scanner = new Scanner(System.in);

    public SubMenuAsignatura() {
        inicializarAsignaturas();  // Inicializamos las asignaturas predeterminadas al crear el objeto
    }

    public static void mostrarSubMenuAsignatura() {
        System.out.println("------------------------------");
        System.out.println("   Gestión de Asignaturas      ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Asignatura");
        System.out.println("2. Modificar Asignatura");
        System.out.println("3. Eliminar Asignatura");
        System.out.println("4. Consultar Asignatura");
        System.out.println("5. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opción deseada: ");
    }

    public static void procesarOpcionAsignatura() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            mostrarSubMenuAsignatura();
            while (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearAsignatura();
                    break;
                case 2:
                    modificarAsignatura();
                    break;
                case 3:
                    eliminarAsignatura();
                    break;
                case 4:
                    consultarAsignatura();
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

    // Método para crear una nueva asignatura
    public static void crearAsignatura() {
        Scanner sc = new Scanner(System.in);
        if (contador >= asignaturas.length) {
            System.out.println("No se pueden agregar más asignaturas. El arreglo está lleno.");
            return;
        }

        System.out.print("Ingrese el nombre de la asignatura: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el ID de la asignatura: ");
        int idAsignatura = sc.nextInt();

        Asignatura nuevaAsignatura = new Asignatura(nombre, idAsignatura);
        asignaturas[contador] = nuevaAsignatura;  // Añadimos la asignatura al arreglo
        contador++;
        System.out.println("Asignatura creada correctamente: " + nuevaAsignatura);
    }

    // Método para modificar una asignatura
    public static void modificarAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la asignatura a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Asignatura asignatura = buscarAsignaturaPorId(id);
        if (asignatura != null) {
            // Mostrar la asignatura antes de modificarla
            System.out.println("Asignatura encontrada: " + asignatura);

            System.out.print("Ingrese el nuevo nombre de la asignatura: ");
            String nuevoNombre = sc.nextLine();
            asignatura.setNombre(nuevoNombre);
            System.out.println("Asignatura modificada: " + asignatura);
        } else {
            System.out.println("Asignatura no encontrada.");
        }
    }

    // Método para eliminar una asignatura
    public static void eliminarAsignatura() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la asignatura a eliminar: ");
        int id = sc.nextInt();

        Asignatura asignatura = buscarAsignaturaPorId(id);
        if (asignatura != null) {
            // Desplazamos los elementos hacia la izquierda para "eliminar" la asignatura
            for (int i = 0; i < contador; i++) {
                if (asignaturas[i].getIdAsignatura() == id) {
                    for (int j = i; j < contador - 1; j++) {
                        asignaturas[j] = asignaturas[j + 1];
                    }
                    asignaturas[contador - 1] = null;  // Limpiamos la última posición
                    contador--;
                    System.out.println("Asignatura eliminada.");
                    return;
                }
            }
        } else {
            System.out.println("Asignatura no encontrada.");
        }
    }

    // Método para consultar las asignaturas
    public static void consultarAsignatura() {
        if (contador == 0) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            System.out.println("Asignaturas registradas:");
            for (int i = 0; i < contador; i++) {
                System.out.println(asignaturas[i]);
            }
        }
    }

    // Método para inicializar asignaturas con valores predeterminados
    public static void inicializarAsignaturas() {
        if (contador > 0) {
            return;  // Si ya hay asignaturas, no hacemos nada
        }

        asignaturas[0] = new Asignatura("Matemáticas", 1);
        asignaturas[1] = new Asignatura("Física", 2);
        asignaturas[2] = new Asignatura("Química", 3);
        contador = 3;  // Actualizamos el contador para reflejar las asignaturas inicializadas
        System.out.println("Asignaturas inicializadas.");
    }

    // Método para buscar una asignatura por su ID
    private static Asignatura buscarAsignaturaPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (asignaturas[i].getIdAsignatura() == id) {
                return asignaturas[i];
            }
        }
        return null;
    }
}
