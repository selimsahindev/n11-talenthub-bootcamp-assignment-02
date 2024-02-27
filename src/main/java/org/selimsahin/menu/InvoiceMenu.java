package org.selimsahin.menu;

import org.selimsahin.entity.Company;
import org.selimsahin.menu.util.ConsoleUtility;

import java.util.List;
import java.util.Scanner;

/**
 * @author selimsahindev
 */
import org.selimsahin.entity.Invoice;
import org.selimsahin.services.CompanyService;
import org.selimsahin.services.InvoiceService;
import org.selimsahin.services.InvoiceCalculatorService;

public class InvoiceMenu {

    private final Scanner scanner;
    private final InvoiceService invoiceService;
    private final InvoiceCalculatorService calculatorService;

    public InvoiceMenu(Scanner scanner,
                       InvoiceService invoiceService,
                       InvoiceCalculatorService calculatorService) {
        this.scanner = scanner;
        this.invoiceService = invoiceService;
        this.calculatorService = calculatorService;
    }

    public void runInvoiceMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            ConsoleUtility.clearConsole();
            displayInvoiceMenu();

            int choice = getUserChoice();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    break;
                case 2:
                    displayAllInvoices();
                    break;
                case 3:
                    displayInvoicesWithAmountGTE(1500.0);
                    break;
                case 4:
                    displayAverageAmountForInvoicesWithAmountGTE(1500.0);
                    break;
                case 5:
                    displayCustomersWithInvoicesAmountLT(500.0);
                    break;
                case 6:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayInvoiceMenu() {
        System.out.println("\nInvoice Management Menu");
        System.out.println("1. Total amount for invoices in a month (Coming soon...)");
        System.out.println("2. List all invoices");
        System.out.println("3. List invoices with amount greater than 1500TL");
        System.out.println("4. Average of the invoices with amount greater than 1500TL");
        System.out.println("5. List customers with invoices amount less than 500TL");
        System.out.println("6. Back to Main Menu");
        System.out.print("\nEnter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void displayTotalAmountForInvoicesInMonth() {
        // TODO: Implement this method
    }

    private void displayAllInvoices() {
        List<Invoice> invoices = invoiceService.findAll();
        System.out.println("\nAll Invoices:");

        for (Invoice invoice : invoices) {
            System.out.println("\n" + invoice);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void displayInvoicesWithAmountGTE(double amount) {
        List<Invoice> invoices = invoiceService.findByAmountGTE(amount);
        System.out.println("\nInvoices with amount greater than 1500TL:");

        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void displayAverageAmountForInvoicesWithAmountGTE(double amount) {
        List<Invoice> invoices = invoiceService.findByAmountGTE(amount);
        double average = calculatorService.calculateAverageAmount(invoices);

        System.out.println("\nAverage amount for invoices with amount greater than 1500TL: " + average + "TL");
        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void displayCustomersWithInvoicesAmountLT(double amount) {
        List<String> customerNames = invoiceService.findByAmountLT(amount).stream()
                .map(invoice -> invoice.getCustomer().getName())
                .distinct()
                .toList();

        System.out.println("\nCustomers with invoices amount less than 500TL:");

        for (String name : customerNames) {
            System.out.println(name);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }
}

