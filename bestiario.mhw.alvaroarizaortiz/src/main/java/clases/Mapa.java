package clases;

import java.util.ArrayList;

public class Mapa extends ElementoConNombre {
	private ArrayList<Monstruo> monstruosPresentes; // Lista de monstruos presentes en el mapa

	// Constructor de mapa
	public Mapa(String nombre) {
		super(nombre);
	}

	public ArrayList<Monstruo> getMonstruosPresentes() {
		return monstruosPresentes;
	}

	public void setMonstruosPresentes(ArrayList<Monstruo> monstruosPresentes) {
		this.monstruosPresentes = monstruosPresentes;
	}

	// Agregar monstruo a monstruosPresentes del Mapa.
	public void agregarMonstruo(Monstruo monstruo) {
		monstruosPresentes.add(monstruo);
	}

	// Eliminar monstruo de monstruosPresentes del Mapa.
	public void eliminarMonstruo(Monstruo monstruo) {
		monstruosPresentes.remove(monstruo);
	}

	// toString mapa
	@Override
	public String toString() {
		return "Mapa [monstruosPresentes=" + monstruosPresentes + "]";
	}

}