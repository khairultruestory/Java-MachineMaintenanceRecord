import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MachineMaintenanceApp {
    public static void main(String[] args) {
        List<MachineMaintenanceRecord> records = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Machine Maintenance Record App");
            System.out.println("1. Add Machine");
            System.out.println("2. Remove Machine");
            System.out.println("3. Add Maintenance Record Date");
            System.out.println("4. Edit Last Maintenance Date");
            System.out.println("5. Retrieve Maintenance Dates");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter machine name: ");
                    String machineName = scanner.nextLine();
                    records.add(new MachineMaintenanceRecord(machineName));
                    break;
                case 2:
                    System.out.print("Enter machine name to remove: ");
                    String machineToRemove = scanner.nextLine();
                    records.removeIf(record -> record.getMachineName().equals(machineToRemove));
                    break;
                case 3:
                    System.out.print("Enter machine name: ");
                    String machineToAddDate = scanner.nextLine();
                    MachineMaintenanceRecord recordToAddDate = findRecord(records, machineToAddDate);

                    if (recordToAddDate != null) {
                        System.out.print("Enter maintenance date (yyyy-mm-dd): ");
                        String date = scanner.nextLine();
                        recordToAddDate.addMaintenanceDate(date);
                    } else {
                        System.out.println("Machine not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter machine name: ");
                    String machineToEditDate = scanner.nextLine();
                    MachineMaintenanceRecord recordToEditDate = findRecord(records, machineToEditDate);

                    if (recordToEditDate != null) {
                        if (!recordToEditDate.getMaintenanceDates().isEmpty()) {
                            System.out.print("Enter new maintenance date (yyyy-mm-dd): ");
                            String newDate = scanner.nextLine();
                            recordToEditDate.editLastMaintenanceDate(newDate);
                        } else {
                            System.out.println("No maintenance dates available for this machine.");
                        }
                    } else {
                        System.out.println("Machine not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter machine name: ");
                    String machineToRetrieveDates = scanner.nextLine();
                    MachineMaintenanceRecord recordToRetrieveDates = findRecord(records, machineToRetrieveDates);

                    if (recordToRetrieveDates != null) {
                        List<String> maintenanceDates = recordToRetrieveDates.getMaintenanceDates();
                        System.out.println("Maintenance dates for " + machineToRetrieveDates + ":");
                        for (String date : maintenanceDates) {
                            System.out.println(date);
                        }
                    } else {
                        System.out.println("Machine not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the app.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option (1-6).");
                    break;
            }
        }
    }

    private static MachineMaintenanceRecord findRecord(List<MachineMaintenanceRecord> records, String machineName) {
        for (MachineMaintenanceRecord record : records) {
            if (record.getMachineName().equals(machineName)) {
                return record;
            }
        }
        return null;
    }
}
