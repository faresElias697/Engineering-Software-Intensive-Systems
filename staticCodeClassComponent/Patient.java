package staticCodeClassComponent;

public class Patient {
    public String name;
    private int id;
    private String healthFundCard;
    private String[] prescriptionIDs;

    public boolean authenticate(String card) {
        return healthFundCard != null && healthFundCard.equals(card);
    }

    public String[] getPrescriptions() {
        return prescriptionIDs;
    }

    public boolean confirmSelection(String medCode) {
        if (prescriptionIDs == null) return false;
        for (String id : prescriptionIDs) {
            if (id.equals(medCode)) return true;
        }
        return false;
    }

    public boolean requestInformation(String medName) {
        return true;
    }

    public boolean makePayment(String cardNumber) {
        PaymentTerminal terminal = new PaymentTerminal();
        return terminal.processCard(this.name, 58.00); // assume static price
    }

    public boolean cancelPayment() {
        return true;
    }

    public boolean insertCard(String cardNumber) {
        return true;
    }

    public boolean performCardlessTransaction() {
        return true;
    }
}