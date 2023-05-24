package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Cazador;
import clases.MonstruoGrande;
import excepciones.AttackException;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;

public class PantallaCombate extends JDialog {
	private Cazador cazador;
	private MonstruoGrande monstruo;

	private final JPanel contentPanel = new JPanel();

	public PantallaCombate(Cazador cazador, MonstruoGrande monstruo) {
		this.cazador = cazador;
		this.monstruo = monstruo;
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JButton btn_Ataque = new JButton("Ataque");
		btn_Ataque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					cazador.ataque(monstruo);
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_Ataque.setBounds(47, 324, 89, 23);
		contentPanel.add(btn_Ataque);

		JButton btn_AtaqueFuerte = new JButton("Ataque Fuerte");
		btn_AtaqueFuerte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.ataqueFuerte(monstruo);
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_AtaqueFuerte.setBounds(146, 324, 113, 23);
		contentPanel.add(btn_AtaqueFuerte);

		JButton btn_AccionArmaEspecial = new JButton("Ataque Especial");
		btn_AccionArmaEspecial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.ataqueEspecial(monstruo);;
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_AccionArmaEspecial.setBounds(47, 358, 89, 23);
		contentPanel.add(btn_AccionArmaEspecial);

		JButton btn_Esquivar = new JButton("Esquivar");
		btn_Esquivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cazador != null && monstruo != null) {
					try {
						cazador.esquivar(monstruo);
					} catch (AttackException ex) {
						System.out.println(ex.getMessage());
					}
				} else {
					System.out.println("No se ha especificado un cazador o monstruo");
				}
			}
		});
		btn_Esquivar.setBounds(146, 358, 113, 23);
		contentPanel.add(btn_Esquivar);
		
		JButton btn_AtaqueMonstruo = new JButton("New button");
		btn_AtaqueMonstruo.setBounds(549, 324, 89, 23);
		contentPanel.add(btn_AtaqueMonstruo);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(549, 358, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(648, 324, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(648, 358, 89, 23);
		contentPanel.add(btnNewButton_3);
	}
}
