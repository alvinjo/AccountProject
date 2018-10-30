package accounts;

public class Account {


    private String firstName;
    private String lastName;
    private String accountNumber;


    public Account(String first, String last, String acc){
        this.firstName = first;
        this.lastName = last;
        this.accountNumber = acc;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
