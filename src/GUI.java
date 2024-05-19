/**
 * Interfaz Gráfica: Utilizar Java Swing para crear una interfaz gráfica que permita a los usuarios crear un nuevo
 * personaje, seleccionar entre diferentes tipos (por ejemplo, Guerrero, Mago, Explorador), y asignar puntos de
 * habilidad (como fuerza, agilidad, inteligencia).
 * */

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame {
    private JTextField nameField;
    private JTextField strengthField;
    private JTextField agilityField;
    private JTextField intelligenceField;
    private JButton saveButton;
    private JButton loadButton;

    SeleccionPJ seleccionPJ = new SeleccionPJ();

    public GUI() {
        // Create the text fields
        nameField = new JTextField(20);
        strengthField = new JTextField(20);
        agilityField = new JTextField(20);
        intelligenceField = new JTextField(20);

        // Create the buttons
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        // Create a panel and add the components to it
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Strength:"));
        panel.add(strengthField);
        panel.add(new JLabel("Agility:"));
        panel.add(agilityField);
        panel.add(new JLabel("Intelligence:"));
        panel.add(intelligenceField);
        panel.add(saveButton);
        panel.add(loadButton);

        // Add action listeners to the buttons
        saveButton.addActionListener(e -> {
            // Implement save functionality here
            try {
                FileWriter writer = new FileWriter("character.txt");
                writer.write("Name: " + nameField.getText() + "\n");
                writer.write("Strength: " + strengthField.getText() + "\n");
                writer.write("Agility: " + agilityField.getText() + "\n");
                writer.write("Intelligence: " + intelligenceField.getText() + "\n");
                writer.close();
                JOptionPane.showMessageDialog(this, "Character saved successfully!");

                cambio(panel,seleccionPJ);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving character: " + ex.getMessage());
            }
        });

        loadButton.addActionListener(e -> {
            try {
                FileReader reader = new FileReader("character.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);
                nameField.setText(bufferedReader.readLine().substring(6));
                strengthField.setText(bufferedReader.readLine().substring(13));
                agilityField.setText(bufferedReader.readLine().substring(10));
                intelligenceField.setText(bufferedReader.readLine().substring(16));
                bufferedReader.close();
                JOptionPane.showMessageDialog(this, "Character loaded successfully!");

                cambio(panel,seleccionPJ);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading character: " + ex.getMessage());
            }
        });

        // Add the panel to the frame
        add(panel);

        // Set the frame properties
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(1080,720));
        setVisible(true);
    }

    private void cambio(JPanel panel, JPanel nextPanel){
        remove(panel);
        add(nextPanel);
        revalidate();
        repaint();
    }
}
