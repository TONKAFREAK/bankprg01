package functions;

import java.util.Scanner;

public class MainMenu {

    public char menu(Scanner sc) {
        char choice = ' ';
        boolean valid = false;
        while (!valid) {
            System.out.println();
            System.out.println("Select one of the following transactions:");
            System.out.println("\t****************************");
            System.out.println("\t    List of Choices         ");
            System.out.println("\t****************************");
            System.out.println("\t     W -- Withdrawal");
            System.out.println("\t     D -- Deposit");
            System.out.println("\t     N -- New Account");
            System.out.println("\t     B -- Balance Inquiry");
            System.out.println("\t     X -- Delete Account");
            System.out.println("\t     Q -- Quit");
            System.out.println();
            System.out.print("\tEnter your selection: ");
            choice = Character.toUpperCase(sc.next().charAt(0));

            if ("WDNBXQ".indexOf(choice) >= 0) {
                valid = true;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }
}
