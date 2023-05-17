package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class MonstruoPequeño extends Monstruo {
	private boolean esHostil;
	private boolean esCabalgable;

	public MonstruoPequeño(String nombre, String especie, int puntosSalud, float tamaño, ArrayList<Mapa> localizaciones,
			boolean esHostil,
			boolean esCabalgable) {
		super(nombre, especie, puntosSalud, tamaño, localizaciones);
		this.esHostil = esHostil;
		this.esCabalgable = esCabalgable;
	}

}
