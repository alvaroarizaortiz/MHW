package clases;

import enumeraciones.Elemento;

public class Arma extends ElementoConNombre {
	private String tipoArma;
	private int poderAtaque;
	private Elemento elementoAtaque;
	private String imagePath;
	private String descripcion;
	public Arma(String nombre, String tipoArma, int poderAtaque, Elemento elementoAtaque, String imagePath,
			String descripcion) {
		super(nombre);
		this.tipoArma = tipoArma;
		this.poderAtaque = poderAtaque;
		this.elementoAtaque = elementoAtaque;
		this.imagePath = imagePath;
		this.descripcion = descripcion;
	}
	public String getTipoArma() {
		return tipoArma;
	}
	public void setTipoArma(String tipoArma) {
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
		return "Arma [tipoArma=" + tipoArma + ", poderAtaque=" + poderAtaque + ", elementoAtaque=" + elementoAtaque
				+ ", imagePath=" + imagePath + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
