package GUIscreens;

import javax.swing.*;

public class OrderMedicineScreen {
    public void showWindow() {
        JFrame frame = new JFrame("הזמנת תרופה שאינה במלאי");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField medField = new JTextField();
        JButton orderBtn = new JButton("הזמן");

        orderBtn.addActionListener(e -> {
            String med = medField.getText();
            if (!med.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "הזמנת התרופה '" + med + "' נשלחה.");
            } else {
                JOptionPane.showMessageDialog(frame, "נא להזין שם תרופה", "שגיאה", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("שם התרופה:"));
        panel.add(medField);
        panel.add(orderBtn);

        frame.add(panel);
        frame.setVisible(true);
    }
}
