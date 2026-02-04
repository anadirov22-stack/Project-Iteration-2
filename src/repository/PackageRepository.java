package repository;

import util.DatabaseConnection;
import java.sql.*;

public class PackageRepository {

    public void showPackages() {
        String sql = """
            SELECT p.id, p.description, p.weight, c.name
            FROM packages p
            JOIN category c ON p.category_id = c.id
        """;

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getDouble(3) + "kg | Category: " +
                                rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPackage(String desc, double weight, int categoryId) {
        String sql = "INSERT INTO packages(description, weight, category_id) VALUES (?, ?, ?)";
        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, desc);
            ps.setDouble(2, weight);
            ps.setInt(3, categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
