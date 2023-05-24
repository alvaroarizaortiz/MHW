package clases;

import java.util.concurrent.ThreadLocalRandom;

import enumeraciones.Elemento;
import excepciones.AttackException;

public class Cazador {
	private int saludCazador;
	private Armadura armaduraEquipada;
	private Arma armaEquipada;
	private int id;
	private String nombre;
	private int saludActualCazador;
	private int turnoAtaqueFuerte = 3;
	private int turnoEsquivar = 2;
	private int turnoAtaqueCritico = 5;
	private int turnoAtaqueMultiple = 5;
	private int turnoAtaqueDefender = 3;
	private boolean ataqueFuerteDisponible = true;
	private boolean esquivarDisponible = true;
	private boolean ataqueCriticoDisponible = true;
	private boolean ataqueMultipleDisponible = true;
	private boolean ataqueDefenderDisponible = true;
	private int turno = 0;

	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada, int id) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
		this.id = id;
		this.saludActualCazador = saludCazador;
	}

	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
	}

	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada, String nombre) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
		this.nombre = nombre;
	}

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

	// Método de ataque normal
	public void ataque(MonstruoGrande monstruo) {
		this.turno++;
		double daño = this.armaEquipada.getPoderAtaque();
		double dañoFinal = calcularDaño(monstruo, daño);
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearAtaqueFuerte();
		resetearEsquivar();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueDefender();
	}

	// Método de ataque fuerte
	public void ataqueFuerte(MonstruoGrande monstruo) throws AttackException {
		if (!ataqueFuerteDisponible) {
			throw new AttackException(
					"Tu cazador está demasiado cansado para hacer eso. El ataque fuerte solo está disponible cada 3 turnos.");
		}

		int daño = this.armaEquipada.getPoderAtaque() * 2;
		double dañoFinal = calcularDaño(monstruo, daño);
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		ataqueFuerteDisponible = false;
		turno++;

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearAtaqueFuerte();
		resetearEsquivar();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueDefender();
	}

	// Método para esquivar
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
		resetearAtaqueDefender();
	}

	// Método para el ataque crítico de la Gran Espada
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
		resetearAtaqueDefender();
		// El daño crítico es entre 2 y 4 veces el daño del arma.
		int critMultiplier = ThreadLocalRandom.current().nextInt(2, 5);
		int daño = armaEquipada.getPoderAtaque() * critMultiplier;
		double dañoFinal = calcularDaño(monstruo, daño);
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

	}

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
		resetearAtaqueDefender();
		// Dispara entre 2 y 4 flechas.
		int arrowCount = ThreadLocalRandom.current().nextInt(2, 5);
		int daño = armaEquipada.getPoderAtaque() * arrowCount;
		double dañoFinal = calcularDaño(monstruo, daño);
		monstruo.recibirDaño(dañoFinal);
		System.out.println(monstruo.getPuntosSaludActual());

		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

	}

	public int defender(MonstruoGrande monstruo) throws AttackException {
		if (!ataqueDefenderDisponible) {
			throw new AttackException(
					"No puedes defender en este turno. El movimiento especial de la Lanza solo está disponible cada 3 turnos");
		}
		ataqueDefenderDisponible = false;
		turno++;
		if (monstruo.getPuntosSaludActual() <= 0) {
			resetearTurnos();
		}

		resetearEsquivar();
		resetearAtaqueFuerte();
		resetearAtaqueCritico();
		resetearAtaqueMultiple();
		resetearAtaqueDefender();
		// Reduce el daño entre un 50% y un 100%.
		int damageReduction = ThreadLocalRandom.current().nextInt(50, 101);
		return armaEquipada.getPoderAtaque() * damageReduction / 100;

	}

	// Elijo qué método especial usar en función del tipo de arma.
	public void ataqueEspecial(MonstruoGrande monstruo) throws AttackException {
		if (armaEquipada.getTipoArma().equals("Gran Espada")) {
			ataqueCritico(monstruo);
		} else if (armaEquipada.getTipoArma().equals("Arco")) {
			disparoMultiple(monstruo);
		} else if (armaEquipada.getTipoArma().equals("Lanza")) {
			defender(monstruo);
		} else {
			throw new AttackException(
					"Esta arma no tiene un ataque especial. Aunque si has escogido un arma sin ataque especial es que has roto el programa...");
		}
	}

	// Método para calcular el daño en función de debilidades y resistencias
	// elementales.
	public double calcularDaño(MonstruoGrande monstruo, double dañoBase) {
		Elemento debilidadMonstruo = monstruo.getDebilidades();
		Elemento resistenciaMonstruo = monstruo.getResistencias();
		Elemento debilidadArmadura = armaduraEquipada.getDebilidadArmadura();
		Elemento resistenciaArmadura = armaduraEquipada.getResistenciaArmadura();
		Elemento elementoArma = armaEquipada.getElementoAtaque();

		double daño = dañoBase;

		// Comprueba si el monstruo es débil o resistente al elemento del arma
		if (debilidadMonstruo == elementoArma) {
			daño *= 1.5;
		} else if (resistenciaMonstruo == elementoArma) {
			daño *= 0.5;
		}
		
		// Comprueba si la armadura es débil o resistente al elemento del monstruo
//		if (debilidadArmadura == resistenciaMonstruo) {
//			daño *= 1.5;
//		} else if (resistenciaArmadura == debilidadMonstruo) {
//			daño *= 0.5;
//		}
		return daño;
	}

	public void resetearAtaqueFuerte() {
		if (turnoAtaqueFuerte <= 0) {
			turnoAtaqueFuerte = 3;
			ataqueFuerteDisponible = true;
		}else {
			turnoAtaqueFuerte--;
		}
		
	}

	public void resetearEsquivar() {
		if (turnoEsquivar <= 0) {
			turnoEsquivar = 2;
			esquivarDisponible = true;
		}else {
			turnoEsquivar--;
		}
		
	}

	public void resetearAtaqueCritico() {
		if (turnoAtaqueCritico <= 0) {
			turnoAtaqueCritico = 5;
			ataqueCriticoDisponible = true;
		}else {
			turnoAtaqueCritico--;
		}
		
	}

	public void resetearAtaqueMultiple() {
		if (turnoAtaqueMultiple <= 0) {
			turnoAtaqueMultiple = 5;
			ataqueMultipleDisponible = true;
		}else {
			turnoAtaqueMultiple--;
		}
		
	}

	public void resetearAtaqueDefender() {
		if (turnoAtaqueDefender <= 0) {
			turnoAtaqueDefender = 3;
			ataqueDefenderDisponible = true;
		}else {
			turnoAtaqueDefender--;
		}
		
	}

	public void resetearTurnos() {
		this.turno = 0;
		this.turnoAtaqueFuerte = 3;
		this.turnoEsquivar = 2;
		this.turnoAtaqueCritico = 5;
		this.turnoAtaqueMultiple = 5;
		this.turnoAtaqueDefender = 3;	
		ataqueFuerteDisponible = true;
		ataqueMultipleDisponible = true;
		ataqueDefenderDisponible = true;
		ataqueCriticoDisponible = true;
		esquivarDisponible = true;
	}

	@Override
	public String toString() {
		return String.format(" %s | Salud: %d |  %s |  %s", nombre, saludCazador, armaduraEquipada.getNombre(),
				armaEquipada.getNombre());
	}

}