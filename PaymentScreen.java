package GUIscreens;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PaymentScreen {
    public void showWindow() {
        JFrame frame = new JFrame("Make Payment for Medicine");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 30, 20, 30));
        mainPanel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Make Payment for Medicine", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBorder(new EmptyBorder(10, 0, 20, 0));

        // Table for medicine list
        String[] columns = {"Medicine", "Price"};
        Object[][] data = {
                {"Atorvastatin", "$25.00"},
                {"Lisinopril", "$15.00"},
                {"Metformin", "$18.00"},
                {"Total", "$58.00"},
        };
        JTable table = new JTable(new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(30);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(300, 100));

        // Right card panel
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(new EmptyBorder(10, 40, 10, 0));

        JLabel cardLabel = new JLabel("<html><center><b>HEALTH<br>FUND CARD</b><br><br>1234 5676 <b>9012</b> 3/30</center></html>");
        cardLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardLabel.setOpaque(true);
        cardLabel.setBackground(new Color(220, 235, 250));
        cardLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        cardLabel.setPreferredSize(new Dimension(160, 100));
        cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        cardPanel.add(Box.createVerticalGlue());
        cardPanel.add(cardLabel);
        cardPanel.add(Box.createVerticalGlue());

        // Split layout: table on left, card on right
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(tableScroll, BorderLayout.CENTER);
        centerPanel.add(cardPanel, BorderLayout.EAST);

        // Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        JButton payBtn = new JButton("Pay with Credit Card");
        JButton cancelBtn = new JButton("Cancel Payment");

        payBtn.setBackground(new Color(0, 120, 215));
        payBtn.setForeground(Color.WHITE);
        payBtn.setFont(new Font("Arial", Font.BOLD, 16));
        payBtn.setFocusPainted(false);

        cancelBtn.setBackground(new Color(220, 53, 69));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFont(new Font("Arial", Font.BOLD, 16));
        cancelBtn.setFocusPainted(false);

        // --- Payment logic ---
        payBtn.addActionListener(e -> {
            String cardNumber = JOptionPane.showInputDialog(frame, "Enter your credit card number:");

            if (cardNumber == null) {
                // User clicked cancel
                return;
            }

            if (cardNumber.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(frame, "Payment completed successfully!");
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Invalid credit card number. Please enter a 16-digit number.",
                        "Payment Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelBtn.addActionListener(e -> frame.dispose());

        buttonPanel.add(payBtn);
        buttonPanel.add(cancelBtn);

        // Assemble
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setVisible(true);
    }
}
