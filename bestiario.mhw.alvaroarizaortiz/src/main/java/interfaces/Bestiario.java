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
				new ImageIcon(urlImagen).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH));
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
		setBounds(100, 100, 1000, 800);
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel Monstruo = new JPanel();
		Monstruo.setBackground(new Color(230, 230, 230));
		getContentPane().add(Monstruo, "name_50281680010900");
		Monstruo.setLayout(null);

		JLabel lbl_BestiarioMonstruoGrande = new JLabel("BESTIARIO - MONSTRUOS GRANDES");
		lbl_BestiarioMonstruoGrande.setForeground(new Color(166, 38, 47));
		lbl_BestiarioMonstruoGrande.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoGrande.setBounds(335, 67, 400, 100);
		Monstruo.add(lbl_BestiarioMonstruoGrande);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setForeground(new Color(42, 97, 88));
		lbl_NombreMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 24));
		lbl_NombreMonstruo.setBounds(195, 160, 300, 50);
		Monstruo.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(173, 208, 300, 300);
		Monstruo.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_EspecieMonstruo.setBounds(569, 220, 133, 30);
		Monstruo.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaEspecieMonstruo.setBounds(712, 220, 168, 30);
		Monstruo.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TamañoMonstruo.setBounds(569, 250, 133, 30);
		Monstruo.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaTamañoMonstruo.setBounds(712, 250, 168, 30);
		Monstruo.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_SaludMonstruo.setBounds(569, 310, 133, 30);
		Monstruo.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_respuestaSaludMonstruo.setBounds(712, 310, 168, 30);
		Monstruo.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_AtaqueMonstruo.setBounds(569, 280, 133, 30);
		Monstruo.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaAtaqueMonstruo.setBounds(712, 280, 168, 30);
		Monstruo.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_LocalizacionMonstruo.setBounds(569, 340, 133, 30);
		Monstruo.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaLocalizacionMonstruo.setBounds(712, 340, 168, 30);
		Monstruo.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_CapturaMonstruo = new JLabel("¿Es capturable?");
		lbl_CapturaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_CapturaMonstruo.setBounds(569, 370, 133, 30);
		Monstruo.add(lbl_CapturaMonstruo);

		lbl_RespuestaCapturaMonstruo = new JLabel("Respuesta Captura");
		lbl_RespuestaCapturaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaCapturaMonstruo.setBounds(712, 370, 168, 30);
		Monstruo.add(lbl_RespuestaCapturaMonstruo);

		JLabel lbl_ResistenciaMonstruo = new JLabel("Resistecia");
		lbl_ResistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ResistenciaMonstruo.setBounds(569, 400, 133, 30);
		Monstruo.add(lbl_ResistenciaMonstruo);

		lbl_RespuestaResistenciaMonstruo = new JLabel("Respuesta resistencia");
		lbl_RespuestaResistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaResistenciaMonstruo.setBounds(712, 400, 168, 30);
		Monstruo.add(lbl_RespuestaResistenciaMonstruo);

		JLabel lbl_DebilidadMonstruo = new JLabel("Debilidad");
		lbl_DebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_DebilidadMonstruo.setBounds(569, 430, 133, 30);
		Monstruo.add(lbl_DebilidadMonstruo);

		lbl_RepuestaDebilidadMonstruo = new JLabel("Respuesta debilidad");
		lbl_RepuestaDebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RepuestaDebilidadMonstruo.setBounds(712, 430, 168, 30);
		Monstruo.add(lbl_RepuestaDebilidadMonstruo);

		JLabel lbl_PuntoDebilMonstruo = new JLabel("Punto débil");
		lbl_PuntoDebilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PuntoDebilMonstruo.setBounds(569, 460, 133, 30);
		Monstruo.add(lbl_PuntoDebilMonstruo);

		lbl_RespuestaPuntoDebilMonstruo = new JLabel("Respuesta punto debil");
		lbl_RespuestaPuntoDebilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaPuntoDebilMonstruo.setBounds(712, 460, 168, 30);
		Monstruo.add(lbl_RespuestaPuntoDebilMonstruo);

		textArea_DescripcionMonstruo = new JTextArea();
		textArea_DescripcionMonstruo.setForeground(Color.WHITE);
		textArea_DescripcionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		textArea_DescripcionMonstruo.setBackground(new Color(42, 97, 88));
		textArea_DescripcionMonstruo.setLineWrap(true);
		textArea_DescripcionMonstruo.setWrapStyleWord(true);
		textArea_DescripcionMonstruo.setEditable(false);
		textArea_DescripcionMonstruo.setBounds(140, 528, 369, 117);
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
		btn_Anterior.setBounds(569, 572, 89, 23);
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

		btn_Siguiente.setBounds(712, 572, 89, 23);
		Monstruo.add(btn_Siguiente);
	}
}
