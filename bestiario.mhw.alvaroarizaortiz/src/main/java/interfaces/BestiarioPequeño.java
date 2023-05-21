package interfaces;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.MonstruoPequeñoBD;
import clases.Monstruo;
import clases.MonstruoGrande;
import clases.MonstruoPequeño;

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
	private JButton btn_Anterior;
	private JButton btn_Siguiente;

	public void mostrarMonstruo(MonstruoPequeño monstruoPequeño) {
		String rutaImagen = "/images/" + monstruoPequeño.getImagePath();
		URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(urlImagen).getImage().getScaledInstance(190, 171, Image.SCALE_DEFAULT));
		lbl_ImagenMonstruo.setIcon(imageIcon);
		lbl_NombreMonstruo.setText(monstruoPequeño.getNombre());
		lbl_RespuestaEspecieMonstruo.setText(monstruoPequeño.getEspecie());
		lbl_RespuestaTamañoMonstruo.setText(String.valueOf(monstruoPequeño.getTamaño()));
		lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoPequeño.getPuntosSalud()));
		lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoPequeño.getPoderAtaque()));
		lbl_RespuestaLocalizacionMonstruo.setText(String.valueOf(monstruoPequeño.getNombreMapa()));
		lbl_RespuestaHostilMonstruo.setText(monstruoPequeño.isEsHostil() ? "Sí" : "No");
		lbl_RespuestaMontarMonstruo.setText(monstruoPequeño.isEsCabalgable() ? "Sí" : "No");
	}

	public BestiarioPequeño(MainInterface madre, boolean modal) {
		super(madre, modal);
		setTitle("BESTIARIO");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new CardLayout(0, 0));

		JPanel MonstruoPequeño = new JPanel();
		getContentPane().add(MonstruoPequeño, "name_50281680010900");
		MonstruoPequeño.setLayout(null);

		JLabel lbl_BestiarioMonstruoPequeño = new JLabel("BESTIARIO - MONSTRUOS PEQUEÑOS");
		lbl_BestiarioMonstruoPequeño.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoPequeño.setBounds(188, 38, 368, 27);
		MonstruoPequeño.add(lbl_BestiarioMonstruoPequeño);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setBounds(83, 133, 100, 14);
		MonstruoPequeño.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("ImagenMonstruo");
		lbl_ImagenMonstruo.setBounds(32, 202, 190, 171);
		MonstruoPequeño.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setBounds(298, 133, 90, 14);
		MonstruoPequeño.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setBounds(441, 133, 115, 14);
		MonstruoPequeño.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setBounds(298, 168, 46, 14);
		MonstruoPequeño.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setBounds(441, 168, 115, 14);
		MonstruoPequeño.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setBounds(298, 201, 46, 14);
		MonstruoPequeño.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setBounds(441, 201, 100, 14);
		MonstruoPequeño.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setBounds(298, 226, 46, 14);
		MonstruoPequeño.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setBounds(441, 226, 100, 14);
		MonstruoPequeño.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setBounds(298, 251, 90, 14);
		MonstruoPequeño.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setBounds(441, 251, 115, 14);
		MonstruoPequeño.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_HostilMonstruo = new JLabel("¿Es hostil?");
		lbl_HostilMonstruo.setBounds(298, 280, 46, 14);
		MonstruoPequeño.add(lbl_HostilMonstruo);

		lbl_RespuestaHostilMonstruo = new JLabel("Respuesta hostil");
		lbl_RespuestaHostilMonstruo.setBounds(441, 280, 115, 14);
		MonstruoPequeño.add(lbl_RespuestaHostilMonstruo);

		JLabel lbl_MontarMonstruo = new JLabel("¿Se puede montar?");
		lbl_MontarMonstruo.setBounds(257, 311, 131, 14);
		MonstruoPequeño.add(lbl_MontarMonstruo);

		lbl_RespuestaMontarMonstruo = new JLabel("Respuesta montar monstruo");
		lbl_RespuestaMontarMonstruo.setBounds(441, 311, 156, 14);
		MonstruoPequeño.add(lbl_RespuestaMontarMonstruo);

		if (!monstruos.isEmpty()) {
			mostrarMonstruo(monstruos.get(indexMonstruo));
		}

		btn_Anterior = new JButton("Anterior");
		btn_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo > 0) {
					indexMonstruo--;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Anterior.setBounds(217, 440, 89, 23);
		MonstruoPequeño.add(btn_Anterior);

		btn_Siguiente = new JButton("Siguiente");
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (indexMonstruo < monstruos.size() - 1) {
					indexMonstruo++;
					mostrarMonstruo(monstruos.get(indexMonstruo));
				}
			}
		});
		btn_Siguiente.setBounds(452, 440, 89, 23);
		MonstruoPequeño.add(btn_Siguiente);

	}
}
