package repository;

import util.DatabaseConnection;
import java.sql.*;

public class DroneRepository {

    public void showDrones() {
        String sql = "SELECT * FROM drone";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("model") + " | " +
                                rs.getDouble("max_payload") + "kg | Available: " +
                                rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAvailableDrones() {
        String sql = "SELECT * FROM drone WHERE available = true";
        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("model") + " | " +
                                rs.getDouble("max_payload") + "kg | Available: " +
                                rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDrone(String model, double payload) {
        String sql = "INSERT INTO drone(model, max_payload, available) VALUES (?, ?, true)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, model);
            ps.setDouble(2, payload);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
