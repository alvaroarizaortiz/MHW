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
	private Bestiario bestiario;
	private BestiarioPequeño bestiariopequeño;
	private ArmaArmadura armaarmadura;
	private CombateInterface combate;

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
		bestiario = new Bestiario(this, true);
		bestiario.setVisible(false);
		bestiariopequeño = new BestiarioPequeño(this, true);
		bestiariopequeño.setVisible(false);
		armaarmadura = new ArmaArmadura(this, true);
		armaarmadura.setVisible(false);
		combate = new CombateInterface(this, true);
		combate.setVisible(false);

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
		btn_BestiarioMonstruosGrandes.setBounds(172, 59, 191, 83);
		contentPane.add(btn_BestiarioMonstruosGrandes);

		JButton btn_BestiarioMonstruosPequeños = new JButton("Bestiario de Monstruos Pequeños");
		btn_BestiarioMonstruosPequeños.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bestiariopequeño.setVisible(true);
			}
		});
		btn_BestiarioMonstruosPequeños.setBounds(28, 186, 180, 83);
		contentPane.add(btn_BestiarioMonstruosPequeños);

		JButton btn_ArmaArmadura = new JButton("Armas y armaduras");
		btn_ArmaArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armaarmadura.setVisible(true);
			}
		});

		btn_ArmaArmadura.setBounds(524, 42, 172, 116);
		contentPane.add(btn_ArmaArmadura);

		JButton btn_SalirPrograma = new JButton("Salir del programuzo");
		btn_SalirPrograma.setBounds(561, 497, 155, 23);
		contentPane.add(btn_SalirPrograma);
		
		JButton btn_Combate = new JButton("Combate");
		btn_Combate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combate.setVisible(true);
			}
		});
		btn_Combate.setBounds(319, 221, 220, 105);
		contentPane.add(btn_Combate);
	}
}
