package GUIscreens;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InsertCardScreen {
    public void showWindow() {
        JFrame frame = new JFrame("Insert Health Fund Card");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel logo = new JLabel("ADVANCED PHARMACARE");
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cardIcon = new JLabel("[ HEALTH FUND CARD ICON ]", SwingConstants.CENTER);
        cardIcon.setFont(new Font("Arial", Font.PLAIN, 14));
        cardIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton insertBtn = new JButton("Insert Health Fund Card");
        JButton cardlessBtn = new JButton("Cardless Transactions");

        insertBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        cardlessBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        insertBtn.setMaximumSize(new Dimension(250, 40));
        cardlessBtn.setMaximumSize(new Dimension(250, 40));

        insertBtn.setFont(new Font("Arial", Font.BOLD, 14));
        cardlessBtn.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(logo);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(cardIcon);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(insertBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cardlessBtn);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
