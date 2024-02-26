package org.selimsahin.menu;

import org.selimsahin.services.CustomerService;

import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class MenuManager {

    private final Scanner scanner;
    private final CustomerService customerService;
    private final CustomerMenu customerMenu;

    public MenuManager(Scanner scanner, CustomerService customerService) {
        this.scanner = scanner;
        this.customerService = customerService;
        this.customerMenu = new CustomerMenu(scanner, customerService);
    }

    public void runMainMenu() {
        boolean exit = false;

        while (!exit) {
            clearConsole();
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    customerMenu.runCustomerMenu();
                    break;
                case 2:
                    // Implement manageInvoices() method
                    System.out.println("Manage Invoices feature coming soon...");
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Invoices");
        System.out.println("3. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J"); // Clear console
        System.out.flush();
    }
}
