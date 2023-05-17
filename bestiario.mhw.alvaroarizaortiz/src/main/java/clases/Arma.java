package clases;

import enumeraciones.Elemento;

public class Arma extends ElementoConNombre {
	private int poderAtaque;
	private Elemento elementoAtaque;
	private String tipoArma;

	public Arma(String nombre, int poderAtaque, Elemento elementoAtaque, String tipoArma) {
		super(nombre);
		this.poderAtaque = poderAtaque;
		this.elementoAtaque = elementoAtaque;
		this.tipoArma = tipoArma;

	}

	public int getPoderAtaque() {
		return poderAtaque;
	}

	public void setPoderAtaque(int poderAtaque) {
		this.poderAtaque = poderAtaque;
	}

	public Elemento getElementoAtaque() {
		return elementoAtaque;
	}

	public void setElementoAtaque(Elemento elementoAtaque) {
		this.elementoAtaque = elementoAtaque;
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	@Override
	public String toString() {
		return "Arma [poderAtaque=" + poderAtaque + ", elementoAtaque=" + elementoAtaque + ", tipoArma=" + tipoArma
				+ "]";
	}

}
