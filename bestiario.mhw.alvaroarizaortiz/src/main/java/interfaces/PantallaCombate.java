package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Cazador;
import clases.MonstruoGrande;
import excepciones.AttackException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PantallaCombate extends JDialog {
	private JTextArea textArea_AtaquesCazador;
	private JTextArea textArea_AtaquesMonstruo;
	private JLabel lbl_SaludCazador;
	private JLabel lbl_SaludMonstruo;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_NombreMonstruo;
	private JLabel lbl_ImagenMonstruo;
	private JLabel lbl_NombreCazador;
	private JLabel lbl_ContadorTurnos;
	private int contadorTurnos = 0;
	private boolean esquivando = false;
	
	
	public PantallaCombate(Cazador cazador, MonstruoGrande monstruoGrande) {
		setTitle("Sin lugar a dudas, una de las batallas más épicas que he visto nunca.exe");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		if(monstruoGrande != null) {
            lbl_NombreMonstruo = new JLabel(monstruoGrande.getNombre());
            lbl_ImagenMonstruo = new JLabel("");
            String ruta = "/images/" + monstruoGrande.getImagePath();
    		URL urlImagen = getClass().getResource(ruta);
    		ImageIcon imageIcon = new ImageIcon(
    				new ImageIcon(urlImagen).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
    		lbl_ImagenMonstruo.setIcon(imageIcon);
    		lbl_ImagenMonstruo.setBounds(505, 64, 200, 200);
    		contentPanel.add(lbl_ImagenMonstruo);
        } else {
            lbl_NombreMonstruo = new JLabel("No hay monstruos seleccionados");
        }
		
		lbl_NombreMonstruo.setBounds(574, 29, 131, 14);
		contentPanel.add(lbl_NombreMonstruo);
		
		if(cazador != null) {
		lbl_NombreCazador = new JLabel(cazador.getNombre());
		lbl_NombreCazador.setBounds(89, 31, 131, 14);
		contentPanel.add(lbl_NombreCazador);
		}
		


		JButton btn_Ataque = new JButton("Ataque");
		btn_Ataque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					cazador.ataque(monstruoGrande);
					double dañoCazador = cazador.getDañoUltimoTurno();
					monstruoGrande.ataqueAleatorio(cazador, esquivando);
					textArea_AtaquesCazador.setText("El cazador ha realizado un ataque normal y ha efectuado "
							+ dañoCazador + " de daño al monstruo.\n");
					String mensaje;
					String tipoAtaque = monstruoGrande.getAtaqueRealizado();
					double daño = monstruoGrande.getDañoUltimoTurno();

					if (tipoAtaque.equals("Rugido intimidante")) {
						mensaje = "El monstruo ha realizado un rugido intimidante. ¡El poder de ataque del cazador ha disminuido un 3%!";
					} else if (tipoAtaque.equals("Defensa")) {
						mensaje = "El monstruo se ha defendido del ataque del cazador.";
					} else {
						mensaje = String.format(
								"El monstruo ha realizado un ataque: %s y ha efectuado %.2f de daño al cazador.",
								tipoAtaque, daño);
					}

					textArea_AtaquesMonstruo.setText(mensaje);

					lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
					lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruoGrande.getPuntosSaludActual());

					// Verificar si el combate ha terminado
					if (cazador.getSaludActualCazador() <= 0 || monstruoGrande.getPuntosSaludActual() <= 0) {
						String mensajeFin;
						if (cazador.getSaludActualCazador() <= 0) {
							mensajeFin = "¡El combate ha terminado! El monstruo ha ganado en " + contadorTurnos
									+ " turnos";
						} else {
							mensajeFin = "¡El combate ha terminado! El cazador ha ganado en " + contadorTurnos
									+ " turnos";
						}
						JOptionPane.showMessageDialog(null, mensajeFin, "Fin del combate",
								JOptionPane.INFORMATION_MESSAGE);
						dispose(); // Cerrar la ventana de combate
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
				contadorTurnos++;
				lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);
			}
		});
		btn_Ataque.setBounds(45, 362, 113, 23);
		contentPanel.add(btn_Ataque);

		JButton btn_AtaqueFuerte = new JButton("Ataque Fuerte");
		btn_AtaqueFuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					try {
						cazador.ataqueFuerte(monstruoGrande);
						monstruoGrande.ataqueAleatorio(cazador, esquivando);
						textArea_AtaquesCazador.setText("El cazador ha realizado un ataque fuerte y ha efectuado "
								+ cazador.getDañoUltimoTurno() + " de daño al monstruo.\n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruoGrande.getAtaqueRealizado() + " y ha efectuado " + monstruoGrande.getDañoUltimoTurno()
								+ " de daño al cazador.\n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruoGrande.getPuntosSaludActual());
						contadorTurnos++;
						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruoGrande.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado en " + contadorTurnos
										+ " turnos";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado en " + contadorTurnos
										+ " turnos";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
				contadorTurnos++;
				lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);
			}
		});
		btn_AtaqueFuerte.setBounds(181, 362, 113, 23);
		contentPanel.add(btn_AtaqueFuerte);

		JButton btn_AccionArmaEspecial = new JButton("Especial");
		btn_AccionArmaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					try {
						cazador.ataqueEspecial(monstruoGrande);
						monstruoGrande.ataqueAleatorio(cazador, esquivando);
						textArea_AtaquesCazador
								.setText("El cazador ha realizado un ataque especial con su arma y ha efectuado "
										+ cazador.getDañoUltimoTurno() + " de daño al monstruo. \n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruoGrande.getAtaqueRealizado() + " y ha efectuado " + monstruoGrande.getDañoUltimoTurno()
								+ " de daño al cazador.\n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruoGrande.getPuntosSaludActual());
						contadorTurnos++;
						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruoGrande.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado en " + contadorTurnos
										+ " turnos";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado en " + contadorTurnos
										+ " turnos";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
				contadorTurnos++;
				lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);
			}
		});
		btn_AccionArmaEspecial.setBounds(45, 396, 113, 23);
		contentPanel.add(btn_AccionArmaEspecial);

		JButton btn_Esquivar = new JButton("Esquivar");
		btn_Esquivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					try {
						cazador.esquivar(monstruoGrande);
						esquivando = true;
						monstruoGrande.ataqueAleatorio(cazador, esquivando);
						esquivando = false;
						textArea_AtaquesCazador.setText(
								"El cazador se mueve con una flexibilidad asombrosa para llevar esa armadura y esquiva el ataque. \n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruoGrande.getAtaqueRealizado() + " y ha efectuado 0 puntos de daño \n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruoGrande.getPuntosSaludActual());
						contadorTurnos++;
						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruoGrande.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado en " + contadorTurnos
										+ " turnos";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado en " + contadorTurnos
										+ " turnos";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}

				lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);
			}
		});
		btn_Esquivar.setBounds(181, 396, 113, 23);
		contentPanel.add(btn_Esquivar);

		textArea_AtaquesCazador = new JTextArea();
		textArea_AtaquesCazador.setFont(new Font("Arial", Font.BOLD, 13));
		textArea_AtaquesCazador.setBounds(45, 301, 249, 50);
		textArea_AtaquesCazador.setLineWrap(true);
		textArea_AtaquesCazador.setWrapStyleWord(true);
		contentPanel.add(textArea_AtaquesCazador);

		textArea_AtaquesMonstruo = new JTextArea();
		textArea_AtaquesMonstruo.setWrapStyleWord(true);
		textArea_AtaquesMonstruo.setLineWrap(true);
		textArea_AtaquesMonstruo.setFont(new Font("Arial", Font.BOLD, 13));
		textArea_AtaquesMonstruo.setBounds(484, 301, 249, 50);
		contentPanel.add(textArea_AtaquesMonstruo);

		lbl_SaludCazador = new JLabel("New label");
		lbl_SaludCazador.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_SaludCazador.setBounds(45, 276, 249, 14);
		contentPanel.add(lbl_SaludCazador);

		lbl_SaludMonstruo = new JLabel("New label");
		lbl_SaludMonstruo.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_SaludMonstruo.setBounds(484, 276, 249, 14);
		contentPanel.add(lbl_SaludMonstruo);

		lbl_ContadorTurnos = new JLabel("Turnos: " + contadorTurnos);
		lbl_ContadorTurnos.setFont(new Font("Arial", Font.ITALIC, 13));
		lbl_ContadorTurnos.setBounds(314, 105, 113, 14);
		contentPanel.add(lbl_ContadorTurnos);
		
		
	}
}
