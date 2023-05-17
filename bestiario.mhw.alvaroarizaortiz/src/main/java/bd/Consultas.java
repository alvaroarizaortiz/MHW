package bd;

import java.util.ArrayList;
import java.util.List;

import clases.Arma;
import clases.Mapa;
import enumeraciones.Elemento;

public class Consultas {

	public static void main(String[] args) {
		MapaBD mapaBD = new MapaBD();
/*
		// Insertar un nuevo mapa en la Base de Datos
		Mapa nuevoMapa = new Mapa("Nombre del mapa a insertar");
		mapaBD.insertMapa(nuevoMapa);

		// Sacar por pantalla todos los mapas introducidos en la Base de Datos
		List<Mapa> todosLosMapas = mapaBD.getAllMapas();
		for (Mapa mapa : todosLosMapas) {
			System.out.println(mapa.getNombre());
		}

		// Eliminar un mapa existente en la Base de Datos
		// Mapa mapaAEliminar = new Mapa("Nombre del mapa a eliminar");
		// mapaBD.deleteMapa(mapaAEliminar);
		 *
	
 */
		
		// Crear una instancia de la clase ArmaBD
		ArmaBD armaBD = new ArmaBD();

		// Crear una lista de armas a añadir
		List<Arma> armas = new ArrayList<>();

		// Añadir las armas a la lista
		armas.add(new Arma("Brillaspada Rathalos", 1296, Elemento.FUEGO, "Gran Espada"));
		armas.add(new Arma("Hoja Venus Real", 1296, Elemento.AGUA, "Gran Espada"));
		

		// Insertar las armas en la base de datos
		for (Arma arma : armas) {
		 armaBD.insertArma(arma);
		}
}
 }