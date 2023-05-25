package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.MonstruoGrandeBD;
import clases.Monstruo;
import clases.MonstruoGrande;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Bestiario extends JDialog {
	MonstruoGrandeBD monstruoGrandeBD = new MonstruoGrandeBD();
	List<MonstruoGrande> monstruos = monstruoGrandeBD.listarMonstruosGrandes();

	private int indexMonstruo = 0;
	private JLabel lbl_NombreMonstruo;
	private JLabel lbl_ImagenMonstruo;
	private JLabel lbl_RespuestaEspecieMonstruo;
	private JLabel lbl_RespuestaTamañoMonstruo;
	private JLabel lbl_RespuestaAtaqueMonstruo;
	private JLabel lbl_respuestaSaludMonstruo;
	private JLabel lbl_RespuestaLocalizacionMonstruo;
	private JLabel lbl_RespuestaCapturaMonstruo;
	private JLabel lbl_RespuestaResistenciaMonstruo;
	private JLabel lbl_RepuestaDebilidadMonstruo;
	private JLabel lbl_RespuestaPuntoDebilMonstruo;
	private JTextArea textArea_DescripcionMonstruo;

	public void mostrarMonstruo(MonstruoGrande monstruo) {
		String rutaImagen = "/images/" + monstruo.getImagePath();
		URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(urlImagen).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
		lbl_ImagenMonstruo.setIcon(imageIcon);
		lbl_NombreMonstruo.setText(monstruo.getNombre());
		lbl_RespuestaEspecieMonstruo.setText(monstruo.getEspecie());
		lbl_RespuestaTamañoMonstruo.setText(String.valueOf(monstruo.getTamaño()));
		lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruo.getPuntosSalud()));
		lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruo.getPoderAtaque()));
		lbl_RespuestaLocalizacionMonstruo.setText(String.valueOf(monstruo.getNombreMapa()));
		lbl_RespuestaCapturaMonstruo.setText(monstruo.isEsCapturable() ? "Sí" : "No");
		lbl_RespuestaResistenciaMonstruo.setText(monstruo.getResistencias().toString());
		lbl_RepuestaDebilidadMonstruo.setText(monstruo.getDebilidades().toString());
		lbl_RespuestaPuntoDebilMonstruo.setText(monstruo.getPuntoDebil());
		textArea_DescripcionMonstruo.setText(monstruo.getDescripcion());
	}

	public Bestiario(MainInterface madre, boolean modal) {
		super(madre, modal);
		setTitle("BESTIARIO DE MONSTRUOS GRANDES");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel Monstruo = new JPanel();
		getContentPane().add(Monstruo, "name_50281680010900");
		Monstruo.setLayout(null);

		JLabel lbl_BestiarioMonstruoGrande = new JLabel("BESTIARIO - MONSTRUOS GRANDES");
		lbl_BestiarioMonstruoGrande.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoGrande.setBounds(293, 35, 368, 27);
		Monstruo.add(lbl_BestiarioMonstruoGrande);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setBounds(98, 98, 100, 14);
		Monstruo.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(23, 140, 250, 250);
		Monstruo.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setBounds(293, 129, 90, 14);
		Monstruo.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setBounds(436, 129, 115, 14);
		Monstruo.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setBounds(293, 164, 46, 14);
		Monstruo.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setBounds(436, 164, 115, 14);
		Monstruo.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setBounds(293, 197, 46, 14);
		Monstruo.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setBounds(436, 197, 100, 14);
		Monstruo.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setBounds(293, 222, 46, 14);
		Monstruo.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setBounds(436, 222, 100, 14);
		Monstruo.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setBounds(293, 247, 90, 14);
		Monstruo.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setBounds(436, 247, 115, 14);
		Monstruo.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_CapturaMonstruo = new JLabel("¿Es capturable?");
		lbl_CapturaMonstruo.setBounds(293, 276, 90, 14);
		Monstruo.add(lbl_CapturaMonstruo);

		lbl_RespuestaCapturaMonstruo = new JLabel("Respuesta Captura");
		lbl_RespuestaCapturaMonstruo.setBounds(436, 276, 100, 14);
		Monstruo.add(lbl_RespuestaCapturaMonstruo);

		JLabel lbl_ResistenciaMonstruo = new JLabel("Resistecia");
		lbl_ResistenciaMonstruo.setBounds(293, 311, 68, 14);
		Monstruo.add(lbl_ResistenciaMonstruo);

		lbl_RespuestaResistenciaMonstruo = new JLabel("Respuesta resistencia");
		lbl_RespuestaResistenciaMonstruo.setBounds(436, 311, 115, 14);
		Monstruo.add(lbl_RespuestaResistenciaMonstruo);

		JLabel lbl_DebilidadMonstruo = new JLabel("Debilidad");
		lbl_DebilidadMonstruo.setBounds(293, 341, 46, 14);
		Monstruo.add(lbl_DebilidadMonstruo);

		lbl_RepuestaDebilidadMonstruo = new JLabel("Respuesta debilidad");
		lbl_RepuestaDebilidadMonstruo.setBounds(436, 341, 100, 14);
		Monstruo.add(lbl_RepuestaDebilidadMonstruo);

		JLabel lbl_PuntoDebilMonstruo = new JLabel("Punto débil");
		lbl_PuntoDebilMonstruo.setBounds(293, 372, 68, 14);
		Monstruo.add(lbl_PuntoDebilMonstruo);

		lbl_RespuestaPuntoDebilMonstruo = new JLabel("Respuesta punto debil");
		lbl_RespuestaPuntoDebilMonstruo.setBounds(436, 372, 100, 14);
		Monstruo.add(lbl_RespuestaPuntoDebilMonstruo);

		textArea_DescripcionMonstruo = new JTextArea();
		textArea_DescripcionMonstruo.setBackground(Color.LIGHT_GRAY);
		textArea_DescripcionMonstruo.setLineWrap(true);
		textArea_DescripcionMonstruo.setWrapStyleWord(true);
		textArea_DescripcionMonstruo.setEditable(false);
		textArea_DescripcionMonstruo.setBounds(23, 417, 287, 140);
		Monstruo.add(textArea_DescripcionMonstruo);

		if (!monstruos.isEmpty()) {
			mostrarMonstruo(monstruos.get(indexMonstruo));
		}

		JButton btn_Anterior = new JButton("Anterior");
		btn_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo > 0) {
					indexMonstruo--;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Anterior.setBounds(335, 465, 89, 23);
		Monstruo.add(btn_Anterior);

		JButton btn_Siguiente = new JButton("Siguiente");
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo < monstruos.size() - 1) {
					indexMonstruo++;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});

		btn_Siguiente.setBounds(452, 465, 89, 23);
		Monstruo.add(btn_Siguiente);
	}
}
