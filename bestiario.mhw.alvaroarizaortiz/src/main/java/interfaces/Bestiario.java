package interfaces;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import bd.MonstruoGrandeBD;
import clases.MonstruoGrande;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
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

		ImageIcon rawmg = new ImageIcon(getClass().getResource("/images/mg.png"));
		Image imagemg = rawmg.getImage().getScaledInstance(430, 169, Image.SCALE_SMOOTH);
		ImageIcon finalIcon = new ImageIcon(imagemg);
		JLabel lbl_BestiarioMonstruoGrande = new JLabel("");
		lbl_BestiarioMonstruoGrande.setIcon(finalIcon);
		lbl_BestiarioMonstruoGrande.setForeground(new Color(166, 38, 47));
		lbl_BestiarioMonstruoGrande.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoGrande.setBounds(285, 35, 430, 169);
		Monstruo.add(lbl_BestiarioMonstruoGrande);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setForeground(new Color(42, 97, 88));
		lbl_NombreMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 24));
		lbl_NombreMonstruo.setBounds(217, 198, 300, 50);
		Monstruo.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(173, 245, 300, 300);
		Monstruo.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_EspecieMonstruo.setBounds(569, 257, 133, 30);
		Monstruo.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaEspecieMonstruo.setBounds(712, 257, 168, 30);
		Monstruo.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TamañoMonstruo.setBounds(569, 287, 133, 30);
		Monstruo.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaTamañoMonstruo.setBounds(712, 287, 168, 30);
		Monstruo.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_SaludMonstruo.setBounds(569, 347, 133, 30);
		Monstruo.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_respuestaSaludMonstruo.setBounds(712, 347, 168, 30);
		Monstruo.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_AtaqueMonstruo.setBounds(569, 317, 133, 30);
		Monstruo.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaAtaqueMonstruo.setBounds(712, 317, 168, 30);
		Monstruo.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_LocalizacionMonstruo.setBounds(569, 377, 133, 30);
		Monstruo.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaLocalizacionMonstruo.setBounds(712, 377, 168, 30);
		Monstruo.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_CapturaMonstruo = new JLabel("¿Es capturable?");
		lbl_CapturaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_CapturaMonstruo.setBounds(569, 407, 133, 30);
		Monstruo.add(lbl_CapturaMonstruo);

		lbl_RespuestaCapturaMonstruo = new JLabel("Respuesta Captura");
		lbl_RespuestaCapturaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaCapturaMonstruo.setBounds(712, 407, 168, 30);
		Monstruo.add(lbl_RespuestaCapturaMonstruo);

		JLabel lbl_ResistenciaMonstruo = new JLabel("Resistecia");
		lbl_ResistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ResistenciaMonstruo.setBounds(569, 437, 133, 30);
		Monstruo.add(lbl_ResistenciaMonstruo);

		lbl_RespuestaResistenciaMonstruo = new JLabel("Respuesta resistencia");
		lbl_RespuestaResistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaResistenciaMonstruo.setBounds(712, 437, 168, 30);
		Monstruo.add(lbl_RespuestaResistenciaMonstruo);

		JLabel lbl_DebilidadMonstruo = new JLabel("Debilidad");
		lbl_DebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_DebilidadMonstruo.setBounds(569, 467, 133, 30);
		Monstruo.add(lbl_DebilidadMonstruo);

		lbl_RepuestaDebilidadMonstruo = new JLabel("Respuesta debilidad");
		lbl_RepuestaDebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RepuestaDebilidadMonstruo.setBounds(712, 467, 168, 30);
		Monstruo.add(lbl_RepuestaDebilidadMonstruo);

		JLabel lbl_PuntoDebilMonstruo = new JLabel("Punto débil");
		lbl_PuntoDebilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PuntoDebilMonstruo.setBounds(569, 497, 133, 30);
		Monstruo.add(lbl_PuntoDebilMonstruo);

		lbl_RespuestaPuntoDebilMonstruo = new JLabel("Respuesta punto debil");
		lbl_RespuestaPuntoDebilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaPuntoDebilMonstruo.setBounds(712, 497, 168, 30);
		Monstruo.add(lbl_RespuestaPuntoDebilMonstruo);

		textArea_DescripcionMonstruo = new JTextArea();
		textArea_DescripcionMonstruo.setForeground(Color.WHITE);
		textArea_DescripcionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		textArea_DescripcionMonstruo.setBackground(new Color(42, 97, 88));
		textArea_DescripcionMonstruo.setLineWrap(true);
		textArea_DescripcionMonstruo.setWrapStyleWord(true);
		textArea_DescripcionMonstruo.setEditable(false);
		textArea_DescripcionMonstruo.setBounds(140, 565, 369, 117);
		Monstruo.add(textArea_DescripcionMonstruo);

		if (!monstruos.isEmpty()) {
			mostrarMonstruo(monstruos.get(indexMonstruo));
		}

		ImageIcon rawIzquierda = new ImageIcon(getClass().getResource("/images/izquierda.png"));
		Image imagenIzquierda = rawIzquierda.getImage().getScaledInstance(75, 85, Image.SCALE_SMOOTH); 
		ImageIcon botonIzquierda = new ImageIcon(imagenIzquierda);
		JButton btn_Anterior = new JButton(botonIzquierda);
		btn_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo > 0) {
					indexMonstruo--;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Anterior.setBounds(627, 582, 75, 85);
		Monstruo.add(btn_Anterior);

		ImageIcon rawDerecha = new ImageIcon(getClass().getResource("/images/derecha.png"));
		Image imagenDerecha = rawDerecha.getImage().getScaledInstance(75, 85, Image.SCALE_SMOOTH); 
		ImageIcon botonDerecha = new ImageIcon(imagenDerecha);
		JButton btn_Siguiente = new JButton(botonDerecha);
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo < monstruos.size() - 1) {
					indexMonstruo++;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});

		btn_Siguiente.setBounds(752, 582, 75, 85);
		Monstruo.add(btn_Siguiente);
	}
}
