package controller;

import repository.PackageRepository;
import util.ValidationUtil;
import java.util.Scanner;

public class PackageController {

    private final PackageRepository repo = new PackageRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void showPackages() {
        repo.showPackages();
    }

    public void addPackage() {
        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Weight: ");
        double weight = scanner.nextDouble();

        System.out.print("Category ID: ");
        int catId = scanner.nextInt();
        scanner.nextLine();

        if (!ValidationUtil.isValidText(desc) ||
                !ValidationUtil.isPositive(weight) ||
                !ValidationUtil.isPositive(catId)) {

            System.out.println("Invalid data.");
            return;
        }

        repo.addPackage(desc, weight, catId);
        System.out.println("Package added.");
    }
}
