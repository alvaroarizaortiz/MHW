package bd;


import java.util.List;

import clases.Arma;
import clases.Armadura;
import clases.Mapa;
import clases.Monstruo;
import clases.MonstruoGrande;
import clases.MonstruoPequeño;

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
		// armas.add(new Arma("Brillaspada Rathalos", 1296, Elemento.FUEGO, "Gran
		// Espada"));
		// armas.add(new Arma("Hoja Venus Real", 1296, Elemento.AGUA, "Gran Espada"));
		// armas.add(new Arma("Serasilfo alado", 1296, Elemento.HIELO, "Gran Espada"));
		// armas.add(new Arma("Vara endemoniada", 1296, Elemento.ELECTRICIDAD, "Gran
		// Espada"));
		// armas.add(new Arma("Dharma inamovible", 1296, Elemento.DRAGON, "Gran
		// Espada"));
		// armas.add(new Arma("Hoja oculta", 1152, Elemento.VENENO, "Gran Espada"));
		// armas.add(new Arma("Trituracídico", 1392, Elemento.PARALISIS, "Gran
		// Espada"));
		// armas.add(new Arma("Somnoespada", 1296, Elemento.SUEÑO, "Gran Espada"));
		// armas.add(new Arma("Filo Parteluz", 1440, Elemento.EXPLOSION, "Gran
		// Espada"));
		// armas.add(new Arma("Amanecer de Platino", 378, Elemento.FUEGO, "Espada y
		// Escudo"));
		// armas.add(new Arma("Espada Nova Real", 378, Elemento.AGUA, "Espada y
		// Escudo"));
		// armas.add(new Arma("Noble Ana Palas", 378, Elemento.HIELO, "Espada y
		// Escudo"));
		// armas.add(new Arma("Rayo del Déspota", 378, Elemento.ELECTRICIDAD, "Espada y
		// Escudo"));
		// armas.add(new Arma("Locura Regia", 378, Elemento.DRAGON, "Espada y Escudo"));
		// armas.add(new Arma("Rosa Lunática", 406, Elemento.VENENO, "Espada y
		// Escudo"));
		// armas.add(new Arma("Paralidardo", 378, Elemento.PARALISIS, "Espada y
		// Escudo"));
		// armas.add(new Arma("Mordisco somnoliento", 406, Elemento.SUEÑO, "Espada y
		// Escudo"));
		// armas.add(new Arma("Espada Parteluz", 420, Elemento.EXPLOSION, "Espada y
		// Escudo"));
		// armas.add(new Arma("Lucha del wyvern", 378, Elemento.FUEGO, "Espadas
		// dobles"));
		// armas.add(new Arma("Sables Salvación Reales", 378, Elemento.AGUA, "Espadas
		// dobles"));
		// armas.add(new Arma("Bergel Vetra", 378, Elemento.HIELO, "Espadas dobles"));
		// armas.add(new Arma("Puños endemoniados", 378, Elemento.ELECTRICIDAD, "Espadas
		// dobles"));
		// armas.add(new Arma("Clarividencia infinita", 378, Elemento.DRAGON, "Espadas
		// dobles"));
		// armas.add(new Arma("Abanicos de lobo", 378, Elemento.VENENO, "Espadas
		// dobles"));
		// armas.add(new Arma("Devoradores del abismo", 378, Elemento.PARALISIS,
		// "Espadas dobles"));
		// armas.add(new Arma("Suave Paraíso", 364, Elemento.SUEÑO, "Espadas dobles"));
		// armas.add(new Arma("Sables Parteluz", 420, Elemento.EXPLOSION, "Espadas
		// dobles"));
		// armas.add(new Arma("Filo Pálido", 891, Elemento.FUEGO, "Katana"));
		// armas.add(new Arma("Tornaria negra", 891, Elemento.AGUA, "Katana"));
		// armas.add(new Arma("Elisarka reverente", 891, Elemento.HIELO, "Katana"));
		// armas.add(new Arma("Alabarda endemoniada", 891, Elemento.ELECTRICIDAD,
		// "Katana"));
		// armas.add(new Arma("Gula Estigia", 891, Elemento.DRAGON, "Katana"));
		// armas.add(new Arma("Lobo Daito", 891, Elemento.VENENO, "Katana"));
		// armas.add(new Arma("Colmillo vípero", 825, Elemento.PARALISIS, "Katana"));
		// armas.add(new Arma("Mordisco de cuervo", 957, Elemento.SUEÑO, "Katana"));
		// armas.add(new Arma("Tintineo Imperial", 920, Elemento.EXPLOSION, "Katana"));
		// armas.add(new Arma("Leonid Parteestrellas", 1404, Elemento.FUEGO,
		// "Martillo"));
		// armas.add(new Arma("Mazo Cruz Real", 1404, Elemento.AGUA, "Martillo"));
		// armas.add(new Arma("Norte Victorioso", 1404, Elemento.HIELO, "Martillo"));
		// armas.add(new Arma("Crujido del déspota", 1404, Elemento.ELECTRICIDAD,
		// "Martillo"));
		// armas.add(new Arma("Caos desatado", 1404, Elemento.DRAGON, "Martillo"));
		// armas.add(new Arma("Noche eterna", 1248, Elemento.VENENO, "Martillo"));
		// armas.add(new Arma("Ataúd atado", 1352, Elemento.PARALISIS, "Martillo"));
		// armas.add(new Arma("Makhlab al-Nasr", 1352, Elemento.SUEÑO, "Martillo"));
		// armas.add(new Arma("Kurogane", 1352, Elemento.EXPLOSION, "Martillo"));
		// armas.add(new Arma("Armonizador de oro", 1134, Elemento.FUEGO, "Cornamusa"));
		// armas.add(new Arma("Canción Sinfónica Real", 1134, Elemento.AGUA,
		// "Cornamusa"));
		// armas.add(new Arma("Eisfyl sonoro", 1134, Elemento.HIELO, "Cornamusa"));
		// armas.add(new Arma("Tambor endemoniado", 1134, Elemento.ELECTRICIDAD,
		// "Cornamusa"));
		// armas.add(new Arma("Tristeza Estigia", 1134, Elemento.DRAGON, "Cornamusa"));
		// armas.add(new Arma("Grito en la noche", 1008, Elemento.VENENO, "Cornamusa"));
		// armas.add(new Arma("Cornamusa de Reina", 1092, Elemento.PARALISIS,
		// "Cornamusa"));
		// armas.add(new Arma("Mordisco de Ogro", 1218, Elemento.SUEÑO, "Cornamusa"));
		// armas.add(new Arma("Quemagrajos", 1092, Elemento.EXPLOSION, "Cornamusa"));
		// armas.add(new Arma("Prominencia de Plata", 621, Elemento.FUEGO, "Lanza"));
		// armas.add(new Arma("Hidrolanza", 621, Elemento.AGUA, "Lanza"));
		// armas.add(new Arma("Ectis de caballería", 621, Elemento.HIELO, "Lanza"));
		// armas.add(new Arma("Lanza Naar", 621, Elemento.ELECTRICIDAD, "Lanza"));
		// armas.add(new Arma("Huso del destino", 621, Elemento.DRAGON, "Lanza"));
		// armas.add(new Arma("Lobo incesante", 552, Elemento.VENENO, "Lanza"));
		// armas.add(new Arma("Lanza estrella brillante", 598, Elemento.PARALISIS,
		// "Lanza"));
		// armas.add(new Arma("Calumnia", 598, Elemento.SUEÑO, "Lanza"));
		// armas.add(new Arma("Taladro Gamma", 552, Elemento.EXPLOSION, "Lanza"));
		// armas.add(new Arma("Gigantomaquia", 313, Elemento.FUEGO, "Arco"));
		// armas.add(new Arma("Vuelo nocturno", 312, Elemento.AGUA, "Arco"));
		// armas.add(new Arma("Evelia cautivadora", 312, Elemento.HIELO, "Arco"));
		// armas.add(new Arma("Horadadragones", 312, Elemento.ELECTRICIDAD, "Arco"));
		// armas.add(new Arma("Flecha lunática", 312, Elemento.DRAGON, "Arco"));
		// armas.add(new Arma("Hilo del destino", 300, Elemento.VENENO, "Arco"));
		// armas.add(new Arma("Fulgurante", 300, Elemento.PARALISIS, "Arco"));
		// armas.add(new Arma("Dulces sueños", 292, Elemento.SUEÑO, "Arco"));
		// armas.add(new Arma("Arco Neo", 312, Elemento.EXPLOSION, "Arco"));

		// Insertar las armas en la Base de Datos. Con un for recorremos todas para
		// hacerlo más rápido.
		// for (Arma arma : armas) {
		// armaBD.insertArma(arma);
		// }

		// Listar todas las armas que han sido introducidas en la Base de Datos
		// List<Arma> todasLasArmas = armaBD.getAllArmas();
		// for (Arma arma : todasLasArmas) {
		// System.out.println("Nombre: " + arma.getNombre());
		// System.out.println("Poder de Ataque: " + arma.getPoderAtaque());
		// System.out.println("Tipo de Arma: " + arma.getTipoArma());
		// System.out.println("Elemento de Ataque: " + arma.getElementoAtaque());
		// System.out.println();

