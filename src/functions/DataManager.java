package functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import user.userAccountInfo;

public class DataManager {

    final int MAX_ACCOUNTS = 100;

    private userAccountInfo[] accounts = new userAccountInfo[MAX_ACCOUNTS];
    
    File dataFile = new File("src/data/database.txt");
    File outFile = new File("src/data/output.txt");
    BufferedWriter writer;
    int count = 0;

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
                        int acctNum = Integer.parseInt(parts[0]);
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

    public void printData(String data){

        try {
            writer = new BufferedWriter(new java.io.FileWriter(outFile));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }


    public void saveData(userAccountInfo user){
       
        
    }

    public userAccountInfo getAccount(int accountNum) {
        for (userAccountInfo account : accounts) {
            if (account != null && account.getAccountNum() == accountNum) {
                return account;
            }
        }
        return null;
    }


}
