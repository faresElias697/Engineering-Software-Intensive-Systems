package staticCodeClassComponent;

public class Robot {
    private String currentStatus;

    public boolean receivePrescription(String medCode) {
        return true;
    }

    public boolean operateMotor(String medCode) {
        return true;
    }

    public boolean deliverMedicine(String medCode) {
        System.out.println("Dispensing: " + medCode);
        return true;
    }

    public boolean checkMotorStatus() {
        return true;
    }

    public boolean selfTest() {
        return true;
    }
}