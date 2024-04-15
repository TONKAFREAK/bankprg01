package functions;

import java.io.File;

public class DataManager {

    File dataFile = new File("../data/database.txt");
    File outFile = new File("../data/output.txt");
    
    public void saveData(String data){
        System.out.println("Data saved: "+data);
    }

    public void deleteData(String data){
        System.out.println("Data deleted: "+data);
    }
}
