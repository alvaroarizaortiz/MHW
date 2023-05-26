package clases;

import java.util.concurrent.ThreadLocalRandom;
import enumeraciones.Elemento;
import excepciones.AttackException;

public class Cazador {
	private int saludCazador; // Salud total del cazador
	private Armadura armaduraEquipada; // Armadura que el cazador tiene equipada
	private Arma armaEquipada; // Arma que el cazador tiene equipada
	private int id; // Identificador cazador
	private String nombre; // Nombre del cazador
	private int saludActualCazador; // Salud actual del cazador (será menor que saludCazador debido a los daños
									// excepto en el primer turno)
	private double dañoUltimoTurno = 0; // Daño que el cazador hizo en el último turno
	private int turnoAtaqueFuerte = 3; // Contador para el ataque fuerte, solo disponible cada 3 turnos
	private int turnoEsquivar = 2; // Contador para esquivar, solo disponible cada 2 turnos. Inicializa en 2 y va
									// restando hasta 0. Luego vuelve a 2
	private int turnoAtaqueCritico = 5; // Contador para el ataque crítico, solo disponible cada 5 turnos. Inicializa en
										// 5 y va restando hasta 0. Luego vuelve a 5
	private int turnoAtaqueMultiple = 5; // Contador para el ataque múltiple, solo disponible cada 5 turnos. Inicializa
											// en 5 y va restando hasta 0. Luego vuelve a 5
	private int turnoAtaqueConEscudo = 2; // Contador ataque con escudo. Inicializa en 2 y va restando hasta 0. Luego
											// vuelve a 2
	private boolean ataqueFuerteDisponible = true; // Indica si el ataque fuerte está disponible. Inicia en true para
													// que esté disponible el primer turno del combate.
	private boolean esquivarDisponible = true; // Indica si esquivar está disponible. Inicia en true para que esté
												// disponible el primer turno del combate
	private boolean ataqueCriticoDisponible = true; // Indica si el ataque crítico está disponible. Inicia en true para
													// que esté disponible el primer turno del combate
	private boolean ataqueMultipleDisponible = true; // Indica si el ataque múltiple está disponible. Inicia en true
														// para que esté disponible el primer turno del combate
	private boolean ataqueConEscudoDisponible = true; // Indica si defender está disponible. Inicia en true para que
														// esté disponible el primer turno del combate
	private boolean dañoAtaqueArmaReducido = false; // Indica si el daño del ataque del arma ha sido reducido. Inicia en
													// false para que el daño del arma no empiece reducido
	boolean esquivando = false;
	private int turno = 0; // Contador de turnos

