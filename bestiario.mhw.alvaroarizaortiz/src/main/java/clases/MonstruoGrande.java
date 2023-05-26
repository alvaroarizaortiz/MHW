package clases;

import enumeraciones.Elemento;
import excepciones.AttackException;

import java.util.Random;

import javax.swing.JTextArea;

public class MonstruoGrande extends Monstruo {
    private String puntoDebil; // Punto debil del monstruo. Usada solo en bestiario
    private double dañoUltimoTurno = 0; // Daño del ultimo turno del monstruo, establecido a 0 por defecto
    private boolean esCapturable; // Usado en bestiario para indicar si es o no capturable
    private Elemento resistencias; // Elemento que resiste el monstruo (enum): FUEGO, AGUA, ELECTRICIDAD, HIELO, DRAGON
    private Elemento debilidades; // Elemento que no resiste el monstruo (enum): FUEGO, AGUA, ELECTRICIDAD, HIELO, DRAGON
    private int id_Monstruo; // id del monstruo, usado en base de datos
    private double puntosSaludActual; // Puntos de salud actuales del monstruo en la batalla, se inicializan como los máximos y van bajando
    private int turnoRugido = 3; //  Indica si el ataque rugido intimidante está disponible. Inicializa en 3 y va restando hasta 0. Luego vuelve a 3
    private int turnoAtaqueFuerte = 2; // Indica si el ataque fuerte está disponible. Inicializa en 2 y va restando hasta 0. Luego vuelve a 2
    private int turnoDefender = 2; // Indica si defender está disponible. Inicializa en 2 y va restando hasta 0. Luego vuelve a 2
    private boolean rugidoDisponible = true; // Indica si el rugido intimidante está disponible. Inicia en true para que esté disponible el primer turno del combate.
    private boolean ataqueFuerteDisponible = true; // Indica si el ataque fuerte está disponible. Inicia en true para que esté disponible el primer turno del combate.
    private boolean defensaDisponible = true; // Indica si defender está disponible. Inicia en true para que esté disponible el primer turno del combate.
    private boolean defendiendo = false; // Por ahora está implementado para que el programa aplique la lógica de que el monstruo se está defendiendo para reducir daño. Se activa cuando el monstruo usa defender.
    private int turno = 0; // Contador de turnos
    private Random random = new Random(); //Random usado en ataques
    private String ataqueRealizado; // String que devuelve el ataque realizado de los random

    // Constructor completo de base de datos.
    public MonstruoGrande(String nombre, String especie, int tamaño, int poderAtaque, int puntosSalud,
                          String nombreMapa, String imagePath, String descripcion, String puntoDebil,
                          boolean esCapturable, Elemento resistencias, Elemento debilidades, int id_Monstruo) {
        super(nombre, especie, tamaño, poderAtaque, puntosSalud, nombreMapa, imagePath, descripcion);
        this.puntoDebil = puntoDebil;
        this.esCapturable = esCapturable;
        this.resistencias = resistencias;
        this.debilidades = debilidades;
        this.id_Monstruo = id_Monstruo;
        this.puntosSaludActual = puntosSalud;
    }

    // Constructor usado en partes de la interfaz.
    public MonstruoGrande(String nombre, int puntosSalud, int poderAtaque, String imagePath) {
        super(nombre, puntosSalud, poderAtaque, imagePath);
        this.puntosSaludActual = puntosSalud;
    }

    // Constructor usado en partes de la interfaz.
    public MonstruoGrande(String nombre, int puntosSalud, int poderAtaque, String imagePath, Elemento resistencias,
                          Elemento debilidades) {
        super(nombre, poderAtaque, puntosSalud, imagePath);
        this.puntosSaludActual = puntosSalud;
        this.resistencias = resistencias;
        this.debilidades = debilidades;
    }

    // Getters y setters.
    public String getPuntoDebil() {
        return puntoDebil;
    }

    public void setPuntoDebil(String puntoDebil) {
        this.puntoDebil = puntoDebil;
    }

    public boolean isEsCapturable() {
        return esCapturable;
    }

    public void setEsCapturable(boolean esCapturable) {
        this.esCapturable = esCapturable;
    }

    public Elemento getResistencias() {
        return resistencias;
    }

    public void setResistencias(Elemento resistencias) {
        this.resistencias = resistencias;
    }

    public Elemento getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(Elemento debilidades) {
        this.debilidades = debilidades;
    }

