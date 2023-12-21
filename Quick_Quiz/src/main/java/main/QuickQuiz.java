package main;

import model.User;
import service.UserManager;
import java.util.Scanner;

public class QuickQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = userManager.authenticateUser(username, password);

        if (user != null) {
            System.out.println("Welcome, " + user.getUsername() + "! You are logged in as " + user.getRole() + ".");
            // Further action based on role
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
