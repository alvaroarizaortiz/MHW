package excepciones;

@SuppressWarnings("serial")
public class FormularioVacioException extends Exception {
    public FormularioVacioException(String errorMessage) {
        super(errorMessage);
    }
}