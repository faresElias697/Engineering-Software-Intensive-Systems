package GUIscreens;

import javax.swing.*;
import java.awt.*;

public class MaintenanceScreen {
    public void showWindow() {
        JFrame frame = new JFrame("Preventive Maintenance");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        JLabel warning = new JLabel("⚠ Machine is currently under preventive maintenance", SwingConstants.CENTER);
        warning.setFont(new Font("Arial", Font.BOLD, 16));
        warning.setAlignmentX(Component.CENTER_ALIGNMENT);
        warning.setForeground(new Color(220, 100, 0));

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginBtn = new JButton("Technician Login");
        JButton logsBtn = new JButton("View Maintenance Logs");
        JButton exitBtn = new JButton("Exit Maintenance Mode");

        for (JButton btn : new JButton[]{loginBtn, logsBtn, exitBtn}) {
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setMaximumSize(new Dimension(250, 40));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        panel.add(warning);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(progressBar);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(loginBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(logsBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(exitBtn);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
