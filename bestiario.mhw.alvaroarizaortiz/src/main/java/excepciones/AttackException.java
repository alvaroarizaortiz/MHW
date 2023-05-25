package excepciones;

public class AttackException extends Exception {
	//Excepción que se muestra en los ataques - en la mayoría de ocasiones si se pulsa un botón cuando no se puede realizar ese ataque
    public AttackException(String message) {
        super(message);
    }
}