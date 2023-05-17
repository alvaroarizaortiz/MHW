package clases;

import java.util.ArrayList;

import enumeraciones.Elemento;

public class Armadura {
	private int poderDefensa;
	private ArrayList<ParteArmadura> partesArmadura;
	private Elemento resistenciasArmadura;
	private Elemento debilidadesArmadura;

	public Armadura(int poderDefensa, ArrayList<ParteArmadura> partesArmadura, Elemento resistenciasArmadura,
			Elemento debilidadesArmadura) {
		super();
		this.poderDefensa = poderDefensa;
		this.partesArmadura = partesArmadura;
		this.resistenciasArmadura = resistenciasArmadura;
		this.debilidadesArmadura = debilidadesArmadura;
	}

	public int getPoderDefensa() {
		return poderDefensa;
	}

	public void setPoderDefensa(int poderDefensa) {
		this.poderDefensa = poderDefensa;
	}

	public ArrayList<ParteArmadura> getPartesArmadura() {
		return partesArmadura;
	}

	public void setPartesArmadura(ArrayList<ParteArmadura> partesArmadura) {
		this.partesArmadura = partesArmadura;
	}

	public Elemento getResistenciasArmadura() {
		return resistenciasArmadura;
	}

	public void setResistenciasArmadura(Elemento resistenciasArmadura) {
		this.resistenciasArmadura = resistenciasArmadura;
	}

	public Elemento getDebilidadesArmadura() {
		return debilidadesArmadura;
	}

	public void setDebilidadesArmadura(Elemento debilidadesArmadura) {
		this.debilidadesArmadura = debilidadesArmadura;
	}

	@Override
	public String toString() {
		return "Armadura [poderDefensa=" + poderDefensa + ", partesArmadura=" + partesArmadura
				+ ", resistenciasArmadura=" + resistenciasArmadura + ", debilidadesArmadura=" + debilidadesArmadura
				+ "]";
	}

}
