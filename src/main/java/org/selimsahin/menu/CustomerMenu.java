package org.selimsahin.menu;

import org.selimsahin.entity.Customer;
import org.selimsahin.services.CustomerService;
import org.selimsahin.menu.util.ConsoleUtility;

import java.util.List;
import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class CustomerMenu {

    private final Scanner scanner;
    private final CustomerService customerService;

    public CustomerMenu(Scanner scanner, CustomerService customerService) {
        this.scanner = scanner;
        this.customerService = customerService;
    }

    public void runCustomerMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            ConsoleUtility.clearConsole();
            displayCustomerMenu();

            int choice = getUserChoice();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createCustomer();
                    break;
                case 2:
                    viewAllCustomers();
                    break;
                case 3:
                    findCustomerById();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    updateCustomer();
                    break;
                case 6:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayCustomerMenu() {
        System.out.println("\nCustomer Management Menu");
        System.out.println("1. Create Customer");
        System.out.println("2. View All Customers");
        System.out.println("3. Find Customer by ID");
        System.out.println("4. Delete Customer");
        System.out.println("5. Update Customer");
        System.out.println("6. Back to Main Menu");
        System.out.print("\nEnter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void createCustomer() {
        ConsoleUtility.clearConsole();

        System.out.println("\nEnter customer details:");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer surname: ");
        String surname = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, surname, email);
        customerService.save(customer);
        System.out.println("\nCustomer created successfully.");

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void viewAllCustomers() {
        ConsoleUtility.clearConsole();

        List<Customer> customers = customerService.findAll();

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            System.out.println("\nAll Customers:\n");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void findCustomerById() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter customer ID: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Customer customer = customerService.findById(id);
        if (customer != null) {
            System.out.println("\nCustomer found:\n");
            System.out.println(customer);
        } else {
            System.out.println("\nCustomer not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void deleteCustomer() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter customer ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        if (customerService.delete(id)) {
            System.out.println("\nCustomer deleted successfully.");
        } else {
            System.out.println("\nCustomer not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void updateCustomer() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter customer ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Customer existingCustomer = customerService.findById(id);
        if (existingCustomer != null) {
            System.out.println("Enter new customer details:");
            System.out.print("Enter customer name: ");
            String name = scanner.nextLine();

            System.out.print("Enter customer surname: ");
            String surname = scanner.nextLine();

            System.out.print("Enter customer email: ");
            String email = scanner.nextLine();

            existingCustomer.setName(name);
            existingCustomer.setSurname(surname);
            existingCustomer.setEmail(email);

            if (customerService.update(existingCustomer)) {
                System.out.println("\nCustomer updated successfully.");
            } else {
                System.out.println("\nFailed to update customer.");
            }
        } else {
            System.out.println("\nCustomer not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }
}
