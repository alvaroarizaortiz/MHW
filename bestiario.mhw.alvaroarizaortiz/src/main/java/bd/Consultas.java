package bd;

import java.util.ArrayList;
import java.util.List;

import clases.Arma;
import clases.Mapa;
import enumeraciones.Elemento;

public class Consultas {

	public static void main(String[] args) {

		// Crear una instancia de la clase MapaBD
		 MapaBD mapaBD = new MapaBD();

		// Insertar un nuevo mapa en la Base de Datos
		// Mapa nuevoMapa = new Mapa("Nombre del mapa a insertar");
		// mapaBD.insertMapa(nuevoMapa);

		// Sacar por pantalla todos los mapas introducidos en la Base de Datos
		// List<Mapa> todosLosMapas = mapaBD.getAllMapas();
		// for (Mapa mapa : todosLosMapas) {
		// System.out.println(mapa.getNombre());
		// }

//_______________________________________________________________________________________________________________________________________________________________________

		// Crear una instancia de la clase ArmaBD
		 ArmaBD armaBD = new ArmaBD();

		// Crear una lista de armas a añadir
		// List<Arma> armas = new ArrayList<>();

		// Añadir las armas a la Base de Datos
		//armas.add(new Arma("Brillaspada Rathalos", 1296, Elemento.FUEGO, "Gran Espada"));
		//armas.add(new Arma("Hoja Venus Real", 1296, Elemento.AGUA, "Gran Espada"));
		//armas.add(new Arma("Serasilfo alado", 1296, Elemento.HIELO, "Gran Espada"));
		//armas.add(new Arma("Vara endemoniada", 1296, Elemento.ELECTRICIDAD, "Gran Espada"));
		//armas.add(new Arma("Dharma inamovible", 1296, Elemento.DRAGON, "Gran Espada"));
		//armas.add(new Arma("Hoja oculta", 1152, Elemento.VENENO, "Gran Espada"));
		//armas.add(new Arma("Trituracídico", 1392, Elemento.PARALISIS, "Gran Espada"));
		//armas.add(new Arma("Somnoespada", 1296, Elemento.SUEÑO, "Gran Espada"));
		//armas.add(new Arma("Filo Parteluz", 1440, Elemento.EXPLOSION, "Gran Espada"));
		//armas.add(new Arma("Amanecer de Platino", 378, Elemento.FUEGO, "Espada y Escudo"));
		//armas.add(new Arma("Espada Nova Real", 378, Elemento.AGUA, "Espada y Escudo"));
		//armas.add(new Arma("Noble Ana Palas", 378, Elemento.HIELO, "Espada y Escudo"));
		//armas.add(new Arma("Rayo del Déspota", 378, Elemento.ELECTRICIDAD, "Espada y Escudo"));
		//armas.add(new Arma("Locura Regia", 378, Elemento.DRAGON, "Espada y Escudo"));
		//armas.add(new Arma("Rosa Lunática", 406, Elemento.VENENO, "Espada y Escudo"));
		//armas.add(new Arma("Paralidardo", 378, Elemento.PARALISIS, "Espada y Escudo"));
		//armas.add(new Arma("Mordisco somnoliento", 406, Elemento.SUEÑO, "Espada y Escudo"));
		//armas.add(new Arma("Espada Parteluz", 420, Elemento.EXPLOSION, "Espada y Escudo"));
		//armas.add(new Arma("Lucha del wyvern", 378, Elemento.FUEGO, "Espadas dobles"));
		//armas.add(new Arma("Sables Salvación Reales", 378, Elemento.AGUA, "Espadas dobles"));
		//armas.add(new Arma("Bergel Vetra", 378, Elemento.HIELO, "Espadas dobles"));
		//armas.add(new Arma("Puños endemoniados", 378, Elemento.ELECTRICIDAD, "Espadas dobles"));
		//armas.add(new Arma("Clarividencia infinita", 378, Elemento.DRAGON, "Espadas dobles"));
		//armas.add(new Arma("Abanicos de lobo", 378, Elemento.VENENO, "Espadas dobles"));
		//armas.add(new Arma("Devoradores del abismo", 378, Elemento.PARALISIS, "Espadas dobles"));
		//armas.add(new Arma("Suave Paraíso", 364, Elemento.SUEÑO, "Espadas dobles"));
		//armas.add(new Arma("Sables Parteluz", 420, Elemento.EXPLOSION, "Espadas dobles"));
		//armas.add(new Arma("Filo Pálido", 891, Elemento.FUEGO, "Katana"));
		//armas.add(new Arma("Tornaria negra", 891, Elemento.AGUA, "Katana"));
		//armas.add(new Arma("Elisarka reverente", 891, Elemento.HIELO, "Katana"));
		//armas.add(new Arma("Alabarda endemoniada", 891, Elemento.ELECTRICIDAD, "Katana"));
		//armas.add(new Arma("Gula Estigia", 891, Elemento.DRAGON, "Katana"));
		//armas.add(new Arma("Lobo Daito", 891, Elemento.VENENO, "Katana"));
		//armas.add(new Arma("Colmillo vípero", 825, Elemento.PARALISIS, "Katana"));
		//armas.add(new Arma("Mordisco de cuervo", 957, Elemento.SUEÑO, "Katana"));
		//armas.add(new Arma("Tintineo Imperial", 920, Elemento.EXPLOSION, "Katana"));
		//armas.add(new Arma("Leonid Parteestrellas", 1404, Elemento.FUEGO, "Martillo"));
		//armas.add(new Arma("Mazo Cruz Real", 1404, Elemento.AGUA, "Martillo"));
		//armas.add(new Arma("Norte Victorioso", 1404, Elemento.HIELO, "Martillo"));
		//armas.add(new Arma("Crujido del déspota", 1404, Elemento.ELECTRICIDAD, "Martillo"));
		//armas.add(new Arma("Caos desatado", 1404, Elemento.DRAGON, "Martillo"));
		//armas.add(new Arma("Noche eterna", 1248, Elemento.VENENO, "Martillo"));
		//armas.add(new Arma("Ataúd atado", 1352, Elemento.PARALISIS, "Martillo"));
		//armas.add(new Arma("Makhlab al-Nasr", 1352, Elemento.SUEÑO, "Martillo"));
		//armas.add(new Arma("Kurogane", 1352, Elemento.EXPLOSION, "Martillo"));
		//armas.add(new Arma("Armonizador de oro", 1134, Elemento.FUEGO, "Cornamusa"));
		//armas.add(new Arma("Canción Sinfónica Real", 1134, Elemento.AGUA, "Cornamusa"));
		//armas.add(new Arma("Eisfyl sonoro", 1134, Elemento.HIELO, "Cornamusa"));
		//armas.add(new Arma("Tambor endemoniado", 1134, Elemento.ELECTRICIDAD, "Cornamusa"));
		//armas.add(new Arma("Tristeza Estigia", 1134, Elemento.DRAGON, "Cornamusa"));
		//armas.add(new Arma("Grito en la noche", 1008, Elemento.VENENO, "Cornamusa"));
		//armas.add(new Arma("Cornamusa de Reina", 1092, Elemento.PARALISIS, "Cornamusa"));
		//armas.add(new Arma("Mordisco de Ogro", 1218, Elemento.SUEÑO, "Cornamusa"));
		//armas.add(new Arma("Quemagrajos", 1092, Elemento.EXPLOSION, "Cornamusa"));
		//armas.add(new Arma("Prominencia de Plata", 621, Elemento.FUEGO, "Lanza"));
		//armas.add(new Arma("Hidrolanza", 621, Elemento.AGUA, "Lanza"));
		//armas.add(new Arma("Ectis de caballería", 621, Elemento.HIELO, "Lanza"));
		//armas.add(new Arma("Lanza Naar", 621, Elemento.ELECTRICIDAD, "Lanza"));
		//armas.add(new Arma("Huso del destino", 621, Elemento.DRAGON, "Lanza"));
		//armas.add(new Arma("Lobo incesante", 552, Elemento.VENENO, "Lanza"));
		//armas.add(new Arma("Lanza estrella brillante", 598, Elemento.PARALISIS, "Lanza"));
		//armas.add(new Arma("Calumnia", 598, Elemento.SUEÑO, "Lanza"));
		//armas.add(new Arma("Taladro Gamma", 552, Elemento.EXPLOSION, "Lanza"));
		//armas.add(new Arma("Gigantomaquia", 313, Elemento.FUEGO, "Arco"));
		//armas.add(new Arma("Vuelo nocturno", 312, Elemento.AGUA, "Arco"));
		//armas.add(new Arma("Evelia cautivadora", 312, Elemento.HIELO, "Arco"));
		//armas.add(new Arma("Horadadragones", 312, Elemento.ELECTRICIDAD, "Arco"));
		//armas.add(new Arma("Flecha lunática", 312, Elemento.DRAGON, "Arco"));
		//armas.add(new Arma("Hilo del destino", 300, Elemento.VENENO, "Arco"));
		//armas.add(new Arma("Fulgurante", 300, Elemento.PARALISIS, "Arco"));
		//armas.add(new Arma("Dulces sueños", 292, Elemento.SUEÑO, "Arco"));
		//armas.add(new Arma("Arco Neo", 312, Elemento.EXPLOSION, "Arco"));


		// Insertar las armas en la Base de Datos. Con un for recorremos todas para hacerlo más rápido.
		//for (Arma arma : armas) {
		//armaBD.insertArma(arma);
		//}
		
		// Listar todas las armas que han sido introducidas en la Base de Datos
		// List<Arma> todasLasArmas = armaBD.getAllArmas();
		// for (Arma arma : todasLasArmas) {
		// System.out.println("Nombre: " + arma.getNombre());
		// System.out.println("Poder de Ataque: " + arma.getPoderAtaque());
		// System.out.println("Tipo de Arma: " + arma.getTipoArma());
		// System.out.println("Elemento de Ataque: " + arma.getElementoAtaque());
		// System.out.println();
		 
//_______________________________________________________________________________________________________________________________________________________________________		
		
		
	}
}