    public int getId_Monstruo() {
        return id_Monstruo;
    }

    public void setId_Monstruo(int id_Monstruo) {
        this.id_Monstruo = id_Monstruo;
    }

    public double getPuntosSaludActual() {
        return puntosSaludActual;
    }

    public void setPuntosSaludActual(double puntosSaludActual) {
        this.puntosSaludActual = puntosSaludActual;
    }

    public double getDañoUltimoTurno() {
		return dañoUltimoTurno;
	}

	public void setDañoUltimoTurno(double dañoUltimoTurno) {
		this.dañoUltimoTurno = dañoUltimoTurno;
	}
	
	public String getAtaqueRealizado() {
		return ataqueRealizado;
	}

	public void setAtaqueRealizado(String ataqueRealizado) {
		this.ataqueRealizado = ataqueRealizado;
	}
	
	public boolean isDefendiendo() {
		return defendiendo;
	}

	public void setDefendiendo(boolean defendiendo) {
		this.defendiendo = defendiendo;
	}

	//  TODOS LOS ATAQUES ESTÁN SUJETOS A LA TABLA DE RESISTENCIAS Y DEBILIDADES ELEMENTALES.
	
	// Método de ataque normal. 
    public void ataqueBasico(Cazador cazador, boolean esquivando) {
        this.turno++;
        double daño = this.getPoderAtaque();
        if(esquivando) {
        	daño = 0;
        }
        double dañoFinal = this.calcularDañoMonstruo(cazador, daño);
        cazador.recibirDaño(dañoFinal);
        this.setDañoUltimoTurno(dañoFinal);
        
        if (cazador.getSaludCazador() <= 0) {
            resetearTurnos();
        }

        resetearDefensa();
        resetearRugido();
        resetearAtaqueFuerte();
        
    }

    //  Método de ataque fuerte. Se puede usar cada tres turnos y hace el daño de un ataque normal multiplicado por 1.5
    public void ataqueFuerte(Cazador cazador, boolean esquivando) throws AttackException {
        if (!ataqueFuerteDisponible) {
            throw new AttackException(
                    "El Monstruo no puede realizar el ataque fuerte. El ataque fuerte solo está disponible cada 2 turnos.");
        }

        this.ataqueFuerteDisponible = false;
        this.turno++;
        double daño = this.getPoderAtaque() * 1.5; // Aumenta el daño base en un 50%
        if(esquivando) {
        	daño = 0;
        }
        double dañoFinal = this.calcularDañoMonstruo(cazador, daño);
        cazador.recibirDaño(dañoFinal);
        this.setDañoUltimoTurno(dañoFinal);

        if (cazador.getSaludCazador() <= 0) {
            resetearTurnos();
        }

        resetearDefensa();
        resetearRugido();
        resetearAtaqueFuerte();
        
    }

    // Método de rugido del monstruo. Se puede usar cada tres turnos y baja un 2% de ataque (permanente) al cazador hasta el final del combate.
    public void rugidoIntimidante(Cazador cazador) throws AttackException {
        if (!rugidoDisponible) {
            throw new AttackException("El Monstruo no puede rugir. El rugido solo está disponible cada 3 turnos.");
        }

        this.rugidoDisponible = false;
        this.turno++;
        // El rugido reduce el ataque del arma del cazador en un 2% cada vez que se usa.
        cazador.getArmaEquipada().reducirAtaque(3);

        if (cazador.getSaludCazador() <= 0) {
            resetearTurnos();
        }

        resetearDefensa();
        resetearRugido();
        resetearAtaqueFuerte();
       
    }

    // Método de defensa del monstruo. Se puede usar cada dos turnos y el monstruo se defiende de todo el ataque que recibe.
    public void defender() throws AttackException {
        if (!defensaDisponible) {
            throw new AttackException("El Monstruo no puede defender. La defensa solo está disponible cada 2 turnos.");
        }

        this.defendiendo = true;
        this.turno++;

        resetearDefensa();
        resetearRugido();
        resetearAtaqueFuerte();
        
        
    }

