package interfaces;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import bd.MonstruoPequeñoBD;
import clases.MonstruoPequeño;

@SuppressWarnings("serial")
public class BestiarioPequeño extends JDialog {
	MonstruoPequeñoBD monstruoPequeñoBD = new MonstruoPequeñoBD();
	List<MonstruoPequeño> monstruos = monstruoPequeñoBD.listarMonstruosPequeños();

	private int indexMonstruo = 0;
	private JLabel lbl_NombreMonstruo;
	private JLabel lbl_ImagenMonstruo;
	private JLabel lbl_RespuestaEspecieMonstruo;
	private JLabel lbl_RespuestaTamañoMonstruo;
	private JLabel lbl_RespuestaAtaqueMonstruo;
	private JLabel lbl_respuestaSaludMonstruo;
	private JLabel lbl_RespuestaLocalizacionMonstruo;
	private JLabel lbl_RespuestaHostilMonstruo;
	private JLabel lbl_RespuestaMontarMonstruo;
	private JTextArea textArea_DescripcionMonstruo;

	//Insertar sonido y controlar volumen
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

	public void mostrarMonstruo(MonstruoPequeño monstruoPequeño) {
		String rutaImagen = "/images/" + monstruoPequeño.getImagePath();
		URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(urlImagen).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
		lbl_ImagenMonstruo.setIcon(imageIcon);
		lbl_NombreMonstruo.setText(monstruoPequeño.getNombre());
		lbl_RespuestaEspecieMonstruo.setText(monstruoPequeño.getEspecie());
		lbl_RespuestaTamañoMonstruo.setText(String.valueOf(monstruoPequeño.getTamaño()));
		lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoPequeño.getPuntosSalud()));
		lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoPequeño.getPoderAtaque()));
		lbl_RespuestaLocalizacionMonstruo.setText(String.valueOf(monstruoPequeño.getNombreMapa()));
		lbl_RespuestaHostilMonstruo.setText(monstruoPequeño.isEsHostil() ? "Sí" : "No");
		lbl_RespuestaMontarMonstruo.setText(monstruoPequeño.isEsCabalgable() ? "Sí" : "No");
		textArea_DescripcionMonstruo.setText(monstruoPequeño.getDescripcion());

	}

	public BestiarioPequeño(MainInterface madre, boolean modal) {
		super(madre, modal);
		setTitle("BESTIARIO DE MONSTRUOS PEQUEÑOS");
		setBounds(100, 100, 1000, 800);
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panelMonstruoPequeño = new JPanel();
		panelMonstruoPequeño.setBackground(new Color(230, 230, 230));
		getContentPane().add(panelMonstruoPequeño, "panelMonstruoPequeño");
		panelMonstruoPequeño.setLayout(null);

		ImageIcon rawmp = new ImageIcon(getClass().getResource("/images/mp.png"));
		Image imagemp = rawmp.getImage().getScaledInstance(430, 169, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(imagemp);
		JLabel lbl_BestiarioMonstruoPequeño = new JLabel("");
		lbl_BestiarioMonstruoPequeño.setIcon(finalIcon);
		lbl_BestiarioMonstruoPequeño.setForeground(new Color(166, 38, 47));
		lbl_BestiarioMonstruoPequeño.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoPequeño.setBounds(285, 35, 430, 169);
		panelMonstruoPequeño.add(lbl_BestiarioMonstruoPequeño);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setForeground(new Color(42, 97, 88));
		lbl_NombreMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 24));
		lbl_NombreMonstruo.setBounds(217, 198, 300, 50);
		panelMonstruoPequeño.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(173, 249, 300, 300);
		panelMonstruoPequeño.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_EspecieMonstruo.setBounds(569, 275, 133, 30);
		panelMonstruoPequeño.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaEspecieMonstruo.setBounds(712, 275, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TamañoMonstruo.setBounds(569, 305, 133, 30);
		panelMonstruoPequeño.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaTamañoMonstruo.setBounds(712, 305, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_SaludMonstruo.setBounds(569, 335, 133, 30);
		panelMonstruoPequeño.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_respuestaSaludMonstruo.setBounds(712, 335, 168, 30);
		panelMonstruoPequeño.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_AtaqueMonstruo.setBounds(569, 365, 133, 30);
		panelMonstruoPequeño.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaAtaqueMonstruo.setBounds(712, 365, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_LocalizacionMonstruo.setBounds(569, 395, 133, 30);
		panelMonstruoPequeño.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaLocalizacionMonstruo.setBounds(712, 395, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_HostilMonstruo = new JLabel("¿Es hostil?");
		lbl_HostilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_HostilMonstruo.setBounds(569, 425, 133, 30);
		panelMonstruoPequeño.add(lbl_HostilMonstruo);

		lbl_RespuestaHostilMonstruo = new JLabel("Respuesta hostil");
		lbl_RespuestaHostilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaHostilMonstruo.setBounds(712, 425, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaHostilMonstruo);

		JLabel lbl_MontarMonstruo = new JLabel("¿Es montable?");
		lbl_MontarMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_MontarMonstruo.setBounds(569, 455, 133, 30);
		panelMonstruoPequeño.add(lbl_MontarMonstruo);

		lbl_RespuestaMontarMonstruo = new JLabel("Respuesta montar monstruo");
		lbl_RespuestaMontarMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaMontarMonstruo.setBounds(712, 455, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaMontarMonstruo);

		textArea_DescripcionMonstruo = new JTextArea();
		textArea_DescripcionMonstruo.setForeground(Color.WHITE);
		textArea_DescripcionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		textArea_DescripcionMonstruo.setBackground(new Color(42, 97, 88));
		textArea_DescripcionMonstruo.setLineWrap(true);
		textArea_DescripcionMonstruo.setWrapStyleWord(true);
		textArea_DescripcionMonstruo.setEditable(false);
		textArea_DescripcionMonstruo.setBounds(140, 565, 369, 117);
		panelMonstruoPequeño.add(textArea_DescripcionMonstruo);

		if (!monstruos.isEmpty()) {
			mostrarMonstruo(monstruos.get(indexMonstruo));
		}

		ImageIcon rawIzquierda = new ImageIcon(getClass().getResource("/images/izquierda.png"));
		Image imagenIzquierda = rawIzquierda.getImage().getScaledInstance(75, 85, Image.SCALE_SMOOTH);
		ImageIcon botonIzquierda = new ImageIcon(imagenIzquierda);
		JButton btn_Anterior = new JButton(botonIzquierda);
		btn_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("/song/pasarpagina.wav", -15.0f);
				if (indexMonstruo > 0) {
					indexMonstruo--;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Anterior.setBounds(627, 582, 75, 85);
		panelMonstruoPequeño.add(btn_Anterior);

		ImageIcon rawDerecha = new ImageIcon(getClass().getResource("/images/derecha.png"));
		Image imagenDerecha = rawDerecha.getImage().getScaledInstance(75, 85, Image.SCALE_SMOOTH);
		ImageIcon botonDerecha = new ImageIcon(imagenDerecha);
		JButton btn_Siguiente = new JButton(botonDerecha);
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound("/song/pasarpagina.wav", -15.0f);
				if (indexMonstruo < monstruos.size() - 1) {
					indexMonstruo++;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Siguiente.setBounds(752, 582, 75, 85);
		panelMonstruoPequeño.add(btn_Siguiente);

	}
}