//_______________________________________________________________________________________________________________________________________________________________________		
		/*
		 * // Crear una instancia de MonstruoDB MonstruoBD monstruoBD = new
		 * MonstruoBD();
		 * 
		 * // Insertar monstruos en la base de datos Monstruo Alatreon = new
		 * Monstruo("Alatreon", "Dragón Anciano", 2474.69f, 52500, 4);
		 * monstruoDB.insertarMonstruo(Alatreon, Alatreon.getId_Mapa());
		 * 
		 * Monstruo Anjanath = new Monstruo("Anjanath", "Wyvern Bruto", 1700f, 18239,
		 * 1); monstruoDB.insertarMonstruo(Anjanath, Anjanath.getId_Mapa());
		 * 
		 * Monstruo Banbaro = new Monstruo("Banbaro", "Wyvern Bruto", 2500f, 16240, 5);
		 * monstruoDB.insertarMonstruo(Banbaro, Banbaro.getId_Mapa());
		 * 
		 * Monstruo Barioth = new Monstruo("Barioth", "Wyvern Volador", 2200f, 19200,
		 * 5); monstruoDB.insertarMonstruo(Barioth, Barioth.getId_Mapa());
		 * 
		 * Monstruo Barroth = new Monstruo("Barroth", "Wyvern Bruto", 2000f, 14210, 2);
		 * monstruoDB.insertarMonstruo(Barroth, Barroth.getId_Mapa());
		 * 
		 * Monstruo Bazelgeuse = new Monstruo("Bazelgeuse", "Wyvern Volador", 2000f,
		 * 25600, 3); monstruoDB.insertarMonstruo(Bazelgeuse, Bazelgeuse.getId_Mapa());
		 * 
		 * Monstruo Beotodus = new Monstruo("Beotodus", "Wyvern Acuático", 1700f, 12296,
		 * 5); monstruoDB.insertarMonstruo(Beotodus, Beotodus.getId_Mapa());
		 * 
		 * Monstruo Brachydios = new Monstruo("Brachydios", "Wyvern Bruto", 1700f,
		 * 19136, 4); monstruoDB.insertarMonstruo(Brachydios, Brachydios.getId_Mapa());
		 * 
		 * Monstruo Bégimo = new Monstruo("Bégimo", "Dragón Anciano", 3423.65f, 35000,
		 * 4); monstruoDB.insertarMonstruo(Bégimo, Bégimo.getId_Mapa());
		 * 
		 * Monstruo Deviljho = new Monstruo("Deviljho", "Wyvern Bruto", 2300f, 23040,
		 * 1); monstruoDB.insertarMonstruo(Deviljho, Deviljho.getId_Mapa());
		 * 
		 * Monstruo Diablos = new Monstruo("Diablos", "Wyvern Bruto", 2200f, 20800, 2);
		 * monstruoDB.insertarMonstruo(Diablos, Diablos.getId_Mapa());
		 * 
		 * Monstruo Dodogama = new Monstruo("Dodogama", "Wyvern Colmillo", 1500f, 17400,
		 * 4); monstruoDB.insertarMonstruo(Dodogama, Dodogama.getId_Mapa());
		 * 
		 * Monstruo Fatalis = new Monstruo("Fatalis", "Dragón Anciano", 4137.17f, 66000,
		 * 4); monstruoDB.insertarMonstruo(Fatalis, Fatalis.getId_Mapa());
		 * 
		 * Monstruo Glavenus = new Monstruo("Glavenus", "Wyvern Bruto", 2500f, 19200,
		 * 2); monstruoDB.insertarMonstruo(Glavenus, Glavenus.getId_Mapa());
		 * 
		 * Monstruo GranGirros = new Monstruo("Gran Girros", "Wyvern Colmillo", 1100f,
		 * 13920, 3); monstruoDB.insertarMonstruo(GranGirros, GranGirros.getId_Mapa());
		 * 
		 * Monstruo GranJagras = new Monstruo("Gran Jagras", "Wyvern Colmillo", 1000f,
		 * 12760, 1); monstruoDB.insertarMonstruo(GranJagras, GranJagras.getId_Mapa());
		 * 
		 * Monstruo Jyuratodus = new Monstruo("Jyuratodus", "Wyvern Acuático", 1500f,
		 * 16240, 2); monstruoDB.insertarMonstruo(Jyuratodus, Jyuratodus.getId_Mapa());
		 * 
		 * Monstruo Kirin = new Monstruo("Kirin", "Dragón Anciano", 500f, 21440, 6);
		 * monstruoDB.insertarMonstruo(Kirin, Kirin.getId_Mapa());
		 * 
		 * Monstruo KuluYaKu = new Monstruo("Kulu Ya-Ku", "Wyvern Pájaro", 1200f, 15370,
		 * 1); monstruoDB.insertarMonstruo(KuluYaKu, KuluYaKu.getId_Mapa());
		 * 
		 * Monstruo KulveTaroth = new Monstruo("Kulve Taroth", "Dragón Anciano", 4573f,
		 * 54000, 4); monstruoDB.insertarMonstruo(KulveTaroth,
		 * KulveTaroth.getId_Mapa());
		 * 
		 * Monstruo KushalaDaora = new Monstruo("Kushala Daora", "Dragón Anciano",
		 * 2000f, 25472, 4); monstruoDB.insertarMonstruo(KushalaDaora,
		 * KushalaDaora.getId_Mapa());
		 * 
		 * Monstruo Lavasioth = new Monstruo("Lavasioth", "Wyvern Acuático", 1800f,
		 * 25600, 4); monstruoDB.insertarMonstruo(Lavasioth, Lavasioth.getId_Mapa());
		 * 
		 * Monstruo Legiana = new Monstruo("Legiana", "Wyvern Volador", 1800f, 19200,
		 * 6); monstruoDB.insertarMonstruo(Legiana, Legiana.getId_Mapa());
		 * 
		 * Monstruo Leshen = new Monstruo("Leshen", "Relicto", 633.81f, 67500, 1);
		 * monstruoDB.insertarMonstruo(Leshen, Leshen.getId_Mapa());
		 * 
		 * Monstruo Lunastra = new Monstruo("Lunastra", "Dragón Anciano", 2000f, 30100,
		 * 4); monstruoDB.insertarMonstruo(Lunastra, Lunastra.getId_Mapa());
		 * 
		 * Monstruo Namielle = new Monstruo("Namielle", "Dragón Anciano", 2250f, 25600,
		 * 6); monstruoDB.insertarMonstruo(Namielle, Namielle.getId_Mapa());
		 * 
		 * Monstruo Nargacuga = new Monstruo("Nargacuga", "Wyvern Volador", 2000f,
		 * 20160, 6); monstruoDB.insertarMonstruo(Nargacuga, Nargacuga.getId_Mapa());
		 * 
		 * Monstruo Nergigante = new Monstruo("Nergigante", "Dragón Anciano", 1900f,
		 * 23680, 4); monstruoDB.insertarMonstruo(Nergigante, Nergigante.getId_Mapa());
		 * 
		 * Monstruo Odogaron = new Monstruo("Odogaron", "Wyvern Colmillo", 1500f, 19200,
		 * 3); monstruoDB.insertarMonstruo(Odogaron, Odogaron.getId_Mapa());
		 * 
		 * Monstruo Paolomu = new Monstruo("Paolomu", "Wyvern Volador", 1200f, 17995,
		 * 6); monstruoDB.insertarMonstruo(Paolomu, Paolomu.getId_Mapa());
		 * 
		 * Monstruo PukeiPukei = new Monstruo("Pukei-Pukei", "Wyvern Pájaro", 1100f,
		 * 17995, 6); monstruoDB.insertarMonstruo(PukeiPukei, PukeiPukei.getId_Mapa());
		 * 
		 * Monstruo Radobaan = new Monstruo("Radobaan", "Wyvern Bruto", 1800f, 18300,
		 * 3); monstruoDB.insertarMonstruo(Radobaan, Radobaan.getId_Mapa());
		 * 
		 * Monstruo Rajang = new Monstruo("Rajang", "Bestia", 1000f, 40000, 5);
		 * monstruoDB.insertarMonstruo(Rajang, Rajang.getId_Mapa());
		 * 
		 * Monstruo Rathalos = new Monstruo("Rathalos", "Wyvern Volador", 1700f, 20800,
		 * 1); monstruoDB.insertarMonstruo(Rathalos, Rathalos.getId_Mapa());
		 * 
		 * Monstruo Rathian = new Monstruo("Rathian", "Wyvern Volador", 1700f, 18300,
		 * 1); monstruoDB.insertarMonstruo(Rathian, Rathian.getId_Mapa());
		 * 
		 * Monstruo Safijiva = new Monstruo("Safi'jiva", "Dragón Anciano", 4799.78f,
		 * 20000, 4); monstruoDB.insertarMonstruo(Safijiva, Safijiva.getId_Mapa());
		 * 
		 * Monstruo SharaIshvalda = new Monstruo("Shara Ishvalda", "Dragón Anciano",
		 * 2910.91f, 37630, 4); monstruoDB.insertarMonstruo(SharaIshvalda,
		 * SharaIshvalda.getId_Mapa());
		 * 
		 * Monstruo Teostra = new Monstruo("Teostra", "Dragón Anciano", 2000f, 27520,
		 * 4); monstruoDB.insertarMonstruo(Teostra, Teostra.getId_Mapa());
		 * 
		 * Monstruo Tigrex = new Monstruo("Tigrex", "Wyvern Volador", 2500f, 19200, 3);
		 * monstruoDB.insertarMonstruo(Tigrex, Tigrex.getId_Mapa());
		 * 
		 * Monstruo TobiKadachi = new Monstruo("Tobi-Kadachi", "Wyvern Colmillo", 1200f,
		 * 16820, 1); monstruoDB.insertarMonstruo(TobiKadachi,
		 * TobiKadachi.getId_Mapa());
		 * 
		 * Monstruo TzitziYaKu = new Monstruo("Tzitzi-Ya-Ku", "Wyvern Pájaro", 900f,
		 * 15370, 6); monstruoDB.insertarMonstruo(TzitziYaKu, TzitziYaKu.getId_Mapa());
		 * 
		 * Monstruo Uragaan = new Monstruo("Uragaan", "Wyvern Bruto", 2200f, 27520, 4);
		 * monstruoDB.insertarMonstruo(Uragaan, Uragaan.getId_Mapa());
		 * 
		 * Monstruo VaalHazak = new Monstruo("Vaal Hazak", "Dragón Anciano", 2300f,
		 * 31070, 3); monstruoDB.insertarMonstruo(VaalHazak, VaalHazak.getId_Mapa());
		 * 
		 * Monstruo Velkhana = new Monstruo("Velkhana", "Dragón Anciano", 2500f, 23040,
		 * 6); monstruoDB.insertarMonstruo(Velkhana, Velkhana.getId_Mapa());
		 * 
		 * Monstruo Xenojiiva = new Monstruo("Xeno'jiiva", "Dragón Anciano", 4509.10f,
		 * 25500, 4); monstruoDB.insertarMonstruo(Xenojiiva, Xenojiiva.getId_Mapa());
		 * 
		 * Monstruo YianGaruga = new Monstruo("Yian Garuga", "Wyvern Pájaro", 1500f,
		 * 24420, 3); monstruoDB.insertarMonstruo(YianGaruga, YianGaruga.getId_Mapa());
		 * 
		 * Monstruo Zinogre = new Monstruo("Zinogre", "Wyvern Colmillo", 1800f, 24350,
		 * 6); monstruoDB.insertarMonstruo(Zinogre, Zinogre.getId_Mapa());
		 * 
		 * Monstruo ZorahMagdaros = new Monstruo("Zorah Magdaros", "Dragón Anciano",
		 * 25764.59f, 24240, 4); monstruoDB.insertarMonstruo(ZorahMagdaros,
		 * ZorahMagdaros.getId_Mapa());
		 * 
		 * Monstruo Anteka = new Monstruo("Anteka", "Herbívoro", 600f, 500, 6);
		 * monstruoDB.insertarMonstruo(Anteka, Anteka.getId_Mapa());
		 * 
		 * Monstruo Apceros = new Monstruo("Apceros", "Herbívoro", 1000f, 700, 2);
		 * monstruoDB.insertarMonstruo(Apceros, Apceros.getId_Mapa());
		 * 
		 * Monstruo Aptonoth = new Monstruo("Aptonoth", "Herbívoro", 1000f, 700, 1);
		 * monstruoDB.insertarMonstruo(Aptonoth, Aptonoth.getId_Mapa());
		 * 
		 * Monstruo Barnos = new Monstruo("Barnos", "Carnívoro", 700f, 500, 4);
		 * monstruoDB.insertarMonstruo(Barnos, Barnos.getId_Mapa());
		 * 
		 * Monstruo Boaboa = new Monstruo("Boaboa", "Lynian", 200f, 200, 5);
		 * monstruoDB.insertarMonstruo(Boaboa, Boaboa.getId_Mapa());
		 * 
		 * Monstruo Gajalaka = new Monstruo("Gajalaka", "Lynian", 200f, 200, 4);
		 * monstruoDB.insertarMonstruo(Gajalaka, Gajalaka.getId_Mapa());
		 * 
		 * Monstruo Gajau = new Monstruo("Gajau", "Carnívoro", 300f, 300, 2);
		 * monstruoDB.insertarMonstruo(Gajau, Gajau.getId_Mapa());
		 * 
		 * Monstruo Gastodon = new Monstruo("Gastodon", "Herbívoro", 600f, 800, 4);
		 * monstruoDB.insertarMonstruo(Gastodon, Gastodon.getId_Mapa());
		 * 
		 * Monstruo Girros = new Monstruo("Girros", "Carnívoro", 500f, 500, 3);
		 * monstruoDB.insertarMonstruo(Girros, Girros.getId_Mapa());
		 * 
		 * Monstruo Grimalkine = new Monstruo("Grimalkine", "Lynian", 200f, 200, 1);
		 * monstruoDB.insertarMonstruo(Grimalkine, Grimalkine.getId_Mapa());
		 * 
		 * Monstruo Hornetaur = new Monstruo("Hornetaur", "Carnívoro", 100f, 200, 3);
		 * monstruoDB.insertarMonstruo(Hornetaur, Hornetaur.getId_Mapa());
		 * 
		 * Monstruo Jagras = new Monstruo("Jagras", "Carnívoro", 500f, 500, 1);
		 * monstruoDB.insertarMonstruo(Jagras, Jagras.getId_Mapa());
		 * 
		 * Monstruo Kelbi = new Monstruo("Kelbi", "Herbívoro", 400f, 200, 2);
		 * monstruoDB.insertarMonstruo(Kelbi, Kelbi.getId_Mapa());
		 * 
		 * Monstruo Kestodon = new Monstruo("Kestodon", "Herbívoro", 600f, 800, 1);
		 * monstruoDB.insertarMonstruo(Kestodon, Kestodon.getId_Mapa());
		 * 
		 * Monstruo Mernos = new Monstruo("Mernos", "Carnívoro", 700f, 500, 1);
		 * monstruoDB.insertarMonstruo(Mernos, Mernos.getId_Mapa());
		 * 
		 * Monstruo Musgorrino = new Monstruo("Musgorrino", "Herbívoro", 200f, 300, 1);
		 * monstruoDB.insertarMonstruo(Musgorrino, Musgorrino.getId_Mapa());
		 * 
		 * Monstruo Noios = new Monstruo("Noios", "Carnívoro", 700f, 500, 2);
		 * monstruoDB.insertarMonstruo(Noios, Noios.getId_Mapa());
		 * 
		 * Monstruo Popo = new Monstruo("Popo", "Herbívoro", 1200f, 1100, 5);
		 * monstruoDB.insertarMonstruo(Popo, Popo.getId_Mapa());
		 * 
		 * Monstruo Raphinos = new Monstruo("Raphinos", "Carnívoro", 700f, 500, 6);
		 * monstruoDB.insertarMonstruo(Raphinos, Raphinos.getId_Mapa());
		 * 
		 * Monstruo Shamos = new Monstruo("Shamos", "Carnívoro", 500f, 500, 6);
		 * monstruoDB.insertarMonstruo(Shamos, Shamos.getId_Mapa());
		 * 
		 * Monstruo Vespoid = new Monstruo("Vespoid", "Carnívoro", 100f, 200, 3);
		 * monstruoDB.insertarMonstruo(Vespoid, Vespoid.getId_Mapa());
		 * 
		 * Monstruo Wulg = new Monstruo("Wulg", "Carnívoro", 200f, 400, 5);
		 * monstruoDB.insertarMonstruo(Wulg, Wulg.getId_Mapa());
		 * 
		 * 
		 * // Agregar los monstruos por ID a los mapas List<Monstruo> listaMonstruos =
		 * new ArrayList<>(); for (Monstruo monstruo : listaMonstruos) {
		 * monstruoBD.insertarMonstruo(monstruo, monstruo.getId_Mapa()); }
		 * 
		 * // Obtener la lista de monstruos y mostrar las localizaciones MonstruoBD
		 * monstruoBD = new MonstruoBD(); List<Monstruo> listaMonstruos =
		 * monstruoBD.listarMonstruos();
		 * 
		 * for (Monstruo monstruo : listaMonstruos) { System.out.println("Monstruo: " +
		 * monstruo.getNombre()); System.out.println("Especie: " +
		 * monstruo.getEspecie()); System.out.println("Tamaño: " +
		 * monstruo.getTamaño()); System.out.println("Puntos de Salud: " +
		 * monstruo.getPuntosSalud()); System.out.println("ID del Mapa: " +
		 * monstruo.getId_Mapa()); System.out.println("--------------------"); }
		 * 
		 */
