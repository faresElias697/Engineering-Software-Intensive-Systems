package GUIscreens;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame menu = new JFrame("Advanced Pharmacare - GUIscreens.Main Menu");
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(400, 400);
            menu.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(java.awt.Color.WHITE);
            panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

            JLabel label = new JLabel("Select a Screen:");
            label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
            label.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

            JButton infoBtn = new JButton("SUC-9: Info Kiosk");
            infoBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            infoBtn.addActionListener(e -> new InfoKioskScreen().showWindow());

            JButton paymentBtn = new JButton("SUC-6: Payment Screen");
            paymentBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            paymentBtn.addActionListener(e -> new PaymentScreen().showWindow());

            JButton insertCardBtn = new JButton("SUC-2: Insert Health Fund Card");
            insertCardBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            insertCardBtn.addActionListener(e -> new InsertCardScreen().showWindow());

            JButton maintenanceBtn = new JButton("SUC-11: Maintenance Mode");
            maintenanceBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            maintenanceBtn.addActionListener(e -> new MaintenanceScreen().showWindow());

            JButton pharmacistBtn = new JButton("SUC-8: Pharmacist Dashboard");
            pharmacistBtn.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            pharmacistBtn.addActionListener(e -> new PharmacistDashboard().showWindow());

            panel.add(label);
            panel.add(Box.createVerticalStrut(15));
            panel.add(infoBtn);
            panel.add(Box.createVerticalStrut(10));
            panel.add(paymentBtn);
            panel.add(Box.createVerticalStrut(10));
            panel.add(insertCardBtn);
            panel.add(Box.createVerticalStrut(10));
            panel.add(maintenanceBtn);
            panel.add(Box.createVerticalStrut(10));
            panel.add(pharmacistBtn);

            menu.add(panel);
            menu.setVisible(true);
        });
    }
}
