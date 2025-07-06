package staticCodeClassComponent;

public class KupatHolim {
    private String providerName;
    private int networkCode;

    public boolean verifyHealthCard(String card) {
        return true;
    }

    public boolean fetchPrescriptions(int patientID) {
        return true;
    }

    public boolean updatePrescriptionStatus(String medCode) {
        return true;
    }
}