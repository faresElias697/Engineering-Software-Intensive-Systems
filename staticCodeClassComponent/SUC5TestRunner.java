package staticCodeClassComponent;

import javax.swing.*;

public class SUC5TestRunner {
    public static void main(String[] args) {
        PharmacareServer server = new PharmacareServer();
        double price = server.getMedicinePrice("MED123");

        JOptionPane.showMessageDialog(null, "💊 Total price: ₪" + price);

        boolean paymentSuccess = false;

        while (!paymentSuccess) {
            String cardNumber = JOptionPane.showInputDialog(null, "💳 Enter your 16-digit credit card number (or Cancel to exit):");

            if (cardNumber == null || cardNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "❌ Payment cancelled by user.");
                return;
            }

            CreditCardPatient card = new CreditCardPatient(cardNumber);

            // Step 1: Check if card is readable
            if (!PaymentProcessor.isCardReadable(card)) {
                JOptionPane.showMessageDialog(null, "⚠️ Card unreadable. Please try again.", "Card Error", JOptionPane.WARNING_MESSAGE);
                continue; // Loop back
            }

            // Step 2: Check if balance is sufficient
            if (!PaymentProcessor.hasSufficientBalance(card, price)) {
                JOptionPane.showMessageDialog(null, "❌ Insufficient funds. Please try a different card.", "Payment Error", JOptionPane.ERROR_MESSAGE);
                continue; // Loop back
            }

            // Step 3: Process Payment
            paymentSuccess = true;
            JOptionPane.showMessageDialog(null, "✅ Payment completed successfully!");

            // Step 4: Notify Kupat Holim and dispense medicine
            KupatHolimProxy kupatHolim = new KupatHolimProxy();
            kupatHolim.transmitPrescription("MED123");

            Robot robot = new Robot();
            robot.deliverMedicine("MED123");

            System.out.println("✅ Payment complete. Prescription updated and medicine dispensed.");
        }
    }
}
