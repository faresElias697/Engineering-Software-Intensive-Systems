package staticCodeClassComponent;

public class SystemMaintenanceTechnician {
    private String name;
    private int techID;

    public void repair() {
        // repair logic
    }

    public void resetSystem(Robot robot) {
        robot.receivePrescription("RESET");
    }

    public void viewLogs() {
        // View maintenance logs
    }

    public void login(String password) {
        // Login process
    }

    public void exitMaintenanceMode() {
        // Exit maintenance mode logic
    }
}