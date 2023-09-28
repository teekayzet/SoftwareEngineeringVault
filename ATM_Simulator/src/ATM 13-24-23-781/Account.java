import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Creating the Account class

class Account {
    private String accountNumber;
    private String fullName;
    private int pin;
    private double balance;
    private List<String> transactionHistory;

    // Constructor for creating a new account
    public Account(String fullName, int pin) {
        this.accountNumber = generateAccountNumber();
        this.fullName = fullName;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Getters and setters for account attributes
     // Getter and setter for accountNumber
     public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter and setter for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and setter for pin
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    // Getter and setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter and setter for transactionHistory
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    // Method to generate a 16-digit account number
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumberBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            accountNumberBuilder.append(random.nextInt(10));
        }
        return accountNumberBuilder.toString();
    }

    // Method to generate a withdraw
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            // Display an error message for invalid withdrawal amount
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
            return false;
        }
        
        if (amount > balance) {
            // Display an error message if insufficient funds for withdrawal
            System.out.println("Insufficient funds. Unable to process withdrawal.");
            return false;
        }
        
        // Subtract the amount from the account balance
        balance -= amount;
        
        // Update the transaction history
        String transaction = "Withdrawal: $" + amount;
        transactionHistory.add(transaction);
        
        // Display a success message
        System.out.println("Withdrawal successful. Remaining balance: $" + balance);
        
        return true;
    }
    
    // Method to deposit
    public boolean deposit(double amount) {
        if (amount <= 0) {
            // Display an error message for invalid deposit amount
            System.out.println("Invalid deposit amount. Please enter a positive value.");
            return false;
        }

        // Add the amount to the account balance
        balance += amount;

        // Update the transaction history
        String transaction = "Deposit: $" + amount;
        transactionHistory.add(transaction);

        // Display a success message
        System.out.println("Deposit successful. New balance: $" + balance);

        return true;
    }

    // Method to transfare
    public boolean transfer(Account recipient, double amount) {
        if (amount <= 0) {
            // Display an error message for invalid transfer amount
            System.out.println("Invalid transfer amount. Please enter a positive value.");
            return false;
        }
        
        if (amount > balance) {
            // Display an error message if insufficient funds for transfer
            System.out.println("Insufficient funds. Unable to process transfer.");
            return false;
        }
        
        // Subtract the amount from the sender's account balance
        balance -= amount;
        
        // Add the amount to the recipient's account balance
        recipient.balance += amount;
        
        // Update the transaction history for sender
        String senderTransaction = "Transfer to Account Number " + recipient.accountNumber + ": $" + amount;
        transactionHistory.add(senderTransaction);
        
        // Update the transaction history for recipient
        String recipientTransaction = "Transfer from Account Number " + accountNumber + ": $" + amount;
        recipient.transactionHistory.add(recipientTransaction);
        
        // Display a success message
        System.out.println("Transfer successful. Remaining balance: $" + balance);
        
        return true;
    }
}

