package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Monstruo;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class Bestiario extends JDialog {

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Bestiario(MainInterface madre, boolean modal) {
		super(madre, modal);
		setTitle("BESTIARIO");
		setBounds(100, 100, 622, 463);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Monstruo = new JPanel();
		getContentPane().add(Monstruo, "name_50281680010900");
		Monstruo.setLayout(null);
		
		JLabel lbl_Bestiario = new JLabel("BESTIARIO");
		lbl_Bestiario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lbl_Bestiario.setBounds(237, 39, 107, 27);
		Monstruo.add(lbl_Bestiario);
		
		JLabel lbll_NombreMonstruo = new JLabel("NombreMonstruo");
		lbll_NombreMonstruo.setBounds(54, 133, 100, 14);
		Monstruo.add(lbll_NombreMonstruo);
		
		JLabel lbl_ImagenMonstruo = new JLabel("ImagenMonstruo");
		lbl_ImagenMonstruo.setBounds(34, 158, 190, 171);
		Monstruo.add(lbl_ImagenMonstruo);
		
		
		JLabel lbl_EspecieMonstruo = new JLabel("Especie");
		lbl_EspecieMonstruo.setBounds(298, 133, 90, 14);
		Monstruo.add(lbl_EspecieMonstruo);
		
		JLabel lbl_RespuestaEspecieMonstruo = new JLabel("Respuesta especie");
		lbl_RespuestaEspecieMonstruo.setBounds(441, 133, 115, 14);
		Monstruo.add(lbl_RespuestaEspecieMonstruo);
		
		JLabel lbl_TamañoMonstruo = new JLabel("Tamaño");
		lbl_TamañoMonstruo.setBounds(298, 168, 46, 14);
		Monstruo.add(lbl_TamañoMonstruo);
		
		JLabel lbl_RespuestaTamañoMonstruo = new JLabel("Respuesta tamaño");
		lbl_RespuestaTamañoMonstruo.setBounds(441, 168, 46, 14);
		Monstruo.add(lbl_RespuestaTamañoMonstruo);
		
		JLabel lbl_SaludMonstruo = new JLabel("Salud");
		lbl_SaludMonstruo.setBounds(298, 201, 46, 14);
		Monstruo.add(lbl_SaludMonstruo);
		
		JLabel lbl_respuestaSaludMonstruo = new JLabel("Respuesta salud");
		lbl_respuestaSaludMonstruo.setBounds(441, 201, 46, 14);
		Monstruo.add(lbl_respuestaSaludMonstruo);
		
		JLabel lbl_AtaqueMonstruo = new JLabel("Ataque");
		lbl_AtaqueMonstruo.setBounds(298, 226, 46, 14);
		Monstruo.add(lbl_AtaqueMonstruo);
		
		JLabel lbl_RespuestaAtaqueMonstruo = new JLabel("Respuesta ataque");
		lbl_RespuestaAtaqueMonstruo.setBounds(441, 226, 46, 14);
		Monstruo.add(lbl_RespuestaAtaqueMonstruo);
		
		JLabel lbl_LocalizacionMonstruo = new JLabel("Localización");
		lbl_LocalizacionMonstruo.setBounds(298, 251, 46, 14);
		Monstruo.add(lbl_LocalizacionMonstruo);
		
		JLabel lbl_RespuestaLocalizacionMonstruo = new JLabel("Respuesta localizacion");
		lbl_RespuestaLocalizacionMonstruo.setBounds(441, 251, 46, 14);
		Monstruo.add(lbl_RespuestaLocalizacionMonstruo);
		
		JButton btn_Siguiente = new JButton("Siguiente");
		btn_Siguiente.setBounds(337, 365, 89, 23);
		Monstruo.add(btn_Siguiente);
		
		JButton btn_Anterior = new JButton("Anterior");
		btn_Anterior.setBounds(171, 365, 89, 23);
		Monstruo.add(btn_Anterior);
		
	}
}
