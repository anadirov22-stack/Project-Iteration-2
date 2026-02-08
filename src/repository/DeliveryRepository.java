package repository;

import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository {

    public void scheduleDelivery(int droneId, int packageId) {
        String sql = "INSERT INTO delivery(drone_id, package_id, status) VALUES (?, ?, 'Scheduled')";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, droneId);
            ps.setInt(2, packageId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void completeDelivery(int id) {
        String sql = "UPDATE delivery SET status='Completed' WHERE id=?";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFullDeliveryInfo() {
        String sql = """
            SELECT d.id, dr.model, p.description, c.name, d.status
            FROM delivery d
            JOIN drone dr ON d.drone_id = dr.id
            JOIN packages p ON d.package_id = p.id
            JOIN category c ON p.category_id = c.id
        """;

        List<String> deliveries = new ArrayList<>();

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                deliveries.add(
                        "Delivery #" + rs.getInt(1) +
                                " | Drone: " + rs.getString(2) +
                                " | Package: " + rs.getString(3) +
                                " | Category: " + rs.getString(4) +
                                " | Status: " + rs.getString(5)
                );
            }

            // STREAM + ЛЯМБДА
            deliveries.stream()
                    .forEach(d -> System.out.println(d));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
