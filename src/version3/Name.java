package version3;

public class Name {
    private String firstname;
    private String middleIn;
    private String lastname;
    private String suffix;

    public Name() {
        this.firstname = "N/A";
        this.middleIn = "N/A"; // Fixed character literal
        this.lastname = "N/A";
        this.suffix = "N/A";
    }

    public Name(String firstname, String middleIn, String lastname){
        this.firstname = firstname;
        this.middleIn = middleIn;
        this.lastname = lastname;
    }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getMiddleIn() { return middleIn; }
    public void setMiddleIn(String middleIn) { this.middleIn = middleIn; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public void displayName(){
        System.out.println("Employee: " + firstname + " " + middleIn + " " + lastname + " " + suffix);
    }

    @Override
    public String toString() {
        return String.format("%s, %s %c %s", lastname, firstname, middleIn.charAt(0), suffix);
    }
}