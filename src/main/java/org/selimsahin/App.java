package org.selimsahin;

import org.selimsahin.entity.Customer;
import org.selimsahin.menu.MenuManager;
import org.selimsahin.services.CompanyService;
import org.selimsahin.services.CustomerService;
import org.selimsahin.services.InvoiceCalculatorService;
import org.selimsahin.services.InvoiceService;
import org.selimsahin.services.impl.CompanyServiceImpl;
import org.selimsahin.services.impl.CustomerServiceImpl;
import org.selimsahin.services.impl.InvoiceCalculatorServiceImpl;
import org.selimsahin.services.impl.InvoiceServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class App {
    private static Scanner scanner;
    private static CustomerService customerService;
    private static CompanyService companyService;
    private static InvoiceService invoiceService;
    private static InvoiceCalculatorService invoiceCalculatorService;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        customerService = new CustomerServiceImpl();
        companyService = new CompanyServiceImpl();
        invoiceService = new InvoiceServiceImpl();
        invoiceCalculatorService = new InvoiceCalculatorServiceImpl(invoiceService);

        MenuManager mainMenu = new MenuManager(
                scanner,
                customerService,
                companyService,
                invoiceService,
                invoiceCalculatorService
        );

        mainMenu.runMainMenu();
    }
}
