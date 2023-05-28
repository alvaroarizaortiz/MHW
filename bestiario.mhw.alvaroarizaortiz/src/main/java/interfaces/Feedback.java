package interfaces;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

public class Feedback extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldEmail;
	private JTextArea textAreaFeedback;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnEstudiante;

	public Feedback(MainInterface madre, boolean modal) {
		setTitle("Feedback");
		setBounds(100, 100, 700, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(230, 230, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblNombre.setBounds(174, 122, 67, 14);
		contentPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textFieldNombre.setBounds(251, 120, 179, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(20);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblEmail.setBounds(190, 180, 67, 14);
		contentPanel.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textFieldEmail.setBounds(251, 178, 179, 20);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(20);

		JLabel lblFeedback = new JLabel("Feedback sobre el programa:");
		lblFeedback.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblFeedback.setBounds(225, 294, 216, 14);
		contentPanel.add(lblFeedback);

		textAreaFeedback = new JTextArea();
		textAreaFeedback.setForeground(Color.WHITE);
		textAreaFeedback.setBackground(new Color(42, 97, 88));
		textAreaFeedback.setFont(new Font("Futura Md BT", Font.PLAIN, 12));
		textAreaFeedback.setBounds(210, 319, 244, 94);
		textAreaFeedback.setLineWrap(true);
		textAreaFeedback.setWrapStyleWord(true);
		contentPanel.add(textAreaFeedback);

		JLabel lblRol = new JLabel("Rol:");
		lblRol.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		lblRol.setBounds(206, 241, 51, 14);
		contentPanel.add(lblRol);

		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBackground(new Color(230, 230, 230));
		rdbtnProfesor.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		rdbtnProfesor.setBounds(251, 237, 83, 23);
		contentPanel.add(rdbtnProfesor);

		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBackground(new Color(230, 230, 230));
		rdbtnEstudiante.setFont(new Font("Futura Md BT", Font.PLAIN, 14));
		rdbtnEstudiante.setBounds(336, 237, 91, 23);
		contentPanel.add(rdbtnEstudiante);

		ButtonGroup buttonGroupRol = new ButtonGroup();
		buttonGroupRol.add(rdbtnProfesor);
		buttonGroupRol.add(rdbtnEstudiante);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Futura Md BT", Font.BOLD, 14));
		btnEnviar.setBounds(464, 390, 83, 23);
		contentPanel.add(btnEnviar);
		
		JLabel lblNewLabel = new JLabel("FEEDBACK");
		lblNewLabel.setForeground(new Color(166, 38, 47));
		lblNewLabel.setFont(new Font("Futura Md BT", Font.PLAIN, 20));
		lblNewLabel.setBounds(280, 11, 100, 100);
		contentPanel.add(lblNewLabel);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldNombre.getText();
				String email = textFieldEmail.getText();
				String feedback = textAreaFeedback.getText();
				String rol = rdbtnProfesor.isSelected() ? "Profesor" : "Estudiante";

				// Aquí se guarda el mensaje que luego mostraremos
				StringBuilder mensaje = new StringBuilder();
				mensaje.append("Nombre: ").append(nombre).append("\n");
				mensaje.append("Email: ").append(email).append("\n");
				mensaje.append("Rol: ").append(rol).append("\n");
				mensaje.append("Mensaje: ").append(feedback).append("\n");
				mensaje.append("\n");
				mensaje.append("¡Gracias por tu valoración!");
			
				// Mostramos todo lo que se ha rellenado del formulario en una ventana emergente
				JOptionPane.showMessageDialog(contentPanel, mensaje.toString(), "Información del formulario",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
}
