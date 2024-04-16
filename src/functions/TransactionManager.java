package functions;

import java.util.Scanner;

public class TransactionManager {

    private int accountNum;
    DataManager dm = new DataManager();
    MainMenu mm = new MainMenu();

    public TransactionManager(char choice, Scanner sc){
        setAccountNum(sc);
        HandleTransaction(choice);
        

    }

    public void HandleTransaction(char choice){
        switch(choice){
            case 'W':
                withdrawal();
                break;
            case 'D':
                deposit();
                break;
            case 'N':
                newAccount();
                break;
            case 'B':
                balanceInquiry(accountNum);
                break;
            case 'X':
                deleteAccount();
                break;
            case 'Q':
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
                mm.menu();
                break;
        }
    }

    public void setAccountNum(Scanner sc) {
        System.out.println("Enter Account Number: ");
        try {
            accountNum = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid account number. Please try again.");
            setAccountNum(sc);
        }
    }
    

    public void withdrawal(){
        System.out.println("Withdrawal");
    }

    public void deposit(){
        System.out.println("Deposit");
    }

    public void newAccount(){
        System.out.println("New Account");
    }

    public void balanceInquiry(int accountNum){

        System.out.println("Balance Inquiry");
         
       

        System.out.println( dm.getAccount(accountNum).getBalance());

        
    }

    public void deleteAccount(){
        System.out.println("Delete Account");
    }   

}
