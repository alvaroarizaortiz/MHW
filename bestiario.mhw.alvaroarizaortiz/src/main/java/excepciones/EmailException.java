package excepciones;

@SuppressWarnings("serial")
public class EmailException extends Exception {
	// Excepción que se muestra en el formulario de feedback si se introduce una dirección de correo electrónico que no contenga @
    public EmailException(String message) {
        super(message);
    }
}