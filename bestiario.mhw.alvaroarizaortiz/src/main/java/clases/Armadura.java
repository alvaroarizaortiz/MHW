package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Armadura extends ElementoConNombre {
	private int poderDefensa; //defensa de la armadura
	private Elemento resistenciaArmadura; // elemento que resiste la armadura equipada (enum): FUEGO, AGUA, ELECTRICIDAD, HIELO, DRAGON
	private Elemento debilidadArmadura; // elemento que no resiste la armadura equipada (enum): FUEGO, AGUA, ELECTRICIDAD, HIELO, DRAGON
	private String imagePath; // ruta imagen de la armadura
	private String descripcion; // descripción de la armadura

	// Constructor en uso
	public Armadura(String nombre, int poderDefensa, Elemento resistenciaArmadura, Elemento debilidadArmadura,
			String imagePath, String descripcion) {
		super(nombre);
		this.poderDefensa = poderDefensa;
		this.resistenciaArmadura = resistenciaArmadura;
		this.debilidadArmadura = debilidadArmadura;
		this.imagePath = imagePath;
		this.descripcion = descripcion;
	}

	// Getters y setters de armadura
	public int getPoderDefensa() {
		return poderDefensa;
	}

	public void setPoderDefensa(int poderDefensa) {
		this.poderDefensa = poderDefensa;
	}

	public Elemento getResistenciaArmadura() {
		return resistenciaArmadura;
	}

	public void setResistenciaArmadura(Elemento resistenciaArmadura) {
		this.resistenciaArmadura = resistenciaArmadura;
	}

	public Elemento getDebilidadArmadura() {
		return debilidadArmadura;
	}

	public void setDebilidadArmadura(Elemento debilidadArmadura) {
		this.debilidadArmadura = debilidadArmadura;
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

	//toString armadura
	@Override
	public String toString() {
		return "Armadura [poderDefensa=" + poderDefensa + ", resistenciaArmadura=" + resistenciaArmadura
				+ ", debilidadArmadura=" + debilidadArmadura + ", imagePath=" + imagePath + ", descripcion="
				+ descripcion + "]";
	}

}
