package interfaces;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainInterface extends JFrame {

    private JPanel contentPane;
    private Bestiario bestiario;
    private BestiarioPequeño bestiariopequeño;
    private ArmaArmadura armaarmadura;
    private CombateInterface combate;
    private Feedback feedback;
    private Clip clip;

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

    public MainInterface() {
        // Música de intro
        playMusic("/song/MonsterHunterTheme.wav");

        bestiario = new Bestiario(this, true);
        bestiario.setVisible(false);

        bestiariopequeño = new BestiarioPequeño(this, true);
        bestiariopequeño.setVisible(false);

        armaarmadura = new ArmaArmadura(this, true);
        armaarmadura.setVisible(false);

        combate = new CombateInterface(this, true);
        combate.setVisible(false);
        
        feedback = new Feedback(this, true);
        feedback.setVisible(false);

        setTitle("Bienvenidos al Bestiario + Combate de Monster Hunter World (pensé en un título más largo pero así está bien)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(230, 230, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
      
        ImageIcon rawbmg = new ImageIcon(getClass().getResource("/images/bmg.png"));
        Image imagenbmg = rawbmg.getImage().getScaledInstance(193, 130, Image.SCALE_SMOOTH); 
        ImageIcon bestiariomg = new ImageIcon(imagenbmg);
        JButton btn_BestiarioMonstruosGrandes = new JButton("", bestiariomg);
        btn_BestiarioMonstruosGrandes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                bestiario.setVisible(true);
            }
        });
        btn_BestiarioMonstruosGrandes.setBounds(47, 37, 220, 150);
        contentPane.add(btn_BestiarioMonstruosGrandes);
        btn_BestiarioMonstruosGrandes.setFocusPainted(false);
        

        ImageIcon rawbmp = new ImageIcon(getClass().getResource("/images/bmp.png"));
        Image imagenbmp = rawbmp.getImage().getScaledInstance(193, 130, Image.SCALE_SMOOTH); 
        ImageIcon bestiariomp = new ImageIcon(imagenbmp);
        JButton btn_BestiarioMonstruosPequeños = new JButton("", bestiariomp);
        btn_BestiarioMonstruosPequeños.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                bestiariopequeño.setVisible(true);
            }
        });
        btn_BestiarioMonstruosPequeños.setBounds(507, 37, 220, 150);
        contentPane.add(btn_BestiarioMonstruosPequeños);
        btn_BestiarioMonstruosPequeños.setFocusPainted(false);

        ImageIcon rawequipo = new ImageIcon(getClass().getResource("/images/equipo.png"));
        Image imagenequipo = rawequipo.getImage().getScaledInstance(193, 130, Image.SCALE_SMOOTH); 
        ImageIcon botonequipo = new ImageIcon(imagenequipo);
        JButton btn_ArmaArmadura = new JButton("", botonequipo);
        btn_ArmaArmadura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                armaarmadura.setVisible(true);
            }
        });

        btn_ArmaArmadura.setBounds(47, 359, 220, 150);
        contentPane.add(btn_ArmaArmadura);
        btn_ArmaArmadura.setFocusPainted(false);

        ImageIcon rawcombate = new ImageIcon(getClass().getResource("/images/combate.png"));
        Image imagencombate = rawcombate.getImage().getScaledInstance(193, 130, Image.SCALE_SMOOTH);
        ImageIcon botoncombate = new ImageIcon(imagencombate);
        JButton btn_Combate = new JButton("", botoncombate);
        btn_Combate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                combate.setVisible(true);
                
                String message =
                        "COMO JUGAR:\n\n"
                        + "0. La resistencia del monstruo enemigo es con el elemento que golpea, así que deberías buscar una armadura resistente a ese elemento. \n"
                        + "Su debilidad es el elemento que debes buscar equipar en tu arma.\n"
                        + "Una efectividad correcta implica 1.5x en el daño y una incorrecta implica 0.5x tanto para el cazador como para el monstruo \n\n"
                        + "1. Equipa a tu personaje: elige la armadura y el arma teniendo en cuenta sus resistencias y sus debilidades elementales. \n"
                        + "Cada arma tiene un ataque especial, que hace una cantidad de daño y tiene un cooldown diferente. \n "
                        + "Ponle un nombre a tu cazador y pulsa el botón de crear. Luego buscalo en el ComboBox y equípalo.\n\n"
                        + "2. Elige un monstruo: cada monstruo tiene niveles de salud, ataque y debilidades y resistencias elementales. \n"
                        + "Algunos son fáciles de ganar aunque te equipas mal, otros son imposibles de ganar si no comprendes como funcionan las efectividades elementales.\n\n"
                        + "3. Pulsa el botón de A LA BATALLA.";
                    
                    JOptionPane.showMessageDialog(null, message);
            }
        });
        btn_Combate.setBounds(277, 198, 220, 150);
        contentPane.add(btn_Combate);
        btn_Combate.setFocusPainted(false);
       
        
        ImageIcon rawfb = new ImageIcon(getClass().getResource("/images/fb.png"));
        Image imagenfb = rawfb.getImage().getScaledInstance(193, 130, Image.SCALE_SMOOTH); 
        ImageIcon botonfb = new ImageIcon(imagenfb);
        JButton btn_Feedback = new JButton("", botonfb);
        btn_Feedback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		stopMusic(); // Detener la música al pulsar el botón
                feedback.setVisible(true);
        	}
        });
        btn_Feedback.setBounds(517, 359, 220, 150);
        contentPane.add(btn_Feedback);
        btn_Feedback.setFocusPainted(false);
    }

    private void playMusic(String filepath) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(filepath));
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            // Para poder tocar el volumen
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // A -25 me parece óptimo porque no revienta ningún tímpano y se escucha bien si el sonido del sistema está al 100%.
            volumeControl.setValue(-25.0f);

            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);  // La música se reproducirá continuamente en el menú de inicio

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
