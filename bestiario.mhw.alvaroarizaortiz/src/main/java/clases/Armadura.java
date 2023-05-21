package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Armadura extends ElementoConNombre {
	private int poderDefensa;
	private Elemento resistenciaArmadura;
	private Elemento debilidadArmadura;
	private String imagePath;
	private String descripcion;
	public Armadura(String nombre, int poderDefensa, Elemento resistenciaArmadura, Elemento debilidadArmadura,
			String imagePath, String descripcion) {
		super(nombre);
		this.poderDefensa = poderDefensa;
		this.resistenciaArmadura = resistenciaArmadura;
		this.debilidadArmadura = debilidadArmadura;
		this.imagePath = imagePath;
		this.descripcion = descripcion;
	}
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
	@Override
	public String toString() {
		return "Armadura [poderDefensa=" + poderDefensa + ", resistenciaArmadura=" + resistenciaArmadura
				+ ", debilidadArmadura=" + debilidadArmadura + ", imagePath=" + imagePath + ", descripcion="
				+ descripcion + "]";
	}
	
	

}
