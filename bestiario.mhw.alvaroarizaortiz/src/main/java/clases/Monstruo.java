package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie;
	private float tamaño;
	private int puntosSalud;
	private int id_Mapa;

	public Monstruo(String nombre, String especie, float tamaño, int puntosSalud, int id_Mapa) {
		super(nombre);
		this.especie = especie;
		this.tamaño = tamaño;
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

	@Override
	public String toString() {
		return "Monstruo [especie=" + especie + ", puntosSalud=" + puntosSalud + ", tamaño=" + tamaño + ", id_Mapa="
				+ id_Mapa + "]";
	}

}