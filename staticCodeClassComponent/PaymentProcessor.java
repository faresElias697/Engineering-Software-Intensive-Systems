package staticCodeClassComponent;

public class PaymentProcessor {

    // Check if the card is readable (format validation)
    public static boolean isCardReadable(CreditCardPatient card) {
        String cardNumber = card.getCardNumber();
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    // Check if balance is sufficient
    public static boolean hasSufficientBalance(CreditCardPatient card, double amount) {
        double balance = getBalanceForCard(card.getCardNumber());
        return balance >= amount;
    }

    // Main processing method (still usable if you want one call)
    public static boolean processCard(CreditCardPatient card, double amount) {
        if (!isCardReadable(card)) {
            System.out.println("Invalid card number format.");
            return false;
        }

        if (!hasSufficientBalance(card, amount)) {
            System.out.println("Insufficient funds for card: " + card.getCardNumber());
            return false;
        }

        System.out.println("Card approved: " + card.getCardNumber() + ", amount: " + amount);
        return true;
    }

    // Simulate credit card balances
    private static double getBalanceForCard(String cardNumber) {
        switch (cardNumber) {
            case "1111222233334444":
                return 100.00;
            case "5555666677778888":
                return 40.00;
            case "9999888877776666":
                return 0.00;
            default:
                return 60.00;
        }
    }
}