	// Constructor usado durante la realización del proyecto. Sobre todo en base de
	// datos.
	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada, int id) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
		this.id = id;
		this.saludActualCazador = saludCazador;
	}

	// Constructor usado durante la realización del proyecto. Es el que se usa en
	// general - incluido interfaz.
	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada, String nombre) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
		this.nombre = nombre;
		this.saludActualCazador = saludCazador;
	}

	// Métodos getters y setters para las variables de estado
	public int getSaludCazador() {
		return saludCazador;
	}

	public void setSaludCazador(int saludCazador) {
		this.saludCazador = saludCazador;
	}

	public Armadura getArmaduraEquipada() {
		return armaduraEquipada;
	}

	public void setArmaduraEquipada(Armadura armaduraEquipada) {
		this.armaduraEquipada = armaduraEquipada;
	}

	public Arma getArmaEquipada() {
		return armaEquipada;
	}

	public void setArmaEquipada(Arma armaEquipada) {
		this.armaEquipada = armaEquipada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Importante para que los puntos de salud del cazador vaya bajando durante el
	// transcurso del combate.
	public int getSaludActualCazador() {
		return saludActualCazador;
	}

	public void setSaludActualCazador(int saludActualCazador) {
		this.saludActualCazador = saludActualCazador;
	}

	// Importante para recibir los daños que hace cada turno el cazador y sacarlos
	// por pantalla a través de un área de texto.
	public double getDañoUltimoTurno() {
		return dañoUltimoTurno;
	}

	public void setDañoUltimoTurno(double dañoUltimoTurno) {
		this.dañoUltimoTurno = dañoUltimoTurno;
	}

	// Importante para que el cazador tenga siempre 5000 puntos de salud al terminar
	// un combate.
	// Terminar un combate implica que la salud del monstruo o del cazador ha
	// llegado a 0 y que el propio programa ha cerrado la pantalla de combate.
	public void resetearSaludCazador() {
		saludActualCazador = saludCazador;
	}

	// TODOS LOS ATAQUES ESTÁN SUJETOS A LA TABLA DE RESISTENCIAS Y DEBILIDADES
	// ELEMENTALES.

	// Método de ataque normal. Ataque estandar que utiliza el daño del arma (sujeto
	// a los debuffs del monstruo)
	public void ataque(MonstruoGrande monstruo) {
		this.turno++;
		int daño = this.armaEquipada.getPoderAtaque();
		
		if (monstruo.isDefendiendo()) {
			daño = 0;
			monstruo.setDefendiendo(false);
		}
		double dañoFinal = calcularDaño(monstruo, daño);
		dañoUltimoTurno = dañoFinal;
		monstruo.recibirDaño(dañoFinal);
		System.out.println("La salud actual del monstruo es " + monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearAtaqueFuerte();
		resetearEsquivar();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();

	}

	// Método de ataque fuerte. Se puede usar cada tres turnos y hace el daño de un
	// ataque normal multiplicado por 2
	public void ataqueFuerte(MonstruoGrande monstruo) throws AttackException {
		int daño = this.armaEquipada.getPoderAtaque() * 2;
		if (!ataqueFuerteDisponible) {
			throw new AttackException(
					"Tu cazador está demasiado cansado para hacer eso. El ataque fuerte solo está disponible cada 3 turnos.");
		}
		if (monstruo.isDefendiendo()) {
			daño = 0;
		}

		double dañoFinal = calcularDaño(monstruo, daño);
		dañoUltimoTurno = dañoFinal;
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		ataqueFuerteDisponible = false;
		turno++;

		resetearAtaqueFuerte();
		resetearEsquivar();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();
	}

	// Método para esquivar. Se puede usar cada 2 turnos. Esquiva totalmente el
	// ataque del monstruo si este iba a hacer daño
	public void esquivar(MonstruoGrande monstruo) throws AttackException {
		if (!esquivarDisponible) {
			throw new AttackException(
					"Tu cazador está demasiado cansado para hacer eso. Esquivar solo está disponible cada 2 turnos");
		}

		esquivarDisponible = false;
		turno++;
		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearEsquivar();
		resetearAtaqueFuerte();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();
	}

	// Método para el ataque crítico de la Gran Espada. Se puede usar cada 5 turnos.
	// Hace un daño aleatorio entre 2 y 4 veces el daño del arma
	public void ataqueCritico(MonstruoGrande monstruo) throws AttackException {
		if (!ataqueCriticoDisponible) {
			throw new AttackException(
					"No puedes realizar un ataque crítico en este turno. El ataque especial de la Gran Espada solo está disponible cada 5 turnos");
		}
		ataqueCriticoDisponible = false;
		turno++;
		resetearEsquivar();
		resetearAtaqueFuerte();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();
		// El daño crítico es entre 2 y 4 veces el daño del arma
		int critMultiplier = ThreadLocalRandom.current().nextInt(2, 5);
		int daño = armaEquipada.getPoderAtaque() * critMultiplier;
		if (monstruo.isDefendiendo()) {
			daño = 0;
		}
		double dañoFinal = calcularDaño(monstruo, daño);
		dañoUltimoTurno = dañoFinal;
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

	}

	// Método para el ataque disparo multiple del Arco. Se puede usar cada 5 turnos.
	// Dispara entre 2 y 5 flechas
	public void disparoMultiple(MonstruoGrande monstruo) throws AttackException {
		if (!ataqueMultipleDisponible) {
			throw new AttackException(
					"No puedes realizar un disparo múltiple en este turno. El ataque especial del Arco solo está disponible cada 5 turnos");
		}
		ataqueMultipleDisponible = false;
		turno++;
		resetearEsquivar();
		resetearAtaqueFuerte();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();
		// Dispara entre 2 y 5 flechas.
		int contadorFlechas = ThreadLocalRandom.current().nextInt(2, 6);
		int daño = armaEquipada.getPoderAtaque() * contadorFlechas;
		if (monstruo.isDefendiendo()) {
			daño = 0;
		}
		double dañoFinal = calcularDaño(monstruo, daño);
		dañoUltimoTurno = dañoFinal;
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

	}

	// Método para el movimiento ataqueConEscudo. Disponible cada 2 turnos.
	public void ataqueConEscudo(MonstruoGrande monstruo) throws AttackException {
		if (!ataqueConEscudoDisponible) {
			throw new AttackException(
					"No puedes realizar un ataque con escudo en este turno. El movimiento especial de la Lanza solo está disponible cada 2 turnos");
		}
		ataqueConEscudoDisponible = false;
		turno++;

		// El ataque con escudo hace 1.5 de daño del poder de la lanza equipada
		int daño = (int) (this.armaEquipada.getPoderAtaque() * 1.5);
		if (monstruo.isDefendiendo()) {
			daño = 0;
		}
		double dañoFinal = calcularDaño(monstruo, daño);
		dañoUltimoTurno = dañoFinal;
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearEsquivar();
		resetearAtaqueFuerte();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueConEscudo();

	}

	// Elijo qué método especial usar en función del tipo de arma. Gran espada usa
	// ataque crítico, arco usa disparo múltiple y la lanza usa defender
	public void ataqueEspecial(MonstruoGrande monstruo) throws AttackException {
		if (armaEquipada.getTipoArma().equals("Gran Espada")) {
			ataqueCritico(monstruo);
		} else if (armaEquipada.getTipoArma().equals("Arco")) {
			disparoMultiple(monstruo);
		} else if (armaEquipada.getTipoArma().equals("Lanza")) {
			ataqueConEscudo(monstruo);
		} else {
			throw new AttackException(
					"Esta arma no tiene un ataque especial. Aunque si has escogido un arma sin ataque especial es que has roto el programa...");
		}
	}

	// Método para calcular el daño en función de debilidades y resistencias
	// elementales. A saber:
	// Si la debilidad del monstruo es igual al elemento del arma, esta hace su daño
	// *1.5
	// Si la resistencia del monstruo es igual al elemento del arma, esta hace su
	// daño *0.5
	public double calcularDaño(MonstruoGrande monstruo, double dañoBase) {
		Elemento debilidadMonstruo = monstruo.getDebilidades();
		Elemento resistenciaMonstruo = monstruo.getResistencias();
		Elemento elementoArma = armaEquipada.getElementoAtaque();

		double daño = dañoBase;

		// Comprueba si el monstruo es débil o resistente al elemento del arma
		if (debilidadMonstruo.equals(elementoArma)) {
			daño *= 1.5;
		} else if (resistenciaMonstruo.equals(elementoArma)) {
			daño *= 0.5;
		}

		return daño;
	}

	// Método que reduce el porcentaje señalado en la Clase Arma para el ataque del
	// arma equipada por el cazador
	public void reducirAtaqueArma(int porcentaje) {
		// Reducir el poder de ataque del arma equipada
		if (armaEquipada != null) {
			armaEquipada.reducirAtaque(porcentaje);

		}

		dañoAtaqueArmaReducido = true;
	}

	// Hacia abajo todos los métodos "resetear" que funcionan con un contador que
	// resta hasta 0 y los resetea hasta la cantidad de turnos de cada ataque

	public void resetearAtaqueFuerte() {
		if (turnoAtaqueFuerte <= 0) {
			turnoAtaqueFuerte = 3;
			ataqueFuerteDisponible = true;
		} else {
			turnoAtaqueFuerte--;
		}

	}

	public void resetearEsquivar() {
		if (turnoEsquivar <= 0) {
			turnoEsquivar = 2;
			esquivarDisponible = true;
		} else {
			turnoEsquivar--;
		}

	}

	public void resetearAtaqueCritico() {
		if (turnoAtaqueCritico <= 0) {
			turnoAtaqueCritico = 5;
			ataqueCriticoDisponible = true;
		} else {
			turnoAtaqueCritico--;
		}

	}

	public void resetearAtaqueMultiple() {
		if (turnoAtaqueMultiple <= 0) {
			turnoAtaqueMultiple = 5;
			ataqueMultipleDisponible = true;
		} else {
			turnoAtaqueMultiple--;
		}

	}

	public void resetearAtaqueConEscudo() {
		if (turnoAtaqueConEscudo <= 0) {
			turnoAtaqueConEscudo = 2;
			ataqueConEscudoDisponible = true;
		} else {
			turnoAtaqueConEscudo--;
		}

	}

	// Este método resetea todo cuando acaba un combate
	// Terminar un combate implica que la salud del monstruo o del cazador ha
	// llegado a 0 y que el propio programa ha cerrado la pantalla de combate
	public void resetearTurnos() {
		this.turno = 0;
		this.turnoAtaqueFuerte = 3;
		this.turnoEsquivar = 2;
		this.turnoAtaqueCritico = 5;
		this.turnoAtaqueMultiple = 5;
		this.turnoAtaqueConEscudo = 2;
		this.armaEquipada.resetearAtaque();
		ataqueFuerteDisponible = true;
		ataqueMultipleDisponible = true;
		ataqueConEscudoDisponible = true;
		ataqueCriticoDisponible = true;
		esquivarDisponible = true;

	}

	// Método por el que el cazador recibe daño. Como puede haber decimales he
	// decidido redondear a uno solo.
	// Si la salud cae por debajo de 0 se mostrará unicamente 0
	public void recibirDaño(double daño) {
		this.saludActualCazador -= Math.round(daño);
		if (this.saludActualCazador < 0) {
			this.saludActualCazador = 0;
		}
		System.out.println("Salud actual del cazador es " + this.saludActualCazador);
	}

	// toString formateado del Cazador
	@Override
	public String toString() {
		return String.format(" %s | Salud: %d |  %s |  %s", nombre, saludCazador, armaduraEquipada.getNombre(),
				armaEquipada.getNombre());
	}

}