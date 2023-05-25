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
import javax.swing.JTextField;

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

		setTitle(
				"Bienvenidos al Bestiario + Combate de Monster Hunter World (pensé en un título más largo pero así está bien)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
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
		btn_BestiarioMonstruosGrandes.setBounds(110, 43, 191, 83);
		contentPane.add(btn_BestiarioMonstruosGrandes);

		JButton btn_BestiarioMonstruosPequeños = new JButton("Bestiario de Monstruos Pequeños");
		btn_BestiarioMonstruosPequeños.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bestiariopequeño.setVisible(true);
			}
		});
		btn_BestiarioMonstruosPequeños.setBounds(110, 323, 191, 83);
		contentPane.add(btn_BestiarioMonstruosPequeños);

		JButton btn_ArmaArmadura = new JButton("Armas y armaduras");
		btn_ArmaArmadura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				armaarmadura.setVisible(true);
			}
		});

		btn_ArmaArmadura.setBounds(471, 43, 191, 83);
		contentPane.add(btn_ArmaArmadura);

		JButton btn_Combate = new JButton("Combate");
		btn_Combate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combate.setVisible(true);
			}
		});
		btn_Combate.setBounds(471, 323, 191, 83);
		contentPane.add(btn_Combate);
	}
}
