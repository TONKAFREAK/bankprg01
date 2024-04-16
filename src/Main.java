import java.util.Scanner;

import functions.DataManager;
import functions.MainMenu;
import functions.TransactionManager;

public class Main {

    MainMenu mm = new MainMenu();
    
    Scanner scanner = new Scanner(System.in);
    char choice;
    public Main() {

        try {
            do {
                choice = mm.menu(); 
                if (choice != 'Q') {
                    new DataManager();
                    new TransactionManager(choice, scanner);
                }
            } while (choice != 'Q');
        } finally {
            if (scanner != null) {
                scanner.close(); 
            }
        }

    }

    public static void main(String[] args) {
       
        new Main();
        

    }
}