//_______________________________________________________________________________________________________________________________________________________________________			

		/*
		 * // Crear una instancia de PuntoDebilDB PuntoDebilBD puntoDebilBD = new
		 * PuntoDebilBD();
		 * 
		 * // Insertar algunos puntos débiles en la base de datos PuntoDebil Cabeza =
		 * new PuntoDebil("Cabeza", true, (byte) 1); PuntoDebil Alas = new
		 * PuntoDebil("Alas", true, (byte) 3); PuntoDebil Cuerpo = new
		 * PuntoDebil("Cuerpo", false, (byte) 5); PuntoDebil Patas = new
		 * PuntoDebil("Patas", false, (byte) 3); PuntoDebil Cola = new
		 * PuntoDebil("Cola", true, (byte) 1);
		 * 
		 * puntoDebilBD.insertarPuntoDebil(Cabeza);
		 * puntoDebilBD.insertarPuntoDebil(Alas);
		 * puntoDebilBD.insertarPuntoDebil(Cuerpo);
		 * puntoDebilBD.insertarPuntoDebil(Patas);
		 * puntoDebilBD.insertarPuntoDebil(Cola);
		 * 
		 * // Obtener la lista de puntos débiles List<PuntoDebil> listaPuntosDebiles =
		 * puntoDebilBD.listarPuntosDebiles(); for (PuntoDebil puntoDebil :
		 * listaPuntosDebiles) { System.out.println("Punto Débil: " +
		 * puntoDebil.getNombre() + ", esRompible: " + puntoDebil.getEsRompible() +
		 * ", resistenciaGolpes: " + puntoDebil.getResistenciaGolpes()); }
		 */
