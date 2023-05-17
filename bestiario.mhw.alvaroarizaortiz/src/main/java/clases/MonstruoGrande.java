package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoGrande extends Monstruo {
	private ArrayList<PuntoDebil> puntosDebilesMonstruo;
	private boolean esCapturable;
	private Elemento resistencias;
	private Elemento debilidades;
	
	public MonstruoGrande(String nombre, String especie, int puntosSalud, float tamaño, ArrayList<Mapa> localizaciones,
			ArrayList<PuntoDebil> puntosDebilesMonstruo, boolean esCapturable, Elemento resistencias,
			Elemento debilidades) {
		super(nombre, especie, puntosSalud, tamaño, localizaciones);
		this.puntosDebilesMonstruo = puntosDebilesMonstruo;
		this.esCapturable = esCapturable;
		this.resistencias = resistencias;
		this.debilidades = debilidades;
	}

	public ArrayList<PuntoDebil> getPuntosDebilesMonstruo() {
		return puntosDebilesMonstruo;
	}

	public void setPuntosDebilesMonstruo(ArrayList<PuntoDebil> puntosDebilesMonstruo) {
		this.puntosDebilesMonstruo = puntosDebilesMonstruo;
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

	@Override
	public String toString() {
		return "MonstruoGrande [puntosDebilesMonstruo=" + puntosDebilesMonstruo + ", esCapturable=" + esCapturable
				+ ", resistencias=" + resistencias + ", debilidades=" + debilidades + "]";
	}
	
	
	
}
