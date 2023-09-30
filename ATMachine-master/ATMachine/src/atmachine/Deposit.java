package atmachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Deposit {
    private static final String TRANSACTIONS_FILE = "transactions.csv";
  
    private static String accountNumber;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    public Deposit(String accountNumber, BigDecimal amount) {
        Deposit.accountNumber = accountNumber;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public void recordTransaction() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
            String transaction = String.join(",", accountNumber, amount.toString(), timestamp.format(DateTimeFormatter.ISO_DATE_TIME));
            writer.write(transaction);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
     public static void makeDeposit() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the amount to deposit: ");
            BigDecimal amount = input.nextBigDecimal();
            
            Deposit deposit = new Deposit(accountNumber, amount);
            deposit.recordTransaction();
        }
        System.out.println("Deposit successful!");
    }


    // Getters and setters for accountNumber, amount, timestamp
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        Deposit.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}

