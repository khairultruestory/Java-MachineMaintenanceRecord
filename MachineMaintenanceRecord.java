import java.util.ArrayList;
import java.util.List;

public class MachineMaintenanceRecord {
    private String machineName;
    private List<String> maintenanceDates;

    public MachineMaintenanceRecord(String machineName) {
        this.machineName = machineName;
        this.maintenanceDates = new ArrayList<>();
    }

    public String getMachineName() {
        return machineName;
    }

    public List<String> getMaintenanceDates() {
        return maintenanceDates;
    }

    public void addMaintenanceDate(String date) {
        maintenanceDates.add(date);
    }

    public void removeMaintenanceDate(String date) {
        maintenanceDates.remove(date);
    }

    public void editLastMaintenanceDate(String newDate) {
        if (!maintenanceDates.isEmpty()) {
            maintenanceDates.set(maintenanceDates.size() - 1, newDate);
        }
    }
}
