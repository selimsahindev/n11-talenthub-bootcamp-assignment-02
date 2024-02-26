package org.selimsahin;

import org.selimsahin.entity.Customer;
import org.selimsahin.menu.MenuManager;
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


    public static void main(String[] args) {
        MenuManager mainMenu = new MenuManager(scanner, customerService);

        mainMenu.runMainMenu();
    }
}
