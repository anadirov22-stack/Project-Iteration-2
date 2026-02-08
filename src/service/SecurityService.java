package service;

import factory.UserFactory;
import model.Role;
import model.User;

public class SecurityService {

    private static User currentUser;

    public static boolean login(String username, String password) {

        User user = UserFactory.createUser(username);

        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public static boolean hasRole(Role role) {
        return currentUser != null && currentUser.getRole() == role;
    }
}
