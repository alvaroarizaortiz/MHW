package clases;

public class Combate {
	private byte turno;
	private Cazador combatienteCazador;
	private Monstruo combatienteMonstruo;
	private boolean ganador;

	public Combate(Cazador combatienteCazador, Monstruo combatienteMonstruo) {
		super();
		this.combatienteCazador = combatienteCazador;
		this.combatienteMonstruo = combatienteMonstruo;
	}

	public byte getTurno() {
		return turno;
	}

	public void setTurno(byte turno) {
		this.turno = turno;
	}

	public Cazador getCombatienteCazador() {
		return combatienteCazador;
	}

	public void setCombatienteCazador(Cazador combatienteCazador) {
		this.combatienteCazador = combatienteCazador;
	}

	public Monstruo getCombatienteMonstruo() {
		return combatienteMonstruo;
	}

	public void setCombatienteMonstruo(Monstruo combatienteMonstruo) {
		this.combatienteMonstruo = combatienteMonstruo;
	}

	public boolean isGanador() {
		return ganador;
	}

	public void setGanador(boolean ganador) {
		this.ganador = ganador;
	}

	
	
	@Override
	public String toString() {
		return "Combate [turno=" + turno + ", combatienteCazador=" + combatienteCazador + ", combatienteMonstruo="
				+ combatienteMonstruo + ", ganador=" + ganador + "]";
	}

}
