package user;

public class userAccountInfo extends Name{
    
    private int accountNum;
    private String accountType;
    private double balance;
    private Name name;

    public userAccountInfo(int accountNum, String accountType, String firstName, String lastName, String ssn, double balance){
        super(firstName, lastName, ssn);
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.balance = balance;
        
    }

    public Name getName(){
        return this.name;
    }

    public int getAccountNum(){
        return this.accountNum;
    }

    public String getAccountType(){
        return this.accountType;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName(Name name){
        this.name = name;
    }

    public void setAccountNum(int accountNum){
        this.accountNum = accountNum;
    }

    public void setAccountType(String accountType){
        this.accountType = accountType;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public String toString(){
        return this.name.toString() + ", " + this.accountNum +", "+this.accountType+", "+this.balance;
    }
}
