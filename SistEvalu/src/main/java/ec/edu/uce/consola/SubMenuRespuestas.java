package ec.edu.uce.consola;

import ec.edu.uce.dominio.Pregunta;
import ec.edu.uce.dominio.Respuesta;

import java.util.Scanner;

public class SubMenuRespuestas {
    private final Scanner scanner = new Scanner(System.in);

    // Método para mostrar el submenú de respuestas
    public void mostrarSubMenuRespuestas() {
        System.out.println("------------------------------");
        System.out.println("    Gestión de Respuestas     ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Respuesta");
        System.out.println("2. Modificar Respuesta");
        System.out.println("3. Eliminar Respuesta");
        System.out.println("4. Consultar Respuesta");
        System.out.println("5. Volver al Menu Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opción deseada: ");
    }

    // Método para procesar la opción seleccionada en el submenú
    public void procesarOpcionRespuestas(Pregunta[] preguntas, int numPreguntas) {
        int opcion = -1;
        do {
            mostrarSubMenuRespuestas();
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearRespuesta(preguntas, numPreguntas);
                    break;
                case 2:
                    modificarRespuesta(preguntas, numPreguntas);
                    break;
                case 3:
                    eliminarRespuesta(preguntas, numPreguntas);
                    break;
                case 4:
                    consultarRespuestas(preguntas, numPreguntas);
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

    // Método para crear una nueva respuesta para una pregunta
    public void crearRespuesta(Pregunta[] preguntas, int numPreguntas) {
        if (numPreguntas == 0) {
            System.out.println("No hay preguntas disponibles para agregar respuestas.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice de la pregunta a la que desea agregar una respuesta: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        if (idPregunta >= 0 && idPregunta < numPreguntas) {
            Pregunta pregunta = preguntas[idPregunta];

            System.out.print("Ingrese el texto de la respuesta: ");
            String textoRespuesta = sc.nextLine();
            System.out.print("¿Es esta respuesta correcta? (true/false): ");
            boolean esCorrecta = sc.nextBoolean();

            // Crear una nueva respuesta
            Respuesta nuevaRespuesta = new Respuesta(textoRespuesta);

            // Agregar la nueva respuesta a las respuestas de la pregunta
            Respuesta[] respuestasActualizadas = new Respuesta[pregunta.getRespuestas().length + 1];
            System.arraycopy(pregunta.getRespuestas(), 0, respuestasActualizadas, 0, pregunta.getRespuestas().length);
            respuestasActualizadas[respuestasActualizadas.length - 1] = nuevaRespuesta;
            pregunta.setRespuestas(respuestasActualizadas);

            System.out.println("Respuesta agregada correctamente.");
        } else {
            System.out.println("Índice de pregunta no válido.");
        }
    }

    // Método para modificar una respuesta existente de una pregunta
    public void modificarRespuesta(Pregunta[] preguntas, int numPreguntas) {
        if (numPreguntas == 0) {
            System.out.println("No hay preguntas disponibles para modificar respuestas.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice de la pregunta a la que desea modificar una respuesta: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        if (idPregunta >= 0 && idPregunta < numPreguntas) {
            Pregunta pregunta = preguntas[idPregunta];

            System.out.print("Ingrese el índice de la respuesta a modificar: ");
            int idRespuesta = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            if (idRespuesta >= 0 && idRespuesta < pregunta.getRespuestas().length) {
                Respuesta respuesta = pregunta.getRespuestas()[idRespuesta];

                System.out.println("Respuesta actual: " + respuesta.getRespuestaTexto());
                System.out.print("Ingrese el nuevo texto de la respuesta: ");
                String nuevoTexto = sc.nextLine();

                System.out.print("¿Es esta respuesta correcta? (true/false): ");
                boolean nuevaEsCorrecta = sc.nextBoolean();

                // Modificar la respuesta
                respuesta.setRespuestaTexto(nuevoTexto);
                respuesta.setEsCorrecta(nuevaEsCorrecta);

                System.out.println("Respuesta modificada correctamente.");
            } else {
                System.out.println("Índice de respuesta no válido.");
            }
        } else {
            System.out.println("Índice de pregunta no válido.");
        }
    }

    // Método para eliminar una respuesta de una pregunta
    public void eliminarRespuesta(Pregunta[] preguntas, int numPreguntas) {
        if (numPreguntas == 0) {
            System.out.println("No hay preguntas disponibles para eliminar respuestas.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice de la pregunta a la que desea eliminar una respuesta: ");
        int idPregunta = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        if (idPregunta >= 0 && idPregunta < numPreguntas) {
            Pregunta pregunta = preguntas[idPregunta];

            System.out.print("Ingrese el índice de la respuesta a eliminar: ");
            int idRespuesta = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            if (idRespuesta >= 0 && idRespuesta < pregunta.getRespuestas().length) {
                // Eliminar la respuesta
                Respuesta[] respuestasActualizadas = new Respuesta[pregunta.getRespuestas().length - 1];
                for (int i = 0, j = 0; i < pregunta.getRespuestas().length; i++) {
                    if (i != idRespuesta) {
                        respuestasActualizadas[j++] = pregunta.getRespuestas()[i];
                    }
                }
                pregunta.setRespuestas(respuestasActualizadas);

                System.out.println("Respuesta eliminada correctamente.");
            } else {
                System.out.println("Índice de respuesta no válido.");
            }
        } else {
            System.out.println("Índice de pregunta no válido.");
        }
    }

    // Método para consultar todas las respuestas de una pregunta
    public void consultarRespuestas(Pregunta[] preguntas, int numPreguntas) {
        if (numPreguntas == 0) {
            System.out.println("No hay preguntas disponibles para consultar respuestas.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el índice de la pregunta para consultar sus respuestas: ");
        int idPregunta = sc.nextInt();
        sc.nextLine();

        if (idPregunta >= 0 && idPregunta < numPreguntas) {
            Pregunta pregunta = preguntas[idPregunta];

            System.out.println("Respuestas para la pregunta: " + pregunta.getEnunciado());
            for (int i = 0; i < pregunta.getRespuestas().length; i++) {
                Respuesta respuesta = pregunta.getRespuestas()[i];
                System.out.println((i + 1) + ". " + respuesta.getRespuestaTexto() + " (Correcta: " + respuesta.getEsCorrecta() + ")");
            }
        } else {
            System.out.println("Índice de pregunta no válido.");
        }
    }
}
