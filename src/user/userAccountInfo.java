package user;

public class userAccountInfo {
    
    private Name name;
    private int accountNum;
    private String accountType;
    private double balance;

    public userAccountInfo(Name name, int accountNum, String accountType){
        this.name = name;
        this.accountNum = accountNum;
        this.accountType = accountType;
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
