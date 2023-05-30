package excepciones;

@SuppressWarnings("serial")
public class AttackException extends Exception {
	// Excepción que se muestra en los ataques si se pulsa un botón cuando no se
	// puede realizar ese ataque
	// dentro del propio juego en la interfaz debido a que tienen un cooldown de dos
	// o más turnos. Nunca saltará usando el ataque básico, ya que no tiene
	// restricciones de turno.
	public AttackException(String message) {
		super(message);
	}
}