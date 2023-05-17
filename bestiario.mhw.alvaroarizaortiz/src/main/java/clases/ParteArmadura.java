package clases;

public class ParteArmadura extends ElementoConNombre {
	private String tipoArmadura;
	private int poderDefensaParteArmadura;

	public ParteArmadura(String nombre, String tipoArmadura, int poderDefensaParteArmadura) {
		super(nombre);
		this.tipoArmadura = tipoArmadura;
		this.poderDefensaParteArmadura = poderDefensaParteArmadura;
	}

	public String getTipoArmadura() {
		return tipoArmadura;
	}

	public void setTipoArmadura(String tipoArmadura) {
		this.tipoArmadura = tipoArmadura;
	}

	public int getPoderDefensaParteArmadura() {
		return poderDefensaParteArmadura;
	}

	public void setPoderDefensaParteArmadura(int poderDefensaParteArmadura) {
		this.poderDefensaParteArmadura = poderDefensaParteArmadura;
	}

	@Override
	public String toString() {
		return "ParteArmadura [tipoArmadura=" + tipoArmadura + ", poderDefensaParteArmadura="
				+ poderDefensaParteArmadura + "]";
	}

}
