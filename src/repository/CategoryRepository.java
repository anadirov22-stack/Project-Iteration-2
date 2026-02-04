package repository;

import util.DatabaseConnection;
import java.sql.*;

public class CategoryRepository {

    public void showCategories() {
        String sql = "SELECT * FROM category";

        try (Connection c = DatabaseConnection.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " + rs.getString("name")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
