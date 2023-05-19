package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Armadura extends ElementoConNombre {
	private int poderDefensa;
	private Elemento resistenciaArmadura;
	private Elemento debilidadArmadura;
	public Armadura(String nombre, int poderDefensa, Elemento resistenciaArmadura, Elemento debilidadArmadura) {
		super(nombre);
		this.poderDefensa = poderDefensa;
		this.resistenciaArmadura = resistenciaArmadura;
		this.debilidadArmadura = debilidadArmadura;
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
	@Override
	public String toString() {
		return "Armadura [poderDefensa=" + poderDefensa + ", resistenciaArmadura=" + resistenciaArmadura
				+ ", debilidadArmadura=" + debilidadArmadura + "]";
	}
	

}
