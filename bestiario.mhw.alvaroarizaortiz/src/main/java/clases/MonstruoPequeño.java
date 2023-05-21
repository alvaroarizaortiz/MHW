package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoPequeño extends Monstruo {
	private boolean esHostil;
	private boolean esCabalgable;
	private int id_Monstruo;
	public MonstruoPequeño(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud,
			String nombreMapa, String imagePath, String descripcion, boolean esHostil, boolean esCabalgable, int id_Monstruo) {
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

}


