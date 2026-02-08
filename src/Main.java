import controller.*;
import service.SecurityService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== Login =====

        System.out.println("===== Login =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (!SecurityService.login(username, password)) {
            System.out.println("Access denied.");
            return;
        }

        System.out.println("Login successful!");

        DroneController droneC = new DroneController();
        PackageController packageC = new PackageController();
        DeliveryController deliveryC = new DeliveryController();
        CategoryController categoryC = new CategoryController();

        while (true) {
            System.out.println("""
                ===== Drone Delivery Menu =====
                1. Show drones
                2. Add drone
                3. Show packages
                4. Add package
                5. Schedule delivery
                6. Complete delivery
                7. Show full deliveries
                8. Show categories
                9. Show available drones
                0. Exit
                Choose:
                """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> droneC.showDrones();
                case "2" -> droneC.addDrone();
                case "3" -> packageC.showPackages();
                case "4" -> packageC.addPackage();
                case "5" -> deliveryC.scheduleDelivery();
                case "6" -> deliveryC.completeDelivery();
                case "7" -> deliveryC.showFullDeliveryInfo();
                case "8" -> categoryC.showCategories();
                case "9" -> droneC.showAvailableDrones();
                case "0" -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }
}
