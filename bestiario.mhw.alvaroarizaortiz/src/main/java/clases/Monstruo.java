package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie;
	private int tamaño;
	private int poderAtaque;
	private int puntosSalud;
	private String nombreMapa;
	private String imagePath;
	
	public Monstruo(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud, String nombreMapa,
			String imagePath) {
		super(nombre);
		this.especie = especie;
		this.tamaño = tamaño;
		this.poderAtaque = poderAtaque;
		this.puntosSalud = puntosSalud;
		this.nombreMapa = nombreMapa;
		this.imagePath = imagePath;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public int getPoderAtaque() {
		return poderAtaque;
	}
	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}
	public int getPuntosSalud() {
		return puntosSalud;
	}
	public void setPuntosSalud(int puntosSalud) {
		this.puntosSalud = puntosSalud;
	}
	public String getNombreMapa() {
		return nombreMapa;
	}
	public void setNombreMapa(String nombreMapa) {
		this.nombreMapa = nombreMapa;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Monstruo [especie=" + especie + ", tamaño=" + tamaño + ", poderAtaque=" + poderAtaque + ", puntosSalud="
				+ puntosSalud + ", nombreMapa=" + nombreMapa + ", imagePath=" + imagePath + "]";
	}

	
}
