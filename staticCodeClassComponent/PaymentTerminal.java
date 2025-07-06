package staticCodeClassComponent;

public class PaymentTerminal {
    private int terminalID;
    private boolean isConnected;

    public boolean processCard(String userName, double amount) {
        // Simulate card processing
        return userName != null && amount > 0;
    }

    public boolean checkBalance(String user) {
        return true;
    }

    public boolean executeTransaction() {
        return true;
    }
}