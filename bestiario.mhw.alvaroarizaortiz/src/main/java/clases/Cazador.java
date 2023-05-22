package clases;

public class Cazador {
	private int saludCazador;
	private Armadura armaduraEquipada;
	private Arma armaEquipada;
	private int id;

	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada, int id) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
		this.id = id;
	}
	
	public Cazador(int saludCazador, Armadura armaduraEquipada, Arma armaEquipada) {
		super();
		this.saludCazador = saludCazador;
		this.armaduraEquipada = armaduraEquipada;
		this.armaEquipada = armaEquipada;
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

	@Override
	public String toString() {
		return "Cazador [saludCazador=" + saludCazador + ", armaduraEquipada=" + armaduraEquipada + ", armaEquipada="
				+ armaEquipada + ", id=" + id + "]";
	}

}