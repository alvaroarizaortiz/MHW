package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoGrande extends Monstruo {
	private String puntoDebil;
	private boolean esCapturable;
	private Elemento resistencias;
	private Elemento debilidades;
	private int id_Monstruo;
	private int puntosSaludActual;

	public MonstruoGrande(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud,
			String nombreMapa, String imagePath, String descripcion, String puntoDebil, boolean esCapturable,
			Elemento resistencias, Elemento debilidades, int id_Monstruo) {
		super(nombre, especie, tamaño, poderAtaque, puntosSalud, nombreMapa, imagePath, descripcion);
		this.puntoDebil = puntoDebil;
		this.esCapturable = esCapturable;
		this.resistencias = resistencias;
		this.debilidades = debilidades;
		this.id_Monstruo = id_Monstruo;
	}

	public MonstruoGrande(String nombre, int puntosSalud, int poderAtaque, String imagePath) {
		super(nombre, puntosSalud, poderAtaque, imagePath);
	}

	public String getPuntoDebil() {
		return puntoDebil;
	}

	public void setPuntoDebil(String puntoDebil) {
		this.puntoDebil = puntoDebil;
	}

	public boolean isEsCapturable() {
		return esCapturable;
	}

	public void setEsCapturable(boolean esCapturable) {
		this.esCapturable = esCapturable;
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

	public int getId_Monstruo() {
		return id_Monstruo;
	}

	public void setId_Monstruo(int id_Monstruo) {
		this.id_Monstruo = id_Monstruo;
	}

	public int getPuntosSaludActual() {
		return puntosSaludActual;
	}

	public void setPuntosSaludActual(int puntosSaludActual) {
		this.puntosSaludActual = puntosSaludActual;
	}

	public void recibirDaño(double daño) {
		this.puntosSaludActual -= daño;
		if (this.puntosSaludActual < 0)
			this.puntosSaludActual = 0;
	}

	@Override
	public String toString() {
		return "MonstruoGrande [puntoDebil=" + puntoDebil + ", esCapturable=" + esCapturable + ", resistencias="
				+ resistencias + ", debilidades=" + debilidades + ", id_Monstruo=" + id_Monstruo + "]";
	}

}
