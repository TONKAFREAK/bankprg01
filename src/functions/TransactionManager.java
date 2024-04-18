package functions;

import java.util.Scanner;

import user.userAccountInfo;

public class TransactionManager {

    private String accountNum;
    DataManager dm = new DataManager();
    MainMenu mm = new MainMenu();

    public TransactionManager(char choice, Scanner sc){

        if (choice != 'N'){
        setAccountNum(sc);
        }
        HandleTransaction(choice, sc);
        
    }

    public void HandleTransaction(char choice, Scanner sc){
        switch(choice){
            case 'W':
                withdrawal(accountNum, sc);
                break;
            case 'D':
                deposit(accountNum, sc);
                break;
            case 'N':
                newAccount(sc);
                break;
            case 'B':
                balanceInquiry(accountNum);
                break;
            case 'X':
                deleteAccount(sc);
                break;
            case 'Q':
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
                mm.menu(sc);
                break;
        }
    }

    public void setAccountNum(Scanner sc) {
        System.out.print("\n");
        System.out.println("Enter Account Number: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid account number. Please enter a valid integer:");
            sc.next(); 
        }
        accountNum = sc.next().trim();
        sc.nextLine(); 
    }

    
    

    public void withdrawal( String accountNum, Scanner sc){
        System.out.println("Enter amount to withdraw: ");
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid amount:");
            sc.next(); 
        }
        double amount = sc.nextDouble();
        double balance = dm.getAccount(accountNum).getBalance();
        if (amount > balance){
            System.out.println("--------------------------");
            System.out.println("Insufficient funds. Please enter a valid amount:");
            System.out.println("Current Balance: $" + balance);
            System.out.println("--------------------------");
            withdrawal(accountNum, sc);
        }
        else{
            balance -= amount;
            dm.getAccount(accountNum).setBalance(balance);
            System.out.println("--------------------------");
            System.out.println("Transaction Type: Withdrawal");
            System.out.println("Account Number: " + accountNum);
            System.out.println("Withdraw Amount: $" + amount);
            System.out.println("New Balance: $" + balance);
            System.out.println("--------------------------");
            dm.saveData();
            dm.printData("Withdrawal", accountNum, dm.getAccount(accountNum).getAccountType(),amount, balance);
        }
    }

    public void deposit( String accountNum, Scanner sc){

        System.out.println("Enter amount to deposit: ");

        while (!sc.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid amount:");
            sc.next(); 
        }
        
        double amount = sc.nextDouble();

        if (amount < 0){
            System.out.println("--------------------------");
            System.out.println("Invalid amount. Please enter a valid amount:");
            System.out.println("--------------------------");
            deposit(accountNum, sc);
        } else {
        double balance = dm.getAccount(accountNum).getBalance();
        balance += amount;
        dm.getAccount(accountNum).setBalance(balance);
        System.out.println("--------------------------");
        System.out.println("Transaction Type: Deposit");
        System.out.println("Account Number: " + accountNum);
        System.out.println("Deposit Amount: $" + amount);
        System.out.println("New Balance: $" + balance);
        System.out.println("--------------------------");
        dm.saveData();
        dm.printData("Deposit", accountNum,dm.getAccount(accountNum).getAccountType(), amount, balance); 
        }
    }

    

    public void balanceInquiry(String accountNum){

        System.out.println("--------------------------");
        System.out.println("Transaction Type: Balance Inquiry");
        System.out.println("Account Number: " + accountNum);
        double balance = dm.getAccount(accountNum).getBalance();
        System.out.println("Balance: $" +balance);
        System.out.println("--------------------------");
        dm.printData("Balance Inquiry", accountNum,dm.getAccount(accountNum).getAccountType(), 0, balance);

    }

    public void deleteAccount(Scanner sc){

        if (dm.getAccount(accountNum) == null){
            System.out.println("--------------------------");
            System.out.println("Account " + accountNum + " does not exist.");
            System.out.println("--------------------------");
        }

        if (dm.getAccount(accountNum).getBalance() != 0){
            System.out.println("--------------------------");
            System.out.println("Account " + accountNum + " has a balance of $" + dm.getAccount(accountNum).getBalance() + ".\nPlease withdraw all funds before deleting account.");
            System.out.println("--------------------------");
        }

        System.out.println("Please enter last four degits of your SSN :");
        String ssn = sc.next();
        System.out.println(dm.getAccount(accountNum).getSSN().substring(7, 11));

        if (!ssn.equals(dm.getAccount(accountNum).getSSN().substring(7, 11)) ){
            System.out.println("--------------------------");
            System.out.println("Invalid SSN. Please try again.");
            System.out.println("Account " + accountNum + " has not been deleted.");
            System.out.println("--------------------------");
        }

        if (ssn.equals(dm.getAccount(accountNum).getSSN().substring(7, 11)) ){
            dm.deleteAccount(accountNum);
            dm.saveData(); 
            dm.printData("Delete Account", accountNum, dm.getAccount(accountNum).getAccountType(), 0, 0);
            System.out.println("--------------------------");
            System.out.println("Account " + accountNum + " has been deleted.");
            System.out.println("--------------------------");
        } 
        
        
        
    } 
    
    public void newAccount(Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Creating a New Account");
    
        String lastAccountNum = dm.getLastAccountNumber();
        int newAccountNumber = Integer.parseInt(lastAccountNum) + 1;
        String accountNum = String.format("%06d", newAccountNumber);
    
        System.out.print("Enter Account Type (e.g., Debit, Credit): ");
        String acctType = capitalizeFirstLetter(sc.next());
    
        System.out.print("Enter First Name: ");
        String firstName = capitalizeFirstLetter(sc.next());
    
        System.out.print("Enter Last Name: ");
        String lastName = capitalizeFirstLetter(sc.next());
    
        System.out.print("Enter SSN (Format: XXX-XX-XXXX): ");
        String ssn;
        while(true) {
            ssn = sc.next();
            if (ssn.matches("\\d{3}-\\d{2}-\\d{4}")) break;
            System.out.println("Invalid SSN. Please enter in the format XXX-XX-XXXX:");
        }
    
        System.out.print("Enter Initial Balance: ");
        double balance;
        while (!sc.hasNextDouble()) {
            System.out.println("Invalid amount. Please enter a valid amount:");
            sc.next(); 
        }
        balance = sc.nextDouble();
    
        dm.addAccount(new userAccountInfo(accountNum, acctType, firstName, lastName, ssn, balance));
        dm.saveData();
        System.out.println("New account created with Account Number: " + accountNum);
        dm.printData("Create an Account", accountNum, acctType, 0, balance);
        System.out.println("--------------------------");
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str; 
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
    

}
