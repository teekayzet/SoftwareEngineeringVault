public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter and setter methods for username and password

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

    // Other methods specific to the Admin class

    public void viewAccountDetails(Account account) {
        // Display account details for a specific account
        System.out.println("Account Details");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Full Name: " + account.getFullName());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Transaction History: " + account.getTransactionHistory());
        System.out.println("------------------------");
    }

    public void viewAllAccountDetails(List<Account> accounts) {
        // Display account details for all accounts
        System.out.println("All Account Details");
        for (Account account : accounts) {
            viewAccountDetails(account);
        }
    }

    public void editAccountDetails(Account account, String fullName, int pin) {
        // Edit account details for a specific account
        account.setFullName(fullName);
        account.setPin(pin);
        System.out.println("Account details updated successfully!");
    }

}