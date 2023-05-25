package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie; // Especie del monstruo
	private int tamaño; // Tamaño del monstruo
	private int poderAtaque; // Poder de ataque del monstruo
	private int puntosSalud; // Puntos de salud del monstruo
	private String nombreMapa; // Nombre del mapa donde se encuentra el monstruo
	private String imagePath; // Ruta imagen del monstruo
	private String descripcion; // Descripción del monstruo

	
	// Constructor usado para insertar los monstruos en base de datos. También interfaz.
	public Monstruo(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud, String nombreMapa,
			String imagePath, String descripcion) {
		super(nombre);
		this.especie = especie;
		this.tamaño = tamaño;
		this.poderAtaque = poderAtaque;
		this.puntosSalud = puntosSalud;
		this.nombreMapa = nombreMapa;
		this.imagePath = imagePath;
		this.descripcion = descripcion;
	}

	// Constructor usado en partes de la interfaz.
	public Monstruo(String nombre, int poderAtaque, int puntosSalud, String imagePath) {
		super(nombre);
		this.poderAtaque = poderAtaque;
		this.puntosSalud = puntosSalud;
		this.imagePath = imagePath;
	}

	//Getters y setters de monstruo
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// toString monstruo
	@Override
	public String toString() {
		return "Monstruo [especie=" + especie + ", tamaño=" + tamaño + ", poderAtaque=" + poderAtaque + ", puntosSalud="
				+ puntosSalud + ", nombreMapa=" + nombreMapa + ", imagePath=" + imagePath + ", descripcion="
				+ descripcion + "]";
	}

}
