package ec.edu.uce.consola;

import ec.edu.uce.dominio.Pregunta;
import ec.edu.uce.dominio.Respuesta;
import java.util.Scanner;

public class SubMenuPreguntas {
    private final Scanner scanner = new Scanner(System.in);

    // Inicialización de algunas preguntas de ejemplo
    private Pregunta[] preguntas = new Pregunta[10];

    public SubMenuPreguntas() {
        // Inicializando el arreglo con preguntas de ejemplo
        inicializarPreguntas();
    }

    // Método para inicializar algunas preguntas de ejemplo
    private void inicializarPreguntas() {
        // Creamos las respuestas para la primera pregunta
        Respuesta[] respuestas1 = new Respuesta[] {
                new Respuesta("París", true),
                new Respuesta("Madrid", false),
                new Respuesta("Londres", false)
        };

        // Creamos la primera pregunta
        preguntas[0] = new Pregunta(1, "¿Cuál es la capital de Francia?", respuestas1);

        // Creamos las respuestas para la segunda pregunta
        Respuesta[] respuestas2 = new Respuesta[] {
                new Respuesta("4", true),
                new Respuesta("5", false),
                new Respuesta("6", false)
        };


        preguntas[1] = new Pregunta(2, "¿Cuánto es 2 + 2?", respuestas2);

    }

    // Método para mostrar el submenú de gestión de preguntas
    public void mostrarSubMenuPreguntas() {
        System.out.println("------------------------------");
        System.out.println("     Gestión De Preguntas     ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Preguntas");
        System.out.println("2. Modificar Preguntas");
        System.out.println("3. Eliminar Preguntas");
        System.out.println("4. Consultar Preguntas");
        System.out.println("5. Volver al Menú Examen");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opción deseada: ");
    }

    // Método para procesar la opción seleccionada por el usuario
    public void procesarOpcionPreguntas(Pregunta[] preguntas) {
        int opcion = -1;
        do {
            mostrarSubMenuPreguntas();
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPregunta();
                    break;
                case 2:
                    modificarPregunta();
                    break;
                case 3:
                    eliminarPregunta();
                    break;
                case 4:
                    consultarPregunta();
                    break;
                case 5:
                    System.out.println("Volviendo al Menú Examen");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);
    }

    // Método para crear una nueva pregunta
    private void crearPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creando nueva pregunta...");

        System.out.print("Ingrese el ID de la pregunta: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el texto de la pregunta: ");
        String texto = sc.nextLine();

        System.out.print("Ingrese el número de respuestas posibles: ");
        int numRespuestas = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        Respuesta[] respuestas = new Respuesta[numRespuestas];
        for (int i = 0; i < numRespuestas; i++) {
            System.out.print("Ingrese la respuesta " + (i + 1) + ": ");
            String textoRespuesta = sc.nextLine();
            respuestas[i] = new Respuesta(textoRespuesta); // Crear una nueva respuesta
        }

        // Buscar un lugar libre en el arreglo de preguntas (vacío o no inicializado)
        for (int i = 0; i < preguntas.length; i++) {
            if (preguntas[i] == null) {
                preguntas[i] = new Pregunta(idPregunta, texto, respuestas);
                System.out.println("Pregunta creada correctamente.");
                return;
            }
        }

        System.out.println("No hay espacio disponible para más preguntas.");
    }

    // Método para modificar una pregunta
    private void modificarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la pregunta que desea modificar: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        // Buscar la pregunta con el ID ingresado
        for (Pregunta pregunta : preguntas) {
            if (pregunta != null && pregunta.getIdPregunta() == idPregunta) {
                System.out.println("Pregunta encontrada: " + pregunta);

                // Modificar el enunciado de la pregunta
                System.out.print("Ingrese el nuevo texto para la pregunta: ");
                pregunta.setEnunciado(sc.nextLine());

                // Modificar las respuestas
                System.out.print("¿Cuántas respuestas desea agregar/modificar? ");
                int numRespuestas = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                Respuesta[] respuestas = new Respuesta[numRespuestas];
                for (int i = 0; i < numRespuestas; i++) {
                    System.out.print("Ingrese la respuesta " + (i + 1) + ": ");
                    String textoRespuesta = sc.nextLine();
                    respuestas[i] = new Respuesta(textoRespuesta); // Crear una nueva respuesta
                }

                pregunta.setRespuestas(respuestas);
                System.out.println("Pregunta modificada correctamente.");
                return;
            }
        }

        System.out.println("No se encontró una pregunta con ese ID.");
    }

    // Método para eliminar una pregunta
    private void eliminarPregunta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la pregunta que desea eliminar: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        // Buscar y eliminar la pregunta con el ID ingresado
        for (int i = 0; i < preguntas.length; i++) {
            if (preguntas[i] != null && preguntas[i].getIdPregunta() == idPregunta) {
                preguntas[i] = null; // Eliminar la pregunta
                System.out.println("Pregunta eliminada correctamente.");
                return;
            }
        }

        System.out.println("No se encontró una pregunta con ese ID.");
    }

    // Método para consultar las preguntas
    private void consultarPregunta() {
        System.out.println("Consultando preguntas...");
        for (Pregunta pregunta : preguntas) {
            if (pregunta != null) {
                System.out.println(pregunta);
            }
        }
    }
}
