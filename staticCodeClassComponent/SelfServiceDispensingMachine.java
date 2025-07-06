package staticCodeClassComponent;

public class SelfServiceDispensingMachine {
    private int machineID;
    private PharmacareServer server;
    private Robot robot;

    public boolean scanCard(String card) {
        return true;
    }

    public boolean verifyPrescription(Patient patient) {
        return true;
    }

    public boolean connectToServer() {
        return true;
    }

    public boolean connectToRobot() {
        return true;
    }

    public boolean selectMedicine(String code) {
        return true;
    }

    public boolean dispense(String code) {
        return robot.deliverMedicine(code);
    }

    public String resetConfig() {
        return "Reset complete";
    }
}