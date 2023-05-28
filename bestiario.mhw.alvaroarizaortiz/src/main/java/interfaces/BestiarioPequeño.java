package interfaces;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JTextArea;
import bd.MonstruoPequeñoBD;
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
	private JTextArea textArea_DescripcionMonstruo;

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

		JLabel lbl_BestiarioMonstruoPequeño = new JLabel("BESTIARIO - MONSTRUOS PEQUEÑOS");
		lbl_BestiarioMonstruoPequeño.setForeground(new Color(166, 38, 47));
		lbl_BestiarioMonstruoPequeño.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_BestiarioMonstruoPequeño.setBounds(335, 67, 400, 100);
		panelMonstruoPequeño.add(lbl_BestiarioMonstruoPequeño);

		lbl_NombreMonstruo = new JLabel("NombreMonstruo");
		lbl_NombreMonstruo.setForeground(new Color(42, 97, 88));
		lbl_NombreMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 24));
		lbl_NombreMonstruo.setBounds(195, 160, 300, 50);
		panelMonstruoPequeño.add(lbl_NombreMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(173, 208, 300, 300);
		panelMonstruoPequeño.add(lbl_ImagenMonstruo);

		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_EspecieMonstruo.setBounds(569, 220, 133, 30);
		panelMonstruoPequeño.add(lbl_EspecieMonstruo);

		lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaEspecieMonstruo.setBounds(712, 220, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaEspecieMonstruo);

		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TamañoMonstruo.setBounds(569, 250, 133, 30);
		panelMonstruoPequeño.add(lbl_TamañoMonstruo);

		lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaTamañoMonstruo.setBounds(712, 250, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaTamañoMonstruo);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_SaludMonstruo.setBounds(569, 280, 133, 30);
		panelMonstruoPequeño.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_respuestaSaludMonstruo.setBounds(712, 280, 168, 30);
		panelMonstruoPequeño.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_AtaqueMonstruo.setBounds(569, 310, 133, 30);
		panelMonstruoPequeño.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaAtaqueMonstruo.setBounds(712, 310, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaAtaqueMonstruo);

		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_LocalizacionMonstruo.setBounds(569, 340, 133, 30);
		panelMonstruoPequeño.add(lbl_LocalizacionMonstruo);

		lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaLocalizacionMonstruo.setBounds(712, 340, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaLocalizacionMonstruo);

		JLabel lbl_HostilMonstruo = new JLabel("¿Es hostil?");
		lbl_HostilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_HostilMonstruo.setBounds(569, 370, 133, 30);
		panelMonstruoPequeño.add(lbl_HostilMonstruo);

		lbl_RespuestaHostilMonstruo = new JLabel("Respuesta hostil");
		lbl_RespuestaHostilMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaHostilMonstruo.setBounds(712, 370, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaHostilMonstruo);

		JLabel lbl_MontarMonstruo = new JLabel("¿Es montable?");
		lbl_MontarMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_MontarMonstruo.setBounds(569, 400, 133, 30);
		panelMonstruoPequeño.add(lbl_MontarMonstruo);

		lbl_RespuestaMontarMonstruo = new JLabel("Respuesta montar monstruo");
		lbl_RespuestaMontarMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaMontarMonstruo.setBounds(712, 400, 168, 30);
		panelMonstruoPequeño.add(lbl_RespuestaMontarMonstruo);

		textArea_DescripcionMonstruo = new JTextArea();
		textArea_DescripcionMonstruo.setForeground(Color.WHITE);
		textArea_DescripcionMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		textArea_DescripcionMonstruo.setBackground(new Color(42, 97, 88));
		textArea_DescripcionMonstruo.setLineWrap(true);
		textArea_DescripcionMonstruo.setWrapStyleWord(true);
		textArea_DescripcionMonstruo.setEditable(false);
		textArea_DescripcionMonstruo.setBounds(140, 528, 369, 117);
		panelMonstruoPequeño.add(textArea_DescripcionMonstruo);

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
		panelMonstruoPequeño.add(btn_Anterior);

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
		panelMonstruoPequeño.add(btn_Siguiente);

	}
}
