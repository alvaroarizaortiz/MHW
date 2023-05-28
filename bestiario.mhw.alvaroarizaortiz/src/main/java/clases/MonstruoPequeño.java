package clases;

public class MonstruoPequeño extends Monstruo {
	private boolean esHostil; // Si el monstruo pequeño es hostil
	private boolean esCabalgable; // Si el monstruo pequeño es cabalgable - montable
	private int id_Monstruo; // ID del monstruo que me ha ayudado en la base de datos

	public MonstruoPequeño(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud,
			String nombreMapa, String imagePath, String descripcion, boolean esHostil, boolean esCabalgable,
			int id_Monstruo) {
		super(nombre, especie, tamaño, poderAtaque, puntosSalud, nombreMapa, imagePath, descripcion);
		this.esHostil = esHostil;
		this.esCabalgable = esCabalgable;
		this.id_Monstruo = id_Monstruo;
	}

	public boolean isEsHostil() {
		return esHostil;
	}

	public void setEsHostil(boolean esHostil) {
		this.esHostil = esHostil;
	}

	public boolean isEsCabalgable() {
		return esCabalgable;
	}

	public void setEsCabalgable(boolean esCabalgable) {
		this.esCabalgable = esCabalgable;
	}

	public int getId_Monstruo() {
		return id_Monstruo;
	}

	public void setId_Monstruo(int id_Monstruo) {
		this.id_Monstruo = id_Monstruo;
	}

	@Override
	public String toString() {
		return "MonstruoPequeño [esHostil=" + esHostil + ", esCabalgable=" + esCabalgable + ", id_Monstruo="
				+ id_Monstruo + "]";
	}

}
