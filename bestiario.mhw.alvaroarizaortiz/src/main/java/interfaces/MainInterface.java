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
		
		setTitle("Bestiario de Monster Hunter World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JButton btnNewButton = new JButton("Bestiario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			bestiario.setVisible(true);	
			}
		});
		btnNewButton.setBounds(152, 122, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Peleitas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(491, 122, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Armas y armaduras");
		btnNewButton_2.setBounds(152, 313, 172, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salir del programuzo");
		btnNewButton_3.setBounds(491, 313, 155, 23);
		contentPane.add(btnNewButton_3);
		
		// JCOMBOBOX DE ARMAS NO PERDER
		/*JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Armas");
		comboBox.setBounds(194, 118, 165, 20);
		ArmaBD armaBD = new ArmaBD();
		List<String> todasLasArmas = armaBD.getNombresArmas();
		for (int i=0; i < todasLasArmas.size(); i++) {
			comboBox.addItem(todasLasArmas.get(i));
		}
		
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Armas");
		lblNewLabel.setBounds(252, 93, 46, 14);
		contentPane.add(lblNewLabel);
		*/
	}
}
