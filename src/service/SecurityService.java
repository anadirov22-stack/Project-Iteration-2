package service;

import model.Role;
import model.User;

public class SecurityService {

    private static User currentUser;

    public static boolean login(String username, String password) {

        if (username.equals("admin") && password.equals("admin123")) {
            currentUser = new User(username, password, Role.ADMIN);
            return true;
        }

        if (username.equals("manager") && password.equals("manager123")) {
            currentUser = new User(username, password, Role.MANAGER);
            return true;
        }

        if (username.equals("user") && password.equals("user123")) {
            currentUser = new User(username, password, Role.USER);
            return true;
        }

        return false;
    }

    public static boolean hasRole(Role role) {
        return currentUser != null && currentUser.getRole() == role;
    }
}
