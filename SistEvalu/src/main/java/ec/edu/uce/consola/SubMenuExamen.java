package ec.edu.uce.consola;

import ec.edu.uce.dominio.Examen;
import ec.edu.uce.dominio.Pregunta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SubMenuExamen {

    private final Scanner scanner = new Scanner(System.in);

    // Método para mostrar el submenú de gestión de exámenes
    public void mostrarSubMenuExamen() {
        System.out.println("------------------------------");
        System.out.println("      Gestión de Exámenes      ");
        System.out.println("------------------------------");
        System.out.println("1. Crear Examen");
        System.out.println("2. Modificar Examen");
        System.out.println("3. Eliminar Examen");
        System.out.println("4. Consultar Examen");
        System.out.println("5. Gestionar Preguntas");
        System.out.println("6. Gestionar Respuestas");
        System.out.println("7. Volver al Menú Principal");
        System.out.println("------------------------------");
        System.out.print("Ingresa la opción deseada: ");
    }

    // Método para procesar la opción seleccionada por el usuario
    public void procesarOpcionExamen(Examen examen) {
        int opcion = -1;
        do {
            mostrarSubMenuExamen();
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearExamen(examen);
                    break;
                case 2:
                    modificarExamen(examen);
                    break;
                case 3:
                    eliminarExamen(examen);
                    break;
                case 4:
                    consultarExamen(examen);
                    break;
                case 5:
                    // Llamar al submenú de preguntas
                    SubMenuPreguntas subMenuPreguntas = new SubMenuPreguntas();
                    subMenuPreguntas.procesarOpcionPreguntas(examen.getPreguntas());
                    break;
                case 6:
                    // Llamar al submenú de respuestas
                    SubMenuRespuestas subMenuRespuestas = new SubMenuRespuestas();
                    subMenuRespuestas.procesarOpcionRespuestas(examen.getPreguntas(), examen.getPreguntas().length);  // Enviamos el arreglo y el número de preguntas
                    break;
                case 7:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 7);
    }

    // Método para crear un examen
    private void crearExamen(Examen examen) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creando un nuevo examen...");

        System.out.print("Ingrese el ID del examen: ");
        examen.setIdExamen(sc.nextInt());
        sc.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Ingrese la asignatura: ");
        examen.setAsignatura(sc.nextLine());

        System.out.print("Ingrese la fecha del examen (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(fechaStr);

            // Validación de que la fecha haya pasado
            if (fecha.before(new Date())) {
                System.out.println("La fecha ingresada ya ha pasado. Por favor ingrese una fecha futura.");
                return;
            }

            examen.setFecha(fecha);
        } catch (ParseException e) {
            System.out.println("Fecha inválida, por favor ingrese la fecha en el formato correcto.");
            return;
        }

        // Inicialización del arreglo de preguntas
        System.out.print("Ingrese el número de preguntas: ");
        int numPreguntas = sc.nextInt();
        if (numPreguntas <= 0) {
            System.out.println("El número de preguntas debe ser mayor a 0.");
            return;
        }
        examen.setPreguntas(new Pregunta[numPreguntas]);


        for (int i = 0; i < numPreguntas; i++) {
            System.out.println("Ingresando pregunta " + (i + 1));
            // Aquí puedes añadir preguntas, usando submenú de preguntas si es necesario
        }

        System.out.println("Examen creado correctamente.");
    }

    // Método para modificar un examen
    private void modificarExamen(Examen examen) {
        if (examen.getIdExamen() == 0) {
            System.out.println("No se ha creado un examen.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Modificando el examen...");

        // Modificar la asignatura
        System.out.print("¿Desea modificar la asignatura? (Sí/No): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Ingrese la nueva asignatura: ");
            examen.setAsignatura(sc.nextLine());
        }

        // Modificar la fecha
        System.out.print("¿Desea modificar la fecha del examen? (Sí/No): ");
        respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
            String fechaStr = sc.nextLine();

            if (fechaStr.matches("\\d{2}/\\d{2}/\\d{4}")) {
                // Convertir la fecha ingresada
                String[] fechaParts = fechaStr.split("/");
                int dia = Integer.parseInt(fechaParts[0]);
                int mes = Integer.parseInt(fechaParts[1]);
                int anio = Integer.parseInt(fechaParts[2]);
                Date nuevaFecha = new Date(anio - 1900, mes - 1, dia);

                // Verificar si la fecha no está en el pasado
                if (nuevaFecha.before(new Date())) {
                    System.out.println("La fecha ingresada ya ha pasado. No se puede modificar.");
                } else {
                    examen.setFecha(nuevaFecha);
                }
            } else {
                System.out.println("La fecha ingresada no tiene el formato correcto. Debe ser dd/MM/yyyy.");
            }
        }

        // Modificar el número de preguntas
        System.out.print("¿Desea modificar el número de preguntas? (Sí/No): ");
        respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.print("Ingrese el nuevo número de preguntas: ");
            int numPreguntas = sc.nextInt();
            sc.nextLine();
            if (numPreguntas <= 0) {
                System.out.println("El número de preguntas debe ser mayor a 0.");
                return;
            }
            examen.setPreguntas(new Pregunta[numPreguntas]);


            System.out.println("Número de preguntas actualizado.");
        }

        System.out.println("Examen modificado correctamente.");
    }



    // Método para eliminar un examen
    private void eliminarExamen(Examen examen) {
        if (examen.getIdExamen() == 0) {
            System.out.println("No se ha creado un examen.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        // Solicitar el ID del examen que se desea eliminar
        System.out.print("Ingrese el ID del examen que desea eliminar: ");
        int idExamenEliminar = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer de entrada

        // Verificar si el ID del examen existe
        if (examen.getIdExamen() == idExamenEliminar) {
            // Mostrar los datos del examen
            System.out.println("Examen encontrado:");
            System.out.println("ID Examen: " + examen.getIdExamen());
            System.out.println("Asignatura: " + examen.getAsignatura());
            System.out.println("Fecha: " + examen.getFecha());
            System.out.println("Número de preguntas: " + examen.getPreguntas().length);


            System.out.print("¿Está seguro de que desea eliminar este examen? (Sí/No): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("Sí")) {

                examen.setIdExamen(0);
                examen.setAsignatura(null);
                examen.setFecha(null);
                examen.setPreguntas(null);

                System.out.println("Examen eliminado correctamente.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("No se encontró un examen con ese ID.");
        }
    }


    // Método para consultar un examen
    private void consultarExamen(Examen examen) {
        if (examen.getIdExamen() == 0) {
            System.out.println("No se ha creado un examen.");
            return;
        }

        System.out.println("Consultando el examen...");
        System.out.println("ID Examen: " + examen.getIdExamen());
        System.out.println("Asignatura: " + examen.getAsignatura());
        System.out.println("Fecha: " + examen.getFecha());
        System.out.println("Número de preguntas: " + examen.getPreguntas().length);

    }
}
