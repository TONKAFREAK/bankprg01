package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import user.userAccountInfo;

public class DataManager {

    final int MAX_ACCOUNTS = 100;

    private userAccountInfo[] accounts = new userAccountInfo[MAX_ACCOUNTS];
    
    File dataFile = new File("src/data/database.txt");
    File outFile = new File("src/data/output.txt");
    File traFile = new File("src/data/tranum.txt");
    BufferedWriter writer;
    int count = 0;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  

    public DataManager(){
        readDataFile();
    }

    public void readDataFile(){
        
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length >= 6) {
                        String acctNum =parts[0];
                        String acctType = parts[1];
                        String firstName = parts[2];
                        String lastName = parts[3];
                        String ssn = parts[4];
                        double balance = Double.parseDouble(parts[5]);
                        accounts[count++] = new userAccountInfo(acctNum, acctType, firstName, lastName, ssn, balance);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData(String transactionType, String accountNum, double amount, double balance){

        try {

            writer = new BufferedWriter(new java.io.FileWriter(outFile, true));
            writer.write("Date: "+ dtf.format(now) + " | Transaction #" +getTranscationNumber()+"\n");
            writer.write("Transaction Type: " + transactionType + "\n");
            writer.write("Account Number: " + accountNum + "\n");
            if (transactionType.equals("Withdrawal")) {
                writer.write("Withdraw Amount: $" + amount + "\n");
            }
            if (transactionType.equals("Deposit")) {
                writer.write("Deposit Amount: $" + amount + "\n");
            }
            if (!transactionType.equals("Delete Account")) {
                writer.write("Balance: $" + balance + "\n");
            }
            
            writer.write("\n");
            updateTranscationNumber(getTranscationNumber()+1);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }


    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(dataFile))) {
            // Writing the header with fixed column widths
            writer.write(String.format("%-10s %-10s %-12s %-12s %-12s %-15s\n",
                                       "# AcctNum", "AcctType", "FirstName", "LastName", "SSN", "Balance"));
    
            // Loop through each account and format each field to align under its corresponding column
            for (userAccountInfo account : accounts) {
                if (account != null) {
                    String line = String.format("%-10s %-10s %-12s %-12s %-12s %-15.2f\n",
                                                account.getAccountNum(),
                                                account.getAccountType(),
                                                account.getFirstName(),
                                                account.getLastName(),
                                                account.getSSN(),
                                                account.getBalance());
                    writer.write(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    public userAccountInfo getAccount(String accountNum) {
        for (userAccountInfo account : accounts) {
            if (account != null && account.getAccountNum().equals(accountNum)) {
                return account;
            }
        }
        return null;
    }

    public int getTranscationNumber() throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(traFile));
        int num = Integer.parseInt(reader.readLine());
        reader.close();
        return num;
    }

    public void updateTranscationNumber(int num) throws IOException{
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(traFile));
        writer.write(Integer.toString(num));
        writer.close();
    }

     public void deleteAccount(String accountNum) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNum().equals(accountNum)) {
                accounts[i] = null;
                break;
            }
        }
     }


}
