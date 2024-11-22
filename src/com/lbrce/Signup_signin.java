package com.lbrce;
import java.util.HashMap;
import java.util.Scanner;

public class Signup_signin {
    
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Welcome to User Authentication System ===");
            System.out.println("1. Signup");
            System.out.println("2. Signin");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    signup(scanner);
                    break;
                case 2:
                    signin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static void signup(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Signup successful! You can now Signin.");
    }

    
    private static void signin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        if (!users.containsKey(username)) {
            System.out.println("User does not exist. Please Signup first.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (users.get(username).equals(password)) {
            System.out.println("Signin successful! Welcome, " + username + "!");
        } else {
            System.out.println("Incorrect password. Please try again.");
        }
    }
}
