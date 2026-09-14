package version2;

public class Name {
    private String firstname;
    private char middleIn;
    private String lastname;

    public Name() {
        this.firstname = "N/A";
        this.middleIn = '\0'; // Fixed character literal
        this.lastname = "N/A";
    }

    public Name(String firstname, char middleIn, String lastname){
        this.firstname = firstname;
        this.middleIn = middleIn;
        this.lastname = lastname;
    }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public char getMiddleIn() { return middleIn; }
    public void setMiddleIn(char middleIn) { this.middleIn = middleIn; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
}
