package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.ArmaBD;
import clases.Arma;

import java.awt.CardLayout;
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

public class ArmaArmadura extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_RespuestatipoArma;
	private JLabel lbl_RespuestapoderataqueArma;
	private JLabel lbl_RespuestaelementoataqueArma;
	private JLabel lbl_ArmaImagen;
	private JTextArea textArea_DescripcionArma;

	public ArmaArmadura(MainInterface madre, boolean modal) {
		setTitle("Armas y Armaduras");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel panel_Armas = new JPanel();
		panel_Armas.setBounds(10, 11, 375, 539);
		contentPanel.add(panel_Armas);
		panel_Armas.setLayout(null);

		JLabel lblNewLabel = new JLabel("ARMAS");
		lblNewLabel.setBounds(124, 0, 132, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Armas.add(lblNewLabel);

		JComboBox comboBox_Armas = new JComboBox();
		ArmaBD armaBD = new ArmaBD();
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
					Image newimg = image.getScaledInstance(180, 180, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + arma.getImagePath());
				}
				 String primerArma = nombresArmas.get(0);
			}
		});

		comboBox_Armas.setBounds(78, 56, 201, 34);
		panel_Armas.add(comboBox_Armas);

		JLabel lbl_TipoArma = new JLabel("Tipo de arma");
		lbl_TipoArma.setBounds(10, 120, 110, 26);
		panel_Armas.add(lbl_TipoArma);

		lbl_RespuestatipoArma = new JLabel("Respuesta tipo arma");
		lbl_RespuestatipoArma.setBounds(198, 116, 192, 26);
		panel_Armas.add(lbl_RespuestatipoArma);

		JLabel lbl_PoderAtaqueArma = new JLabel("Poder de ataque");
		lbl_PoderAtaqueArma.setBounds(10, 166, 90, 26);
		panel_Armas.add(lbl_PoderAtaqueArma);

		lbl_RespuestapoderataqueArma = new JLabel("Respuesta poder ataque");
		lbl_RespuestapoderataqueArma.setBounds(198, 166, 124, 26);
		panel_Armas.add(lbl_RespuestapoderataqueArma);

		JLabel lbl_ElementoAtaque = new JLabel("Elemento");
		lbl_ElementoAtaque.setBounds(10, 206, 90, 26);
		panel_Armas.add(lbl_ElementoAtaque);

		lbl_RespuestaelementoataqueArma = new JLabel("Respuesta elemento ataque");
		lbl_RespuestaelementoataqueArma.setBounds(198, 206, 135, 26);
		panel_Armas.add(lbl_RespuestaelementoataqueArma);

		lbl_ArmaImagen = new JLabel("Imagen del arma");
		lbl_ArmaImagen.setBounds(95, 355, 184, 184);
		panel_Armas.add(lbl_ArmaImagen);

		textArea_DescripcionArma = new JTextArea();
		textArea_DescripcionArma.setBackground(Color.LIGHT_GRAY);
		textArea_DescripcionArma.setLineWrap(true);
		textArea_DescripcionArma.setWrapStyleWord(true);
		textArea_DescripcionArma.setEditable(false);
		textArea_DescripcionArma.setBounds(28, 255, 302, 100);
		panel_Armas.add(textArea_DescripcionArma);

		JPanel panel_Armaduras = new JPanel();
		panel_Armaduras.setBounds(400, 11, 375, 539);
		contentPanel.add(panel_Armaduras);
		panel_Armaduras.setLayout(null);

		JLabel lbl_Armaduras = new JLabel("ARMADURAS");
		lbl_Armaduras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_Armaduras.setBounds(124, 17, 113, 25);
		panel_Armaduras.add(lbl_Armaduras);

		JComboBox comboBox_Armaduras = new JComboBox();
		comboBox_Armaduras.setBounds(86, 56, 201, 34);
		panel_Armaduras.add(comboBox_Armaduras);

		JLabel lbl_PoderDefensaArmadura = new JLabel("Poder de defensa");
		lbl_PoderDefensaArmadura.setBounds(23, 111, 100, 14);
		panel_Armaduras.add(lbl_PoderDefensaArmadura);

		JLabel lbl_Respuestapoderdefensarmadura = new JLabel("Respuesta poder defensa");
		lbl_Respuestapoderdefensarmadura.setBounds(191, 111, 133, 14);
		panel_Armaduras.add(lbl_Respuestapoderdefensarmadura);

		JLabel lbl_ResistenciaArmadura = new JLabel("Resistencia");
		lbl_ResistenciaArmadura.setBounds(23, 136, 88, 14);
		panel_Armaduras.add(lbl_ResistenciaArmadura);

		JLabel lbl_RespuestaresistenciaArmadura = new JLabel("Respuesta resistencia");
		lbl_RespuestaresistenciaArmadura.setBounds(191, 136, 113, 14);
		panel_Armaduras.add(lbl_RespuestaresistenciaArmadura);

		JLabel lbl_DebilidadArmadura = new JLabel("Debilidad");
		lbl_DebilidadArmadura.setBounds(23, 161, 68, 14);
		panel_Armaduras.add(lbl_DebilidadArmadura);

		JLabel lbl_RespuestadebilidadArmadura = new JLabel("Respuesta debilidad");
		lbl_RespuestadebilidadArmadura.setBounds(191, 161, 100, 14);
		panel_Armaduras.add(lbl_RespuestadebilidadArmadura);

		JLabel lbl_DescripcionArmadura = new JLabel("Descripcion");
		lbl_DescripcionArmadura.setBounds(23, 186, 301, 57);
		panel_Armaduras.add(lbl_DescripcionArmadura);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(68, 268, 232, 260);
		panel_Armaduras.add(lblNewLabel_1);
	}
}