//_______________________________________________________________________________________________________________________________________________________________________
		/*
		 * // Crear la instancia de MonstruoGrandeBD MonstruoGrandeBD monstruoGrandeBD =
		 * new MonstruoGrandeBD();
		 * 
		 * // Crear una lista para almacenar los objetos MonstruoGrande
		 * List<MonstruoGrande> listaMonstruos = new ArrayList<>();
		 * 
		 * // Crear y agregar los objetos MonstruoGrande a la lista MonstruoGrande
		 * Alatreon = new MonstruoGrande("Alatreon", "Dragón Anciano", 2474.69f, 52500,
		 * 4, false, Elemento.FUEGO, Elemento.HIELO, 1); listaMonstruos.add(Alatreon);
		 * 
		 * MonstruoGrande Anjanath = new MonstruoGrande("Anjanath", "Wyvern Bruto",
		 * 1700f, 18239, 1, true, Elemento.FUEGO, Elemento.AGUA, 2);
		 * listaMonstruos.add(Anjanath);
		 * 
		 * MonstruoGrande Banbaro = new MonstruoGrande("Banbaro", "Wyvern Bruto", 2500f,
		 * 16240, 5, true, Elemento.HIELO, Elemento.DRAGON, 3);
		 * listaMonstruos.add(Banbaro);
		 * 
		 * MonstruoGrande Barioth = new MonstruoGrande("Barioth", "Wyvern Volador",
		 * 2200f, 19200, 5, true, Elemento.HIELO, Elemento.FUEGO, 4);
		 * listaMonstruos.add(Barioth);
		 * 
		 * MonstruoGrande Barroth = new MonstruoGrande("Barroth", "Wyvern Bruto", 2000f,
		 * 14210, 2, true, Elemento.ELECTRICIDAD, Elemento.AGUA, 5);
		 * listaMonstruos.add(Barroth);
		 * 
		 * MonstruoGrande Bazelgeuse = new MonstruoGrande("Bazelgeuse",
		 * "Wyvern Volador", 2000f, 25600, 3, true, Elemento.FUEGO,
		 * Elemento.ELECTRICIDAD, 6); listaMonstruos.add(Bazelgeuse);
		 * 
		 * MonstruoGrande Beotodus = new MonstruoGrande("Beotodus", "Wyvern Acuático",
		 * 1700f, 12296, 5, true, Elemento.HIELO, Elemento.FUEGO, 7);
		 * listaMonstruos.add(Beotodus);
		 * 
		 * MonstruoGrande Brachydios = new MonstruoGrande("Brachydios", "Wyvern Bruto",
		 * 1700f, 19136, 4, true, Elemento.FUEGO, Elemento.HIELO, 8);
		 * listaMonstruos.add(Brachydios);
		 * 
		 * MonstruoGrande Bégimo = new MonstruoGrande("Bégimo", "Dragón Anciano",
		 * 3423.65f, 35000, 4, false, Elemento.FUEGO, Elemento.DRAGON, 9);
		 * listaMonstruos.add(Bégimo);
		 * 
		 * MonstruoGrande Deviljho = new MonstruoGrande("Deviljho", "Wyvern Bruto",
		 * 2300f, 23040, 1, true, Elemento.HIELO, Elemento.DRAGON, 10);
		 * listaMonstruos.add(Deviljho);
		 * 
		 * MonstruoGrande Diablos = new MonstruoGrande("Diablos", "Wyvern Bruto", 2200f,
		 * 20800, 2, true, Elemento.FUEGO, Elemento.HIELO, 11);
		 * listaMonstruos.add(Diablos);
		 * 
		 * MonstruoGrande Dodogama = new MonstruoGrande("Dodogama", "Wyvern Colmillo",
		 * 1500f, 17400, 4, true, Elemento.FUEGO, Elemento.ELECTRICIDAD, 12);
		 * listaMonstruos.add(Dodogama);
		 * 
		 * MonstruoGrande Fatalis = new MonstruoGrande("Fatalis", "Dragón Anciano",
		 * 4137.17f, 66000, 4, false, Elemento.AGUA, Elemento.DRAGON, 13);
		 * listaMonstruos.add(Fatalis);
		 * 
		 * MonstruoGrande Glavenus = new MonstruoGrande("Glavenus", "Wyvern Bruto",
		 * 2500f, 19200, 2, true, Elemento.FUEGO, Elemento.AGUA, 14);
		 * listaMonstruos.add(Glavenus);
		 * 
		 * MonstruoGrande GranGirros = new MonstruoGrande("Gran Girros",
		 * "Wyvern Colmillo", 1100f, 13920, 3, true, Elemento.ELECTRICIDAD,
		 * Elemento.AGUA, 15); listaMonstruos.add(GranGirros);
		 * 
		 * MonstruoGrande GranJagras = new MonstruoGrande("Gran Jagras",
		 * "Wyvern Colmillo", 1000f, 12760, 1, true, Elemento.AGUA, Elemento.FUEGO, 16);
		 * listaMonstruos.add(GranJagras);
		 * 
		 * MonstruoGrande Jyuratodus = new MonstruoGrande("Jyuratodus",
		 * "Wyvern Acuático", 1500f, 16240, 2, true, Elemento.AGUA,
		 * Elemento.ELECTRICIDAD, 17); listaMonstruos.add(Jyuratodus);
		 * 
		 * MonstruoGrande Kirin = new MonstruoGrande("Kirin", "Dragón Anciano", 500f,
		 * 21440, 6, false, Elemento.ELECTRICIDAD, Elemento.FUEGO, 18);
		 * listaMonstruos.add(Kirin);
		 * 
		 * MonstruoGrande KuluYaKu = new MonstruoGrande("Kulu-Ya-Ku", "Wyvern Pájaro",
		 * 1200f, 15370, 1, true, Elemento.FUEGO, Elemento.AGUA, 19);
		 * listaMonstruos.add(KuluYaKu);
		 * 
		 * MonstruoGrande KulveTaroth = new MonstruoGrande("Kulve Taroth",
		 * "Dragón Anciano", 4573f, 54000, 4, false, Elemento.FUEGO, Elemento.HIELO,
		 * 20); listaMonstruos.add(KulveTaroth);
		 * 
		 * MonstruoGrande KushalaDaora = new MonstruoGrande("Kushala Daora",
		 * "Dragón Anciano", 2000f, 25472, 4, false, Elemento.AGUA,
		 * Elemento.ELECTRICIDAD, 21); listaMonstruos.add(KushalaDaora);
		 * 
		 * MonstruoGrande Lavasioth = new MonstruoGrande("Lavasioth", "Wyvern Acuático",
		 * 1800f, 25600, 4, true, Elemento.FUEGO, Elemento.AGUA, 22);
		 * listaMonstruos.add(Lavasioth);
		 * 
		 * MonstruoGrande Legiana = new MonstruoGrande("Legiana", "Wyvern Volador",
		 * 1800f, 19200, 6, true, Elemento.HIELO, Elemento.ELECTRICIDAD, 23);
		 * listaMonstruos.add(Legiana);
		 * 
		 * MonstruoGrande Leshen = new MonstruoGrande("Leshen", "Relicto", 633.81f,
		 * 67500, 1, false, Elemento.AGUA, Elemento.FUEGO, 24);
		 * listaMonstruos.add(Leshen);
		 * 
		 * MonstruoGrande Lunastra = new MonstruoGrande("Lunastra", "Dragón Anciano",
		 * 2000f, 30100, 4, false, Elemento.FUEGO, Elemento.HIELO, 25);
		 * listaMonstruos.add(Lunastra);
		 * 
		 * MonstruoGrande Namielle = new MonstruoGrande("Namielle", "Dragón Anciano",
		 * 2250f, 25600, 6, false, Elemento.AGUA, Elemento.FUEGO, 26);
		 * listaMonstruos.add(Namielle);
		 * 
		 * MonstruoGrande Nargacuga = new MonstruoGrande("Nargacuga", "Wyvern Volador",
		 * 2000f, 20160, 6, true, Elemento.AGUA, Elemento.ELECTRICIDAD, 27);
		 * listaMonstruos.add(Nargacuga);
		 * 
		 * MonstruoGrande Nergigante = new MonstruoGrande("Nergigante",
		 * "Dragón Anciano", 1900f, 23680, 4, false, Elemento.DRAGON,
		 * Elemento.ELECTRICIDAD, 28); listaMonstruos.add(Nergigante);
		 * 
		 * MonstruoGrande Odogaron = new MonstruoGrande("Odogaron", "Wyvern Colmillo",
		 * 1500f, 19200, 3, true, Elemento.DRAGON, Elemento.HIELO, 29);
		 * listaMonstruos.add(Odogaron);
		 * 
		 * MonstruoGrande Paolomu = new MonstruoGrande("Paolomu", "Wyvern Volador",
		 * 1200f, 17995, 6, true, Elemento.AGUA, Elemento.FUEGO, 30);
		 * listaMonstruos.add(Paolomu);
		 * 
		 * MonstruoGrande PukeiPukei = new MonstruoGrande("Pukei-Pukei",
		 * "Wyvern Pájaro", 1100f, 17995, 6, true, Elemento.AGUA, Elemento.ELECTRICIDAD,
		 * 31); listaMonstruos.add(PukeiPukei);
		 * 
		 * MonstruoGrande Radobaan = new MonstruoGrande("Radobaan", "Wyvern Bruto",
		 * 1800f, 18300, 3, true, Elemento.FUEGO, Elemento.DRAGON, 32);
		 * listaMonstruos.add(Radobaan);
		 * 
		 * MonstruoGrande Rajang = new MonstruoGrande("Rajang", "Bestia", 1000f, 40000,
		 * 5, true, Elemento.DRAGON, Elemento.HIELO, 33); listaMonstruos.add(Rajang);
		 * 
		 * MonstruoGrande Rathalos = new MonstruoGrande("Rathalos", "Wyvern Volador",
		 * 1700f, 20800, 1, true, Elemento.FUEGO, Elemento.DRAGON, 34);
		 * listaMonstruos.add(Rathalos);
		 * 
		 * MonstruoGrande Rathian = new MonstruoGrande("Rathian", "Wyvern Volador",
		 * 1700f, 18300, 1, true, Elemento.FUEGO, Elemento.DRAGON, 35);
		 * listaMonstruos.add(Rathian);
		 * 
		 * MonstruoGrande Safijiva = new MonstruoGrande("Safi'jiva", "Dragón Anciano",
		 * 4799.78f, 20000, 4, false, Elemento.FUEGO, Elemento.DRAGON, 36);
		 * listaMonstruos.add(Safijiva);
		 * 
		 * MonstruoGrande SharaIshvalda = new MonstruoGrande("Shara Ishvalda",
		 * "Dragón Anciano", 2910.91f, 37630, 4, false, Elemento.DRAGON, Elemento.HIELO,
		 * 37); listaMonstruos.add(SharaIshvalda);
		 * 
		 * MonstruoGrande Teostra = new MonstruoGrande("Teostra", "Dragón Anciano",
		 * 2000f, 27520, 4, false, Elemento.FUEGO, Elemento.AGUA, 38);
		 * listaMonstruos.add(Teostra);
		 * 
		 * MonstruoGrande Tigrex = new MonstruoGrande("Tigrex", "Wyvern Volador", 2500f,
		 * 19200, 3, true, Elemento.ELECTRICIDAD, Elemento.FUEGO, 39);
		 * listaMonstruos.add(Tigrex);
		 * 
		 * MonstruoGrande TobiKadachi = new MonstruoGrande("Tobi-Kadachi",
		 * "Wyvern Colmillo", 1200f, 16820, 1, true, Elemento.ELECTRICIDAD,
		 * Elemento.AGUA, 40); listaMonstruos.add(TobiKadachi);
		 * 
		 * MonstruoGrande TzitziYaKu = new MonstruoGrande("Tzitzi-Ya-Ku",
		 * "Wyvern Pájaro", 900f, 15370, 6, true, Elemento.DRAGON,
		 * Elemento.ELECTRICIDAD, 41); listaMonstruos.add(TzitziYaKu);
		 * 
		 * MonstruoGrande Uragaan = new MonstruoGrande("Uragaan", "Wyvern Bruto", 2200f,
		 * 27520, 4, true, Elemento.FUEGO, Elemento.AGUA, 42);
		 * listaMonstruos.add(Uragaan);
		 * 
		 * MonstruoGrande VaalHazak = new MonstruoGrande("Vaal Hazak", "Dragón Anciano",
		 * 2300f, 31070, 3, false, Elemento.AGUA, Elemento.FUEGO, 43);
		 * listaMonstruos.add(VaalHazak);
		 * 
		 * MonstruoGrande Velkhana = new MonstruoGrande("Velkhana", "Dragón Anciano",
		 * 2500f, 23040, 6, false, Elemento.HIELO, Elemento.FUEGO, 44);
		 * listaMonstruos.add(Velkhana);
		 * 
		 * MonstruoGrande Xenojiiva = new MonstruoGrande("Xeno'jiiva", "Dragón Anciano",
		 * 4509.10f, 25500, 4, false, Elemento.DRAGON, Elemento.AGUA, 45);
		 * listaMonstruos.add(Xenojiiva);
		 * 
		 * MonstruoGrande YianGaruga = new MonstruoGrande("Yian Garuga",
		 * "Wyvern Pájaro", 1500f, 24420, 3, true, Elemento.HIELO, Elemento.AGUA, 46);
		 * listaMonstruos.add(YianGaruga);
		 * 
		 * MonstruoGrande Zinogre = new MonstruoGrande("Zinogre", "Wyvern Colmillo",
		 * 1800f, 24350, 6, true, Elemento.ELECTRICIDAD, Elemento.HIELO, 47);
		 * listaMonstruos.add(Zinogre);
		 * 
		 * MonstruoGrande ZorahMagdaros = new MonstruoGrande("Zorah Magdaros",
		 * "Dragón Anciano", 25764.59f, 24240, 4, false, Elemento.FUEGO, Elemento.AGUA,
		 * 48); listaMonstruos.add(ZorahMagdaros);
		 * 
		 * //Insertar en la base de datos for (MonstruoGrande monstruo : listaMonstruos)
		 * { monstruoGrandeBD.insertarMonstruoGrande(monstruo); }
		 * 
		 * // Imprimir la lista de objetos for (MonstruoGrande monstruo :
		 * listaMonstruos) { System.out.println(monstruo); }
		 */

