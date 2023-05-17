package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie;
	private int puntosSalud;
	private float tamaño;
	private ArrayList<Mapa> localizaciones;


	public Monstruo(String nombre, String especie, int puntosSalud, float tamaño,
			ArrayList<Mapa> localizaciones) {
		super(nombre);
		this.especie = especie;
		this.puntosSalud = puntosSalud;
		this.tamaño = tamaño;
		this.localizaciones = localizaciones;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public int getPuntosSalud() {
		return puntosSalud;
	}

	public void setPuntosSalud(int puntosSalud) {
		this.puntosSalud = puntosSalud;
	}

	public float getTamaño() {
		return tamaño;
	}

	public void setTamaño(float tamaño) {
		this.tamaño = tamaño;
	}

	public ArrayList<Mapa> getLocalizaciones() {
		return localizaciones;
	}

	public void setLocalizaciones(ArrayList<Mapa> localizaciones) {
		this.localizaciones = localizaciones;
	}


	@Override
	public String toString() {
		return "Monstruo [especie=" + especie + ", puntosSalud=" + puntosSalud + ", tamaño=" + tamaño
				+ ", localizaciones=" + localizaciones 
				 + ", puntosDebilesMonstruo=";
	}

}