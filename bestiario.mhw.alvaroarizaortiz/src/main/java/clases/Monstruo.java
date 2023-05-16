package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Monstruo extends ElementoConNombre {
	private String especie;
	private int puntosSalud;
	private float tamaño;
	private boolean puedeSerCapturado;
	private ArrayList<Mapa> localizaciones;
	private ArrayList<Material> materiales;
	private ArrayList<PuntoDebil> puntosDebilesMonstruo;
	private Elemento resistencias;
	private Elemento debilidades;

	public Monstruo(String nombre, String especie, int puntosSalud, float tamaño, boolean puedeSerCapturado,
			ArrayList<Mapa> localizaciones, ArrayList<Material> materiales, ArrayList<PuntoDebil> puntosDebilesMonstruo,
			Elemento resistencias, Elemento debilidades) {
		super(nombre);
		this.especie = especie;
		this.puntosSalud = puntosSalud;
		this.tamaño = tamaño;
		this.puedeSerCapturado = puedeSerCapturado;
		this.localizaciones = localizaciones;
		this.materiales = materiales;
		this.puntosDebilesMonstruo = puntosDebilesMonstruo;
		this.resistencias = resistencias;
		this.debilidades = debilidades;
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

	public boolean isPuedeSerCapturado() {
		return puedeSerCapturado;
	}

	public void setPuedeSerCapturado(boolean puedeSerCapturado) {
		this.puedeSerCapturado = puedeSerCapturado;
	}

	public ArrayList<Mapa> getLocalizaciones() {
		return localizaciones;
	}

	public void setLocalizaciones(ArrayList<Mapa> localizaciones) {
		this.localizaciones = localizaciones;
	}

	public ArrayList<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) {
		this.materiales = materiales;
	}

	public ArrayList<PuntoDebil> getPuntosDebilesMonstruo() {
		return puntosDebilesMonstruo;
	}

	public void setPuntosDebilesMonstruo(ArrayList<PuntoDebil> puntosDebilesMonstruo) {
		this.puntosDebilesMonstruo = puntosDebilesMonstruo;
	}

	public Elemento getResistencias() {
		return resistencias;
	}

	public void setResistencias(Elemento resistencias) {
		this.resistencias = resistencias;
	}

	public Elemento getDebilidades() {
		return debilidades;
	}

	public void setDebilidades(Elemento debilidades) {
		this.debilidades = debilidades;
	}

	@Override
	public String toString() {
		return "Monstruo [especie=" + especie + ", puntosSalud=" + puntosSalud + ", tamaño=" + tamaño
				+ ", puedeSerCapturado=" + puedeSerCapturado + ", localizaciones=" + localizaciones + ", materiales="
				+ materiales + ", puntosDebilesMonstruo=" + puntosDebilesMonstruo + ", resistencias=" + resistencias
				+ ", debilidades=" + debilidades + "]";
	}

}