//_______________________________________________________________________________________________________________________________________________________________________			

		/*
		 * // Instancia de monstruoPequeñoBD MonstruoPequeñoBD monstruoPequeñoBD = new
		 * MonstruoPequeñoBD(); List<MonstruoPequeño> listaMonstruosPequeños = new
		 * ArrayList<>(); // Crear una lista de objetos MonstruoPequeño MonstruoPequeño
		 * Anteka = new MonstruoPequeño("Anteka", "Herbívoro", 600f, 500, 6, false,
		 * true, 49); listaMonstruosPequeños.add(Anteka); MonstruoPequeño Apceros = new
		 * MonstruoPequeño("Apceros", "Herbívoro", 1000f, 700, 2, false, true, 50);
		 * listaMonstruosPequeños.add(Apceros); MonstruoPequeño Aptonoth = new
		 * MonstruoPequeño("Aptonoth", "Herbívoro", 1000f, 700, 1, false, true, 51);
		 * listaMonstruosPequeños.add(Aptonoth); MonstruoPequeño Barnos = new
		 * MonstruoPequeño("Barnos", "Carnívoro", 700f, 500, 4, true, false, 52);
		 * listaMonstruosPequeños.add(Barnos); MonstruoPequeño Boaboa = new
		 * MonstruoPequeño("Boaboa", "Lynian", 200f, 200, 5, true, false, 53);
		 * listaMonstruosPequeños.add(Boaboa); MonstruoPequeño Gajalaka = new
		 * MonstruoPequeño("Gajalaka", "Lynian", 200f, 200, 4, true, false, 54);
		 * listaMonstruosPequeños.add(Gajalaka); MonstruoPequeño Gajau = new
		 * MonstruoPequeño("Gajau", "Carnívoro", 300f, 300, 2, true, false, 55);
		 * listaMonstruosPequeños.add(Gajau); MonstruoPequeño Gastodon = new
		 * MonstruoPequeño("Gastodon", "Herbívoro", 600f, 800, 4, true, true, 56);
		 * listaMonstruosPequeños.add(Gastodon); MonstruoPequeño Girros = new
		 * MonstruoPequeño("Girros", "Carnívoro", 500f, 500, 3, true, true, 57);
		 * listaMonstruosPequeños.add(Girros); MonstruoPequeño Grimalkine = new
		 * MonstruoPequeño("Grimalkine", "Lynian", 200f, 200, 1, true, false, 58);
		 * listaMonstruosPequeños.add(Grimalkine); MonstruoPequeño Hornetaur = new
		 * MonstruoPequeño("Hornetaur", "Carnívoro", 100f, 200, 3, true, false, 59);
		 * listaMonstruosPequeños.add(Hornetaur); MonstruoPequeño Jagras = new
		 * MonstruoPequeño("Jagras", "Carnívoro", 500f, 500, 1, true, true, 60);
		 * listaMonstruosPequeños.add(Jagras); MonstruoPequeño Kelbi = new
		 * MonstruoPequeño("Kelbi", "Herbívoro", 400f, 200, 2, false, true, 61);
		 * listaMonstruosPequeños.add(Kelbi); MonstruoPequeño Kertos = new
		 * MonstruoPequeño("Kertos", "Carnívoro", 700f, 500, 5, true, false, 62);
		 * listaMonstruosPequeños.add(Kertos); MonstruoPequeño Kestodon = new
		 * MonstruoPequeño("Kestodon", "Herbívoro", 600f, 800, 1, false, true, 63);
		 * listaMonstruosPequeños.add(Kestodon); MonstruoPequeño Mernos = new
		 * MonstruoPequeño("Mernos", "Carnívoro", 700f, 500, 1, true, false, 64);
		 * listaMonstruosPequeños.add(Mernos); MonstruoPequeño Musgorrino = new
		 * MonstruoPequeño("Musgorrino", "Herbívoro", 200f, 300, 1, false, true, 65);
		 * listaMonstruosPequeños.add(Musgorrino); MonstruoPequeño Noios = new
		 * MonstruoPequeño("Noios", "Carnívoro", 700f, 500, 2, true, false, 66);
		 * listaMonstruosPequeños.add(Noios); MonstruoPequeño Popo = new
		 * MonstruoPequeño("Popo", "Herbívoro", 1200f, 1100, 5, false, true, 67);
		 * listaMonstruosPequeños.add(Popo); MonstruoPequeño Raphinos = new
		 * MonstruoPequeño("Raphinos", "Carnívoro", 700f, 500, 6, true, false, 68);
		 * listaMonstruosPequeños.add(Raphinos); MonstruoPequeño Shamos = new
		 * MonstruoPequeño("Shamos", "Carnívoro", 500f, 500, 6, true, true, 69);
		 * listaMonstruosPequeños.add(Shamos); MonstruoPequeño Vespoid = new
		 * MonstruoPequeño("Vespoid", "Carnívoro", 100f, 200, 3, true, false, 70);
		 * listaMonstruosPequeños.add(Vespoid); MonstruoPequeño Wulg = new
		 * MonstruoPequeño("Wulg", "Carnívoro", 200f, 400, 5, true, true, 71);
		 * listaMonstruosPequeños.add(Wulg);
		 * 
		 * // Insertar los monstruos pequeños en la base de datos for (MonstruoPequeño
		 * monstruoPequeño : listaMonstruosPequeños) {
		 * monstruoPequeñoBD.insertarMonstruoPequeño(monstruoPequeño); }
		 */
