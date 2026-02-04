package controller;

import repository.DeliveryRepository;
import util.ValidationUtil;
import java.util.Scanner;

public class DeliveryController {

    private final DeliveryRepository repo = new DeliveryRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void scheduleDelivery() {
        System.out.print("Drone ID: ");
        int droneId = scanner.nextInt();

        System.out.print("Package ID: ");
        int packageId = scanner.nextInt();
        scanner.nextLine();

        if (!ValidationUtil.isPositive(droneId) || !ValidationUtil.isPositive(packageId)) {
            System.out.println("Invalid IDs.");
            return;
        }

        repo.scheduleDelivery(droneId, packageId);
        System.out.println("Delivery scheduled.");
    }

    public void completeDelivery() {
        System.out.print("Delivery ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (!ValidationUtil.isPositive(id)) {
            System.out.println("Invalid ID.");
            return;
        }

        repo.completeDelivery(id);
        System.out.println("Delivery completed.");
    }

    public void showFullDeliveryInfo() {
        repo.showFullDeliveryInfo();
    }
}
