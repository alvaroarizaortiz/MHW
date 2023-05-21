package interfaces;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.ArmaBD;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterface() {
		Bestiario bestiario = new Bestiario(this, true);
		bestiario.setVisible(false);
		BestiarioPequeño bestiariopequeño = new BestiarioPequeño(this, true);
		bestiariopequeño.setVisible(false);
		ArmaArmadura armaarmadura = new ArmaArmadura(this, true);
		armaarmadura.setVisible(false);

		setTitle("Bestiario de Monster Hunter World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn_BestiarioMonstruosGrandes = new JButton("Bestiario de Monstruos Grandes");
		btn_BestiarioMonstruosGrandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bestiario.setVisible(true);
			}
		});
		btn_BestiarioMonstruosGrandes.setBounds(129, 92, 191, 83);
		contentPane.add(btn_BestiarioMonstruosGrandes);

		JButton btn_BestiarioMonstruosPequeños = new JButton("Bestiario de Monstruos Pequeños");
		btn_BestiarioMonstruosPequeños.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bestiariopequeño.setVisible(true);
			}
		});
		btn_BestiarioMonstruosPequeños.setBounds(129, 289, 180, 83);
		contentPane.add(btn_BestiarioMonstruosPequeños);

		JButton btn_ArmaArmadura = new JButton("Armas y armaduras");
		btn_ArmaArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armaarmadura.setVisible(true);
			}
		});

		btn_ArmaArmadura.setBounds(472, 92, 172, 116);
		contentPane.add(btn_ArmaArmadura);

		JButton btnNewButton_3 = new JButton("Salir del programuzo");
		btnNewButton_3.setBounds(491, 313, 155, 23);
		contentPane.add(btnNewButton_3);

	
	}
}
