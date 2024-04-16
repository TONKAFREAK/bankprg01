package functions;

import java.util.Scanner;

public class MainMenu {

    
    public boolean valid = false;

    public char menu()
	{
        char choice = ' ';
        Scanner sc = new Scanner(System.in);
        while(!valid){
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
        
        if (choice == 'W' || choice == 'D' || choice == 'N' || choice == 'B' || choice == 'X' || choice == 'Q')
        {
            valid = true;
            
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
        
    }
    return choice;
	}
    
}
