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
import java.awt.Color;

@SuppressWarnings("serial")
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
	private JLabel lbl_ImagenCazador;
	private int contadorTurnos = 0;
	private boolean esquivando = false;
	private JLabel lbl_versus;

	public PantallaCombate(Cazador cazador, MonstruoGrande monstruoGrande) {
		setTitle("SIN LUGAR A DUDAS, UNA DE LAS BATALLAS MÁS ÉPICAS QUE HE VISTO NUNCA.EXE");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBackground(new Color(230, 230, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		if (monstruoGrande != null) {
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

		lbl_NombreMonstruo.setBounds(574, 29, 200, 14);
		lbl_NombreMonstruo.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		contentPanel.add(lbl_NombreMonstruo);

		if (cazador != null) {
			lbl_NombreCazador = new JLabel(cazador.getNombre());
			lbl_NombreCazador.setFont(new Font("Futura Md BT", Font.BOLD, 14));
			lbl_NombreCazador.setBounds(89, 31, 250, 14);
			contentPanel.add(lbl_NombreCazador);
		}

		JButton btn_Ataque = new JButton("Ataque");
		btn_Ataque.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
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

		JButton btn_AtaqueFuerte = new JButton("At. Fuerte");
		btn_AtaqueFuerte.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		btn_AtaqueFuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					try {
						cazador.ataqueFuerte(monstruoGrande);
						double dañoCazador = cazador.getDañoUltimoTurno();
						textArea_AtaquesCazador.setText("El cazador ha realizado un ataque fuerte y ha efectuado "
								+ dañoCazador + " de daño al monstruo.\n");
						monstruoGrande.ataqueAleatorio(cazador, esquivando);

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

						contadorTurnos++;
						lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);

					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});

		btn_AtaqueFuerte.setBounds(181, 362, 113, 23);
		contentPanel.add(btn_AtaqueFuerte);

		JButton btn_AccionArmaEspecial = new JButton("Especial");
		btn_AccionArmaEspecial.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		btn_AccionArmaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruoGrande != null) {
					try {
						cazador.ataqueEspecial(monstruoGrande);
						double dañoCazador = cazador.getDañoUltimoTurno();
						textArea_AtaquesCazador
								.setText("El cazador ha realizado un ataque especial con su arma y ha efectuado "
										+ dañoCazador + " de daño al monstruo. \n");
						monstruoGrande.ataqueAleatorio(cazador, esquivando);

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

						contadorTurnos++;
						lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);

					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_AccionArmaEspecial.setBounds(45, 396, 113, 23);
		contentPanel.add(btn_AccionArmaEspecial);

		JButton btn_Esquivar = new JButton("Esquivar");
		btn_Esquivar.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
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

						String mensaje;
						String tipoAtaque = monstruoGrande.getAtaqueRealizado();
						if (tipoAtaque.equals("Rugido intimidante")) {
							mensaje = "El monstruo ha realizado un rugido intimidante. ¡El poder de ataque del cazador ha disminuido un 3%!";
						} else if (tipoAtaque.equals("Defensa")) {
							mensaje = "El monstruo se ha defendido del ataque del cazador.";
						} else {
							mensaje = "El monstruo ha realizado un ataque: " + tipoAtaque
									+ " y ha efectuado 0 puntos de daño \n";
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

						contadorTurnos++;
						lbl_ContadorTurnos.setText("Turno: " + contadorTurnos);

					} catch (AttackException ex) {
						textArea_AtaquesCazador.setText(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}

			}
		});
		btn_Esquivar.setBounds(181, 396, 113, 23);
		contentPanel.add(btn_Esquivar);

		textArea_AtaquesCazador = new JTextArea();
		textArea_AtaquesCazador.setBackground(new Color(42, 97, 88));
		textArea_AtaquesCazador.setForeground(Color.WHITE);
		textArea_AtaquesCazador.setFont(new Font("Futura Md BT", Font.BOLD, 13));
		textArea_AtaquesCazador.setBounds(45, 301, 249, 50);
		textArea_AtaquesCazador.setLineWrap(true);
		textArea_AtaquesCazador.setWrapStyleWord(true);
		contentPanel.add(textArea_AtaquesCazador);

		textArea_AtaquesMonstruo = new JTextArea();
		textArea_AtaquesMonstruo.setForeground(Color.WHITE);
		textArea_AtaquesMonstruo.setBackground(new Color(42, 97, 88));
		textArea_AtaquesMonstruo.setWrapStyleWord(true);
		textArea_AtaquesMonstruo.setLineWrap(true);
		textArea_AtaquesMonstruo.setFont(new Font("Futura Md BT", Font.BOLD, 13));
		textArea_AtaquesMonstruo.setBounds(484, 301, 249, 50);
		contentPanel.add(textArea_AtaquesMonstruo);

		lbl_SaludCazador = new JLabel("Salud del cazador:");
		lbl_SaludCazador.setFont(new Font("Futura Md BT", Font.ITALIC, 14));
		lbl_SaludCazador.setBounds(45, 276, 249, 14);
		contentPanel.add(lbl_SaludCazador);

		lbl_SaludMonstruo = new JLabel("Salud del monstruo:");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.ITALIC, 14));
		lbl_SaludMonstruo.setBounds(484, 276, 249, 14);
		contentPanel.add(lbl_SaludMonstruo);

		lbl_ContadorTurnos = new JLabel("Turnos: " + contadorTurnos);
		lbl_ContadorTurnos.setFont(new Font("Futura Md BT", Font.ITALIC, 14));
		lbl_ContadorTurnos.setBounds(356, 85, 80, 14);
		contentPanel.add(lbl_ContadorTurnos);

		ImageIcon rawcazador = new ImageIcon(getClass().getResource("/images/cazador.png"));
		Image imagecazador = rawcazador.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon finalcazador = new ImageIcon(imagecazador);
		lbl_ImagenCazador = new JLabel("");
		lbl_ImagenCazador.setIcon(finalcazador);
		lbl_ImagenCazador.setBounds(62, 64, 200, 200);
		contentPanel.add(lbl_ImagenCazador);

		ImageIcon rawvs = new ImageIcon(getClass().getResource("/images/vs.png"));
		Image imagevs = rawvs.getImage().getScaledInstance(110, 115, Image.SCALE_SMOOTH);
		ImageIcon finalvs = new ImageIcon(imagevs);
		lbl_versus = new JLabel("");
		lbl_versus.setIcon(finalvs);
		lbl_versus.setBounds(335, 110, 110, 115);
		contentPanel.add(lbl_versus);

	}
}
