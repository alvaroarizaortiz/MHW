package excepciones;

@SuppressWarnings("serial")
public class NombreCazadorVacio extends Exception {
	// Excepción que se muestra si se introduce un nombre en blanco cuando se crea un cazador
    public NombreCazadorVacio(String message) {
        super(message);
    }
}
