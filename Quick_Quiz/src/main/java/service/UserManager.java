package service;

import model.User;
import util.FileHandler;
import java.util.List;

public class UserManager {
    private static final String USER_FILE = "./src/main/resources/users.json";
    private List<User> users;

    public UserManager() {
        this.users = FileHandler.readUsersFromFile(USER_FILE);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // ... other methods
}
