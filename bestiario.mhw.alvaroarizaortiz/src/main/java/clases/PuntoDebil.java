package clases;

public class PuntoDebil extends ElementoConNombre {
	private boolean esRompible;
	private byte resistenciaGolpes;

	public PuntoDebil(String nombre, boolean esRompible, byte resistenciaGolpes) {
		super(nombre);
		this.esRompible = esRompible;
		this.resistenciaGolpes = resistenciaGolpes;
	}

	public boolean getEsRompible() {
		return esRompible;
	}

	public void setEsRompible(boolean esRompible) {
		this.esRompible = esRompible;
	}

	public byte getResistenciaGolpes() {
		return resistenciaGolpes;
	}

	public void setResistenciaGolpes(byte resistenciaGolpes) {
		this.resistenciaGolpes = resistenciaGolpes;
	}

	@Override
	public String toString() {
		return "PuntoDebil [esRompible=" + esRompible + ", resistenciaGolpes=" + resistenciaGolpes + "]";
	}

}
