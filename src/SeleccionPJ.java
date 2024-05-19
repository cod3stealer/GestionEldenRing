import javax.swing.*;
import java.awt.*;

public class SeleccionPJ extends JPanel {
    private JButton warriorButton;
    private JButton mageButton;
    private JButton explorerButton;
    private JButton comenzar;
    Duelo duelo;

    public SeleccionPJ() {
        warriorButton = new JButton("Warrior");
        mageButton = new JButton("Mage");
        explorerButton = new JButton("Explorer");
        comenzar = new JButton("Start");

        PJ pj1 = new Guerrero();
        PJ pj2 = new Guerrero();

        warriorButton.addActionListener(e -> {
            pj1 = new Guerrero();
            pj2 = new Guerrero();
        });

        mageButton.addActionListener(e -> {
            pj1 = new Mago();
            pj2 = new Mago();
        });

        explorerButton.addActionListener(e -> {
            pj1 = new Explorador();
            pj2 = new Explorador();
        });

        comenzar.addActionListener(e -> {
            duelo = new Duelo(pj1, pj2);
            JOptionPane.showMessageDialog(null, duelo.fin());
        });

        setLayout(new GridLayout(4, 1));
        add(warriorButton);
        add(mageButton);
        add(explorerButton);
        add(comenzar);
    }
}