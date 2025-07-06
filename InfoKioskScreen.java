package GUIscreens;

import javax.swing.*;
import java.awt.*;

public class InfoKioskScreen {
    public void showWindow() {
        JFrame frame = new JFrame("Patient Medication Information");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0, 51, 102));
        frame.setLocationRelativeTo(null);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Patient Medication Information", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cardInput = new JLabel("Health Fund Card Number", SwingConstants.CENTER);
        cardInput.setFont(new Font("Arial", Font.PLAIN, 16));
        cardInput.setOpaque(true);
        cardInput.setBackground(Color.LIGHT_GRAY);
        cardInput.setMaximumSize(new Dimension(300, 30));
        cardInput.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel medName = new JLabel("SamplePill™ 10 mg", SwingConstants.CENTER);
        medName.setFont(new Font("Arial", Font.BOLD, 20));
        medName.setForeground(Color.WHITE);
        medName.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel purpose = new JLabel("Purpose: Lowers blood pressure");
        purpose.setForeground(Color.WHITE);
        purpose.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel dosage = new JLabel("Dosage: Take 1 pill daily");
        dosage.setForeground(Color.BLACK);
        dosage.setOpaque(true);
        dosage.setBackground(new Color(200, 200, 255));
        dosage.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel effects = new JLabel("Side Effects: • Nausea • Headache • Dizziness");
        effects.setForeground(Color.BLACK);
        effects.setOpaque(true);
        effects.setBackground(new Color(200, 200, 255));
        effects.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel warning = new JLabel("Contact your doctor if severe side effects occur.");
        warning.setForeground(Color.WHITE);
        warning.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(cardInput);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(medName);
        frame.add(purpose);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(dosage);
        frame.add(effects);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(warning);

        frame.setVisible(true);
    }
}
