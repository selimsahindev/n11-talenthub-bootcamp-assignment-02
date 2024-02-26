package org.selimsahin.menu;

import org.selimsahin.entity.Company;
import org.selimsahin.entity.Customer;
import org.selimsahin.menu.util.ConsoleUtility;
import org.selimsahin.services.CompanyService;
import org.selimsahin.services.CustomerService;

import java.util.List;
import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class CompanyMenu {

    private final Scanner scanner;
    private final CompanyService companyService;

    public CompanyMenu(Scanner scanner, CompanyService companyService) {
        this.scanner = scanner;
        this.companyService = companyService;
    }

    public void runCompanyMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            ConsoleUtility.clearConsole();
            displayCompanyMenu();

            int choice = getUserChoice();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createCompany();
                    break;
                case 2:
                    viewAllCompanies();
                    break;
                case 3:
                    findCompanyById();
                    break;
                case 4:
                    deleteCompany();
                    break;
                case 5:
                    updateCompany();
                    break;
                case 6:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private void displayCompanyMenu() {
        System.out.println("\nCompany Management Menu");
        System.out.println("1. Create Company");
        System.out.println("2. View All Companies");
        System.out.println("3. Find Company by ID");
        System.out.println("4. Delete Company");
        System.out.println("5. Update Company");
        System.out.println("6. Back to Main Menu");
        System.out.print("\nEnter your choice: ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void createCompany() {
        ConsoleUtility.clearConsole();

        System.out.println("\nEnter company details:");

        System.out.print("Enter company name: ");
        String name = scanner.nextLine();

        System.out.print("Enter company work area: ");
        String workArea = scanner.nextLine();

        Company company = new Company(name, workArea);
        companyService.save(company);
        System.out.println("\nCompany created successfully.");

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void viewAllCompanies() {
        ConsoleUtility.clearConsole();

        List<Company> companies = companyService.findAll();

        if (companies.isEmpty()) {
            System.out.println("No companies found.");
        } else {
            System.out.println("\nAll Companies:\n");
            for (Company company : companies) {
                System.out.println(company);
            }
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void findCompanyById() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter company ID: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Company company = companyService.findById(id);
        if (company != null) {
            System.out.println("\nCompany found:\n");
            System.out.println(company);
        } else {
            System.out.println("\nCompany not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void deleteCompany() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter company ID to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        if (companyService.delete(id)) {
            System.out.println("\nCompany deleted successfully.");
        } else {
            System.out.println("\nCompany not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }

    private void updateCompany() {
        ConsoleUtility.clearConsole();

        System.out.print("\nEnter company ID to update: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Company company = companyService.findById(id);

        if (company != null) {
            System.out.println("Enter new company details:");

            // Get existing values for reference
            String defaultName = company.getName();
            String defaultWorkArea = company.getWorkArea();

            // Get new values from user input
            System.out.print("Enter company name (" + defaultName + "): ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                name = defaultName; // Use default value if input is empty
            }

            System.out.print("Enter company work area (" + defaultWorkArea + "): ");
            String workArea = scanner.nextLine();
            if (workArea.isEmpty()) {
                workArea = defaultWorkArea; // Use default value if input is empty
            }

            company.setName(name);
            company.setWorkArea(workArea);

            if (companyService.update(company)) {
                System.out.println("\nCompany updated successfully.");
            } else {
                System.out.println("\nFailed to update company.");
            }
        } else {
            System.out.println("\nCompany not found with ID: " + id);
        }

        ConsoleUtility.pressEnterToContinue(scanner);
    }
}
