package clases;

public class Cazador {
	private int saludCazador;
	private Armadura armaduraEquipada;
	private Arma armaEquipada;
	private int id;
	private String nombre;

	
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

	@Override
	public String toString() {
		 return String.format(" %s | Salud: %d |  %s |  %s", nombre, saludCazador, armaduraEquipada.getNombre(), armaEquipada.getNombre());
	}

}