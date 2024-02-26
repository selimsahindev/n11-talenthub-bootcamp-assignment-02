package org.selimsahin.menu.util;

import java.util.Scanner;

/**
 * @author selimsahindev
 */
public class ConsoleUtility {

    private ConsoleUtility() {
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
