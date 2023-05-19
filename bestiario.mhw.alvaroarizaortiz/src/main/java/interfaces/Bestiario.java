package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Bestiario extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BESTIARIO");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(223, 39, 137, 43);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Especie");
		lblNewLabel_1.setBounds(353, 151, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tamaño");
		lblNewLabel_2.setBounds(353, 202, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Localización");
		lblNewLabel_3.setBounds(353, 253, 70, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Salud");
		lblNewLabel_4.setBounds(353, 300, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poder");
		lblNewLabel_5.setBounds(353, 345, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setBounds(452, 202, 46, 14);
		contentPanel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(Color.GRAY);
		lblNewLabel_7.setBounds(469, 151, 46, 14);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBackground(new Color(0, 255, 0));
		lblNewLabel_6.setBounds(441, 151, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(441, 202, 46, 14);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("New label");
		lblNewLabel_8_1.setBounds(441, 253, 46, 14);
		contentPanel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("New label");
		lblNewLabel_8_1_1.setBounds(441, 300, 46, 14);
		contentPanel.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("New label");
		lblNewLabel_8_1_1_1.setBounds(441, 345, 46, 14);
		contentPanel.add(lblNewLabel_8_1_1_1);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(52, 117, 142, 25);
		contentPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(52, 174, 184, 173);
		ImageIcon icono = new ImageIcon(getClass().getResource("/images/alatreon.png"));
		Image imagen = icono.getImage();
		Image imagenEscalada = imagen.getScaledInstance(lblNewLabel_10.getWidth(), lblNewLabel_10.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imagenEscalada2 = new ImageIcon(imagenEscalada);
		lblNewLabel_10.setIcon(imagenEscalada2);
		
		contentPanel.add(lblNewLabel_10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("PATRAS");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("PALANTE");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
