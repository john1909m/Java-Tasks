package Model;

public class Account {
    private String username;
    private String password;
    private String phoneNumber;
    private Double balance;

    public Account() {

    }

    public Account(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
    }

    public Account(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
