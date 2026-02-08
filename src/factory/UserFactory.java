package factory;

import model.Role;
import model.User;

public class UserFactory {

    public static User createUser(String username) {

        return switch (username) {
            case "admin" ->
                    new User("admin", "admin123", Role.ADMIN);
            case "manager" ->
                    new User("manager", "manager123", Role.MANAGER);
            case "user" ->
                    new User("user", "user123", Role.USER);
            default -> null;
        };
    }
}
