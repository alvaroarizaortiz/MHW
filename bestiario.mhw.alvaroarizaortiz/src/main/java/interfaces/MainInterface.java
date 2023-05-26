package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {

    private JPanel contentPane;
    private Bestiario bestiario;
    private BestiarioPequeño bestiariopequeño;
    private ArmaArmadura armaarmadura;
    private CombateInterface combate;
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

        setTitle("Bienvenidos al Bestiario + Combate de Monster Hunter World (pensé en un título más largo pero así está bien)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn_BestiarioMonstruosGrandes = new JButton("Bestiario de Monstruos Grandes");
        btn_BestiarioMonstruosGrandes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                bestiario.setVisible(true);
            }
        });
        btn_BestiarioMonstruosGrandes.setBounds(110, 43, 191, 83);
        contentPane.add(btn_BestiarioMonstruosGrandes);

        JButton btn_BestiarioMonstruosPequeños = new JButton("Bestiario de Monstruos Pequeños");
        btn_BestiarioMonstruosPequeños.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                bestiariopequeño.setVisible(true);
            }
        });
        btn_BestiarioMonstruosPequeños.setBounds(110, 323, 191, 83);
        contentPane.add(btn_BestiarioMonstruosPequeños);

        JButton btn_ArmaArmadura = new JButton("Armas y armaduras");
        btn_ArmaArmadura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                armaarmadura.setVisible(true);
            }
        });

        btn_ArmaArmadura.setBounds(471, 43, 191, 83);
        contentPane.add(btn_ArmaArmadura);

        JButton btn_Combate = new JButton("Combate");
        btn_Combate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic(); // Detener la música al pulsar el botón
                combate.setVisible(true);
            }
        });
        btn_Combate.setBounds(471, 323, 191, 83);
        contentPane.add(btn_Combate);
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
