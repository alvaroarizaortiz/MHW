package interfaces;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Cazador;
import clases.MonstruoGrande;
import excepciones.AttackException;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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

	public PantallaCombate(Cazador cazador, MonstruoGrande monstruo) {
		setTitle("Sin lugar a dudas, una de las batallas más épicas que he visto nunca.exe");
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JButton btn_Ataque = new JButton("Ataque");
		btn_Ataque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					cazador.ataque(monstruo);
					monstruo.ataqueAleatorio(cazador);
					textArea_AtaquesCazador.setText("El cazador ha realizado un ataque normal y ha efectuado "
							+ cazador.getDañoUltimoTurno() + " de daño al monstruo.\n");
					textArea_AtaquesMonstruo
							.setText("El monstruo ha realizado un ataque: " + monstruo.getAtaqueRealizado()
									+ " y ha efectuado " + monstruo.getDañoUltimoTurno() + " de daño al cazador.\n");
					lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
					lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruo.getPuntosSaludActual());

					// Verificar si el combate ha terminado
					if (cazador.getSaludActualCazador() <= 0 || monstruo.getPuntosSaludActual() <= 0) {
						String mensaje;
						if (cazador.getSaludActualCazador() <= 0) {
							mensaje = "¡El combate ha terminado! El monstruo ha ganado.";
						} else {
							mensaje = "¡El combate ha terminado! El cazador ha ganado.";
						}
						JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
								JOptionPane.INFORMATION_MESSAGE);
						dispose(); // Cerrar la ventana de combate
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_Ataque.setBounds(45, 362, 113, 23);
		contentPanel.add(btn_Ataque);

		JButton btn_AtaqueFuerte = new JButton("Ataque Fuerte");
		btn_AtaqueFuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.ataqueFuerte(monstruo);
						monstruo.ataqueAleatorio(cazador);
						textArea_AtaquesCazador.setText("El cazador ha realizado un ataque fuerte y ha efectuado "
								+ cazador.getDañoUltimoTurno() + " de daño al monstruo.\n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruo.getAtaqueRealizado() + " y ha efectuado " + monstruo.getDañoUltimoTurno()
								+ " de daño al cazador.\n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruo.getPuntosSaludActual());

						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruo.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado.";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado.";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_AtaqueFuerte.setBounds(181, 362, 113, 23);
		contentPanel.add(btn_AtaqueFuerte);

		JButton btn_AccionArmaEspecial = new JButton("Ataque Especial");
		btn_AccionArmaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.ataqueEspecial(monstruo);
						monstruo.ataqueAleatorio(cazador);
						textArea_AtaquesCazador
								.setText("El cazador ha realizado un ataque especial con su arma y ha efectuado "
										+ cazador.getDañoUltimoTurno() + " de daño al monstruo. \n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruo.getAtaqueRealizado() + " y ha efectuado " + monstruo.getDañoUltimoTurno()
								+ " de daño al cazador.\n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruo.getPuntosSaludActual());

						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruo.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado.";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado.";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_AccionArmaEspecial.setBounds(45, 396, 113, 23);
		contentPanel.add(btn_AccionArmaEspecial);

		JButton btn_Esquivar = new JButton("Esquivar");
		btn_Esquivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.esquivar(monstruo);
						monstruo.ataqueAleatorio(cazador);
						textArea_AtaquesCazador.setText(
								"El cazador se mueve con una flexibilidad asombrosa para llevar esa armadura y esquiva el ataque. \n");
						textArea_AtaquesMonstruo.setText("El monstruo ha realizado un ataque: "
								+ monstruo.getAtaqueRealizado() + " y ha efectuado " + monstruo.getDañoUltimoTurno()
								+ " de daño al cazador.\n");
						lbl_SaludCazador.setText("Salud del cazador: " + cazador.getSaludActualCazador());
						lbl_SaludMonstruo.setText("Salud del monstruo: " + monstruo.getPuntosSaludActual());

						// Verificar si el combate ha terminado
						if (cazador.getSaludActualCazador() <= 0 || monstruo.getPuntosSaludActual() <= 0) {
							String mensaje;
							if (cazador.getSaludActualCazador() <= 0) {
								mensaje = "¡El combate ha terminado! El monstruo ha ganado.";
							} else {
								mensaje = "¡El combate ha terminado! El cazador ha ganado.";
							}
							JOptionPane.showMessageDialog(null, mensaje, "Fin del combate",
									JOptionPane.INFORMATION_MESSAGE);
							dispose(); // Cerrar la ventana de combate
						}
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
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

		lbl_NombreMonstruo = new JLabel("New label");
		lbl_NombreMonstruo.setBounds(574, 29, 46, 14);
		contentPanel.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("New label");
		lbl_ImagenMonstruo.setBounds(505, 64, 200, 200);
		contentPanel.add(lbl_ImagenMonstruo);

	}
}
