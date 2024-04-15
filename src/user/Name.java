package user;

public class Name {
    private String firstName;
    private String lastName;
    private String ssn;

    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getSSN(){
        return this.ssn;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setSSN(String ssn){
        this.ssn = ssn;
    }


    public String toString(){
        return this.firstName + ", " + this.lastName +", "+ssn;
    }
}

