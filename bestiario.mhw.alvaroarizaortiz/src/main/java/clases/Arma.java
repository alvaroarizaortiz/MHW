package clases;

import enumeraciones.Elemento;

public class Arma extends ElementoConNombre {
	private String tipoArma; // tipo del arma equipada: Gran espada, arco, lanza
	private int poderAtaque; // poder de ataque del arma equipada
	private Elemento elementoAtaque; // elemento del arma equipada (enum): FUEGO, AGUA, ELECTRICIDAD, HIELO, DRAGON
	private String imagePath; // ruta de imagen del arma
	private String descripcion; // descripción del arma
	private double poderAtaqueOriginal; // para resetear el daño del arma entre combates debido a la disminución de daño por parte del rugido de monstruo
	

	// Constructor en uso
	public Arma(String nombre, String tipoArma, int poderAtaque, Elemento elementoAtaque, String imagePath,
			String descripcion) {
		super(nombre);
		this.tipoArma = tipoArma;
		this.poderAtaque = poderAtaque;
		this.elementoAtaque = elementoAtaque;
		this.imagePath = imagePath;
		this.descripcion = descripcion;
		this.poderAtaque = poderAtaque;
		this.poderAtaqueOriginal = poderAtaque;
	}

	
	// Getters y setters del arma
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

	// Complementario al rugido intimidante de la Clase Monstruo, que establece la fórmula para bajar el ataque.
	public void reducirAtaque(int porcentaje) {
		// Reducir el poder de ataque. La variable porcentaje la usaremos en monstruo y
		// va dirigida a cazador.
		this.poderAtaque -= this.poderAtaque * porcentaje / 100;

		// No puede ir por debajo de 0
		if (this.poderAtaque < 0) {
			this.poderAtaque = 0;
		}
	}
	
	// Método que resetea el ataque entre combates
	public void resetearAtaque() {
	    this.poderAtaque = (int) this.poderAtaqueOriginal;
	}

	// toString arma
	@Override
	public String toString() {
		return "Arma [tipoArma=" + tipoArma + ", poderAtaque=" + poderAtaque + ", elementoAtaque=" + elementoAtaque
				+ ", imagePath=" + imagePath + ", descripcion=" + descripcion + "]";
	}

}
