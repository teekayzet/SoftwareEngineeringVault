package atmachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
        accountNumber = getAccountNumber();
        if (accountNumber != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE, true))) {
                String transaction = String.join(",", accountNumber, amount.toString(), timestamp.format(DateTimeFormatter.ISO_DATE_TIME));
                writer.write(transaction);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid account number!");
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
public static String getAccountNumber() {
    try (BufferedReader reader = new BufferedReader(new FileReader("accounts.csv"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            // Assuming the account number is in the first column
            String accountNumber = data[0];
            // Check if the account number matches the account number in Deposit object
            if (accountNumber.equals(Deposit.accountNumber)) {
                return accountNumber;
            }
        }
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
    return null;
}
    // Getters and setters for accountNumber, amount, timestamp
}

