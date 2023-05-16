package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoPequeño extends Monstruo {
	private boolean esHostil;
	private boolean esCabalgable;
	
	public MonstruoPequeño(String nombre, String especie, int puntosSalud, float tamaño, boolean puedeSerCapturado,
			ArrayList<Mapa> localizaciones, ArrayList<Material> materiales, ArrayList<PuntoDebil> puntosDebilesMonstruo,
			Elemento resistencias, Elemento debilidades, boolean esHostil, boolean esCabalgable) {
		super(nombre, especie, puntosSalud, tamaño, puedeSerCapturado, localizaciones, materiales,
				puntosDebilesMonstruo, resistencias, debilidades);
		this.esHostil = esHostil;
		this.esCabalgable = esCabalgable;
	}
	
	
}
