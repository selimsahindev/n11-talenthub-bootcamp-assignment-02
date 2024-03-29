package org.selimsahin.menu;

import org.selimsahin.services.CompanyService;
import org.selimsahin.services.CustomerService;
import org.selimsahin.services.InvoiceCalculatorService;
import org.selimsahin.services.InvoiceService;

import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class MenuManager {

    private final Scanner scanner;
    private final CustomerService customerService;
    private final CompanyService companyService;
    private final InvoiceService invoiceService;
    private final InvoiceCalculatorService invoiceCalculatorService;
    private final CustomerMenu customerMenu;
    private final CompanyMenu companyMenu;
    private final InvoiceMenu invoiceMenu;

    public MenuManager(Scanner scanner,
                       CustomerService customerService,
                       CompanyService companyService,
                       InvoiceService invoiceService,
                       InvoiceCalculatorService invoiceCalculatorService
    ) {
        this.scanner = scanner;
        this.customerService = customerService;
        this.companyService = companyService;
        this.invoiceService = invoiceService;
        this.invoiceCalculatorService = invoiceCalculatorService;
        this.customerMenu = new CustomerMenu(scanner, customerService);
        this.companyMenu = new CompanyMenu(scanner, companyService);
        this.invoiceMenu = new InvoiceMenu(scanner, invoiceService, invoiceCalculatorService);
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
                    companyMenu.runCompanyMenu();
                    break;
                case 3:
                    invoiceMenu.runInvoiceMenu();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Companies");
        System.out.println("3. Manage Invoices");
        System.out.println("4. Exit");
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
