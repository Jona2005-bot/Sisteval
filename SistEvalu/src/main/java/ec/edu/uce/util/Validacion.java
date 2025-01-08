package ec.edu.uce.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {

    //valida usuario de 5-20 caracteres
    public static boolean validarNombres(String nombreUsuario) {
        String usuarioPattern = "^[a-zA-Z0-9_ ]{5,20}$";
        Pattern pattern = Pattern.compile(usuarioPattern);
        Matcher matcher = pattern.matcher(nombreUsuario);
        return matcher.matches();
    }

    // valida contraseña Al menos 6 caracteres, con una letra y un número
    public static boolean validarContrasena(String contraseña) {
        // Verificar que la longitud sea al menos 6 caracteres
        if (contraseña.length() < 6) {
            return false;
        }
        // Verificar que contenga al menos un número
        if (!contraseña.matches(".*\\d.*")) {
            return false;
        }
        // Verificar que contenga al menos una letra
        if (!contraseña.matches(".*[a-zA-Z].*")) {
            return false;
        }
        // Si pasa todas las verificaciones, es válida
        return true;
    }

    //valida la forma de un correo
    public static boolean validarCorreoElectronico(String correoElectronico) {
        String correoPattern = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(correoPattern);
        Matcher matcher = pattern.matcher(correoElectronico);
        return matcher.matches();
    }

    //valida la matricula de un estudiante 6-10 caracteres
    public void setMatricula(String Matricula) {
        if (Matricula == null || !Matricula.matches("^\\d{6,10}$")) {
            throw new IllegalArgumentException("La matrícula debe contener entre 6 y 10 dígitos numéricos.");
        }

    }


}
