package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import bd.ArmaBD;
import bd.ArmaduraBD;
import bd.CazadorBD;
import bd.MonstruoBD;
import bd.MonstruoGrandeBD;
import clases.Arma;
import clases.Armadura;
import clases.Cazador;
import clases.Monstruo;
import clases.MonstruoGrande;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class CombateInterface extends JDialog {
	// AQUÍ ARRIBA ESTÁN TODAS LAS INSTANCIAS Y VARIABLES DECLARADAS.
	private PantallaCombate pantallacombate;
	private final JPanel contentPanel = new JPanel();
	MonstruoGrandeBD monstruoGrandeBD = new MonstruoGrandeBD();
	private ArmaBD armaBD = new ArmaBD();
	private ArmaduraBD armaduraBD = new ArmaduraBD();
	List<MonstruoGrande> monstruos = monstruoGrandeBD.listarMonstruosGrandes();
	private Cazador cazador;
	private MonstruoGrande monstruoGrande;

	// LAS JLABEL, COMBOBOX, BOTONES QUE SON NECESARIOS DECLARAR ARRIBA. LAS QUE NO
	// INTERACTUAN CON LA BASE DE DATOS NO ESTÁN AQUÍ YA QUE NO ES NECESARIO.
	private JComboBox<String> comboBox_Armas;
	private JComboBox<String> comboBox_Armaduras;
	private JLabel lbl_ImagenMonstruo;
	private JLabel lbl_RespuestaAtaqueMonstruo;
	private JLabel lbl_respuestaSaludMonstruo;
	private JLabel lbl_RespuestatipoArma;
	private JLabel lbl_RespuestapoderataqueArma;
	private JLabel lbl_RespuestaelementoataqueArma;
	private JLabel lbl_ArmaImagen;
	private JLabel lbl_Respuestapoderdefensarmadura;
	private JLabel lbl_RespuestaresistenciaArmadura;
	private JLabel lbl_RespuestadebilidadArmadura;
	private JLabel lbl_ArmaduraImagen;
	private JTextField textField_RespuestaNombreCazador;

	public CombateInterface(MainInterface madre, boolean modal) {
		pantallacombate = new PantallaCombate(cazador, monstruoGrande);
		pantallacombate.setVisible(false);
		setBounds(100, 100, 1000, 1000);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setBounds(682, 155, 46, 14);
		contentPanel.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setBounds(793, 155, 100, 14);
		contentPanel.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setBounds(682, 189, 46, 14);
		contentPanel.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setBounds(780, 189, 100, 14);
		contentPanel.add(lbl_RespuestaAtaqueMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(679, 374, 246, 292);
		contentPanel.add(lbl_ImagenMonstruo);

		JPanel panel_Cazador = new JPanel();
		panel_Cazador.setBounds(10, 26, 586, 549);
		contentPanel.add(panel_Cazador);
		panel_Cazador.setLayout(null);
		panel_Cazador.setVisible(false);

		JLabel lbl_ArmaduraequipadaCazador = new JLabel("Armadura equipada");
		lbl_ArmaduraequipadaCazador.setBounds(41, 78, 108, 14);
		panel_Cazador.add(lbl_ArmaduraequipadaCazador);

		JLabel lbl_ArmaequipadaCazador = new JLabel("Arma equipada");
		lbl_ArmaequipadaCazador.setBounds(41, 196, 76, 14);
		panel_Cazador.add(lbl_ArmaequipadaCazador);

		JLabel lbl_TipoArma = new JLabel("Tipo de arma");
		lbl_TipoArma.setBounds(36, 231, 110, 26);
		panel_Cazador.add(lbl_TipoArma);

		lbl_RespuestatipoArma = new JLabel((String) null);
		lbl_RespuestatipoArma.setBounds(159, 233, 192, 26);
		panel_Cazador.add(lbl_RespuestatipoArma);

		JLabel lbl_PoderAtaqueArma = new JLabel("Poder de ataque");
		lbl_PoderAtaqueArma.setBounds(36, 271, 90, 26);
		panel_Cazador.add(lbl_PoderAtaqueArma);

		lbl_RespuestapoderataqueArma = new JLabel("0");
		lbl_RespuestapoderataqueArma.setBounds(194, 269, 124, 26);
		panel_Cazador.add(lbl_RespuestapoderataqueArma);

		JLabel lbl_ElementoAtaque = new JLabel("Elemento");
		lbl_ElementoAtaque.setBounds(36, 313, 90, 26);
		panel_Cazador.add(lbl_ElementoAtaque);

		lbl_RespuestaelementoataqueArma = new JLabel((String) null);
		lbl_RespuestaelementoataqueArma.setBounds(178, 312, 135, 26);
		panel_Cazador.add(lbl_RespuestaelementoataqueArma);

		lbl_ArmaImagen = new JLabel();
		lbl_ArmaImagen.setBounds(383, 313, 171, 173);
		panel_Cazador.add(lbl_ArmaImagen);

		JLabel lbl_PoderDefensaArmadura = new JLabel("Poder de defensa");
		lbl_PoderDefensaArmadura.setBounds(41, 114, 100, 14);
		panel_Cazador.add(lbl_PoderDefensaArmadura);

		lbl_Respuestapoderdefensarmadura = new JLabel("0");
		lbl_Respuestapoderdefensarmadura.setBounds(168, 114, 133, 14);
		panel_Cazador.add(lbl_Respuestapoderdefensarmadura);

		JLabel lbl_ResistenciaArmadura = new JLabel("Resistencia");
		lbl_ResistenciaArmadura.setBounds(41, 135, 88, 14);
		panel_Cazador.add(lbl_ResistenciaArmadura);

		lbl_RespuestaresistenciaArmadura = new JLabel((String) null);
		lbl_RespuestaresistenciaArmadura.setBounds(153, 135, 113, 14);
		panel_Cazador.add(lbl_RespuestaresistenciaArmadura);

		JLabel lbl_DebilidadArmadura = new JLabel("Debilidad");
		lbl_DebilidadArmadura.setBounds(41, 154, 68, 14);
		panel_Cazador.add(lbl_DebilidadArmadura);

		lbl_RespuestadebilidadArmadura = new JLabel((String) null);
		lbl_RespuestadebilidadArmadura.setBounds(151, 151, 100, 14);
		panel_Cazador.add(lbl_RespuestadebilidadArmadura);

		lbl_ArmaduraImagen = new JLabel();
		lbl_ArmaduraImagen.setBounds(381, 101, 173, 173);
		panel_Cazador.add(lbl_ArmaduraImagen);

		// BOTÓN QUE PERMITE CREAR EL CAZADOR. AL PRESIONARLO, EL PROGRAMA CREA UN
		// CAZADOR CON EL ARMA Y ARMADURA SELECCIONADA EN LA BASE DE DATOS.
		JButton btnCrearCazador = new JButton("Crear cazador");
		btnCrearCazador.setBounds(241, 386, 120, 25);
		panel_Cazador.add(btnCrearCazador);

		btnCrearCazador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
				String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();
				String nombreCazador = textField_RespuestaNombreCazador.getText();

				Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
				Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);

				Cazador cazador = new Cazador(5000, armadura, arma, nombreCazador);
				CazadorBD cazadorBD = new CazadorBD();
				cazadorBD.insertCazador(cazador);

			}
		});

		// COMBOBOX DE ARMAS PARA PODER ELEGIR EL ARMA DEL INVENTARIO PARA EL CAZADOR.
		comboBox_Armas = new JComboBox<String>();
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

		comboBox_Armas.setBounds(163, 192, 171, 22);
		panel_Cazador.add(comboBox_Armas);

		// COMBOBOX DE ARMADURAS PARA PODER ELEGIR LA ARMADURA DEL INVENTARIO PARA EL
		// CAZADOR.
		comboBox_Armaduras = new JComboBox<String>();
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

				URL location1 = this.getClass().getResource("/images/" + armadura.getImagePath());
				if (location1 != null) {
					ImageIcon icon = new ImageIcon(location1);
					Image image = icon.getImage();
					Image newimg = image.getScaledInstance(250, 500, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaduraImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + armadura.getImagePath());
				}
			}
		});
		comboBox_Armaduras.setBounds(159, 78, 166, 22);
		panel_Cazador.add(comboBox_Armaduras);

		JComboBox<String> comboBox_Monstruo = new JComboBox<>();
		List<MonstruoGrande> monstruosGrandes = monstruoGrandeBD.listarMonstruosGrandes();

		for (MonstruoGrande monstruoGrande : monstruosGrandes) {
			String nombreMonstruo = monstruoGrande.getNombre();
			comboBox_Monstruo.addItem(nombreMonstruo);
		}

		comboBox_Monstruo.setBounds(704, 111, 189, 22);
		contentPanel.add(comboBox_Monstruo);

		comboBox_Monstruo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreMonstruoSeleccionado = (String) comboBox_Monstruo.getSelectedItem();
				MonstruoGrande monstruoGrandeSeleccionado = null;

				for (MonstruoGrande monstruoGrande : monstruosGrandes) {
					if (monstruoGrande.getNombre().equals(nombreMonstruoSeleccionado)) {
						monstruoGrandeSeleccionado = monstruoGrande;
						break;
					}
				}

				if (monstruoGrandeSeleccionado != null) {

					String rutaImagen = "/images/" + monstruoGrandeSeleccionado.getImagePath();
					URL urlImagen = getClass().getResource(rutaImagen);
					ImageIcon imageIcon = new ImageIcon(
							new ImageIcon(urlImagen).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
					lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPuntosSalud()));
					lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPoderAtaque()));
					lbl_ImagenMonstruo.setIcon(imageIcon);
				}
			}
		});

		JButton btn_CerrarInventario = new JButton("Cerrar ");
		btn_CerrarInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Cazador.setVisible(false);
			}
		});
		btn_CerrarInventario.setBounds(441, 32, 89, 23);
		panel_Cazador.add(btn_CerrarInventario);

		JLabel lblNewLabel = new JLabel("INVENTARIO");
		lblNewLabel.setBounds(218, 11, 133, 14);
		panel_Cazador.add(lblNewLabel);

		JButton btn_Inventario = new JButton("Inventario");
		btn_Inventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_Cazador.setVisible(true);
			}
		});
		btn_Inventario.setBounds(859, 11, 89, 23);
		contentPanel.add(btn_Inventario);

		JButton btn_Combate = new JButton("A LA BATALLA");
		btn_Combate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
				String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();
				String nombreCazador = textField_RespuestaNombreCazador.getText();

				Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
				Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);

				cazador = new Cazador(5000, armadura, arma, nombreCazador);

				String nombreMonstruoSeleccionado = (String) comboBox_Monstruo.getSelectedItem();
				monstruoGrande = monstruoGrandeBD.getMonstruoGrandePorNombre(nombreMonstruoSeleccionado);

				pantallacombate = new PantallaCombate(cazador, monstruoGrande);
				pantallacombate.setVisible(true);
			}
		});
		btn_Combate.setBounds(424, 643, 151, 48);
		contentPanel.add(btn_Combate);

		JComboBox<Cazador> comboBox_CargarCazador = new JComboBox<Cazador>();
		comboBox_CargarCazador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		CazadorBD cazadorBD = new CazadorBD();
		List<Cazador> cazadores = cazadorBD.getAllCazadores();
		comboBox_CargarCazador.removeAllItems();
		for (Cazador cazador : cazadores) {
			comboBox_CargarCazador.addItem(cazador);
		}
		
		comboBox_CargarCazador.setBounds(25, 45, 406, 22);
		panel_Cazador.add(comboBox_CargarCazador);

		JLabel lbl_NombreCazador = new JLabel("New label");
		lbl_NombreCazador.setBounds(41, 336, 46, 14);
		panel_Cazador.add(lbl_NombreCazador);

		textField_RespuestaNombreCazador = new JTextField();
		textField_RespuestaNombreCazador.setBounds(158, 333, 108, 20);
		panel_Cazador.add(textField_RespuestaNombreCazador);
		textField_RespuestaNombreCazador.setColumns(10);

		// ESTA ES LA ÚNICA FORMA REAL QUE HE DESCUBIERTO DE HACER QUE LOS COMBOBOX
		// EMPIECEN INICIALIZADOS.
		// PONER LOS CONSTRUCTORES AL FINAL SIN LA ETIQUETA DEL COMBOBOX.

		String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();
		Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);
		lbl_Respuestapoderdefensarmadura.setText(String.valueOf(armadura.getPoderDefensa()));
		lbl_RespuestaresistenciaArmadura.setText(armadura.getResistenciaArmadura().toString());
		lbl_RespuestadebilidadArmadura.setText(armadura.getDebilidadArmadura().toString());
		URL location1 = this.getClass().getResource("/images/" + armadura.getImagePath());
		if (location1 != null) {
			ImageIcon icon = new ImageIcon(location1);
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(250, 500, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			lbl_ArmaduraImagen.setIcon(icon);
		}

		String nombreMonstruoSeleccionado = (String) comboBox_Monstruo.getSelectedItem();
		MonstruoGrande monstruoGrandeSeleccionado = null;

		for (MonstruoGrande monstruoGrande : monstruosGrandes) {
			if (monstruoGrande.getNombre().equals(nombreMonstruoSeleccionado)) {
				monstruoGrandeSeleccionado = monstruoGrande;
				break;
			}
		}

		if (monstruoGrandeSeleccionado != null) {

			String rutaImagen = "/images/" + monstruoGrandeSeleccionado.getImagePath();
			URL urlImagen = getClass().getResource(rutaImagen);
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(urlImagen).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
			lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPuntosSalud()));
			lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPoderAtaque()));
			lbl_ImagenMonstruo.setIcon(imageIcon);
		}

		String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
		Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
		lbl_RespuestatipoArma.setText(arma.getTipoArma());
		lbl_RespuestapoderataqueArma.setText(String.valueOf(arma.getPoderAtaque()));
		lbl_RespuestaelementoataqueArma.setText(arma.getElementoAtaque().toString());
		URL location = this.getClass().getResource("/images/" + arma.getImagePath());
		if (location != null) {
			ImageIcon icon = new ImageIcon(location);
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(350, 350, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			lbl_ArmaImagen.setIcon(icon);

		}

	}
}
