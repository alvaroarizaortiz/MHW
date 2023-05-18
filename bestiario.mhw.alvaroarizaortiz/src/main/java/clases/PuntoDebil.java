package clases;

public class PuntoDebil extends ElementoConNombre {
	private boolean esRompible;
	private byte resistenciaGolpes;
	private int idPuntoDebil;
	public PuntoDebil(String nombre, boolean esRompible, byte resistenciaGolpes, int idPuntoDebil) {
		super(nombre);
		this.esRompible = esRompible;
		this.resistenciaGolpes = resistenciaGolpes;
		this.idPuntoDebil = idPuntoDebil;
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
	public int getIdPuntoDebil() {
		return idPuntoDebil;
	}
	public void setIdPuntoDebil(int idPuntoDebil) {
		this.idPuntoDebil = idPuntoDebil;
	}
	@Override
	public String toString() {
		return "PuntoDebil [esRompible=" + esRompible + ", resistenciaGolpes=" + resistenciaGolpes + ", idPuntoDebil="
				+ idPuntoDebil + "]";
	}


}
