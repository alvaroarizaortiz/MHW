CREATE DATABASE  IF NOT EXISTS `monsterhunterworld` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `monsterhunterworld`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: monsterhunterworld
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arma`
--

DROP TABLE IF EXISTS `arma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `arma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `poderAtaque` int(11) DEFAULT NULL,
  `tipoArma` varchar(50) DEFAULT NULL,
  `elementoAtaque` enum('FUEGO','AGUA','ELECTRICIDAD','HIELO','DRAGON','VENENO','PARALISIS','SUEÑO','EXPLOSION') DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arma`
--

LOCK TABLES `arma` WRITE;
/*!40000 ALTER TABLE `arma` DISABLE KEYS */;
INSERT INTO `arma` VALUES (1,750,'Gran Espada','FUEGO','Brillaspada Rathalos','brillaspadarathalos.png','Imponente hoja que reluce con brillo propio. Algunos cazadores dicen haber visto como evoca llamas sin ni siquiera estar en combate.'),(2,750,'Gran Espada','AGUA','Hoja Venus Real','hojavenusreal.png','Hermosa hoja ondulante con un poderoso ataque acuático. Su elegante diseño evoca la belleza de las tierras andalusíes con los almendros en flor.'),(3,750,'Gran Espada','HIELO','Serasilfo alado','serasilfoalado.png','No se conoce material más frío que el que fue forjado para esta hoja. Un solo corte de este arma podría congelar la sangre de cualquier monstruo.'),(4,750,'Gran Espada','ELECTRICIDAD','Vara endemoniada','varaendemoniada.png','Las leyendas cuentan que los cazadores del Viejo Mundo encontraron este arma atraídos fatalmente por un sin fin de voces espectrales.'),(5,750,'Gran Espada','DRAGON','Dharma inamovible','dharmainamovible.png','Una hoja forjada con Dragonita, el mineral más pesado del Nuevo Mundo. Solo los cazadores más fuertes pueden blandirla y usarla en combate.'),(6,650,'Lanza','FUEGO','Prominencia de Plata','prominenciadeplata.png','La punta incandesdecente de esta lanza brilla como la plata fundida, dejando un rastro de fuego a su paso.'),(7,650,'Lanza','AGUA','Hidrolanza','hidrolanza.png','Una lanza que desencadena la fueza incontenible de los mares. Sus arremetidas acuáticas generan un torrente devastador.'),(8,650,'Lanza','HIELO','Ectis de caballería','ectisdecaballeria.png','Considerada la lanza más majestuosa de todas las jamás forjadas. Su poder gélido congela incluso los corazones más ardientes.'),(9,650,'Lanza','ELECTRICIDAD','Lanza Naar','lanzanaar.png','La energía que emana de esta lanza es sobrecogedora. Los relámpagos danzan con cada arremetida y electrifican el campo de batalla.'),(10,650,'Lanza','DRAGON','Huso del destino','husodeldestino.png','Lanza que porta el legado de los dragones ancianos. El cazador que la blande penetra las defensas enemigas con la determinación de un destino inquebrantable.'),(11,500,'Arco','FUEGO','Gigantomaquia','gigantomaquia.png','Se dice que este arco antes tenía un tamaño normal pero al cazador que lo portaba se le cayó algo de sulfato atómico encima.'),(12,500,'Arco','AGUA','Vuelo nocturno','vuelonocturno.png','Las flechas lanzadas por este arco son tan veloces  que recogen la condensación del agua en el aire, dejando un rastro de neblina en su estela.'),(13,500,'Arco','HIELO','Evelia cautivadora','eveliacautivadora.png','Sus flechas congeladas deslumbran como cristales en el aire, atrapando a los enemigos en una danza de frío y muerte.'),(14,500,'Arco','ELECTRICIDAD','Horadadragones','horadadragones.png','Un arco cargado con la energía de los dragones ancianos. Sus flechas truenan en el horizonte, desgarrando el aire y liberando descargas eléctricas.'),(15,500,'Arco','DRAGON','Flecha lunática','flechalunatica.png','El influjo lunar hace que sus flechas surquen el cielo y golpeen en el enemigo perforándolo con un destello de luz lunar. Su verdadero poder se libera las noches de luna llena.');
/*!40000 ALTER TABLE `arma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `armadura`
--

DROP TABLE IF EXISTS `armadura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armadura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `poderDefensa` int(11) NOT NULL,
  `resistenciaArmadura` enum('FUEGO','AGUA','ELECTRICIDAD','HIELO','DRAGON') DEFAULT NULL,
  `debilidadArmadura` enum('FUEGO','AGUA','ELECTRICIDAD','HIELO','DRAGON') DEFAULT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armadura`
--

LOCK TABLES `armadura` WRITE;
/*!40000 ALTER TABLE `armadura` DISABLE KEYS */;
INSERT INTO `armadura` VALUES (1,'Armadura de Rathalos',100,'FUEGO','DRAGON','armadurarathalos.png','Esta imponente armadura forjada con las escamas del Rey de los Cielos encarna el poder ardiente del fuego y la majestuosidad de los dragones.'),(2,'Armadura de Pukei',100,'AGUA','ELECTRICIDAD','armadurapukei.png','Símbolo de destreza y elegancia. Sus vivos colores y patrones hacen que el cazador se funda con su entorno y pueda cazar libremente.'),(3,'Armadura de Legiana',100,'HIELO','FUEGO','armaduralegiana.png','Su diseño elegante y aerodinámico permite al cazador deslizarse por los cielos como un verdadero maestro del viento.'),(4,'Armadura de Kirin',100,'ELECTRICIDAD','HIELO','armadurakirin.png','Con ella, el cazador se convierte en un ser divino, capaz de desatar la ira de los cielos sobre sus enemigos. Y además queda increíble.'),(5,'Armadura de Odogaron',100,'DRAGON','AGUA','armaduraodogaron.png','Símbolo de ferocidad y salvajismo. Sus afiladas púas evocan el temor y el respeto que inspira esta bestia en el corazón de cualquiera que ose mirarla.'),(6,'Armadura Espórea',100,'AGUA','DRAGON','armaduraesporea.png','Encarna la esencia de la muerte y la descomposición. Esta armadura exhala un aura oscura que se alimenta de la energía vital de sus presas.'),(7,'Armadura de Kaiser',100,'FUEGO','AGUA','armadurakaiser.png','Forjada con los minerales más resistentes del Nuevo Mundo. Esta armadura cuenta un historia de conquista y triunfo, reflejando la autoridad de un verdadero rey.'),(8,'Armadura de Gala',100,'ELECTRICIDAD','FUEGO','armaduradegala.png','Otorga al cazador una apariencia impecable. ¿Quién dijo que un cazador no puede ser letal y elegante a la vez? '),(9,'Armadura de Lingotes',100,'HIELO','ELECTRICIDAD','armaduralingotes.png','Forjada a partir de los más resistentes lingotes de metal. El cazador se convierte en un pesado bastión indestructible.'),(10,'Armadura de Dante',100,'DRAGON','HIELO','armaduradedante.png','Esta armadura te quiere parecer familiar... Cada pieza de esta armadura está imbuida con la esencia del poder demoníaco y la venganza.');
/*!40000 ALTER TABLE `armadura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cazador`
--

DROP TABLE IF EXISTS `cazador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cazador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idArma` int(11) DEFAULT NULL,
  `idArmadura` int(11) DEFAULT NULL,
  `puntosSalud` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cazador_armadura` (`idArmadura`),
  KEY `idArma` (`idArma`),
  CONSTRAINT `cazador_ibfk_1` FOREIGN KEY (`idArma`) REFERENCES `arma` (`id`),
  CONSTRAINT `fk_cazador_armadura` FOREIGN KEY (`idArmadura`) REFERENCES `armadura` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cazador`
--

LOCK TABLES `cazador` WRITE;
/*!40000 ALTER TABLE `cazador` DISABLE KEYS */;
INSERT INTO `cazador` VALUES (1,2,1,5000,'Cazador predeterminado nº1'),(2,8,5,5000,'Cazador predeterminado nº2'),(3,14,6,5000,'Cazador predeterminado nº3');
/*!40000 ALTER TABLE `cazador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mapa`
--

DROP TABLE IF EXISTS `mapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mapa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapa`
--

LOCK TABLES `mapa` WRITE;
/*!40000 ALTER TABLE `mapa` DISABLE KEYS */;
INSERT INTO `mapa` VALUES (1,'Bosque Primigenio'),(2,'Yermo de Agujas'),(3,'Valle Putrefacto'),(4,'Lecho de los Ancianos'),(5,'Arroyo de Escarcha'),(6,'Altiplanos Coralinos');
/*!40000 ALTER TABLE `mapa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monstruo`
--

DROP TABLE IF EXISTS `monstruo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monstruo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `especie` varchar(50) NOT NULL,
  `tamaño` int(11) NOT NULL,
  `puntosSalud` int(11) DEFAULT NULL,
  `id_mapa` int(11) DEFAULT NULL,
  `poderAtaque` int(11) DEFAULT NULL,
  `imagen` varchar(100) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_monstruo_mapa` (`id_mapa`),
  CONSTRAINT `fk_monstruo_mapa` FOREIGN KEY (`id_mapa`) REFERENCES `mapa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monstruo`
--

LOCK TABLES `monstruo` WRITE;
/*!40000 ALTER TABLE `monstruo` DISABLE KEYS */;
INSERT INTO `monstruo` VALUES (1,'Alatreon','Dragón Anciano',2475,17500,4,500,'alatreon.png','El Alatreón es un dragón legendario que solo se conoce en las leyendas y cuya existencia es mantenida por el Gremio debido a su enorme poder. Los cazadores más viejos dicen que posee el control de todos los elementos.'),(2,'Anjanath','Wyvern Bruto',1700,6100,1,300,'anjanath.png','El Anjanath es uno de los depredadores que domina el Bosque Primigenio, donde rivaliza con el Rathalos. Se alimenta principalmente de Aptonoth, a los que caza usando su agudo olfato. El Anjanath marca su territorio dejando su saliva pegajosa sobre árboles y rocas para mantener a los intrusos a raya. '),(3,'Banbaro','Wyvern Bruto',2500,6000,5,200,'banbaro.png','Un monstruo provisto de dos cuernos gigantescos. Un verdadero muro con patas. Carga contra sus enemigos con los cuernos enterrados bajo la tierra, arrasando incluso árboles a su paso.'),(4,'Barioth','Wyvern Volador',2200,6500,5,300,'barioth.png','Wyverns que reinan en la Tundra helada. Usan sus enormes colmillos y sus pinchos para moverse libremente por el hielo, lo que hace muy difícil seguirles el ritmo. '),(5,'Barroth','Wyvern Bruto',2000,5000,2,200,'barroth.png','Normalmente se quedan bajo el barro, quizás para protegerse del calor, incluso arrojan barro para atacar. Cargan frenéticamente contra todo aquello que perturbe sus barrizales.'),(6,'Bazelgeuse','Wyvern Volador',2000,9000,3,350,'bazelgeuse.png','Un malvado wyvern volador que se ha desplazado al Nuevo Mundo en busca de presas. Para cazar esparce escamas explosivas por amplias superficies, para alimentarse de criaturas atrapadas en la explosión. Lo más parecido a un Boeing B-52 que hay por aquí.'),(7,'Beotodus','Wyvern Acuático',1700,5000,5,150,'beotodus.png','Un wyvern nadador que usa su afilada cresta para cortar el terreno congelado, nadando así libremente por la nieve. Se le puede ver a menudo cubriendo de nieve a sus presas usando las aletas de sus patas.'),(8,'Brachydios','Wyvern Bruto',1700,8000,4,400,'brachydios.png','Wyverns brutales cubiertos de una sustancia explosiva verde llamada \"nitro\": un raro hongo viscoso que explota con fuerza debido a un elemento de la saliva del monstruo. Además, sus patas delanteras propinan golpes muy peligrosos.'),(9,'Bégimo','Dragón Anciano',3424,15000,4,500,'begimo.png','Una poderosa bestia de otro mundo. Sus largos cuernos y porte musculoso son extraordinarios. Necesitarás un plan único para hacerle frente. Como por ejemplo una party con un mago blanco, una maga blanca, una maga azul y el protagonista.'),(10,'Deviljho','Wyvern Bruto',2300,9999,1,400,'deviljho.png','Debido a su metabolismo, los Deviljho siempre andan buscando presas. Son muy agresivos, y a menudo se les ve con las fauces clavadas en grandes monstruos y sacudiéndolos por los aires. Es un devorador de ecosistemas, pueden cazar hasta extinguir especies.'),(11,'Diablos','Wyvern Bruto',2200,7750,2,350,'diablos.png','El mayor depredador del Yermo de Agujas. Una bestia amenazadora y muy territorial, que se esconde bajo la tierra. Los ruidos fuertes lo hacen salir en busca de presas a las que arrastrar bajo las arenas.'),(12,'Dodogama','Wyvern Colmillo',1500,4500,4,150,'dodogama.png','Un monstruo cuya dieta se basa en devorar rocas. Los cristales que devora se mezclan con su saliva para producir minerales explosivos que escupe a sus enemigos.'),(13,'Fatalis','Dragón Anciano',4137,16500,4,500,'fatalis.png','Un dragón negro legendario, conocido solo como Fatalis. Se rumorea que destruyó un reino entero en una sola noche, y se quedó con su castillo como colofón.'),(14,'Glavenus','Wyvern Bruto',2500,6100,2,300,'glavenus.png','Wyvern de gran tamaño que suele aplastar a sus enemigos con su gigantesca cola como si fuera una maza, obliterándolos en un estallido de llamas creado por sus escamas. Si su cola se atenúa por el exceso de hollín, el Glavenus usará sus colmillos para volver a afilarla.'),(15,'Gran Girros','Wyvern Colmillo',1100,4100,3,150,'grangirros.png','Monstruo que se alimenta rapiñando los restos de comida caídos de los Altiplanos Coralinos. Actúan como líderes en las manadas de Girros, y cuentan con colmillos paralizantes de gran tamaño.'),(16,'Gran Jagras','Wyvern Colmillo',1000,3800,1,100,'granjagras.png','El lider de una manada de Jagras. Son muy voraces: los grandes Jagras hambrientos atacan a monstruos mas fuertes que ellos, y cuando tienen el estomago lleno este puede hincharse hasta alcanzar un gran tamaño. Los viejos cazadores dicen haber visto uno del tamaño de un barco.'),(17,'Jyuratodus','Wyvern Acuático',1500,5000,2,150,'jyuratodus.png','Un gran wyvern nadador que habita en los pantanos del Yermo de Agujas. Se ayuda del barro para capturar a sus presas, y a veces se le puede ver peleando por su territorio con Barroth.'),(18,'Kirin','Dragón Anciano',500,14375,6,450,'kirin.png','Dragones ancianos tan difíciles de encontrar que poco se conoce de su ecología, aunque todo el mundo sabe el gran valor de las partes del Kirin. Se dicen que son uno con el rayo, y que sus cuerpos se visten de electricidad pura al provocarlos.'),(19,'Kulu Ya-Ku','Wyvern Pájaro',1200,2575,1,100,'kuluyaku.png','Unos extraños wyvern pájaro que han desarrollado extremidades con las que pueden usar armas. Se les puede ver alrededor del Bosque Primigenio robando huevos de nidos ajenos.'),(20,'Kulve Taroth','Dragón Anciano',4573,20000,4,400,'kulvetaroth.png','Una dragona anciana que se protege a sí misma con un caparazón de metal brillante. Los detalles de su ecología y su recubrimiento metálico pueden variar en cada avistamiento, así que es necesaria una investigación más a fondo.'),(21,'Kushala Daora','Dragón Anciano',2000,13850,4,400,'kushaladaora.png','Un dragón anciano envuelto en torbellinos de viento que dificultan acercarse a él. Tiene la piel recubierta de duras escamas metálicas.Es capaz de lanzar proyectiles de viento e incluso generar huracanes y ventiscas. '),(22,'Lavasioth','Wyvern Acuático',1800,9100,4,300,'lavasioth.png','Un wyvern nadador que vive en magma. Sus escamas están cubiertas de capas de magma solidificado, proporcionándole una formidable defensa. Acostumbra a nadar por la lava, lanzando la roca derretida que haya cogido.'),(23,'Legiana','Wyvern Volador',1800,8750,6,300,'legiana.png','El Legiana es el depredador dominante de los Altiplanos Coralinos, utilizando sus enormes alas puede surcar el cielo aprovechando las corrientes de aire. Se alimenta de monstruos pequeños como Raphinos que caza en pleno vuelo.'),(24,'Leshen','Relicto',634,18001,1,350,'leshen.png','Se trata de un espíritu del bosque capaz de utilizar la magia para poseer y manipular a los seres vivos que se encuentran en su territorio. Si estás buscando como derrotarle pregúntale a Geralt de Rivia.'),(25,'Lunastra','Dragón Anciano',2000,15650,4,400,'lunastra.png','Una dragona anciana muy escasa que llena el aire de polvo azul ardiente. Al contrario que el Teostra, la Lunastra es mucho más escasa y existen muy pocos avistamientos, pero se cree que crían en parejas. '),(26,'Namielle','Dragón Anciano',2250,17500,6,400,'namielle.png','Un dragón anciano supuestamente capaz de controlar el agua y utilizarla como escudo. Aunque las veces que se ha avistado al monstruo se cuentan con los dedos de la mano, los informes mencionan \"explosiones de agua\" y \"luces brillantes\". Su existencia permanece rodeada de misterio.'),(27,'Nargacuga','Wyvern Volador',2000,11250,6,400,'nargacuga.png','Wyvern voladores que han evolucionado para vivir en frondosas áreas boscosas. Estas bestias aladas acechan a su presa con tenacidad y a gran velocidad. Su enorme cola es letal y eliminará a monstruos más pequeños de un solo coletazo.'),(28,'Nergigante','Dragón Anciano',1900,14730,4,450,'nergigante.png','Cada década el Nergigante viaja al Nuevo Mundo en la Migración de los Ancianos. La razón de esto es porque este monstruo depreda otros Dragones Ancianos. Se ha documentado ampliamente su pasión por la destrucción.'),(29,'Odogaron','Wyvern Colmillo',1500,10050,3,350,'odogaron.png','El Odogaron es uno de los depredadores dominantes del Valle Putrefacto y está siempre en busca de alimento, ya sean monstruos vivos o carroña.Su naturaleza agresiva convierte a cualquiera, sea monstruo o persona, en una cena potencial. '),(30,'Paolomu','Wyvern Volador',1200,8075,6,250,'paolomu.png','El Paolumu habita en los Altiplanos Coralinos, donde se alimenta de los huevos que liberan los corales terrestres para reproducirse. Gracias a su saco aéreo único es capaz de utilizar las corrientes de aire para flotar como un globo.'),(31,'Pukei-Pukei','Wyvern Pájaro',1100,4500,6,150,'pukeipukei.png','Wyvern volador conocido por las toxinas venenosas de su cuerpo. A menudo almacena fragmenueces en la boca o la cola, lo que las cubre de veneno y las hace útiles como proyectiles contra cualquier amenaza.'),(32,'Radobaan','Wyvern Bruto',1800,10920,3,200,'radobaan.png','Un wyvern brutal gigantesco que se alimenta de huesos de cadáveres que encuentra en el Valle Putrefacto. También es capaz de usar los huesos como armadura, y se enrolla como una bola para atacar y desplazarse.'),(33,'Rajang','Bestia',1000,21750,5,500,'rajang.png','Una criatura muy agresiva, difícil de ver y de la que es difícil escapar. Los supervivientes informan de una extraña forma de ataque. El Rajang es una criatura solitaria, una forma de vida que complica el averiguar sus inclinaciones territoriales. Al enfadarse, parte de su piel se vuelve dorada.'),(34,'Rathalos','Wyvern Volador',1700,13020,1,350,'rathalos.png','Terribles wyverns llamados \"Reyes de los cielos\". Junto con las Rathian, acechan amplios territorios cerca de sus nidos. Los Rathalos descienden sobre los invasores desde el cielo, atacando con veneno, garras y fuego.'),(35,'Rathian','Wyvern Volador',1700,12020,1,300,'rathian.png','Wyverns hembras que lanzan fuego también denominadas \"Reinas de la tierra\". De patas poderosas y cola venenosa, suelen cazar en tierra. Las Rathian a veces cazan en pareja con un Rathalos, con los que parecen coordinar sus ataques.'),(36,'Safi\'jiva','Dragón Anciano',4800,23467,4,450,'safijiva.png','Tras mudar cientos de veces en un remoto lugar,Xeno\'jiiva finalmente llega a su fase adulta, Safi\'jiiva. Este monstruo tiene la habilidad de absorber la energía que fluye por la tierra para curarse cuando se encuentra débil. '),(37,'Shara Ishvalda','Dragón Anciano',2911,17500,4,450,'sharaishvalda.png','Sus poderes tectónicos son capaces de provocar cataclismos a gran escala, volviéndose una amenaza para continentes enteros. Al percibir alguna perturbación cerca de su lugar de descanso, emergirá cubierto de una armadura de roca para protegerse. '),(38,'Teostra','Dragón Anciano',2000,14500,4,400,'teostra.png','El Teostra habita normalmente en zonas volcánicas, pero puede desplazarse a muchos otros lugares como pantanos, desiertos e incluso poblaciones humanas. Esto sumado a su gran agresividad lo convierte en una de las primeras preocupaciones del Gremio. '),(39,'Tigrex','Wyvern Volador',2500,13000,3,400,'tigrex.png','Wyverns voladores cuyo origen primitivo es obvio. De carácter muy virulento, atacan ferozmente con garras, mandíbula y miembros desarrollados. Habitan un amplio área en busca de una presa y se les ha visto incluso en regiones azotadas por el frío.'),(40,'Tobi-Kadachi','Wyvern Colmillo',1200,7896,1,200,'tobikadachi.png','Utiliza sus garras en forma de gancho para aferrarse a los árboles y sus membranas para planear entre ellos. Debido a la fricción generada al moverse entre los árboles, puede acumular electricidad estática en su cuerpo que luego puede liberar contra sus atacantes.'),(41,'Tzitzi-Ya-Ku','Wyvern Pájaro',900,2894,6,100,'tzitziyaku.png','Extraño monstruo que ciega tanto a presas como a enemigos con los destellos de un órgano especial cerca de su cabeza, para a continuación rematarlos con sus fuertes patas.'),(42,'Uragaan','Wyvern Bruto',2200,10133,4,200,'uragaan.png','Grandes y brutales wyverns que se alimentan de minerales, haciendo crujir rocas enormes hasta pulverizarlas con sus poderosísimas mandíbulas. Al parecer, no es infrecuente verles librando disputas territoriales con Lavasioth.'),(43,'Vaal Hazak','Dragón Anciano',2300,17897,3,300,'vaalhazak.png','Se sabe que este dragón anciano tiene control sobre el efluvio, pudiendo envolverse en una nube tóxica y expulsarlo en forma de rayo o como una onda. También es capaz de recuperar salud absorbiendo la energía vital de monstruos infectados por el efluvio. '),(44,'Velkhana','Dragón Anciano',2500,18900,6,350,'velkhana.png','Un dragón anciano que congela todo lo que encuentra. Según la leyenda, puede controlar el frío y utilizar su aliento helado para crear agujas de hielo de la nada. Sus cantos se confunden con los vientos polares. '),(45,'Xeno\'jiiva','Dragón Anciano',4509,19999,4,450,'xenojiiva.png','Se cree que este monstruo es la razón por la que los Dragones Ancianos migran al continente, pues utiliza su energía vital para incubarse y obtener su poder. '),(46,'Yian Garuga','Wyvern Pájaro',1500,12565,3,300,'yiangaruga.png','El Yian Garuga habita en selvas y zonas templadas, su mal temperamento les convierte en bestias solitarias y agresivas, sobre todo hacia monstruos más pequeños, a quienes suelen perseguir y robar el territorio. '),(47,'Zinogre','Wyvern Colmillo',1800,13000,6,400,'zinogre.png','Wyverns de colmillo cuyos cuerpos están recubiertos de electricidad. Sus afiladas garras y fuertes patas les permiten crecen en terreno de montaña. Durante la caza, reúnen numerosos bichos eléctricos para potenciarse a sí mismos y entrar en estado de supercarga.'),(48,'Zorah Magdaros','Dragón Anciano',25765,30000,4,250,'zorahmagdaros.png','El Zorah Magdaros es como una montaña de fuego viviente, almacenando en su interior una cantidad colosal de energía.En la última Migración de los Ancianos, este colosal dragón ha conseguido cruzar el océano para llegar al Nuevo Mundo por una razón desconocida.'),(49,'Anteka','Herbívoro',600,500,6,10,'anteka.png','Herbívoros que viven en climas fríos. Dóciles por naturaleza, pero pueden ser hostiles si se les ataca. Su piel es de gran valor y tienen varios usos. Sus astas también son de gran valor para el gremio.'),(50,'Apceros','Herbívoro',1000,700,2,10,'apceros.png','Bestias herbívoras del desierto de piel acorazada. Se les conoce por ser muy teritoriales y por perseguir incansablemente a los que entren en su hábitat. Es muy hostil hacia los cazadores, ya que estos acostumbran a robar los huevos de sus nidos.'),(51,'Aptonoth','Herbívoro',1000,700,1,10,'aptonoth.png','Herbívoros relativamente dóciles con distintivas crestas plateadas. Forman rebaños y crían a los más jóvenes en comunidad. Su carne es deliciosa y nutritiva, así que son muy cautelosos cuando algún monstruo anda cerca.'),(52,'Barnos','Carnívoro',700,500,4,30,'barnos.png','Los Barnos son a menudo avistados revoloteando alrededor del gigantesco Dragón Anciano Zorah Magdaros, posiblemente en busca de restos de comida. Debido a la apariencia volcánica de este coloso, se cree que los Barnos también pueden encontrarse en zonas volcánicas. '),(53,'Boaboa','Lynian',200,200,5,20,'boaboa.png','Estos Lynian atacan con distintos estados alterados, que dependen del color con el que estén pintadas sus máscaras y armas. Sus vestimentas tratan de emular a los Popo, sus presas habituales.'),(54,'Gajalaka','Lynian',200,200,4,20,'gajalaka.png','Siempre portan una gran máscara de color rojo para intimidar a sus atacantes.Tienen una sana afición: bombardear a cualquier ser vivo que merodee por sus territorios.'),(55,'Gajau','Carnívoro',300,300,2,20,'gajau.png','Estos gigantescos peces pueden encontrarse nadando tanto en aguas claras como en aguas turbias de poca profundidad. Son agresivos, y no dudarán en atacar con sus enormes fauces. Pueden llegar a saltar a suelo firme y luego volver deslizándose al agua. '),(56,'Gastodon','Herbívoro',600,800,4,20,'gastodon.png','Los Gastodon únicamente se encuentran en el Lecho de los Ancianos, donde se han adaptado para vivir en este clima más duro desarrollando una melena resistente al calor. Son presa de numerosos depredadores, por lo que suelen alterarse fácilmente ante los intrusos y cargan contra monstruos el doble de grandes que ellos. '),(57,'Girros','Carnívoro',500,500,3,30,'girros.png','Los Girros viven en grupos numerosos comandados por un Gran Girros. Son monstruos bastante ágiles capaces de paralizar con sus colmillos venenosos. Derrotar a algunos de ellos hará que el grupo de Girros se separe.'),(58,'Grimalkine','Lynian',200,200,1,20,'grimalkine.png','Los Grimalkine son una raza encontrada en el Nuevo Mundo, donde existen varias tribus repartidas por distintas áreas. Los Grimalkynes son amistosos y pueden llegar a ayudar al cazador en sus misiones de campo.'),(59,'Hornetaur','Carnívoro',100,200,3,10,'hornetaur.png','Principalmente terrestres, los Hornetaur rara vez vuelan. Estos monstruos viven en pequeños grupos sobre todo en selvas y zonas cálidas. A pesar de estar bien protegidos por su concha, ésta es muy frágil y se romperán en pedazos al matarlos con armas fuertes. '),(60,'Jagras','Carnívoro',500,500,1,20,'jagras.png','Los Jagras viven en grupos liderados por un macho alfa, el Gran Jagras. Ante la amenaza de grandes monstruos como Anjanath o Rathalos, los Jagras buscarán refugio subiéndose a los árboles. No obstante, si ven que el monstruo está indefenso no dudarán en atacar en grupo. '),(61,'Kelbi','Herbívoro',400,200,2,10,'kelbi.png','Pequeños herbívoros conocidos por su conducta tranquila, además de por la propiedad medicinal de sus cuernos. A pesar de ser muy asustadizos, los Kelbi machos no dudarán en defender a su grupo y a veces atacarán al cazador cargando con sus cuernos.'),(62,'Kestodon','Herbívoro',600,800,1,30,'kestodon.png','Las hembras de Kestodon alertan al grupo de cualquier peligro, mientras los machos cargan violentamente contra cualquier posible amenaza. Son bastante territoriales y atacarán a los intrusos que vean, pero huirán si aparece un monstruo grande cerca. '),(63,'Mernos','Carnívoro',700,500,1,30,'mernos.png','Los Mernos habitan en pequeños grupos en zonas boscosas. Si se asustan, sus bandadas pueden llegar a desplazarse largas distancias, convirtiéndolos en transportes ideales para cazadores listos y con un gancho.'),(64,'Musgorrino','Herbívoro',200,300,1,0,'musgorrino.png','Los Mosswine pueden encontrarse en cualquier lugar con humedad, donde puedan encontrarse hongos. Utilizan su sensible olfato para detectar sus hongos favoritos, las setas especiales, o para detectar a posibles amenazas. '),(65,'Noios','Carnívoro',700,500,2,30,'noios.png','Los Noios viven en grandes bandadas en las zonas abiertas del Yermo de Agujas y se alimentan de hormigas. Sus intesos chillidos sirven para alertar a sus compañeros de posibles amenazas, lo que normalmente acaba atrayendo a monstruos como Diablos.'),(66,'Popo','Herbívoro',1200,1100,5,30,'popo.png','A menudo son cazados por su carne y su lengua, un conocido manjar. Son criaturas muy dóciles y escaparán cuando uno de sus miembros en un grupo es atacado o cuando un monstruo grande entre en su área. Aún así, no dudarán en proteger a sus crías de los depredadores. '),(67,'Raphinos','Carnívoro',700,500,6,30,'raphinos.png','Se alimentan de los huevos liberados por los corales terrestres, aunque también se sabe que asaltan los nidos de monstruos grandes para robarles los huevos. Debido a su posición baja en la cadena alimenticia, son cazados por monstruos como Tzitzi-Ya-Ku, también son la presa favorita del Legiana. '),(68,'Shamos','Carnívoro',500,500,6,30,'shamos.png','Los Shamos viven en grupos en los Altiplanos Coralinos y son principalmente nocturnos, pues sus grandes ojos les permiten cazar con facilidad en la oscuridad. Debido a su sensibilidad a la luz, los Shamos odian el cegador flash de Tzitzi-Ya-Ku.'),(69,'Vespoid','Carnívoro',100,200,3,10,'vespoid.png','Un enorme insecto, similar a una avispa, que se sirve del veneno de su aguijón para paralizar a sus presas. El enjambre de Vespoids está liderado por la Vespoid Reina, mucho más grande y fuerte. '),(70,'Wulg','Carnívoro',200,400,5,30,'wulg.png','Estos monstruos pueden encontrarse en el Arroyo de Escarcha. Son carnívoros sociales que se mueven en grupos y atacarán al cazador al verlo, pero huirán frente a monstruos más grandes ocultándose bajo la nieve. ');
/*!40000 ALTER TABLE `monstruo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monstruogrande`
--

DROP TABLE IF EXISTS `monstruogrande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monstruogrande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `esCapturable` tinyint(1) DEFAULT NULL,
  `resistencias` enum('FUEGO','AGUA','ELECTRICIDAD','HIELO','DRAGON') DEFAULT NULL,
  `debilidades` enum('FUEGO','AGUA','ELECTRICIDAD','HIELO','DRAGON') DEFAULT NULL,
  `id_monstruo` int(11) DEFAULT NULL,
  `puntoDebil` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `monstruogrande_ibfk_1` FOREIGN KEY (`id`) REFERENCES `monstruo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monstruogrande`
--

LOCK TABLES `monstruogrande` WRITE;
/*!40000 ALTER TABLE `monstruogrande` DISABLE KEYS */;
INSERT INTO `monstruogrande` VALUES (1,0,'FUEGO','HIELO',1,'Alas'),(2,1,'FUEGO','AGUA',2,'Cabeza'),(3,1,'HIELO','DRAGON',3,'Cabeza'),(4,1,'HIELO','FUEGO',4,'Cuerpo'),(5,1,'ELECTRICIDAD','AGUA',5,'Patas'),(6,1,'FUEGO','ELECTRICIDAD',6,'Alas'),(7,1,'HIELO','FUEGO',7,'Patas'),(8,1,'FUEGO','HIELO',8,'Cabeza'),(9,0,'FUEGO','DRAGON',9,'Cuerpo'),(10,1,'HIELO','DRAGON',10,'Cabeza'),(11,1,'FUEGO','HIELO',11,'Cabeza'),(12,1,'FUEGO','ELECTRICIDAD',12,'Patas'),(13,0,'AGUA','DRAGON',13,'Alas'),(14,1,'FUEGO','AGUA',14,'Cabeza'),(15,1,'ELECTRICIDAD','AGUA',15,'Cuerpo'),(16,1,'AGUA','FUEGO',16,'Cuerpo'),(17,1,'AGUA','ELECTRICIDAD',17,'Patas'),(18,0,'ELECTRICIDAD','FUEGO',18,'Cabeza'),(19,1,'FUEGO','AGUA',19,'Patas'),(20,0,'FUEGO','HIELO',20,'Cabeza'),(21,0,'AGUA','ELECTRICIDAD',21,'Alas'),(22,1,'FUEGO','AGUA',22,'Cuerpo'),(23,1,'HIELO','ELECTRICIDAD',23,'Alas'),(24,0,'AGUA','FUEGO',24,'Cabeza'),(25,0,'FUEGO','HIELO',25,'Cabeza'),(26,0,'AGUA','FUEGO',26,'Alas '),(27,1,'AGUA','ELECTRICIDAD',27,'Cuerpo'),(28,0,'DRAGON','ELECTRICIDAD',28,'Cabeza'),(29,1,'DRAGON','HIELO',29,'Cola'),(30,1,'AGUA','FUEGO',30,'Alas'),(31,1,'AGUA','ELECTRICIDAD',31,'Alas'),(32,1,'FUEGO','DRAGON',32,'Cabeza'),(33,1,'DRAGON','HIELO',33,'Cuerpo'),(34,1,'FUEGO','DRAGON',34,'Alas'),(35,1,'FUEGO','DRAGON',35,'Alas'),(36,0,'FUEGO','DRAGON',36,'Cabeza'),(37,0,'DRAGON','HIELO',37,'Cabeza'),(38,0,'FUEGO','AGUA',38,'Cabeza'),(39,1,'ELECTRICIDAD','FUEGO',39,'Cuerpo'),(40,1,'ELECTRICIDAD','AGUA',40,'Cola'),(41,1,'DRAGON','ELECTRICIDAD',41,'Cuerpo'),(42,1,'FUEGO','AGUA',42,'Cabeza'),(43,0,'AGUA','FUEGO',43,'Patas'),(44,0,'HIELO','FUEGO',44,'Alas'),(45,0,'DRAGON','AGUA',45,'Alas'),(46,1,'HIELO','AGUA',46,'Alas'),(47,1,'ELECTRICIDAD','HIELO',47,'Cola'),(48,0,'FUEGO','AGUA',48,'Cuerpo');
/*!40000 ALTER TABLE `monstruogrande` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monstruopequeño`
--

DROP TABLE IF EXISTS `monstruopequeño`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monstruopequeño` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `esHostil` bit(1) NOT NULL,
  `esCabalgable` bit(1) NOT NULL,
  `id_monstruo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `monstruopequeño_ibfk_1` FOREIGN KEY (`id`) REFERENCES `monstruo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monstruopequeño`
--

LOCK TABLES `monstruopequeño` WRITE;
/*!40000 ALTER TABLE `monstruopequeño` DISABLE KEYS */;
INSERT INTO `monstruopequeño` VALUES (1,_binary '\0',_binary '',49),(2,_binary '\0',_binary '',50),(3,_binary '\0',_binary '',51),(4,_binary '',_binary '\0',52),(5,_binary '',_binary '\0',53),(6,_binary '',_binary '\0',54),(7,_binary '',_binary '\0',55),(8,_binary '',_binary '',56),(9,_binary '',_binary '',57),(10,_binary '\0',_binary '\0',58),(11,_binary '',_binary '\0',59),(12,_binary '',_binary '',60),(13,_binary '\0',_binary '',61),(14,_binary '',_binary '',62),(15,_binary '',_binary '',63),(16,_binary '',_binary '',64),(17,_binary '',_binary '',65),(18,_binary '',_binary '',66),(19,_binary '',_binary '\0',67),(20,_binary '',_binary '',68),(21,_binary '',_binary '',69),(22,_binary '',_binary '',70);
/*!40000 ALTER TABLE `monstruopequeño` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-30 12:42:21
