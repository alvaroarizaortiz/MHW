package interfaces;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import excepciones.EmailException;
import excepciones.FormularioVacioException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Desktop;

@SuppressWarnings("serial")
public class Feedback extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextArea textAreaFeedback;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnEstudiante;

	// Insertar sonido y controlar volumen
	private void playSound(String soundName, float volume) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundName));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(volume);

			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public Feedback(MainInterface madre, boolean modal) {
		setTitle("FEEDBACK");
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(230, 230, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblNombre.setBounds(174, 129, 67, 14);
		contentPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textFieldNombre.setBounds(251, 127, 179, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(20);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblEmail.setBounds(190, 187, 67, 14);
		contentPanel.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textFieldEmail.setBounds(251, 185, 179, 20);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(20);

		JLabel lblFeedback = new JLabel("Feedback sobre el programa:");
		lblFeedback.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblFeedback.setBounds(225, 301, 216, 14);
		contentPanel.add(lblFeedback);

		textAreaFeedback = new JTextArea();
		textAreaFeedback.setForeground(Color.WHITE);
		textAreaFeedback.setBackground(new Color(42, 97, 88));
		textAreaFeedback.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textAreaFeedback.setBounds(210, 326, 244, 94);
		textAreaFeedback.setLineWrap(true);
		textAreaFeedback.setWrapStyleWord(true);
		contentPanel.add(textAreaFeedback);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblRol.setBounds(206, 248, 51, 14);
		contentPanel.add(lblRol);

		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBackground(new Color(230, 230, 230));
		rdbtnProfesor.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		rdbtnProfesor.setBounds(251, 244, 83, 23);
		contentPanel.add(rdbtnProfesor);

		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBackground(new Color(230, 230, 230));
		rdbtnEstudiante.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		rdbtnEstudiante.setBounds(336, 244, 91, 23);
		contentPanel.add(rdbtnEstudiante);

		ButtonGroup buttonGroupRol = new ButtonGroup();
		buttonGroupRol.add(rdbtnProfesor);
		buttonGroupRol.add(rdbtnEstudiante);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		btnEnviar.setBounds(371, 431, 83, 23);
		contentPanel.add(btnEnviar);

		ImageIcon rawfb = new ImageIcon(getClass().getResource("/images/feed.png"));
		Image imagefb = rawfb.getImage().getScaledInstance(279, 42, Image.SCALE_SMOOTH);
		ImageIcon finalfb = new ImageIcon(imagefb);
		JLabel lbl_titulofeedback = new JLabel("FEEDBACK");
		lbl_titulofeedback.setIcon(finalfb);
		lbl_titulofeedback.setForeground(new Color(166, 38, 47));
		lbl_titulofeedback.setFont(new Font("Futura Md BT", Font.PLAIN, 20));
		lbl_titulofeedback.setBounds(190, 46, 279, 42);
		contentPanel.add(lbl_titulofeedback);

		// Adjunto enlaces de navegador a los recursos para poder comprobar las fuentes
		JEditorPane editorPane_creditos = new JEditorPane();
		editorPane_creditos.setContentType("text/html");
		editorPane_creditos.setText("<html>Recursos utilizados para el programa:<br>"
				+ "Imágenes extraídas del archivo <a href='https://monsterhunterworld-archive.fandom.com/wiki/Monsters'><i>fandom</i> de MHW</a>. <br>"
				+ "Botones, títulos e imagen del cazador en combate hechos a mano en Photoshop. <br>"
				+ "Sonidos extraídos de libreríaFX, <a href='https://www.youtube.com/watch?v=BlVn3swlSng'>tema oficial de MHFUnite</a> "
				+ "y <a href='https://www.youtube.com/watch?v=FZUcpVmEHuk'><i>still a piece of garbage</i> de Bill Wurtz</a> en Youtube. </html>");
		editorPane_creditos.setFont(new Font("Futura Md BT", Font.PLAIN, 11));
		editorPane_creditos.setBackground(new Color(230, 230, 230));
		editorPane_creditos.setBounds(10, 431, 356, 119);
		editorPane_creditos.setEditable(false);
		editorPane_creditos.addHyperlinkListener((HyperlinkListener) new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					if (Desktop.isDesktopSupported()) {
						try {
							Desktop.getDesktop().browse(e.getURL().toURI());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		contentPanel.add(editorPane_creditos);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textFieldNombre.getText();
					String email = textFieldEmail.getText();
					String feedback = textAreaFeedback.getText();

					if (nombre.isEmpty() || feedback.isEmpty()) {
						throw new FormularioVacioException("El nombre y el mensaje no pueden estar vacíos.");
					}

					if (!email.contains("@")) {
						throw new EmailException("Email inválido " + email + ", por favor, inserte \n"
								+ " una dirección de correo electrónico que use @ ");
					}

					String rol = rdbtnProfesor.isSelected() ? "Profesor" : "Estudiante";

					playSound("/song/thanks.wav", -15.0f);

					StringBuilder mensaje = new StringBuilder();
					mensaje.append("Nombre: ").append(nombre).append("\n");
					mensaje.append("Email: ").append(email).append("\n");
					mensaje.append("Rol: ").append(rol).append("\n");
					mensaje.append("Mensaje: ").append(feedback).append("\n");
					mensaje.append("\n");
					mensaje.append("¡Gracias por tu valoración!");

					// Mostramos todo lo que se ha rellenado del formulario en una ventana emergente
					JOptionPane.showMessageDialog(contentPanel, mensaje.toString(), "Información del formulario",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (EmailException ex) {
					// Excepción email
					JOptionPane.showMessageDialog(contentPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (FormularioVacioException ex) {
					// Excepción formulario vacío
					JOptionPane.showMessageDialog(contentPanel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
