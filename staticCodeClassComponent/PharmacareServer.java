package staticCodeClassComponent;

public class PharmacareServer {
    private String ipAddress;

    public boolean validatePrescription(Patient patient, KupatHolim kupatHolim) {
        return true;
    }

    public boolean drugInformation(String medicineID) {
        return true;
    }

    public boolean updatePrescriptionStatus(String medCode) {
        return true;
    }


    public double getMedicinePrice(String medCode) {
        // Static mapping for demo
        if (medCode.equals("MED123")) return 58.00;
        return 0.0;
    }
}