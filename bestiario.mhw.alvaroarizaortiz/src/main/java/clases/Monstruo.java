package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie;
	private float tamaño;
	private int poderAtaque;
	private int puntosSalud;
	private int id_Mapa;
	private String imagePath;

	public Monstruo(String name, String especie, float tamaño, int poderAtaque, int puntosSalud, int id_Mapa,
			String imagePath) {
		super(name);
		this.especie = especie;
		this.tamaño = tamaño;
		this.poderAtaque = poderAtaque;
		this.puntosSalud = puntosSalud;
		this.id_Mapa = id_Mapa;
		this.imagePath = imagePath;
	}

	public Monstruo(String nombre, String especie, float tamaño, int poderAtaque, int puntosSalud, int id_Mapa) {
		super(nombre);
		this.especie = especie;
		this.tamaño = tamaño;
		this.poderAtaque = poderAtaque;
		this.puntosSalud = puntosSalud;
		this.id_Mapa = id_Mapa;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public float getTamaño() {
		return tamaño;
	}

	public void setTamaño(float tamaño) {
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

	public int getId_Mapa() {
		return id_Mapa;
	}

	public void setId_Mapa(int id_Mapa) {
		this.id_Mapa = id_Mapa;
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
				+ puntosSalud + ", id_Mapa=" + id_Mapa + ", imagePath=" + imagePath + "]";
	}

}
