package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoPequeño extends Monstruo {
	private boolean esHostil;
	private boolean esCabalgable;
	public MonstruoPequeño(String nombre, String especie, float tamaño, int puntosSalud, int id_Mapa, boolean esHostil,
			boolean esCabalgable) {
		super(nombre, especie, tamaño, puntosSalud, id_Mapa);
		this.esHostil = esHostil;
		this.esCabalgable = esCabalgable;
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
	@Override
	public String toString() {
		return "MonstruoPequeño [esHostil=" + esHostil + ", esCabalgable=" + esCabalgable + "]";
	}
	
}