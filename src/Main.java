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
            new DataManager();
            do {
                choice = mm.menu(scanner); 
                if (choice != 'Q') {
                    
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