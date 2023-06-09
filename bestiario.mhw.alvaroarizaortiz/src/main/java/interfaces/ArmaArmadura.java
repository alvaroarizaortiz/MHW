package interfaces;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.ArmaBD;
import bd.ArmaduraBD;
import clases.Arma;
import clases.Armadura;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("serial")
public class ArmaArmadura extends JDialog {
	private ArmaBD armaBD = new ArmaBD();
	private ArmaduraBD armaduraBD = new ArmaduraBD();

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_RespuestatipoArma;
	private JLabel lbl_RespuestapoderataqueArma;
	private JLabel lbl_RespuestaelementoataqueArma;
	private JLabel lbl_ArmaImagen;
	private JTextArea textArea_DescripcionArma;
	private JLabel lbl_Respuestapoderdefensarmadura;
	private JLabel lbl_RespuestaresistenciaArmadura;
	private JLabel lbl_RespuestadebilidadArmadura;
	private JLabel lbl_ArmaduraImagen;
	private JTextArea textArea_DescripcionArmadura;

	public ArmaArmadura(MainInterface madre, boolean modal) {
		setTitle("ARMAS Y ARMADURAS");
		setBounds(100, 100, 1000, 1000);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBackground(new Color(42, 97, 88));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel_Armas = new JPanel();
		panel_Armas.setBounds(10, 11, 477, 939);
		contentPanel.add(panel_Armas);
		panel_Armas.setLayout(null);

		ImageIcon rawarmas = new ImageIcon(getClass().getResource("/images/armas.png"));
		Image imagearmas = rawarmas.getImage().getScaledInstance(370, 124, Image.SCALE_SMOOTH);
		ImageIcon finalarmas = new ImageIcon(imagearmas);
		JLabel lbl_Armas = new JLabel("");
		lbl_Armas.setIcon(finalarmas);
		lbl_Armas.setBounds(55, 25, 370, 124);
		lbl_Armas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Armas.add(lbl_Armas);

		JComboBox<String> comboBox_Armas = new JComboBox<String>();
		List<String> nombresArmas = armaBD.getNombresArmas();
		for (String nombre : nombresArmas) {
			comboBox_Armas.addItem(nombre);
		}

		comboBox_Armas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
				Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
				lbl_RespuestatipoArma.setText(arma.getTipoArma());
				lbl_RespuestapoderataqueArma.setText(String.valueOf(arma.getPoderAtaque()));
				lbl_RespuestaelementoataqueArma.setText(arma.getElementoAtaque().toString());
				textArea_DescripcionArma.setText(arma.getDescripcion());

				URL location = this.getClass().getResource("/images/" + arma.getImagePath());
				if (location != null) {
					ImageIcon icon = new ImageIcon(location);
					Image image = icon.getImage();
					Image newimg = image.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + arma.getImagePath());
				}
			}
		});

		comboBox_Armas.setBounds(98, 184, 297, 34);
		panel_Armas.add(comboBox_Armas);

		JLabel lbl_TipoArma = new JLabel("Tipo de arma");
		lbl_TipoArma.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TipoArma.setBounds(98, 229, 110, 30);
		panel_Armas.add(lbl_TipoArma);

		lbl_RespuestatipoArma = new JLabel("Respuesta tipo arma");
		lbl_RespuestatipoArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestatipoArma.setBounds(250, 229, 192, 30);
		panel_Armas.add(lbl_RespuestatipoArma);

		JLabel lbl_PoderAtaqueArma = new JLabel("Poder de ataque");
		lbl_PoderAtaqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PoderAtaqueArma.setBounds(98, 279, 163, 30);
		panel_Armas.add(lbl_PoderAtaqueArma);

		lbl_RespuestapoderataqueArma = new JLabel("Respuesta poder ataque");
		lbl_RespuestapoderataqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestapoderataqueArma.setBounds(250, 279, 124, 30);
		panel_Armas.add(lbl_RespuestapoderataqueArma);

		JLabel lbl_ElementoAtaque = new JLabel("Elemento");
		lbl_ElementoAtaque.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ElementoAtaque.setBounds(98, 329, 90, 30);
		panel_Armas.add(lbl_ElementoAtaque);

		lbl_RespuestaelementoataqueArma = new JLabel("Respuesta elemento ataque");
		lbl_RespuestaelementoataqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaelementoataqueArma.setBounds(250, 329, 135, 30);
		panel_Armas.add(lbl_RespuestaelementoataqueArma);

		lbl_ArmaImagen = new JLabel();
		lbl_ArmaImagen.setBounds(67, 512, 350, 350);
		panel_Armas.add(lbl_ArmaImagen);

		textArea_DescripcionArma = new JTextArea();
		textArea_DescripcionArma.setForeground(Color.WHITE);
		textArea_DescripcionArma.setBackground(new Color(42, 97, 88));
		textArea_DescripcionArma.setLineWrap(true);
		textArea_DescripcionArma.setWrapStyleWord(true);
		textArea_DescripcionArma.setEditable(false);
		textArea_DescripcionArma.setBounds(97, 392, 300, 65);
		panel_Armas.add(textArea_DescripcionArma);

		// Esto deja el ComboBox inicializado en el primer arma y ya coge los datos de
		// la BD automáticamente.
		// Sin esto el programa aparece en blanco al iniciarse.
		String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
		Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
		lbl_RespuestatipoArma.setText(arma.getTipoArma());
		lbl_RespuestapoderataqueArma.setText(String.valueOf(arma.getPoderAtaque()));
		lbl_RespuestaelementoataqueArma.setText(arma.getElementoAtaque().toString());
		textArea_DescripcionArma.setText(arma.getDescripcion());

		URL location = this.getClass().getResource("/images/" + arma.getImagePath());
		if (location != null) {
			ImageIcon icon = new ImageIcon(location);
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			lbl_ArmaImagen.setIcon(icon);
		} else {
			System.err.println("No se pudo encontrar la imagen: " + arma.getImagePath());
		}

		JPanel panel_Armaduras = new JPanel();
		panel_Armaduras.setBounds(494, 11, 477, 939);
		contentPanel.add(panel_Armaduras);
		panel_Armaduras.setLayout(null);

		ImageIcon rawarmaduras = new ImageIcon(getClass().getResource("/images/armaduras.png"));
		Image imagearmaduras = rawarmaduras.getImage().getScaledInstance(448, 121, Image.SCALE_SMOOTH);
		ImageIcon finalarmaduras = new ImageIcon(imagearmaduras);
		JLabel lbl_Armaduras = new JLabel("");
		lbl_Armaduras.setIcon(finalarmaduras);
		lbl_Armaduras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Armaduras.setBounds(19, 25, 448, 121);
		panel_Armaduras.add(lbl_Armaduras);

		JComboBox<String> comboBox_Armaduras = new JComboBox<String>();
		List<String> nombresArmaduras = armaduraBD.getNombresArmaduras();
		for (String nombre : nombresArmaduras) {
			comboBox_Armaduras.addItem(nombre);
		}

		comboBox_Armaduras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();

				Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);
				lbl_Respuestapoderdefensarmadura.setText(String.valueOf(armadura.getPoderDefensa()));
				lbl_RespuestaresistenciaArmadura.setText(armadura.getResistenciaArmadura().toString());
				lbl_RespuestadebilidadArmadura.setText(armadura.getDebilidadArmadura().toString());
				textArea_DescripcionArmadura.setText(armadura.getDescripcion());

				URL location = this.getClass().getResource("/images/" + armadura.getImagePath());
				if (location != null) {
					ImageIcon icon = new ImageIcon(location);
					Image image = icon.getImage();
					Image newimg = image.getScaledInstance(200, 400, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaduraImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + armadura.getImagePath());
				}
			}

		});

		comboBox_Armaduras.setBounds(98, 184, 297, 34);
		panel_Armaduras.add(comboBox_Armaduras);

		JLabel lbl_PoderDefensaArmadura = new JLabel("Poder de defensa");
		lbl_PoderDefensaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PoderDefensaArmadura.setBounds(98, 229, 163, 30);
		panel_Armaduras.add(lbl_PoderDefensaArmadura);

		lbl_Respuestapoderdefensarmadura = new JLabel("Respuesta poder defensa");
		lbl_Respuestapoderdefensarmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_Respuestapoderdefensarmadura.setBounds(271, 231, 133, 30);
		panel_Armaduras.add(lbl_Respuestapoderdefensarmadura);

		JLabel lbl_ResistenciaArmadura = new JLabel("Resistencia");
		lbl_ResistenciaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ResistenciaArmadura.setBounds(98, 279, 88, 30);
		panel_Armaduras.add(lbl_ResistenciaArmadura);

		lbl_RespuestaresistenciaArmadura = new JLabel("Respuesta resistencia");
		lbl_RespuestaresistenciaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaresistenciaArmadura.setBounds(271, 279, 113, 30);
		panel_Armaduras.add(lbl_RespuestaresistenciaArmadura);

		JLabel lbl_DebilidadArmadura = new JLabel("Debilidad");
		lbl_DebilidadArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_DebilidadArmadura.setBounds(96, 329, 120, 30);
		panel_Armaduras.add(lbl_DebilidadArmadura);

		lbl_RespuestadebilidadArmadura = new JLabel("Respuesta debilidad");
		lbl_RespuestadebilidadArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestadebilidadArmadura.setBounds(271, 329, 100, 30);
		panel_Armaduras.add(lbl_RespuestadebilidadArmadura);

		textArea_DescripcionArmadura = new JTextArea();
		textArea_DescripcionArmadura.setForeground(Color.WHITE);
		textArea_DescripcionArmadura.setBackground(new Color(42, 97, 88));
		textArea_DescripcionArmadura.setLineWrap(true);
		textArea_DescripcionArmadura.setWrapStyleWord(true);
		textArea_DescripcionArmadura.setEditable(false);
		textArea_DescripcionArmadura.setBounds(97, 392, 300, 65);
		panel_Armaduras.add(textArea_DescripcionArmadura);

		String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();

		Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);
		lbl_Respuestapoderdefensarmadura.setText(String.valueOf(armadura.getPoderDefensa()));
		lbl_RespuestaresistenciaArmadura.setText(armadura.getResistenciaArmadura().toString());
		lbl_RespuestadebilidadArmadura.setText(armadura.getDebilidadArmadura().toString());
		textArea_DescripcionArmadura.setText(armadura.getDescripcion());

		lbl_ArmaduraImagen = new JLabel();
		lbl_ArmaduraImagen.setBounds(150, 514, 200, 400);
		panel_Armaduras.add(lbl_ArmaduraImagen);

		URL location1 = this.getClass().getResource("/images/" + armadura.getImagePath());
		if (location1 != null) {
			ImageIcon icon = new ImageIcon(location1);
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(200, 400, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			lbl_ArmaduraImagen.setIcon(icon);
		} else {
			System.err.println("No se pudo encontrar la imagen: " + armadura.getImagePath());
		}
	}
}
