package org.selimsahin;

import org.selimsahin.entity.Customer;
import org.selimsahin.services.CustomerService;
import org.selimsahin.services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 *  @author selimsahindev
 */
public class App 
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerService customerService = new CustomerServiceImpl();

    private static final String PRESS_ENTER = "\nPress Enter to continue...";

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            clearConsole(); // Clear console

            // Display main menu
            System.out.println("\nMain Menu");
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Invoices");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageCustomers();
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

        scanner.close();
    }

    private static void manageCustomers() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            clearConsole(); // Clear console

            // Display customer management menu
            System.out.println("\nCustomer Management Menu");
            System.out.println("1. Create Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Find Customer by ID");
            System.out.println("4. Delete Customer");
            System.out.println("5. Update Customer");
            System.out.println("6. Back to Main Menu");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
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

    private static void createCustomer() {
        clearConsole(); // Clear console

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

        System.out.print(PRESS_ENTER);
        scanner.nextLine();
    }

    private static void viewAllCustomers() {
        clearConsole(); // Clear console
        List<Customer> customers = customerService.findAll();

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println("\nAll Customers:\n");
                System.out.println(customer);
            }
        }

        System.out.print(PRESS_ENTER);
        scanner.nextLine();
    }

    private static void findCustomerById() {
        clearConsole(); // Clear console

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

        System.out.print(PRESS_ENTER);
        scanner.nextLine();
    }

    private static void deleteCustomer() {
        clearConsole(); // Clear console

        System.out.print("\nEnter customer ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        if (customerService.delete(id)) {
            System.out.println("\nCustomer deleted successfully.");
        } else {
            System.out.println("\nCustomer not found with ID: " + id);
        }

        System.out.print(PRESS_ENTER);
        scanner.nextLine();
    }

    private static void updateCustomer() {
        clearConsole(); // Clear console

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

        System.out.print(PRESS_ENTER);
        scanner.nextLine();
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J"); // Clear console
        System.out.flush();
    }
}
