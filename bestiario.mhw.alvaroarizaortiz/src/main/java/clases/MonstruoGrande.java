package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoGrande extends Monstruo {
	private ArrayList<PuntoDebil> puntosDebilesMonstruo;
	private boolean esCapturable;
	private Elemento resistencias;
	private Elemento debilidades;
	private int id_Monstruo;
	
	public MonstruoGrande(String nombre, String especie, float tamaño, int puntosSalud, int id_Mapa,
			boolean esCapturable, Elemento resistencias,
			Elemento debilidades, int id_Monstruo) {
		super(nombre, especie, tamaño, puntosSalud, id_Mapa);
		this.puntosDebilesMonstruo = puntosDebilesMonstruo;
		this.esCapturable = esCapturable;
		this.resistencias = resistencias;
		this.debilidades = debilidades;
		this.id_Monstruo = id_Monstruo;
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

	public int getId_Monstruo() {
		return id_Monstruo;
	}

	public void setId_Monstruo(int id_Monstruo) {
		this.id_Monstruo = id_Monstruo;
	}

	@Override
	public String toString() {
		return "MonstruoGrande [puntosDebilesMonstruo=" + puntosDebilesMonstruo + ", esCapturable=" + esCapturable
				+ ", resistencias=" + resistencias + ", debilidades=" + debilidades + ", id_Monstruo=" + id_Monstruo
				+ "]";
	}


	
}
