package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class PantallaCombate extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public PantallaCombate() {
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btn_Ataque = new JButton("Ataque");
		btn_Ataque.setBounds(47, 324, 89, 23);
		contentPanel.add(btn_Ataque);
		
		JButton btn_AtaqueFuerte = new JButton("Ataque Fuerte");
		btn_AtaqueFuerte.setBounds(146, 324, 113, 23);
		contentPanel.add(btn_AtaqueFuerte);
		
		JButton btn_AccionArmaEspecial = new JButton("New button");
		btn_AccionArmaEspecial.setBounds(47, 358, 89, 23);
		contentPanel.add(btn_AccionArmaEspecial);
		
		JButton btn_Esquivar = new JButton("Esquivar");
		btn_Esquivar.setBounds(146, 358, 113, 23);
		contentPanel.add(btn_Esquivar);
	}
}
