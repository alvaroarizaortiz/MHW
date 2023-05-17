package clases;

import java.util.ArrayList;

public class Cazador {
	private int defensaCazador;
	private int saludCazador;
	private ArrayList<Armadura> armaduraEquipada;
	private Arma armaEquipada;

	public Cazador(int defensaCazador, int saludCazador, ArrayList<Armadura> armaduraEquipada, Arma armaEquipada) {
		super();
		this.defensaCazador = defensaCazador;
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
	}

	public int getDefensaCazador() {
		return defensaCazador;
	}

	public void setDefensaCazador(int defensaCazador) {
		this.defensaCazador = defensaCazador;
	}

	public int getSaludCazador() {
		return saludCazador;
	}

	public void setSaludCazador(int saludCazador) {
		this.saludCazador = saludCazador;
	}

	public ArrayList<Armadura> getArmaduraEquipada() {
		return armaduraEquipada;
	}

	public void setArmaduraEquipada(ArrayList<Armadura> armaduraEquipada) {
		this.armaduraEquipada = armaduraEquipada;
	}

	public Arma getArmaEquipada() {
		return armaEquipada;
	}

	public void setArmaEquipada(Arma armaEquipada) {
		this.armaEquipada = armaEquipada;
	}

	@Override
	public String toString() {
		return "Cazador [defensaCazador=" + defensaCazador + ", saludCazador=" + saludCazador + ", armaduraEquipada="
				+ armaduraEquipada + ", armaEquipada=" + armaEquipada + "]";
	}

}