//_______________________________________________________________________________________________________________________________________________________________________			

		/*
		 * MonstruoGrandeBD monstruoGrandeBD = new MonstruoGrandeBD(); PuntoDebilBD
		 * puntoDebilBD = new PuntoDebilBD();
		 * 
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(1, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(2, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(3, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(4, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(5, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(6, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(7, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(8, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(9, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(10, 5);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(11, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(12, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(13, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(14, 5);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(15, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(16, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(17, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(18, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(19, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(20, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(21, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(22, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(23, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(24, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(25, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(26, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(27, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(28, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(29, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(30, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(31, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(32, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(33, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(34, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(35, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(36, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(37, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(38, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(39, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(40, 5);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(41, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(42, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(43, 4);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(44, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(45, 1);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(46, 2);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(47, 3);
		 * monstruoGrandeBD.insertarRelacionMonstruoPuntoDebil(48, 3);
		 * 
		 */

//_______________________________________________________________________________________________________________________________________________________________________
		/*
		 * // Crear instancias de Armadura Armadura ArmaduraRathalos = new
		 * Armadura("Armadura de Rathalos", 100, Elemento.FUEGO, Elemento.DRAGON);
		 * Armadura ArmaduraPukei = new Armadura("Armadura de Pukei", 100,
		 * Elemento.AGUA, Elemento.ELECTRICIDAD); Armadura ArmaduraLegiana = new
		 * Armadura("Armadura de Legiana", 100, Elemento.HIELO, Elemento.FUEGO);
		 * Armadura ArmaduraKirin = new Armadura("Armadura de Kirin", 100,
		 * Elemento.ELECTRICIDAD, Elemento.HIELO); Armadura ArmaduraOdogaron = new
		 * Armadura("Armadura de Odogaron", 100, Elemento.DRAGON, Elemento.AGUA);
		 * Armadura ArmaduraEsporea = new Armadura("Armadura Espórea", 100,
		 * Elemento.AGUA, Elemento.DRAGON); Armadura ArmaduraKaiser = new
		 * Armadura("Armadura de Kaiser", 100, Elemento.FUEGO, Elemento.AGUA); Armadura
		 * ArmaduraBarioth = new Armadura("Armadura de Barioth", 100,
		 * Elemento.ELECTRICIDAD, Elemento.FUEGO); Armadura ArmaduraLingotes = new
		 * Armadura("Armadura de Lingotes", 100, Elemento.HIELO, Elemento.ELECTRICIDAD);
		 * Armadura ArmaduraDiablos = new Armadura("Armadura de Diablos", 100,
		 * Elemento.DRAGON, Elemento.HIELO);
		 * 
		 * // Insertar las armaduras en la base de datos ArmaduraBD armaduraBD = new
		 * ArmaduraBD(); armaduraBD.insertArmadura(ArmaduraRathalos);
		 * armaduraBD.insertArmadura(ArmaduraPukei);
		 * armaduraBD.insertArmadura(ArmaduraLegiana);
		 * armaduraBD.insertArmadura(ArmaduraKirin);
		 * armaduraBD.insertArmadura(ArmaduraOdogaron);
		 * armaduraBD.insertArmadura(ArmaduraEsporea);
		 * armaduraBD.insertArmadura(ArmaduraKaiser);
		 * armaduraBD.insertArmadura(ArmaduraBarioth);
		 * armaduraBD.insertArmadura(ArmaduraLingotes);
		 * armaduraBD.insertArmadura(ArmaduraDiablos);
		 * 
		 * // Listar todas las armaduras existentes List<Armadura> armaduras =
		 * armaduraBD.getAllArmaduras(); for (Armadura a : armaduras) {
		 * System.out.println("Nombre: " + a.getNombre());
		 * System.out.println("Poder de Defensa: " + a.getPoderDefensa());
		 * System.out.println("Resistencias de la Armadura: " +
		 * a.getResistenciaArmadura());
		 * System.out.println("Debilidades de la Armadura: " +
		 * a.getDebilidadArmadura()); System.out.println("-------------------------"); }
		 */
//_______________________________________________________________________________________________________________________________________________________________________        
	}
}
