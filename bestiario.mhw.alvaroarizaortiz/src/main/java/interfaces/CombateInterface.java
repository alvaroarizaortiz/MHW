package interfaces;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.ArmaBD;
import bd.ArmaduraBD;
import bd.CazadorBD;
import bd.MonstruoGrandeBD;
import clases.Arma;
import clases.Armadura;
import clases.Cazador;
import clases.MonstruoGrande;
import excepciones.NombreCazadorVacio;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class CombateInterface extends JDialog {

	private PantallaCombate pantallacombate;
	private final JPanel contentPanel = new JPanel();
	private MonstruoGrandeBD monstruoGrandeBD = new MonstruoGrandeBD();
	private ArmaBD armaBD = new ArmaBD();
	private ArmaduraBD armaduraBD = new ArmaduraBD();
	private Cazador cazador;
	private MonstruoGrande monstruoGrande;

	private JComboBox<String> comboBox_Armas;
	private JComboBox<String> comboBox_Armaduras;
	private JComboBox<Cazador> comboBox_CargarCazador;
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
	private JLabel lbl_RespuestaresistenciaMonstruo;
	private JLabel lbl_RespuestadebilidadMonstruo;
	private JLabel lbl_eligepersonaje;
	private JLabel lbl_eligemonstruo;

	public CombateInterface(MainInterface madre, boolean modal) {
		setTitle("EQUÍPATE PARA EL COMBATE");
		pantallacombate = new PantallaCombate(cazador, monstruoGrande);
		pantallacombate.setVisible(false);
		setBounds(100, 100, 1200, 900);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(230, 230, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_SaludMonstruo.setBounds(796, 230, 100, 40);
		contentPanel.add(lbl_SaludMonstruo);

		lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_respuestaSaludMonstruo.setBounds(959, 232, 100, 40);
		contentPanel.add(lbl_respuestaSaludMonstruo);

		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_AtaqueMonstruo.setBounds(796, 270, 100, 40);
		contentPanel.add(lbl_AtaqueMonstruo);

		lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaAtaqueMonstruo.setBounds(959, 270, 100, 40);
		contentPanel.add(lbl_RespuestaAtaqueMonstruo);

		lbl_ImagenMonstruo = new JLabel("");
		lbl_ImagenMonstruo.setBounds(796, 419, 250, 250);
		contentPanel.add(lbl_ImagenMonstruo);

		JPanel panel_Cazador = new JPanel();
		panel_Cazador.setBackground(new Color(230, 230, 230));
		panel_Cazador.setBounds(88, 124, 680, 726);
		contentPanel.add(panel_Cazador);
		panel_Cazador.setLayout(null);

		JLabel lbl_ArmaduraequipadaCazador = new JLabel("Armadura equipada");
		lbl_ArmaduraequipadaCazador.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ArmaduraequipadaCazador.setBounds(41, 50, 169, 40);
		panel_Cazador.add(lbl_ArmaduraequipadaCazador);

		JLabel lbl_ArmaequipadaCazador = new JLabel("Arma equipada");
		lbl_ArmaequipadaCazador.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ArmaequipadaCazador.setBounds(41, 310, 190, 40);
		panel_Cazador.add(lbl_ArmaequipadaCazador);

		JLabel lbl_TipoArma = new JLabel("Tipo de arma");
		lbl_TipoArma.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_TipoArma.setBounds(41, 430, 174, 40);
		panel_Cazador.add(lbl_TipoArma);

		lbl_RespuestatipoArma = new JLabel((String) null);
		lbl_RespuestatipoArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestatipoArma.setBounds(245, 432, 192, 40);
		panel_Cazador.add(lbl_RespuestatipoArma);

		JLabel lbl_PoderAtaqueArma = new JLabel("Poder de ataque");
		lbl_PoderAtaqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PoderAtaqueArma.setBounds(41, 390, 174, 40);
		panel_Cazador.add(lbl_PoderAtaqueArma);

		lbl_RespuestapoderataqueArma = new JLabel("0");
		lbl_RespuestapoderataqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestapoderataqueArma.setBounds(245, 390, 124, 40);
		panel_Cazador.add(lbl_RespuestapoderataqueArma);

		JLabel lbl_ElementoAtaque = new JLabel("Elemento");
		lbl_ElementoAtaque.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ElementoAtaque.setBounds(41, 350, 174, 40);
		panel_Cazador.add(lbl_ElementoAtaque);

		lbl_RespuestaelementoataqueArma = new JLabel((String) null);
		lbl_RespuestaelementoataqueArma.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaelementoataqueArma.setBounds(245, 350, 135, 40);
		panel_Cazador.add(lbl_RespuestaelementoataqueArma);

		lbl_ArmaImagen = new JLabel();
		lbl_ArmaImagen.setBounds(435, 310, 200, 200);
		panel_Cazador.add(lbl_ArmaImagen);

		JLabel lbl_PoderDefensaArmadura = new JLabel("Poder de defensa");
		lbl_PoderDefensaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_PoderDefensaArmadura.setBounds(41, 90, 169, 40);
		panel_Cazador.add(lbl_PoderDefensaArmadura);

		lbl_Respuestapoderdefensarmadura = new JLabel("0");
		lbl_Respuestapoderdefensarmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_Respuestapoderdefensarmadura.setBounds(225, 90, 59, 40);
		panel_Cazador.add(lbl_Respuestapoderdefensarmadura);

		JLabel lbl_ResistenciaArmadura = new JLabel("Resistencia");
		lbl_ResistenciaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ResistenciaArmadura.setBounds(41, 130, 100, 40);
		panel_Cazador.add(lbl_ResistenciaArmadura);

		lbl_RespuestaresistenciaArmadura = new JLabel((String) null);
		lbl_RespuestaresistenciaArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaresistenciaArmadura.setBounds(225, 130, 113, 40);
		panel_Cazador.add(lbl_RespuestaresistenciaArmadura);

		JLabel lbl_DebilidadArmadura = new JLabel("Debilidad");
		lbl_DebilidadArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_DebilidadArmadura.setBounds(41, 170, 100, 40);
		panel_Cazador.add(lbl_DebilidadArmadura);

		lbl_RespuestadebilidadArmadura = new JLabel((String) null);
		lbl_RespuestadebilidadArmadura.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestadebilidadArmadura.setBounds(221, 170, 117, 40);
		panel_Cazador.add(lbl_RespuestadebilidadArmadura);

		lbl_ArmaduraImagen = new JLabel();
		lbl_ArmaduraImagen.setBounds(473, 63, 125, 250);
		panel_Cazador.add(lbl_ArmaduraImagen);

		JLabel lbl_ResistenciaMonstruo = new JLabel("Resistencia ");
		lbl_ResistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_ResistenciaMonstruo.setBounds(796, 350, 100, 40);
		contentPanel.add(lbl_ResistenciaMonstruo);

		JLabel lbl_DebilidadMonstruo = new JLabel("Debilidad ");
		lbl_DebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_DebilidadMonstruo.setBounds(796, 310, 100, 40);
		contentPanel.add(lbl_DebilidadMonstruo);

		lbl_RespuestaresistenciaMonstruo = new JLabel("New label");
		lbl_RespuestaresistenciaMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestaresistenciaMonstruo.setBounds(959, 312, 103, 40);
		contentPanel.add(lbl_RespuestaresistenciaMonstruo);

		lbl_RespuestadebilidadMonstruo = new JLabel("New label");
		lbl_RespuestadebilidadMonstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		lbl_RespuestadebilidadMonstruo.setBounds(959, 350, 90, 40);
		contentPanel.add(lbl_RespuestadebilidadMonstruo);

		// BOTÓN QUE PERMITE CREAR EL CAZADOR. AL PRESIONARLO, EL PROGRAMA CREA UN
		// CAZADOR CON EL ARMA Y ARMADURA SELECCIONADA EN LA BASE DE DATOS.
		JButton btnCrearCazador = new JButton("Crear cazador");
		btnCrearCazador.setBounds(485, 608, 120, 25);
		panel_Cazador.add(btnCrearCazador);
		btnCrearCazador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombreArmaSeleccionada = (String) comboBox_Armas.getSelectedItem();
					String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();
					String nombreCazador = textField_RespuestaNombreCazador.getText();

					// Verificamos si el nombre del cazador es válido, no puede estar en blanco
					if (nombreCazador.isEmpty()) {
						throw new NombreCazadorVacio("El nombre del cazador no puede estar vacío.");
					}

					Arma arma = armaBD.getArmaPorNombre(nombreArmaSeleccionada);
					Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);

					Cazador cazador = new Cazador(5000, armadura, arma, nombreCazador);
					CazadorBD cazadorBD = new CazadorBD();
					cazadorBD.insertCazador(cazador);

					comboBox_CargarCazador.removeAllItems();
					List<Cazador> cazadores = cazadorBD.getAllCazadores();
					for (Cazador cazadorbox : cazadores) {
						comboBox_CargarCazador.addItem(cazadorbox);
					}
				} catch (NombreCazadorVacio ex) {
					// La excepción muestra una ventana de error
					JOptionPane.showMessageDialog(panel_Cazador, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// COMBOBOX DE ARMAS PARA PODER ELEGIR EL ARMA DEL INVENTARIO PARA EL CAZADOR.
		comboBox_Armas = new JComboBox<String>();
		comboBox_Armas.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
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
					Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + arma.getImagePath());
				}
			}
		});

		comboBox_Armas.setBounds(245, 321, 171, 22);
		panel_Cazador.add(comboBox_Armas);

		// COMBOBOX DE ARMADURAS PARA PODER ELEGIR LA ARMADURA DEL INVENTARIO PARA EL
		// CAZADOR.
		comboBox_Armaduras = new JComboBox<String>();
		comboBox_Armaduras.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
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
					Image newimg = image.getScaledInstance(125, 250, java.awt.Image.SCALE_SMOOTH);
					icon = new ImageIcon(newimg);
					lbl_ArmaduraImagen.setIcon(icon);
				} else {
					System.err.println("No se pudo encontrar la imagen: " + armadura.getImagePath());
				}
			}
		});
		comboBox_Armaduras.setBounds(227, 61, 189, 22);
		panel_Cazador.add(comboBox_Armaduras);

		JComboBox<String> comboBox_Monstruo = new JComboBox<>();
		comboBox_Monstruo.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		List<MonstruoGrande> monstruosGrandes = monstruoGrandeBD.listarMonstruosGrandes();

		for (MonstruoGrande monstruoGrande : monstruosGrandes) {
			String nombreMonstruo = monstruoGrande.getNombre();
			comboBox_Monstruo.addItem(nombreMonstruo);
		}

		comboBox_Monstruo.setBounds(796, 184, 287, 22);
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
							new ImageIcon(urlImagen).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
					lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPuntosSalud()));
					lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPoderAtaque()));
					lbl_RespuestaresistenciaMonstruo.setText(monstruoGrandeSeleccionado.getResistencias().toString());
					lbl_RespuestadebilidadMonstruo.setText(monstruoGrandeSeleccionado.getDebilidades().toString());
					lbl_ImagenMonstruo.setIcon(imageIcon);
				}
			}
		});

		ImageIcon rawbatalla = new ImageIcon(getClass().getResource("/images/a_la_batalla.png"));
		Image imagenbatalla = rawbatalla.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		ImageIcon batalla = new ImageIcon(imagenbatalla);
		JButton btn_Combate = new JButton("", batalla);
		btn_Combate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener el monstruo seleccionado del JComboBox
				String nombreMonstruoSeleccionado = (String) comboBox_Monstruo.getSelectedItem();
				monstruoGrande = monstruoGrandeBD.getMonstruoGrandePorNombre(nombreMonstruoSeleccionado);

				// Verificar si se ha seleccionado un cazador
				cazador = (Cazador) comboBox_CargarCazador.getSelectedItem();
				if (cazador == null) {
					System.out.println("No se ha especificado un cazador");
					return;
				}

				// Reiniciar los turnos del cazador cada combate
				cazador.resetearTurnos();
				cazador.resetearSaludCazador();

				pantallacombate = new PantallaCombate(cazador, monstruoGrande);
				pantallacombate.setVisible(true);
			}
		});
		btn_Combate.setBounds(849, 722, 150, 100);
		contentPanel.add(btn_Combate);

		comboBox_CargarCazador = new JComboBox<Cazador>();
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

		comboBox_CargarCazador.setBounds(41, 672, 557, 22);
		panel_Cazador.add(comboBox_CargarCazador);

		JLabel lbl_NombreCazador = new JLabel("Nombre del cazador");
		lbl_NombreCazador.setFont(new Font("Futura Md BT", Font.PLAIN, 17));
		lbl_NombreCazador.setBounds(41, 597, 169, 40);
		panel_Cazador.add(lbl_NombreCazador);

		textField_RespuestaNombreCazador = new JTextField();
		textField_RespuestaNombreCazador.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		textField_RespuestaNombreCazador.setBounds(242, 609, 181, 25);
		panel_Cazador.add(textField_RespuestaNombreCazador);
		textField_RespuestaNombreCazador.setColumns(10);

		// Esta es la única forma que he descubierto que realmente funciona para que los
		// combobox empiecen inicializados y no en blanco.

		String nombreArmaduraSeleccionada = (String) comboBox_Armaduras.getSelectedItem();
		Armadura armadura = armaduraBD.getArmaduraPorNombre(nombreArmaduraSeleccionada);
		lbl_Respuestapoderdefensarmadura.setText(String.valueOf(armadura.getPoderDefensa()));
		lbl_RespuestaresistenciaArmadura.setText(armadura.getResistenciaArmadura().toString());
		lbl_RespuestadebilidadArmadura.setText(armadura.getDebilidadArmadura().toString());
		URL location1 = this.getClass().getResource("/images/" + armadura.getImagePath());
		if (location1 != null) {
			ImageIcon icon = new ImageIcon(location1);
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(125, 250, java.awt.Image.SCALE_SMOOTH);
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
					new ImageIcon(urlImagen).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
			lbl_respuestaSaludMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPuntosSalud()));
			lbl_RespuestaAtaqueMonstruo.setText(String.valueOf(monstruoGrandeSeleccionado.getPoderAtaque()));
			lbl_RespuestaresistenciaMonstruo.setText(monstruoGrandeSeleccionado.getResistencias().toString());
			lbl_RespuestadebilidadMonstruo.setText(monstruoGrandeSeleccionado.getDebilidades().toString());
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
			Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
			icon = new ImageIcon(newimg);
			lbl_ArmaImagen.setIcon(icon);

		}

		ImageIcon rawpersonaje = new ImageIcon(getClass().getResource("/images/elige_personaje.png"));
		Image imagepersonaje = rawpersonaje.getImage().getScaledInstance(212, 77, Image.SCALE_SMOOTH);
		ImageIcon finalpersonaje = new ImageIcon(imagepersonaje);
		lbl_eligepersonaje = new JLabel("");
		lbl_eligepersonaje.setIcon(finalpersonaje);
		lbl_eligepersonaje.setBounds(309, 36, 212, 77);
		contentPanel.add(lbl_eligepersonaje);

		ImageIcon raweligemonstruo = new ImageIcon(getClass().getResource("/images/elige_monstruo.png"));
		Image imageeligemonstruo = raweligemonstruo.getImage().getScaledInstance(212, 77, Image.SCALE_SMOOTH);
		ImageIcon finaleligemonstruo = new ImageIcon(imageeligemonstruo);
		lbl_eligemonstruo = new JLabel("");
		lbl_eligemonstruo.setIcon(finaleligemonstruo);
		lbl_eligemonstruo.setBounds(796, 30, 212, 77);
		contentPanel.add(lbl_eligemonstruo);

	}
}