	// Función para que el monstruo realice un ataque aleatorio entre los cuatro que
	// hay disponibles
	public void ataqueAleatorio(Cazador cazador, boolean esquivando) {
		boolean ataqueRealizado = false;
		double dañoMonstruo = 0.0; // Inicialmente no hay daño
		while (!ataqueRealizado) {
			int ataque = random.nextInt(4);
			try {
				switch (ataque) {
				case 0:
					if(!esquivando){
						ataqueBasico(cazador, esquivando);
						setAtaqueRealizado("Ataque básico");
						dañoMonstruo = getDañoUltimoTurno();
						ataqueRealizado = true;
					}
					break;
				case 1:
					rugidoIntimidante(cazador);
					setAtaqueRealizado("Rugido intimidante");
					// No hay daño en este caso, así que el dañoMonstruo permanece como 0
					ataqueRealizado = true;
					break;
				case 2:
					if(!esquivando) {
						ataqueFuerte(cazador, esquivando);
						setAtaqueRealizado("Ataque fuerte");
						dañoMonstruo = getDañoUltimoTurno();
						ataqueRealizado = true;
					}
					break;
				case 3:
					defender();
					setAtaqueRealizado("Defensa");
					// No hay daño en este caso, así que el dañoMonstruo permanece como 0
					ataqueRealizado = true;
					break;
				}
			} catch (AttackException e) {
				// Ignorar excepción y volver a intentar seleccionar un ataque
			}
		}
		// Solo actualizar el daño del último turno si hubo daño
		if (dañoMonstruo > 0) {
			cazador.setDañoUltimoTurno(dañoMonstruo);
		} else {
			cazador.setDañoUltimoTurno(0);
		}
	}

    
    // Método para calcular el daño en función de debilidades y resistencias elementales. A saber:
 	// Si la debilidad de la armadura es igual al elemento que resiste el monstruo, este hace 1.5* de daño al cazador
 	// Si la resistencia de la armadura es igual al elemento que resiste el monstruo, este hace 0.5* de daño al cazador
	public double calcularDañoMonstruo(Cazador cazador, double dañoBase) {
	    Elemento resistenciaMonstruo = this.getResistencias();
	    Elemento debilidadArmadura = cazador.getArmaduraEquipada().getDebilidadArmadura();
	    Elemento resistenciaArmadura = cazador.getArmaduraEquipada().getResistenciaArmadura();

	    double daño = dañoBase;

	 // Comprueba si la armadura del cazador es débil o resistente al elemento del monstruo
	    if (debilidadArmadura.equals(resistenciaMonstruo)) {
	        daño *= 1.5;
	    } else if (resistenciaArmadura.equals(resistenciaMonstruo)) {
	        daño *= 0.5;
	    }
	    return daño;
	}
    
	// Método que usa el booleano de defender para comprobar si está defendiendose. En caso afirmativo se activa el porcentaje, luego se cambia a false.
    public void recibirDaño(double daño) {
        if (defendiendo) {
            daño = 0; // El daño recibido se reduce en 0 cuando el monstruo se está defendiendo
            defendiendo = false;
        }
        this.puntosSaludActual -= Math.round(daño);
        if (this.puntosSaludActual < 0) {
            this.puntosSaludActual = 0;
        }
        
        resetearDefensa();
    }

    // Hacia abajo todos los métodos "resetear" que funcionan con un contador que resta hasta 0 y los resetea hasta la cantidad de turnos de cada ataque
    public void resetearRugido() {
        if (turnoRugido <= 0) {
            turnoRugido = 3;
            rugidoDisponible = true;
        } else {
            turnoRugido--;
        }
    }

    public void resetearAtaqueFuerte() {
        if (turnoAtaqueFuerte <= 0) {
            turnoAtaqueFuerte = 2;
            ataqueFuerteDisponible = true;
        } else {
            turnoAtaqueFuerte--;
        }
    }

    public void resetearDefensa() {
        if (turnoDefender <= 0) {
            turnoDefender = 2;
            defendiendo = false;
        } else {
            turnoDefender--;
        }
    }

    public void resetearTurnos() {
        this.turno = 0;
        this.turnoRugido = 3;
        this.rugidoDisponible = true;
        this.turnoAtaqueFuerte = 2;
        this.ataqueFuerteDisponible = true;
        this.turnoDefender = 2;
        this.defensaDisponible = true;
    }

    // toString de MonstruoGrande
    @Override
    public String toString() {
        return "MonstruoGrande [puntoDebil=" + puntoDebil + ", esCapturable=" + esCapturable + ", resistencias="
                + resistencias + ", debilidades=" + debilidades + ", id_Monstruo=" + id_Monstruo + "]";
    }
}

