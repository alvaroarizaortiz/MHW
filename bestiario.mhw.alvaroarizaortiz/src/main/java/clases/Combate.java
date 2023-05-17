package clases;

public class Combate {
	private byte turno;
	private Cazador combatienteCazador;
	private Monstruo combatienteMonstruo;
	public Combate(byte turno, Cazador combatienteCazador, Monstruo combatienteMonstruo) {
		super();
		this.turno = turno;
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
	@Override
	public String toString() {
		return "Combate [turno=" + turno + ", combatienteCazador=" + combatienteCazador + ", combatienteMonstruo="
				+ combatienteMonstruo + "]";
	}
	
	
}
