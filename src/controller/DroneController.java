package controller;

import repository.DroneRepository;
import util.ValidationUtil;
import java.util.Scanner;

public class DroneController {

    private final DroneRepository repo = new DroneRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void showDrones() {
        repo.showDrones();
    }

    public void showAvailableDrones() {
        repo.showAvailableDrones();
    }

    public void addDrone() {
        System.out.print("Drone model: ");
        String model = scanner.nextLine();

        System.out.print("Max payload (kg): ");
        double payload = scanner.nextDouble();
        scanner.nextLine();

        if (!ValidationUtil.isValidText(model) || !ValidationUtil.isPositive(payload)) {
            System.out.println("Invalid data. Model cannot be empty and payload must be positive.");
            return;
        }

        repo.addDrone(model, payload);
        System.out.println("Drone added successfully.");
    }
}
