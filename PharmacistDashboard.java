package GUIscreens;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PharmacistDashboard {
    public void showWindow() {
        JFrame frame = new JFrame("Pharmacist Dashboard");
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Sidebar
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(225, 232, 240));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(180, 0));
        sidebar.setBorder(new EmptyBorder(20, 10, 10, 10));

        JLabel logo = new JLabel("<html><b>Advanced PharmaCare</b></html>");
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setFont(new Font("Arial", Font.BOLD, 14));

        JButton checkBtn = new JButton("Check Medicine Stock");
        JButton orderBtn = new JButton("Order Medicine");
        JButton reportBtn = new JButton("Reports");
        JButton logoutBtn = new JButton("Logout");

        for (JButton btn : new JButton[]{checkBtn, orderBtn, reportBtn, logoutBtn}) {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(160, 35));
            btn.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        sidebar.add(logo);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(checkBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(orderBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(reportBtn);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(logoutBtn);

        // GUIscreens.Main panel container
        JPanel mainPanel = new JPanel(new CardLayout());
        mainPanel.setBackground(Color.WHITE);

        // ----------------------- PAGE 1: Medicine Stock -----------------------
        JPanel stockPanel = new JPanel(new BorderLayout());
        stockPanel.setBackground(Color.WHITE);
        stockPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Medicine Stock");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        String[] columns = {"Medicine Name", "Code", "Expiry Date", "Quantity in Stock", "Status"};
        Object[][] data = {
                {"Aspirin", "ASP100", "08/15/2024", 150, "✔ Available"},
                {"Lisinopril", "LIS10", "12/10/2024", 75, "✔ Available"},
                {"Metformin", "MET500", "06/30/2025", 30, "⚠ Low"},
                {"Amoxicillin", "AMX250", "05/22/2024", 200, "✔ Available"},
                {"Atorvastatin", "ATO20", "01/18/2025", 40, "✔ Available"},
                {"Albuterol", "ALB100", "11/05/2024", 120, "✔ Available"},
        };

        JTable table = new JTable(new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        JScrollPane tableScroll = new JScrollPane(table);

        stockPanel.add(title, BorderLayout.NORTH);
        stockPanel.add(tableScroll, BorderLayout.CENTER);

        // ----------------------- PAGE 2: Order Medicine -----------------------
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel orderTitle = new JLabel("Order Missing Medicine");
        orderTitle.setFont(new Font("Arial", Font.BOLD, 18));
        orderTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField medField = new JTextField("Albuterol");
        medField.setMaximumSize(new Dimension(200, 30));
        medField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel qtyPanel = new JPanel();
        qtyPanel.setBackground(Color.WHITE);
        JButton minus = new JButton("-");
        JTextField qtyField = new JTextField("1");
        qtyField.setHorizontalAlignment(JTextField.CENTER);
        qtyField.setMaximumSize(new Dimension(40, 30));
        JButton plus = new JButton("+");

        qtyPanel.add(minus);
        qtyPanel.add(qtyField);
        qtyPanel.add(plus);

        JButton confirmOrder = new JButton("Confirm Order");
        confirmOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmOrder.setBackground(new Color(0, 120, 215));
        confirmOrder.setForeground(Color.WHITE);
        confirmOrder.setFont(new Font("Arial", Font.BOLD, 14));
        confirmOrder.setFocusPainted(false);

        plus.addActionListener(e -> {
            int qty = Integer.parseInt(qtyField.getText());
            qtyField.setText(String.valueOf(qty + 1));
        });

        minus.addActionListener(e -> {
            int qty = Integer.parseInt(qtyField.getText());
            if (qty > 1) qtyField.setText(String.valueOf(qty - 1));
        });

        confirmOrder.addActionListener(e -> {
            String med = medField.getText();
            String qty = qtyField.getText();
            JOptionPane.showMessageDialog(frame, "Order placed for " + qty + " unit(s) of " + med);
        });

        orderPanel.add(orderTitle);
        orderPanel.add(Box.createVerticalStrut(10));
        orderPanel.add(medField);
        orderPanel.add(Box.createVerticalStrut(10));
        orderPanel.add(qtyPanel);
        orderPanel.add(Box.createVerticalStrut(10));
        orderPanel.add(confirmOrder);

        // ----------------------- PAGE 3: Reports -----------------------
        JPanel reportsPanel = new JPanel();
        reportsPanel.setLayout(new BoxLayout(reportsPanel, BoxLayout.Y_AXIS));
        reportsPanel.setBackground(Color.WHITE);
        reportsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        JLabel reportLabel = new JLabel("📊 Reports Page - Coming Soon");
        reportLabel.setFont(new Font("Arial", Font.BOLD, 18));
        reportLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportsPanel.add(reportLabel);

        // Add panels to CardLayout
        mainPanel.add(stockPanel, "STOCK");
        mainPanel.add(orderPanel, "ORDER");
        mainPanel.add(reportsPanel, "REPORTS");

        CardLayout layout = (CardLayout) mainPanel.getLayout();

        // ----------------------- Sidebar Button Actions -----------------------
        checkBtn.addActionListener(e -> layout.show(mainPanel, "STOCK"));
        orderBtn.addActionListener(e -> layout.show(mainPanel, "ORDER"));
        reportBtn.addActionListener(e -> layout.show(mainPanel, "REPORTS"));
        logoutBtn.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "You have been logged out.");
        });

        // ----------------------- Assemble Layout -----------------------
        frame.add(sidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
